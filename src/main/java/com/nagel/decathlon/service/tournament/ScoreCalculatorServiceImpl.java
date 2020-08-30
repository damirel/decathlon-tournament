package com.nagel.decathlon.service.tournament;

import com.nagel.decathlon.domain.AthleteResult;
import com.nagel.decathlon.service.processor.EventProcessor;
import com.nagel.decathlon.service.processor.EventsProcessorsLocator;

import java.util.List;

/**
 * ScoreCalculatorServiceImpl.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class ScoreCalculatorServiceImpl implements ScoreCalculatorService {

    private final EventsProcessorsLocator trackerLocator;

    public ScoreCalculatorServiceImpl() {
        trackerLocator = new EventsProcessorsLocator();
    }

    @Override
    public int getTotalScore(List<AthleteResult> athleteResults) {
        return athleteResults.stream()
                .mapToInt(this::getScore)
                .sum();
    }

    private int getScore(AthleteResult athleteResult) {
        EventProcessor processor = trackerLocator.getProcessor(athleteResult.getEvent());
        return processor.calculateScore(athleteResult.getEvent(), athleteResult.getScore());
    }
}
