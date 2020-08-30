package com.nagel.decathlon.domain;

import java.util.Objects;

/**
 * AthleteResult.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class AthleteResult {

    private Event event;
    private String score;

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AthleteResult that = (AthleteResult) o;
        return event == that.event &&
                Objects.equals(score, that.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event, score);
    }

    @Override
    public String toString() {
        return "AthleteResult{" +
                "event=" + event +
                ", score='" + score + '\'' +
                '}';
    }
}
