package com.nagel.decathlon.service.input;

import com.nagel.decathlon.domain.Athlete;
import com.nagel.decathlon.domain.AthleteResult;
import com.nagel.decathlon.domain.Event;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * CsvInputResultProcessor.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class CsvInputResultProcessor implements InputResultProcessor {

    private final static String DELIMITER = ";";

    public List<Athlete> loadInputResult(String filePath) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath))) {
            return bufferedReader.lines()
                    .filter(line -> !line.isEmpty())
                    .map(line -> line.split(DELIMITER))
                    .map(this::getAthlete)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to load result from file. FileName:%s", filePath), e);
        }
    }

    private Athlete getAthlete(String[] values) {
        Athlete athlete = new Athlete();
        athlete.setName(values[0]);
        List<AthleteResult> athleteResults = getAthleteResults(values);
        athlete.setAthleteResults(athleteResults);
        return athlete;
    }

    private List<AthleteResult> getAthleteResults(String[] values) {
        return IntStream.range(1, values.length)
                .mapToObj(order -> getAthleteResult(values[order], order))
                .collect(Collectors.toList());
    }

    private AthleteResult getAthleteResult(String value, Integer order) {
        AthleteResult athleteResult = new AthleteResult();
        athleteResult.setEvent(Event.getFromOrder(order));
        athleteResult.setScore(value);
        return athleteResult;
    }
}
