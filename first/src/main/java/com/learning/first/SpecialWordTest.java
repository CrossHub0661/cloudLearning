package com.learning.first;

import org.apache.commons.text.StringEscapeUtils;

/**
 * Created by liuying on 2019/10/31 10:05
 */
public class SpecialWordTest {
    public static void main(String[] args) {
        System.out.println("转义/反转义Java字符串");
        String javaString = "这是Java字符串";
        System.out.println(StringEscapeUtils.escapeJava(javaString));
        System.out.println(StringEscapeUtils.unescapeJava(StringEscapeUtils.escapeJava(javaString)));
        System.out.println("-------------------------------------------------------------");
        System.out.println("转义/反转义Json字符串");
        String jsonString = "{\"keyword\": \"这是Json字符串\"}";
        System.out.println(StringEscapeUtils.escapeJson(jsonString));
        System.out.println(StringEscapeUtils.unescapeJson(StringEscapeUtils.escapeJson(jsonString)));
        System.out.println("-------------------------------------------------------------");
        //除了html4还有html3等格式
        System.out.println("转义/反转义Html字符串");
        String htmlString = "<strong>加粗字符</strong>";
        System.out.println(StringEscapeUtils.escapeHtml4(htmlString));
        System.out.println(StringEscapeUtils.unescapeHtml4(StringEscapeUtils.escapeHtml4(htmlString)));
        System.out.println("-------------------------------------------------------------");
        //除了xml10还有xml11等格式
        System.out.println("转义/反转义xml字符串");
        String xmlString = "<xml>\"xml字符串\"</xml>";
        System.out.println(StringEscapeUtils.escapeXml10(xmlString));
        System.out.println(StringEscapeUtils.unescapeXml(StringEscapeUtils.escapeXml10(xmlString)));
        System.out.println("-------------------------------------------------------------");
        System.out.println("转义/反转义csv字符串");
        String csvString = "1997,Ford,E350,\"Super, luxurious truck\"";
        System.out.println(StringEscapeUtils.escapeCsv(csvString));
        System.out.println(StringEscapeUtils.unescapeCsv(StringEscapeUtils.escapeCsv(csvString)));
        System.out.println("-------------------------------------------------------------");
        System.out.println("转义/反转义Java Script字符串");
        String jsString = "<script>alert('1111')</script>";
        System.out.println(StringEscapeUtils.escapeEcmaScript(jsString));
        System.out.println(StringEscapeUtils.unescapeEcmaScript(StringEscapeUtils.escapeEcmaScript(jsString)));
    }
}
