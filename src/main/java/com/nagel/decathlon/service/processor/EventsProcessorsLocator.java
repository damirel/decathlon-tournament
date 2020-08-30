package com.nagel.decathlon.service.processor;

import com.nagel.decathlon.domain.Event;
import com.nagel.decathlon.domain.EventType;

import java.util.HashMap;
import java.util.Map;

/**
 * EventsProcessorsLocator. Class for processors lookup.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class EventsProcessorsLocator {

    private static final Map<EventType, EventProcessor> PROCESSORS = new HashMap<>();

    static {
        initProcessors();
    }

    public EventProcessor getProcessor(Event event) {
        return PROCESSORS.get(event.getEventType());
    }

    private static void initProcessors() {
        PROCESSORS.put(EventType.FIELD, new FieldEventProcessor());
        PROCESSORS.put(EventType.TRACK, new TrackEventProcessor());
    }
}
