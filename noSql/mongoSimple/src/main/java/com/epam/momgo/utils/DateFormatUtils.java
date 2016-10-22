package com.epam.momgo.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Created by Полина on 22.10.2016.
 */
public class DateFormatUtils {

    public static LocalDateTime getDateTimeByFormat(String str, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(str, formatter);
    }

    public static LocalDate getDateByFormat(String str, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return LocalDate.parse(str, formatter);
    }
}
