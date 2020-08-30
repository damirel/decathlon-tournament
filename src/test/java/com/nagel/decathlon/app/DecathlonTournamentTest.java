package com.nagel.decathlon.app;

import com.nagel.decathlon.domain.Athlete;
import com.nagel.decathlon.domain.Tournament;
import com.nagel.decathlon.service.input.InputResultProcessor;
import com.nagel.decathlon.service.output.ExportService;
import com.nagel.decathlon.service.tournament.TournamentService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class DecathlonTournamentTest {

    @Mock
    private InputResultProcessor inputResultProcessor;
    @Mock
    private TournamentService tournamentService;
    @Mock
    private ExportService exportService;
    @InjectMocks
    private DecathlonTournament sut;

    @After
    public void tearDown() {
        verifyNoMoreInteractions(inputResultProcessor, tournamentService, exportService);
    }

    @Test
    public void Should_start_tournament_correctly() {
        //given
        List<Athlete> athletes = new ArrayList<>();
        Tournament tournament = new Tournament(athletes);
        given(inputResultProcessor.loadInputResult(anyString()))
                .willReturn(athletes);
        given(tournamentService.calculateResult(athletes))
                .willReturn(tournament);

        //when
        sut.start();

        //then
        then(inputResultProcessor)
                .should()
                .loadInputResult(anyString());
        then(tournamentService)
                .should()
                .calculateResult(athletes);
        then(exportService)
                .should()
                .export(eq(tournament), anyString());
    }
}