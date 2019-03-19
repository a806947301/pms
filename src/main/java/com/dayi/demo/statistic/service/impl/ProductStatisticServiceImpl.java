package com.dayi.demo.statistic.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dayi.demo.bug.service.BugService;
import com.dayi.demo.product.model.Product;
import com.dayi.demo.product.service.ProductService;
import com.dayi.demo.project.model.Project;
import com.dayi.demo.project.service.ProjectService;
import com.dayi.demo.statistic.service.ProductStatisticService;
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
    public JSONArray doStatistic() {
        JSONArray productJsonArray = new JSONArray();
        Map<String, JSONObject> productJsonMap = doPackageProductJsonMap();
        doAppendProject(productJsonMap);
        Set<Map.Entry<String, JSONObject>> productEntries = productJsonMap.entrySet();
        for (Map.Entry<String, JSONObject> productEntry : productEntries) {
            productJsonArray.add(productEntry.getValue());
        }
        return productJsonArray;
    }

    /**
     * 打包成map（key :产品id    value：产品json）
     * 产品json：
     * productName:String类型    产品的名称
     * product:JsonArray类型     产品下的项目，此时为空，等待添加
     *
     * @return
     */
    private Map<String, JSONObject> doPackageProductJsonMap() {
        List<Product> products = productService.findAll();
        Map<String, JSONObject> productMap = new LinkedHashMap<String, JSONObject>();
        JSONObject productJson;
        for (Product product : products) {
            productJson = new JSONObject();
            productJson.put("productName", product.getProductName());
            productJson.put("projects", new LinkedList<Object>());
            productMap.put(product.getId(), productJson);
        }
        return productMap;
    }

    /**
     * 添加项目到产品Json上
     *
     * @param productJsonMap 商品json对应的map
     */
    private void doAppendProject(Map<String, JSONObject> productJsonMap) {
        Map<String, JSONObject> projectBugCountMap = bugService.countBugByProject();
        List<Project> projects = projectService.findAll();
        JSONObject projectJson;
        for (Project project : projects) {
            // 添加项目信息到json
            projectJson = projectBugCountMap.get(project.getId());
            if(null == projectJson) {
                projectJson = new JSONObject();
                projectJson.put("bugNumber",0);
                projectJson.put("allBug",0);
            }
            projectJson.put("projectName", project.getProjectName());
            projectJson.put("finished", project.isFinished());

            // 添加项目json到产品json
            JSONObject productJson = productJsonMap.get(project.getProduct().getId());
            LinkedList<Object> projectList = (LinkedList<Object>) productJson.get("projects");
            projectList.add(projectJson);
        }
    }

    @Override
    public void exportExcelProduct(OutputStream out) throws IOException {
        JSONArray jsonArray = doStatistic();
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
        for (Object jsonObj : jsonArray) {
            JSONObject json = (JSONObject) jsonObj;
            // 插入产品名
            XSSFRow productRow = sheet.createRow(rowNumber++);
            productRow.setHeightInPoints(20);
            XSSFCell productCell = productRow.createCell(0);
            productCell.setCellType(XSSFCell.CELL_TYPE_STRING);
            productCell.setCellStyle(productStyle);
            productCell.setCellValue((String) json.get("productName"));
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
            List<JSONObject> projects = (List<JSONObject>) json.get("projects");
            for (int i = 0; i < projects.size(); i++) {
                JSONObject project = projects.get(i);
                // 创建一行以及所需单元格
                XSSFRow bodyRow = sheet.createRow(rowNumber++);
                XSSFCell[] bodyCells = ExcelUtil.createCells(bodyRow, maxCellNumber, bodyStyle);
                //插入数据到单元格
                bodyCells[0].setCellValue(i);
                bodyCells[1].setCellValue((String) project.get("projectName"));
                bodyCells[2].setCellValue((int) project.get("bugNumber"));
                bodyCells[3].setCellValue((int) project.get("allBug"));
                String finished = (boolean) project.get("finished") ? "已完成" : "未完成";
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
