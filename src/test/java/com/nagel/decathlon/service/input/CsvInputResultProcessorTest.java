package com.nagel.decathlon.service.input;

import com.nagel.decathlon.domain.Athlete;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class CsvInputResultProcessorTest {

    private CsvInputResultProcessor sut;

    @Before
    public void init() {
        sut = new CsvInputResultProcessor();
    }

    @Test
    public void Should_load_input_result_When_file_exist() {
        //given
        Path resourceDirectory = Paths.get("src", "test", "resources", "results.csv");
        String inputFilePath = resourceDirectory.toFile().getAbsolutePath();

        //when
        List<Athlete> actual = sut.loadInputResult(inputFilePath);

        //then
        assertThat(actual, hasSize(4));
        assertThat(actual.get(0).getName(), equalTo("John Smith"));
        assertThat(actual.get(0).getAthleteResults(), hasSize(10));
    }

    @Test(expected = RuntimeException.class)
    public void Should_throw_exception_When_file_not_exist() {
        //given
        Path resourceDirectory = Paths.get("src", "test", "resources", "unknown.csv");
        String inputFilePath = resourceDirectory.toFile().getAbsolutePath();

        //when
        sut.loadInputResult(inputFilePath);
    }
}