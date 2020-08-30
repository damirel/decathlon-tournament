package com.nagel.decathlon.service.output;

import com.nagel.decathlon.domain.Athlete;
import com.nagel.decathlon.domain.Tournament;
import com.nagel.decathlon.domain.export.xml.AthleteXml;
import com.nagel.decathlon.domain.export.xml.TournamentXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static com.nagel.decathlon.utils.Constants.FILE_PATH;
import static com.nagel.decathlon.utils.Constants.USER_PATH;

/**
 * XmlExportService.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class XmlExportService implements ExportService {

    @Override
    public void export(Tournament tournament, String fileName) {
        File file = new File(String.format(FILE_PATH, USER_PATH, fileName));
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(TournamentXml.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(convert(tournament), file);
        } catch (JAXBException e) {
            throw new RuntimeException(
                    String.format("Error, while exporting result for the tournament. Tournament:%s", tournament), e);
        }
    }

    private TournamentXml convert(Tournament tournament) {
        List<AthleteXml> athletes = convert(tournament.getAthletes());
        return new TournamentXml(athletes);
    }

    private List<AthleteXml> convert(List<Athlete> athletes) {
        return athletes.stream()
                .map(this::getAthleteXml)
                .collect(Collectors.toList());
    }

    private AthleteXml getAthleteXml(Athlete athlete) {
        AthleteXml athleteXml = new AthleteXml();
        athleteXml.setName(athlete.getName());
        athleteXml.setAthleteResults(athlete.getAthleteResults());
        athleteXml.setTotalScore(athlete.getTotalScore());
        athleteXml.setPlace(convertPlace(athlete.getPlaces()));
        return athleteXml;
    }

    private String convertPlace(List<Integer> places) {
        return places.stream()
                .map(Object::toString)
                .collect(Collectors.joining("-"));
    }
}
