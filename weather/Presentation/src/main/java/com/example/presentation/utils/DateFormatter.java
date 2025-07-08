package com.example.presentation.utils;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateFormatter {

    public static String formatDate(String input) {
        try {
            LocalDate date = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                date = LocalDate.parse(input.substring(0, 10));
            }

            String month = null;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                month = date.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
            }
            int day = 0;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                day = date.getDayOfMonth();
            }

            return month + ", " + day;

        } catch (Exception e) {

            return "-";
        }
    }
}

