package com.example.administrator.demo1.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/21.
 */

public class DateFormatUtil {

    public static String dateFormat(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }


    public static Date transFormat(String date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    public static String displayDateFormat(Date date){
        DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
        return dateFormat.format(date);
    }
}
