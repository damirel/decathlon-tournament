package com.nagel.decathlon.service.tournament;

import com.nagel.decathlon.domain.AthleteResult;

import java.util.List;

/**
 * ScoreCalculatorService.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public interface ScoreCalculatorService {

    int getTotalScore(List<AthleteResult> athleteResults);

}
