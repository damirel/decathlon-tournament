package com.nagel.decathlon.service.processor;

import com.nagel.decathlon.domain.Event;

/**
 * EventProcessor.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public interface EventProcessor {

    int calculateScore(Event event, String score);

}
