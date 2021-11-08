package com.metao.java8.challenges;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConversion {

    public static final String HH_MM_SSA = "hh:mm:ssa";

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat dateParser = new SimpleDateFormat(HH_MM_SSA);
        Date date = dateParser.parse("07:30:23PM");
        SimpleDateFormat dateFormatter = new SimpleDateFormat("HH:mm:ss");
        System.out.println(dateFormatter.format(date));
    }
}
