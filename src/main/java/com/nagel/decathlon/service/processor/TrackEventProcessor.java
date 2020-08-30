package com.nagel.decathlon.service.processor;

import com.nagel.decathlon.domain.Event;
import com.nagel.decathlon.utils.EventUtils;

/**
 * TrackEventProcessor. Class for calculating score points for the track events.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class TrackEventProcessor implements EventProcessor {

    /**
     * @param event Event
     * @param score String
     * @return int, calculated points = INT(A(B — P)C) for track events (faster time produces a higher score) for the
     * track event.
     */
    @Override
    public int calculateScore(Event event, String score) {
        return (int) ((Math.pow((event.getB() - EventUtils.convert(score)), event.getC())) * event.getA());
    }
}
