package com.nagel.decathlon.service.processor;

import com.nagel.decathlon.domain.Event;
import com.nagel.decathlon.utils.EventUtils;

/**
 * FieldEventProcessor. Class for calculating score points for the field events.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class FieldEventProcessor implements EventProcessor {

    /**
     * @param event Event
     * @param score String
     * @return double, calculated points = INT(A(P — B)C) for field events (greater distance or height produces a higher
     * score) for the field event.
     */
    @Override
    public int calculateScore(Event event, String score) {
        double distance = EventUtils.convert(score);
        if (distance <= event.getB()) {
            return 0;
        }
        return (int) ((Math.pow(((EventUtils.convert(score) - event.getB())), event.getC())) * event.getA());
    }
}
