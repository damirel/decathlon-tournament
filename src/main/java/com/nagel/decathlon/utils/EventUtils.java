package com.nagel.decathlon.utils;

/**
 * EventUtils.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public final class EventUtils {

    private final static String DELIMITER = ":";

    private EventUtils() {
    }

    public static double convert(String value) {
        String[] values = value.split(DELIMITER);
        if (values.length > 1) {
            return Double.parseDouble(values[0]) * 60 + Double.parseDouble(values[1]);
        }
        return Double.parseDouble(value);
    }
}