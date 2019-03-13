package com.dayi.demo.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-12
 */
public class ExcelUtil {
    private static final int MAX_CELL_NUMBER = 3;

    /**
     * 产品信息导出Excel
     * @param jsonArray 产品统计Json数组
     * @param filepath  存放文件的位置
     * @throws Exception
     */
    public static void exportExcelProduct(JSONArray jsonArray, String filepath) throws Exception {
        // 创建工作薄
        XSSFWorkbook workBook = new XSSFWorkbook();
        // 设置产品样式
        XSSFCellStyle productStyle = createStyle(workBook, "宋体", Font.COLOR_RED, true);
        XSSFFont productFont = productStyle.getFont();
        productFont.setFontHeight((short) 320);
        productStyle.setFont(productFont);
        //设置标题样式
        XSSFCellStyle titleStyle = createStyle(workBook, "宋体", Font.COLOR_NORMAL, true);
        // 设置body样式
        XSSFCellStyle bodyStyle = createStyle(workBook, "宋体", Font.COLOR_NORMAL, false);
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
                    productRow.getRowNum(), 0, MAX_CELL_NUMBER);
            sheet.addMergedRegion(region);
            // 插入表头
            XSSFRow titleRow = sheet.createRow(rowNumber++);
            XSSFCell[] titleCells = new XSSFCell[MAX_CELL_NUMBER + 1];
            for (int i = 0; i <= MAX_CELL_NUMBER; i++) {
                titleCells[i] = titleRow.createCell(i);
                titleCells[i].setCellStyle(titleStyle);
            }
            titleCells[0].setCellValue("序号");
            titleCells[1].setCellValue("项目名");
            titleCells[2].setCellValue("完成状态");
            titleCells[3].setCellValue("Bug量");
            // 表体
            List<JSONObject> projects = (List<JSONObject>) json.get("projects");
            for (int i = 0; i < projects.size(); i++) {
                JSONObject project = projects.get(i);
                XSSFRow bodyRow = sheet.createRow(rowNumber++);
                XSSFCell[] bodyCells = new XSSFCell[MAX_CELL_NUMBER + 1];
                for (int j = 0; j <= MAX_CELL_NUMBER; j++) {
                    bodyCells[j] = bodyRow.createCell(j);
                    bodyCells[j].setCellStyle(bodyStyle);
                }
                bodyCells[0].setCellValue(i);
                bodyCells[1].setCellValue((String) project.get("projectName"));
                String finished = (boolean) project.get("finished") ? "已完成" : "未完成";
                bodyCells[2].setCellValue(finished);
                bodyCells[3].setCellValue((int) project.get("countBug"));

            }
            if (0 == projects.size()) {
                XSSFRow bodyRow = sheet.createRow(rowNumber++);
                XSSFCell bodyCell = bodyRow.createCell(0);
                bodyCell.setCellStyle(bodyStyle);
                bodyCell.setCellValue("无项目");
                CellRangeAddress bodyRegion = new CellRangeAddress(bodyRow.getRowNum(),
                        bodyRow.getRowNum(), 0, MAX_CELL_NUMBER);
                sheet.addMergedRegion(bodyRegion);

            }
            rowNumber++;
        }

        for (int i = 0; i <= MAX_CELL_NUMBER; i++) {
            sheet.autoSizeColumn(i);
        }
        setSizeColumn(sheet, rowNumber);

        // 新建一输出流并把相应的excel文件存盘
        File file = new File(filepath);
        FileOutputStream fos = new FileOutputStream(filepath);
        workBook.write(fos);
        fos.flush();
        //操作结束，关闭流
        fos.close();
    }

    /**
     * 生成样式
     *
     * @param workbook
     * @param fontName
     * @param color
     * @param isThick
     * @return
     */
    private static XSSFCellStyle createStyle(XSSFWorkbook workbook, String fontName, short color, boolean isThick) {
        XSSFCellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontName(fontName);
        if (-1 != color) {
            font.setColor(color);
        }
        if (isThick) {
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        }
        style.setFont(font);
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER);
        return style;
    }


    /**
     * 自适应宽度(中文支持)
     *
     * @param sheet
     * @param size
     */
    private static void setSizeColumn(XSSFSheet sheet, int size) {
        for (int columnNum = 0; columnNum < size; columnNum++) {
            int columnWidth = sheet.getColumnWidth(columnNum) / 256;
            for (int rowNum = 0; rowNum < sheet.getLastRowNum(); rowNum++) {
                XSSFRow currentRow;
                //当前行未被使用过
                if (sheet.getRow(rowNum) == null) {
                    currentRow = sheet.createRow(rowNum);
                } else {
                    currentRow = sheet.getRow(rowNum);
                }
                if (currentRow.getCell(columnNum) != null) {
                    XSSFCell currentCell = currentRow.getCell(columnNum);
                    if (currentCell.getCellType() == XSSFCell.CELL_TYPE_STRING) {
                        int length = currentCell.getStringCellValue().getBytes().length;
                        if (columnWidth < length) {
                            columnWidth = length;
                        }
                    }
                }
            }
            sheet.setColumnWidth(columnNum, columnWidth * 256);
        }
    }

}
