package com.demo.util;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.List;

/**
 * @author wwx
 * @date 2019/5/6 10:32
 **/
public class ExcelUtil {
    public static void outputExcel(String header, String sheetName, String[] array, String[] arrayName, List<Map<String, Object>> list, HttpServletResponse response) {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(sheetName);
        HSSFRow row1 = sheet.createRow(0);


        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        Font font1 = wb.createFont();
        font1.setFontHeightInPoints((short) 12);
        font1.setFontName("宋体");
        font1.setBold(true);
        cellStyle.setFont(font1);

        Cell c= row1.createCell(0);
        c.setCellValue(header);
        c.setCellStyle(cellStyle);
        sheet.addMergedRegion(new CellRangeAddress(0,0,0,8));

        HSSFRow row2 = sheet.createRow(1);
        for (int i = 0; i < array.length; i++) {
            Cell cell = row2.createCell(i);
            cell.setCellValue(array[i]);
            cell.setCellStyle(cellStyle);
            sheet.setColumnWidth(i, 256 * 10);
        }
        CellStyle cellStyle1 = cellStyle;
        Font font = font1;
        font.setFontName("宋体");
        font.setBold(false);
        cellStyle1.setFont(font);
        //列添加查询到的数据
        for (int i = 0; i < list.size(); i++) {
            HSSFRow row=sheet.createRow(i + 2);
            for (int j = 0; j < arrayName.length; j++) {
                Map<String, Object> map = list.get(i);
                for (String key : map.keySet()) {
                    if (key.equals(arrayName[j])) {
                        String value = map.get(key).toString();
                        Cell cell=row.createCell(j);
                        cell.setCellValue(value);
                        cell.setCellStyle(cellStyle1);
                        sheet.setColumnWidth(j,256*13);
                        break;
                    }
                }
            }
        }
        try {
            OutputStream out = response.getOutputStream();
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + new String("我的信息表.xls".getBytes("UTF-8"), "ISO-8859-1"));
            response.setContentType("application/msexcel");
            wb.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
