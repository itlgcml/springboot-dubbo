package com.itlg.demo.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Tables {
    public static final String DEST = "pdf/tables.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        createPdf(DEST);
    }
    public static void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.setMargins(10,10,20,10);
        HeaderFooter headerFooter= new HeaderFooter();
        document.open();



        // 使用语言包字体
        BaseFont abf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
        // 外部字体
        //BaseFont bf = BaseFont.createFont(FONT, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font titleFont = new Font(abf, 12, Font.BOLD);
        titleFont.setColor(new BaseColor(76,175,80));
        Font font = new Font(abf, 10);

        Paragraph p = new Paragraph("个人简历表", new Font(abf, 12, Font.BOLD));
        p.setAlignment(Paragraph.ALIGN_CENTER);

        PdfPTable table = new PdfPTable(8);
        table.setSpacingBefore(16f);

        PdfPCell cell = new PdfPCell(new Phrase("姓名", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("德丽莎", font));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("性别", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("女", font));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("出生年月", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("3月28日", font));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("民族", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("天命→休伯利安", font));
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("个人简历", titleFont));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setColspan(7);
        cell.addElement(new Paragraph("卡斯兰娜家族一贯的白发蓝眸，长发扎成马尾披于左肩。常穿天命早期使用的女武神统一制服。德丽莎所穿的制服是特别定制款，由主教奥托亲手缝制，在衣服胸口处别着阿波卡利斯家族的家徽。", font));
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("家庭成员", titleFont));
        cell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);
        cell.setRowspan(3);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("称呼", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("姓名", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("关系", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setColspan(5);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("爷爷", font));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("奥托·阿波卡利斯", font));
        table.addCell(cell);
        cell = new PdfPCell();
        cell.addElement(new Paragraph("德丽莎的造物主，奥托赐予了德丽莎名字，认其为孙女。因为德丽莎温柔而又坚强的性格，让奥托多次产生德丽莎是卡莲的转世的想法", font));
        cell.setColspan(5);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("侄女", font));
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("琪亚娜·卡斯兰娜", font));
        table.addCell(cell);
        cell = new PdfPCell();
        cell.addElement(new Paragraph("塞西莉亚和齐格飞的女儿，两人让德丽莎当琪亚娜的教母，琪亚娜这个名字也是德丽莎起的。齐格飞逃离天命的行动中，本想一起逃离天命的德丽莎为保护备天命回收的琪亚娜，回到天命。", font));
        cell.setColspan(5);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("他人评价", titleFont));
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell();
        cell.setColspan(7);
        cell.setPaddingLeft(8f);
        cell.setPaddingRight(8f);
        cell.setPaddingBottom(16f);
        // 配置行间距
        cell.addElement(new Paragraph(24, "“即使离开了天命，您也依然是我们所尊敬的学园长。”——雷电芽衣\n" +
                "“虽然看起来很小，倒也有点本事。”——西琳 \n" +
                "“诶~德丽莎看起来小小的，意外地很能干嘛。”——萝莎莉娅·阿琳", font));
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("其它", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("···"));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setFixedHeight(32f);
        cell.setColspan(7);
        table.addCell(cell);
        document.add(table);

        document.newPage();
        document.add(p);


        int indentation=0;
        Image image = Image.getInstance("d:/1.png");
        image.setAlignment(Image.UNDERLYING);
        image.scaleAbsoluteHeight(500);

        document.add(image);
        // ------------------------------------------------

       /* table = new PdfPTable(4);
        table.setSpacingBefore(32f);

        Font titleFont2 = new Font(abf, 14, Font.BOLD);
        titleFont2.setColor(new BaseColor(255,255,255));

        cell = new PdfPCell(new Phrase("账单", titleFont2));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setColspan(4);
        cell.setFixedHeight(32f);
        cell.setBackgroundColor(new BaseColor(96, 125, 139));
        cell.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell);

        cell = new PdfPCell(new Phrase("日期", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("项目", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("金额", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);
        cell = new PdfPCell(new Phrase("说明", titleFont));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell);

        LocalDateTime dt = LocalDateTime.now();
        for (int i = 0; i < 10; i++){
            dt = dt.plusDays(1L);
            cell = new PdfPCell(new Phrase(dt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), font));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(8f);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("花呗还款", font));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(8f);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("$100.0", font));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(8f);
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("——", font));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setPadding(8f);
            table.addCell(cell);
        }
        document.add(table);

        // ------------------------------------------------

        document.newPage();
        document.add(new Paragraph("芒种\n\n" +
                "一想到你我就\n" +
                "wu~~~~\n" +
                "空恨别梦久\n" +
                "wu~~~~\n" +
                "烧去纸灰埋烟柳\n" +
                "\n" +
                "于鲜活的枝丫\n" +
                "凋零下的无暇\n" +
                "是收获谜底的代价\n" +
                "\n" +
                "余晖沾上 远行人的发\n" +
                "他洒下手中牵挂\n" +
                "于桥下\n" +
                "前世迟来者~~~（擦肩而过）\n" +
                "掌心刻~~~~~（来生记得）\n" +
                "你眼中烟波滴落一滴墨 wo~~~\n" +
                "若佛说~~~~~（无牵无挂）\n" +
                "放下执着~~~~~（无相无色）\n" +
                "我怎能 波澜不惊 去附和\n" +
                "\n" +
                "一想到你我就\n" +
                "wu~~~~~\n" +
                "恨情不寿 总于苦海囚\n" +
                "wu~~~~~\n" +
                "新翠徒留 落花影中游\n" +
                "wu~~~~~\n" +
                "相思无用 才笑山盟旧\n" +
                "wu~~~~~\n" +
                "谓我何求\n" +
                "\n" +
                "种一万朵莲花\n" +
                "在众生中发芽\n" +
                "等红尘一万种解答\n" +
                "\n" +
                "念珠落进 时间的泥沙\n" +
                "待 割舍诠释慈悲\n" +
                "的读法\n" +
                "\n" +
                "前世迟来者~~~（擦肩而过）\n" +
                "掌心刻~~~~~（来生记得）\n" +
                "你眼中烟波滴落一滴墨 wo~~~\n" +
                "若佛说~~~~~（无牵无挂）\n" +
                "放下执着~~~~~（无相无色）\n" +
                "我怎能 波澜不惊 去附和", font));

*/
        document.close();
    }
}
