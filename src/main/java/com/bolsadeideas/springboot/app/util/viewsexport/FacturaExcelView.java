package com.bolsadeideas.springboot.app.util.viewsexport;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("factura/ver.xlsx")
public class FacturaExcelView extends AbstractXlsxView {

    @Override
    protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"factura_view.xlsx\""); //Me permite cambiar el nombre del archivo generado
        Factura factura = (Factura) map.get("factura");
        Sheet sheet = workbook.createSheet("Factura Spring");//El parametro permite cambiar el nombre de la hoja excel
        Cell cell = null;

        sheet.createRow(0).createCell(0).setCellValue("Datos del Cliente");
        sheet.createRow(1).createCell(0).setCellValue(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
        sheet.createRow(2).createCell(0).setCellValue(factura.getCliente().getEmail());

        sheet.createRow(4).createCell(0).setCellValue("Datos de la Factura");
        sheet.createRow(5).createCell(0).setCellValue("Folio: " + factura.getId());
        sheet.createRow(6).createCell(0).setCellValue("Descripcion: " + factura.getDescripcion());
        sheet.createRow(7).createCell(0).setCellValue("Fecha: " + factura.getCreateAt());

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setBorderBottom(BorderStyle.MEDIUM);
        headerStyle.setBorderTop(BorderStyle.MEDIUM);
        headerStyle.setBorderLeft(BorderStyle.MEDIUM);
        headerStyle.setBorderRight(BorderStyle.MEDIUM);
        headerStyle.setFillForegroundColor(IndexedColors.GOLD.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle bodyStyle = workbook.createCellStyle();
        bodyStyle.setBorderBottom(BorderStyle.THIN);
        bodyStyle.setBorderTop(BorderStyle.THIN);
        bodyStyle.setBorderLeft(BorderStyle.THIN);
        bodyStyle.setBorderRight(BorderStyle.THIN);

        Row header = sheet.createRow(9);
        header.createCell(0).setCellValue("Producto");
        header.createCell(1).setCellValue("Precio");
        header.createCell(2).setCellValue("Cantidad");
        header.createCell(3).setCellValue("Total");
        header.getCell(0).setCellStyle(headerStyle);
        header.getCell(1).setCellStyle(headerStyle);
        header.getCell(2).setCellStyle(headerStyle);
        header.getCell(3).setCellStyle(headerStyle);
        int rownum = 10; //Contador que arranca desde la tabla de productos

        for (ItemFactura itemFactura : factura.getItems()) {
            Row fila = sheet.createRow(rownum++); //Para que con cada item se cree un fila
            cell = fila.createCell(0);
            cell.setCellValue(itemFactura.getProducto().getNombre());
            cell.setCellStyle(bodyStyle);

            cell = fila.createCell(1);
            cell.setCellValue(itemFactura.getProducto().getPrecio());
            cell.setCellStyle(bodyStyle);

            cell = fila.createCell(2);
            cell.setCellValue(itemFactura.getCantidad());
            cell.setCellStyle(bodyStyle);

            cell = fila.createCell(3);
            cell.setCellValue(itemFactura.calcularImporte());
            cell.setCellStyle(bodyStyle);
        }

        Row filatotal = sheet.createRow(rownum);
        cell = filatotal.createCell(2);
        cell.setCellValue("Gran Total: ");
        cell.setCellStyle(bodyStyle);
        cell = filatotal.createCell(3);
        cell.setCellValue(factura.getTotal());
        cell.setCellStyle(bodyStyle);
    }
}