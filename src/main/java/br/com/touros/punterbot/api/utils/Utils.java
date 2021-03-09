package br.com.touros.punterbot.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utils {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static boolean isNull(Object o) {
        return o == null;
    }

    public static boolean isNullOrEmpty(String o) {
        return o == null || o.isEmpty();
    }

    public static boolean isNullOrEmpty(List<?> o) {
        return o == null || o.isEmpty();
    }

    public static <T extends ISelectItem> List<SelectItem> Select(List<T> objectSelects) {
        List<SelectItem> selectItems = new ArrayList<>();
        for (T objectSelect : objectSelects) {
            selectItems.add(new SelectItem(objectSelect.getItemLabel(), objectSelect.getItemValue()));
        }
        return selectItems;
    }

    public static <T extends ISelectItem> List<SelectItem> Select(T[] objectSelects) {
        List<SelectItem> selectItems = new ArrayList<>();
        for (T objectSelect : objectSelects) {
            selectItems.add(new SelectItem(objectSelect.getItemLabel(), objectSelect.getItemValue()));
        }
        return selectItems;
    }

    public static boolean isDebug() {
        return java.lang.management.ManagementFactory.getRuntimeMXBean().getInputArguments().toString().indexOf("-agentlib:jdwp") > 0;
    }

    public static String formatDate(Date date) {
        return isNull(date) ? null : SIMPLE_DATE_FORMAT.format(date);
    }

    public static Date stringToDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
