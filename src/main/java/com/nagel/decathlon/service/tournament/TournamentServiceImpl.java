package com.nagel.decathlon.service.tournament;

import com.nagel.decathlon.domain.Athlete;
import com.nagel.decathlon.domain.Tournament;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TournamentServiceImpl. Class for calculating total scores and distributing places for the Athletes
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class TournamentServiceImpl implements TournamentService {

    private final ScoreCalculatorService scoreCalculatorService;

    public TournamentServiceImpl() {
        scoreCalculatorService = new ScoreCalculatorServiceImpl();
    }

    public TournamentServiceImpl(ScoreCalculatorService scoreCalculatorService) {
        this.scoreCalculatorService = scoreCalculatorService;
    }

    @Override
    public Tournament calculateResult(List<Athlete> athletes) {
        populateTotalScore(athletes);
        distributePlaces(athletes);
        athletes.sort(Comparator.comparingInt(Athlete::getTotalScore).reversed());
        return new Tournament(athletes);
    }

    private void populateTotalScore(List<Athlete> athletes) {
        athletes.forEach(
                athlete -> athlete.setTotalScore(scoreCalculatorService.getTotalScore(athlete.getAthleteResults())));
    }

    /**
     * Method groups list of Athletes by total score in descending order and populates shared places for groups of
     * athletes by polling available place from the queue.
     *
     * @param athletes List<Athlete>
     */
    private void distributePlaces(List<Athlete> athletes) {
        Map<Integer, List<Athlete>> groupedByScore = athletes.stream()
                .collect(Collectors.groupingBy(Athlete::getTotalScore,
                        () -> new TreeMap<>(Comparator.reverseOrder()), Collectors.toList()));
        Queue<Integer> placesQueue = IntStream.rangeClosed(1, athletes.size())
                .boxed()
                .collect(Collectors.toCollection(LinkedList::new));
        groupedByScore.values().forEach(value -> populatePlaces(value, placesQueue));
    }

    private void populatePlaces(List<Athlete> athletes, Queue<Integer> placesQueue) {
        List<Integer> sharedPlaces = IntStream.range(0, athletes.size())
                .mapToObj(value -> placesQueue.poll())
                .collect(Collectors.toList());
        athletes.forEach(athlete -> athlete.setPlaces(sharedPlaces));
    }
}
