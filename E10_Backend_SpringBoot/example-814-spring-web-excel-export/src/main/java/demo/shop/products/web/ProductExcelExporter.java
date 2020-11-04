package demo.shop.products.web;

import demo.shop.products.Product;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductExcelExporter {

    public InputStream exportProductList(List<Product> products) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();

        int idColumnIndex = 0;
        int nameColumnIndex = 1;
        int netPriceColumnIndex = 2;

        Sheet sheet = workbook.createSheet("Products");
        sheet.setColumnWidth(idColumnIndex, 3000);
        sheet.setColumnWidth(nameColumnIndex, 6000);
        sheet.setColumnWidth(netPriceColumnIndex, 4000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = workbook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(idColumnIndex);
        headerCell.setCellValue("ID");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(nameColumnIndex);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(netPriceColumnIndex);
        headerCell.setCellValue("Net Price");
        headerCell.setCellStyle(headerStyle);

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        int rowIndex = 1;
        for (Product product : products) {

            Row row = sheet.createRow(rowIndex++);
            Cell cell = row.createCell(idColumnIndex);
            cell.setCellValue(product.getId());
            cell.setCellStyle(style);

            cell = row.createCell(nameColumnIndex);
            cell.setCellValue(product.getName());
            cell.setCellStyle(style);

            cell = row.createCell(netPriceColumnIndex);
            cell.setCellValue(product.getNetPrice().toString());
            cell.setCellStyle(style);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        workbook.write(baos);
        workbook.close();

        return new ByteArrayInputStream(baos.toByteArray());
    }

}
