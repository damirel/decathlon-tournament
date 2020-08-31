package com.nagel.decathlon.utils;

import com.nagel.decathlon.domain.MeasuringPoint;

/**
 * EventUtils.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public final class EventUtils {

    private final static String DELIMITER = ":";
    private final static int CM_COEFFICIENT = 100;

    private EventUtils() {
    }

    public static double convertFieldScore(MeasuringPoint measuringPoint, String value) {
        switch (measuringPoint) {
            case M:
                return convert(value);
            case CM:
                return convert(value) * CM_COEFFICIENT;
            default:
                throw new RuntimeException(
                        String.format("Unsupported measuring point. MeasuringPoint:%s", measuringPoint));
        }
    }

    public static double convert(String value) {
        String[] values = value.split(DELIMITER);
        if (values.length > 1) {
            return Double.parseDouble(values[0]) * 60 + Double.parseDouble(values[1]);
        }
        return Double.parseDouble(value);
    }
}