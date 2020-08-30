package com.nagel.decathlon.domain.export.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * TournamentXml.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
@XmlRootElement(name = "tournament")
@XmlAccessorType(XmlAccessType.FIELD)
public class TournamentXml {

    public TournamentXml() {
    }

    public TournamentXml(List<AthleteXml> athletes) {
        this.athletes = athletes;
    }

    @XmlElement(name = "athlete")
    private List<AthleteXml> athletes;

    public List<AthleteXml> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<AthleteXml> athletes) {
        this.athletes = athletes;
    }
}
