package com.dayi.demo.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * Excel工具类
 *
 * @author WuTong<wut   @   pvc123.com>
 * @date 2019-03-12
 */
public class ExcelUtil {



    /**
     * 生成样式
     *
     * @param workbook
     * @param fontName
     * @param color
     * @param isThick
     * @return
     */
    public static XSSFCellStyle createStyle(XSSFWorkbook workbook, String fontName, short color, boolean isThick) {
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
     * 指定行创建多个单元格
     *
     * @param row       行号
     * @param countCell
     * @param style     单元格样式
     * @return
     */
    public static XSSFCell[] createCells(XSSFRow row, int countCell, XSSFCellStyle style) {
        XSSFCell[] cells = new XSSFCell[countCell + 1];
        for (int i = 0; i <= countCell; i++) {
            cells[i] = row.createCell(i);
            cells[i].setCellStyle(style);
        }
        return cells;
    }

    /**
     * 自适应宽度(中文支持)
     *
     * @param sheet
     * @param size
     */
    public static void setSizeColumn(XSSFSheet sheet, int size, int cellSize) {
        // 设置宽度自动
        for (int i = 0; i <= cellSize; i++) {
            sheet.autoSizeColumn(i);
        }
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
