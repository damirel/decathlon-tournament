package com.nagel.decathlon.service.tournament;

import com.nagel.decathlon.domain.Athlete;
import com.nagel.decathlon.domain.Tournament;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class TournamentServiceImplTest {

    @Mock
    private ScoreCalculatorService scoreCalculatorService;
    @InjectMocks
    private TournamentServiceImpl sut;

    @After
    public void tearDown() {
        verifyNoMoreInteractions(scoreCalculatorService);
    }

    @Test
    public void Should_distribute_places_When_athletes_have_different_points() {
        //given
        String name = "Usain Bolt";
        Athlete athlete = new Athlete();
        athlete.setName(name);

        String name2 = "Johann Sebastian Bach";
        Athlete athlete2 = new Athlete();
        athlete2.setName(name2);

        given(scoreCalculatorService.getTotalScore(athlete.getAthleteResults()))
                .willReturn(1000).willReturn(500);
        //when
        Tournament actual = sut.calculateResult(Arrays.asList(athlete, athlete2));

        //then
        verify(scoreCalculatorService, times(2)).getTotalScore(any());
        assertThat(actual.getAthletes(), hasSize(2));
        assertThat(actual.getAthletes().get(0).getPlaces(), contains(1));
        assertThat(actual.getAthletes().get(1).getPlaces(), contains(2));
    }

    @Test
    public void Should_share_places_When_athletes_have_equal_points() {
        //given
        String name = "Usain Bolt";
        Athlete athlete = new Athlete();
        athlete.setName(name);

        String name2 = "Johann Sebastian Bach";
        Athlete athlete2 = new Athlete();
        athlete2.setName(name2);

        given(scoreCalculatorService.getTotalScore(athlete.getAthleteResults()))
                .willReturn(1000);
        given(scoreCalculatorService.getTotalScore(athlete2.getAthleteResults()))
                .willReturn(1000);
        //when
        Tournament actual = sut.calculateResult(Arrays.asList(athlete, athlete2));

        //then
        verify(scoreCalculatorService, times(2)).getTotalScore(any());
        assertThat(actual.getAthletes(), hasSize(2));
        assertThat(actual.getAthletes().get(0).getPlaces(), contains(1, 2));
        assertThat(actual.getAthletes().get(1).getPlaces(), contains(1, 2));
    }
}