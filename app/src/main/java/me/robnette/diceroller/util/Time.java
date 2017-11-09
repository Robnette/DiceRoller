package me.robnette.diceroller.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Robnette on 07/11/2017.
 */

public class Time {

    private static final DateFormat df = new SimpleDateFormat("HH:mm:ss");

    public static String getTimeDisplay(){
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }
}
