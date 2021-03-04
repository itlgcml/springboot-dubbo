/*
package com.itlg.demo.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

*/
/**
 * 设置底部页码
 *//*

public class HeaderFooter extends PdfPageEventHelper {
    public void onEndPage(PdfWriter writer, Document document) {
        Rectangle rectangle = writer.getBoxSize("art");
        switch (writer.getPageNumber() % 2) {
            case 0:
                ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Paragraph(""), rectangle.getRight(), rectangle.getTop(), 0);
                break;
            case 1:
                ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_LEFT, new Paragraph(""), rectangle.getRight(), rectangle.getTop(), 0);
                break;
        }
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase(String.format("第 %D 页", writer.getPageNumber())), (rectangle.getLeft() + rectangle.getRight() / 2), rectangle.getBottom() - 18, 0);
    }
}
*/
