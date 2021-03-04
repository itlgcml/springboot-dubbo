package com.itlg.demo.excel;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 超大数据量导出，不支持图片
 */
public class Excel {
    public static void main(String[] args) throws Exception {
        excel();
    }

    public static String excel() throws Exception {
        String time = Long.toString(System.currentTimeMillis());
        FileWriter fw = new FileWriter("d:/" + time + ".xls");
        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version=\"1.0\"?>");
        sb.append("\n");
        sb.append("<?mso-application progid=\"Excel.Sheet\"?>");
        sb.append("\n");
        sb.append("<Workbook xmlns=\"urn:schemas-microsoft-com:office:spreadsheet\"");
        sb.append("\n");
        sb.append("  xmlns:o=\"urn:schemas-microsoft-com:office:office\"");
        sb.append("\n");
        sb.append(" xmlns:x=\"urn:schemas-microsoft-com:office:excel\"");
        sb.append("\n");
        sb.append(" xmlns:ss=\"urn:schemas-microsoft-com:office:spreadsheet\"");
        sb.append("\n");
        sb.append(" xmlns:html=\"http://www.w3.org/TR/REC-html40\">");
        sb.append("\n");
        sb.append("<Styles>\n");
        sb.append("<Style ss:ID=\"Default\" ss:Name=\"Normal\">\n");
        sb.append("<Alignment ss:Vertical=\"Center\"/>\n");
        sb.append("<Borders/>\n");
        sb.append("<Font ss:FontName=\"宋体\" x:CharSet=\"134\" ss:Size=\"12\"/>\n");
        sb.append("<Interior/>\n");
        sb.append("<NumberFormat/>\n");
        sb.append("<Protection/>\n");
        sb.append("</Style>\n");
        sb.append("</Styles>\n");

        String[] titles = {"序号", "业务流水", "营销流水", "缴费流水", "电话号码", "卡费(元)", "营销金额(元)", "自由花费(元)"};

        int recordcount = 60000;//每个sheet页面的条数
        int currentRecord = 0;
        int col = titles.length;

        sb.append("<Worksheet ss:Name=\"交易明细1\">");
        sb.append("\n");
        sb.append("<Table ss:ExpandedColumnCount=\"" + col
                + "\" ss:ExpandedRowCount=\"" + (recordcount + 1)
                + "\" x:FullColumns=\"1\" x:FullRows=\"1\">");
        sb.append("\n");

        sb.append("<Row>");
        sb.append("<Cell><Data ss:Type=\"String\">" + titles[0] + "</Data></Cell>");
        sb.append("<Cell><Data ss:Type=\"String\">" + titles[1] + "</Data></Cell>");
        sb.append("<Cell><Data ss:Type=\"String\">" + titles[2] + "</Data></Cell>");
        sb.append("<Cell><Data ss:Type=\"String\">" + titles[3] + "</Data></Cell>");
        sb.append("<Cell><Data ss:Type=\"String\">" + titles[4] + "</Data></Cell>");
        sb.append("<Cell><Data ss:Type=\"String\">" + titles[5] + "</Data></Cell>");
        sb.append("<Cell><Data ss:Type=\"String\">" + titles[6] + "</Data></Cell>");
        sb.append("<Cell><Data ss:Type=\"String\">" + titles[7] + "</Data></Cell>");
        sb.append("</Row>");

        int n = 1;
        int i = 0;
        int j = 1;

        List<BaseBean> list = new ArrayList<>();
        for (int m = 0; m < 1000000; m++) {
            BaseBean baseBean = new BaseBean();
            baseBean.setAcmoney(String.valueOf(m));
            list.add(baseBean);
        }
        while (true) {
            if ((currentRecord >= recordcount) && i != 0) {// 一个sheet写满
                currentRecord = 0;
                i = 0;
                fw.write(sb.toString());
                sb.setLength(0);

                sb.append("</Table>");
                sb.append("<WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">");
                sb.append("\n");
                sb.append("<ProtectObjects>False</ProtectObjects>");
                sb.append("\n");
                sb.append("<ProtectScenarios>False</ProtectScenarios>");
                sb.append("\n");
                sb.append("</WorksheetOptions>");
                sb.append("\n");
                sb.append("</Worksheet>");

                sb.append("<Worksheet ss:Name=\"交易明细" + ++j + "\">");
                sb.append("\n");
                sb.append("<Table ss:ExpandedColumnCount=\"" + col
                        + "\" ss:ExpandedRowCount=\"" + (recordcount + 1)
                        + "\" x:FullColumns=\"1\" x:FullRows=\"1\">");
                sb.append("\n");

                sb.append("<Row>");
                sb.append("<Cell><Data ss:Type=\"String\">" + titles[0] + "</Data></Cell>");
                sb.append("<Cell><Data ss:Type=\"String\">" + titles[1] + "</Data></Cell>");
                sb.append("<Cell><Data ss:Type=\"String\">" + titles[2] + "</Data></Cell>");
                sb.append("<Cell><Data ss:Type=\"String\">" + titles[3] + "</Data></Cell>");
                sb.append("<Cell><Data ss:Type=\"String\">" + titles[4] + "</Data></Cell>");
                sb.append("<Cell><Data ss:Type=\"String\">" + titles[5] + "</Data></Cell>");
                sb.append("<Cell><Data ss:Type=\"String\">" + titles[6] + "</Data></Cell>");
                sb.append("<Cell><Data ss:Type=\"String\">" + titles[7] + "</Data></Cell>");
                sb.append("</Row>");
            }

            if (list != null && list.size() > 0) {
                BaseBean item = null;
                Iterator<BaseBean> it = list.iterator();
                while (it.hasNext()) {
                    i++;
                    item = it.next();
                    sb.append("<Row>");
                    sb.append("<Cell><Data ss:Type=\"String\">" + i + "</Data></Cell>");
                    sb.append("<Cell><Data ss:Type=\"String\">" + item.getAcmoney()+ "</Data></Cell>");
                    sb.append("<Cell><Data ss:Type=\"String\">" + "bbbbb" + "</Data></Cell>");
                    sb.append("<Cell><Data ss:Type=\"String\">" + "cccc" + "</Data></Cell>");
                    sb.append("<Cell><Data ss:Type=\"String\">" + "cccc" + "</Data></Cell>");
                    sb.append("<Cell><Data ss:Type=\"String\">" + "cccc" + "</Data></Cell>");
                    sb.append("<Cell><Data ss:Type=\"String\">" + "cccc" + "</Data></Cell>");
                    sb.append("<Cell><Data ss:Type=\"String\">" + "cccc" + "</Data></Cell>");
                    sb.append("</Row>");

                    if (i % 1000 == 0) {
                        fw.write(sb.toString());
                        fw.flush();
                        sb.setLength(0);
                    }
                    sb.append("\n");
                    currentRecord++;
                }
            }
            break;

        }
        fw.write(sb.toString());
        fw.flush();
        sb.setLength(0);
        sb.append("</Table>");
        sb.append("<WorksheetOptions xmlns=\"urn:schemas-microsoft-com:office:excel\">");
        sb.append("\n");
        sb.append("<ProtectObjects>False</ProtectObjects>");
        sb.append("\n");
        sb.append("<ProtectScenarios>False</ProtectScenarios>");
        sb.append("\n");
        sb.append("</WorksheetOptions>");
        sb.append("\n");
        sb.append("</Worksheet>");
        sb.append("</Workbook>");
        sb.append("\n");
        fw.write(sb.toString());
        fw.flush();
        fw.close();
        return "SUCCESS";
    }
}
