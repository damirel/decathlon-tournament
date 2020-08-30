package com.nagel.decathlon.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Event. Class for event types. And constants for calculating events. A, B and C are parameters that vary by
 * discipline
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public enum Event {

    ONE_HUNDRED_M(1, 25.4347, 18, 1.81, EventType.TRACK),
    LONG_JUMP(2, 0.14354, 220, 1.4, EventType.FIELD),
    SHOT_PUT(3, 51.39, 1.5, 1.05, EventType.FIELD),
    HIGH_JUMP(4, 0.8465, 75, 1.42, EventType.FIELD),
    FOUR_HUNDRED_M(5, 1.53775, 82, 1.81, EventType.TRACK),
    ONE_HUNDRED_TEN_M_HURDLES(6, 5.74352, 28.5, 1.92, EventType.TRACK),
    DISCUS_THROW(7, 12.91, 4, 1.1, EventType.FIELD),
    POLE_VAULT(8, 0.2797, 100, 1.35, EventType.FIELD),
    JAVELIN_THROW(9, 10.14, 7, 1.08, EventType.FIELD),
    ONE_THOUSAND_FIVE_HUNDRED_M(10, 0.03768, 480, 1.85, EventType.TRACK);

    private static final Map<Integer, Event> ENUM_MAP;

    static {
        ENUM_MAP = Collections.unmodifiableMap(Arrays.stream(values())
                .collect(Collectors.toMap(Event::getOrder, Function.identity())));
    }

    private final int order;
    private final double a;
    private final double b;
    private final double c;
    private final EventType eventType;

    Event(int order, double a, double b, double c, EventType eventType) {
        this.order = order;
        this.a = a;
        this.b = b;
        this.c = c;
        this.eventType = eventType;
    }

    public int getOrder() {
        return order;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public EventType getEventType() {
        return eventType;
    }

    public static Event getFromOrder(int order) {
        return ENUM_MAP.get(order);
    }
}
