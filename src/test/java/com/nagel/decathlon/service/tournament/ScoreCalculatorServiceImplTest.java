package com.nagel.decathlon.service.tournament;

import com.nagel.decathlon.domain.AthleteResult;
import com.nagel.decathlon.domain.Event;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScoreCalculatorServiceImplTest {

    private ScoreCalculatorServiceImpl sut;

    @Before
    public void init() {
        sut = new ScoreCalculatorServiceImpl();
    }

    @Test
    public void Should_calculate_total_score_When_athlete_results_given() {
        //given
        String score = "Jane Doe;13.04;4.53;7.79;1.55;64.72;18.74;24.20;2.40;28.20;6:50.76";
        String[] scores = score.split(";");
        List<AthleteResult> athleteResults = getAthleteResults(scores);

        //when
        int actual = sut.getTotalScore(athleteResults);

        //then
        assertThat(actual, equalTo(3199));
    }

    private List<AthleteResult> getAthleteResults(String[] scores) {
        return IntStream.range(1, scores.length)
                .mapToObj(order -> getAthleteResult(scores[order], order))
                .collect(Collectors.toList());
    }

    private AthleteResult getAthleteResult(String value, Integer order) {
        return new AthleteResult(Event.getFromOrder(order), value);
    }
}