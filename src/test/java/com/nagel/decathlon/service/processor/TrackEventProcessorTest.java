package com.nagel.decathlon.service.processor;

import com.nagel.decathlon.domain.Event;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class TrackEventProcessorTest {

    private TrackEventProcessor sut;

    @Before
    public void init() {
        sut = new TrackEventProcessor();
    }

    @Test
    public void Should_calculate_score_When_field_event_has_score() {
        //given
        String distance = "16.43";

        //when
        int actual = sut.calculateScore(Event.ONE_HUNDRED_TEN_M_HURDLES, distance);

        //then
        assertThat(actual, equalTo(685));
    }

    @Test
    public void Should_not_calculate_score_When_field_event_has_small_score() {
        //given
        String distance = "5:25.72";

        //when
        int actual = sut.calculateScore(Event.ONE_THOUSAND_FIVE_HUNDRED_M, distance);

        //then
        assertThat(actual, equalTo(421));
    }

}