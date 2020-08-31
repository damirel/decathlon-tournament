package com.nagel.decathlon.app;

import com.nagel.decathlon.domain.Athlete;
import com.nagel.decathlon.domain.Tournament;
import com.nagel.decathlon.service.input.CsvInputResultProcessor;
import com.nagel.decathlon.service.input.InputResultProcessor;
import com.nagel.decathlon.service.output.ExportService;
import com.nagel.decathlon.service.output.XmlExportService;
import com.nagel.decathlon.service.tournament.TournamentService;
import com.nagel.decathlon.service.tournament.TournamentServiceImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import static com.nagel.decathlon.utils.Constants.FILE_PATH;
import static com.nagel.decathlon.utils.Constants.USER_PATH;

/**
 * DecathlonTournament.
 * <p>
 * Date: 29/08/2020
 *
 * @author dfatkulin
 */
public class DecathlonTournament {

    private final static String PROPERTIES_FILE = "application.properties";
    private final static String INPUT_FILE_PROPERTY = "input.result.name";
    private final static String OUTPUT_FILE_PROPERTY = "output.result.name";

    private final InputResultProcessor inputResultProcessor;
    private final TournamentService tournamentService;
    private final ExportService exportService;

    public DecathlonTournament(InputResultProcessor inputResultProcessor,
                               TournamentService tournamentService,
                               ExportService exportService) {
        this.inputResultProcessor = inputResultProcessor;
        this.tournamentService = tournamentService;
        this.exportService = exportService;
    }

    public DecathlonTournament() {
        inputResultProcessor = new CsvInputResultProcessor();
        tournamentService = new TournamentServiceImpl();
        exportService = new XmlExportService();
    }

    public void start() {
        Properties properties = loadProperties();
        String inputFilePath = String.format(FILE_PATH, USER_PATH, properties.getProperty(INPUT_FILE_PROPERTY));
        List<Athlete> athletes = inputResultProcessor.loadInputResult(inputFilePath);
        Tournament tournament = tournamentService.calculateResult(athletes);
        String exportFilePath = String.format(FILE_PATH, USER_PATH, properties.getProperty(OUTPUT_FILE_PROPERTY));
        exportService.export(tournament, exportFilePath);
    }

    private Properties loadProperties() {
        String fileName = String.format(FILE_PATH, USER_PATH, PROPERTIES_FILE);
        try (InputStream input = new FileInputStream(fileName)) {
            Properties result = new Properties();
            result.load(input);
            return result;
        } catch (IOException e) {
            throw new RuntimeException(String.format("Failed to load properties file. FileName:%s", fileName), e);
        }
    }
}
