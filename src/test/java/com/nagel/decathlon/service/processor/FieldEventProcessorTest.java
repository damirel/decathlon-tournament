package com.nagel.decathlon.service.processor;

import com.nagel.decathlon.domain.Event;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class FieldEventProcessorTest {

    private FieldEventProcessor sut;

    @Before
    public void init() {
        sut = new FieldEventProcessor();
    }

    @Test
    public void Should_calculate_score_When_field_event_has_score() {
        //given
        String distance = "20.0";

        //when
        int actual = sut.calculateScore(Event.DISCUS_THROW, distance);

        //then
        assertThat(actual, equalTo(272));
    }

    @Test
    public void Should_not_calculate_score_When_field_event_has_small_score() {
        //given
        String distance = "1.0";

        //when
        int actual = sut.calculateScore(Event.DISCUS_THROW, distance);

        //then
        assertThat(actual, equalTo(0));
    }
}