package com.bolsadeideas.springboot.app.util.viewsexport;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Map;

@Component("factura/ver.pdf")
public class FacturaPdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse) throws Exception {
        //Para pbtener los datos de la factura de la vista
        Factura factura = (Factura) map.get("factura");
        PdfPTable table = new PdfPTable(1);
        table.setSpacingAfter(20);
        //El cell me permite personalizar mas las tablas, dando decoracion y formato..
        PdfPCell cell = null;
        cell = new PdfPCell(new Phrase("Datos del Cliente"));
        cell.setBackgroundColor(new Color(184, 218, 255));
        cell.setPadding(8f);
        table.addCell(cell);
        table.addCell(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
        table.addCell(factura.getCliente().getEmail());

        PdfPTable table2 = new PdfPTable(1);
        table.setSpacingAfter(20);
        cell = new PdfPCell(new Phrase("Datos de la Factura"));
        cell.setBackgroundColor(new Color(0xC3E6CB));
        cell.setPadding(8f);
        table2.addCell(cell);
        table2.addCell("Folio: " + factura.getId());
        table.addCell("Descripcion: " + factura.getDescripcion());
        table2.addCell("Fecha: " + factura.getCreateAt());

        //Header de la tabla
        PdfPTable table3 = new PdfPTable(4);
        table3.setWidths(new float[]{3.5f, 1, 1, 1});
        table3.addCell("Producto");
        table3.addCell("Precio");
        table3.addCell("Cantidad");
        table3.addCell("Total");
        //Body de la tabla
        for (ItemFactura item : factura.getItems()) {
            table3.addCell(item.getProducto().getNombre());
            table3.addCell(item.getProducto().getPrecio().toString());
            cell = new PdfPCell(new Phrase(item.getCantidad().toString()));
            cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            table3.addCell(cell);
            table3.addCell(item.calcularImporte().toString());
        }

        //Footer de la tabla
        cell = new PdfPCell(new Phrase("Total: "));
        cell.setColspan(3); //las columnas que ocupa o espacio
        cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
        table3.addCell(cell);
        table3.addCell(factura.getTotal().toString());

        document.add(table);
        document.add(table2);
        document.add(table3);

    }
}
