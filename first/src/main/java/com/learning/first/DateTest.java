package com.learning.first;

import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuying on 2019/10/18 9:47
 */
@RestController
public class DateTest {

    public final static SimpleDateFormat sdfDateTimeFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        DateTest dateTest = new DateTest();
        System.out.println(dateTest.getNowDate());
    }

    public String getNowDate() {
        return DateTest.sdfDateTimeFormat.format(new Date());
    }

}
