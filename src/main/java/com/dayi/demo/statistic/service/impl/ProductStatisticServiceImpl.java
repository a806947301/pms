package com.dayi.demo.statistic.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.product.model.Product;
import com.dayi.demo.product.service.ProductService;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.statistic.dto.ProductBugDto;
import com.dayi.demo.statistic.dto.ProjectBugDto;
import com.dayi.demo.statistic.service.ProductStatisticService;
import com.dayi.demo.statistic.vo.ProjectBugVo;
import com.dayi.demo.util.ExcelUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * 产品统计模块Service层实现类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-12
 */
@Component
public class ProductStatisticServiceImpl implements ProductStatisticService {

    /**
     * 保存文件的相对路径
     */
    private static final String PATH = "\\excel\\product.xlsx";

    @Resource
    private ProductService productService;

    @Resource
    private ProjectService projectService;

    @Resource
    private BugService bugService;

    @Override
    public List<ProductBugDto> doStatistic() {
        LinkedList<ProductBugDto> products = new LinkedList<>();
        //获取产品Bug Dto Map
        Map<String, ProductBugDto> productDtoMap = doPackageProductDtoMap();
        //把项目加进产品
        doAppendProject(productDtoMap);
        //Map转化List
        Set<Map.Entry<String, ProductBugDto>> entries = productDtoMap.entrySet();
        for (Map.Entry<String, ProductBugDto> e : entries) {
            products.add(e.getValue());
        }
        return products;
    }

    /**
     * 打包产品dto对象
     *
     * @return
     */
    private Map<String, ProductBugDto> doPackageProductDtoMap() {
        //查找产品
        List<Product> products = productService.findAll();
        //新建产品id、产品dto对应Map
        Map<String, ProductBugDto> productMap = new LinkedHashMap<String, ProductBugDto>();
        ProductBugDto productBugDto;
        for (Product product : products) {
            //把产品信息封装到dto
            productBugDto = new ProductBugDto();
            productBugDto.setProductName(product.getProductName());
            productBugDto.setProjects(new LinkedList<ProjectBugDto>());
            //添加到id、dto对应Map
            productMap.put(product.getId(), productBugDto);
        }
        return productMap;
    }

    /**
     * 添加项目到产品Map上
     *
     * @param productDtoMap 产品dto对应的map
     */
    private void doAppendProject(Map<String, ProductBugDto> productDtoMap) {
        //查找项目Bug信息
        Map<String, ProjectBugVo> projectBugVoMap = bugService.countBugByProject();
        //查找项目
        List<Project> projects = projectService.findAll();
        for (Project p : projects) {
            //把项目Bug Vo 转化为项目Bug Dto
            ProjectBugVo vo = projectBugVoMap.get(p.getId());
            ProjectBugDto projectBugDto = new ProjectBugDto(vo);
            projectBugDto.setProjectName(p.getProjectName());
            projectBugDto.setProjectId(p.getId());
            projectBugDto.setFinished(p.getFinished());

            //把项目Bug Dto添加到产品
            List<ProjectBugDto> productChildren = productDtoMap.get(p.getProduct().getId()).getProjects();
            productChildren.add(projectBugDto);

        }

    }

    @Override
    public void exportExcelProduct(OutputStream out) throws IOException {
        List<ProductBugDto> products = doStatistic();
        final int maxCellNumber = 4;
        // 创建工作薄
        XSSFWorkbook workBook = new XSSFWorkbook();
        // 设置产品样式
        XSSFCellStyle productStyle = ExcelUtil.createStyle(workBook, "宋体", Font.COLOR_RED, true);
        XSSFFont productFont = productStyle.getFont();
        productFont.setFontHeight((short) 320);
        productStyle.setFont(productFont);
        //设置标题样式
        XSSFCellStyle titleStyle = ExcelUtil.createStyle(workBook, "宋体", Font.COLOR_NORMAL, true);
        // 设置body样式
        XSSFCellStyle bodyStyle = ExcelUtil.createStyle(workBook, "宋体", Font.COLOR_NORMAL, false);
        // 在工作薄中创建一工作表
        XSSFSheet sheet = workBook.createSheet();

        int rowNumber = 0;
        for (ProductBugDto product : products) {
            // 插入产品名
            XSSFRow productRow = sheet.createRow(rowNumber++);
            productRow.setHeightInPoints(20);
            XSSFCell productCell = productRow.createCell(0);
            productCell.setCellType(XSSFCell.CELL_TYPE_STRING);
            productCell.setCellStyle(productStyle);
            productCell.setCellValue(product.getProductName());
            CellRangeAddress region = new CellRangeAddress(productRow.getRowNum(),
                    productRow.getRowNum(), 0, maxCellNumber);
            sheet.addMergedRegion(region);
            // 创建表头
            XSSFRow titleRow = sheet.createRow(rowNumber++);
            XSSFCell[] titleCells = ExcelUtil.createCells(titleRow, maxCellNumber, titleStyle);
            // 插入值到表头
            titleCells[0].setCellValue("序号");
            titleCells[1].setCellValue("项目名");
            titleCells[2].setCellValue("未完成Bug量");
            titleCells[3].setCellValue("Bug总量");
            titleCells[4].setCellValue("完成状态");
            // 表体，循环插入项目
            List<ProjectBugDto> projects = product.getProjects();
            for (int i = 0; i < projects.size(); i++) {
                ProjectBugDto project = projects.get(i);
                // 创建一行以及所需单元格
                XSSFRow bodyRow = sheet.createRow(rowNumber++);
                XSSFCell[] bodyCells = ExcelUtil.createCells(bodyRow, maxCellNumber, bodyStyle);
                //插入数据到单元格
                bodyCells[0].setCellValue(i);
                bodyCells[1].setCellValue(project.getProjectName());
                bodyCells[2].setCellValue(project.getCountBug());
                bodyCells[3].setCellValue(project.getCountAllBug());
                String finished = project.isFinished() ? "已完成" : "未完成";
                bodyCells[4].setCellValue(finished);

            }
            // 如果没有数据，则插入“无项目”
            if (0 == projects.size()) {
                XSSFRow bodyRow = sheet.createRow(rowNumber++);
                XSSFCell bodyCell = bodyRow.createCell(0);
                bodyCell.setCellStyle(bodyStyle);
                bodyCell.setCellValue("无项目");
                CellRangeAddress bodyRegion = new CellRangeAddress(bodyRow.getRowNum(),
                        bodyRow.getRowNum(), 0, maxCellNumber);
                sheet.addMergedRegion(bodyRegion);

            }
            // 每个产品间空一行
            rowNumber++;
        }
        // 设置宽度自动
        ExcelUtil.setSizeColumn(sheet, rowNumber, maxCellNumber);

        // 把Excel写入到输出流中
        workBook.write(out);
        out.flush();
        //操作结束，关闭流
        out.close();
    }
}
