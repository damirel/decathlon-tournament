package com.nagel.decathlon.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Athlete.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class Athlete {

    private String name;
    private List<AthleteResult> athleteResults = new ArrayList<>();
    private int totalScore;
    private List<Integer> places = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AthleteResult> getAthleteResults() {
        return athleteResults;
    }

    public void setAthleteResults(List<AthleteResult> athleteResults) {
        this.athleteResults = athleteResults;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public List<Integer> getPlaces() {
        return places;
    }

    public void setPlaces(List<Integer> places) {
        this.places = places;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athlete athlete = (Athlete) o;
        return totalScore == athlete.totalScore &&
                Objects.equals(name, athlete.name) &&
                Objects.equals(athleteResults, athlete.athleteResults) &&
                Objects.equals(places, athlete.places);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, athleteResults, totalScore, places);
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", athleteResults=" + athleteResults +
                ", totalScore=" + totalScore +
                ", places=" + places +
                '}';
    }
}
