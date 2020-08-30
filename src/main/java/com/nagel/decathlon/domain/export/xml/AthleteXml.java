package com.nagel.decathlon.domain.export.xml;

import com.nagel.decathlon.domain.AthleteResult;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * AthleteXml.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
@XmlRootElement
@XmlType(propOrder = {"name", "athleteResults", "totalScore", "place"})
public class AthleteXml {

    private String name;
    private List<AthleteResult> athleteResults;
    private int totalScore;
    private String place;

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
