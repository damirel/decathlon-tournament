package com.nagel.decathlon.domain;

import java.util.List;

/**
 * Tournament.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class Tournament {

    public Tournament(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    private List<Athlete> athletes;

    public List<Athlete> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Athlete> athletes) {
        this.athletes = athletes;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "athletes=" + athletes +
                '}';
    }
}
