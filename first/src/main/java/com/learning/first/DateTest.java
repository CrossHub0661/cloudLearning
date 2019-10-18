package com.learning.first;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuying on 2019/10/18 9:47
 */
public class DateTest {

    public final static SimpleDateFormat sdfDateTimeFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        System.out.println(DateTest.sdfDateTimeFormat.format(new Date()));
    }

}
