package com.nagel.decathlon.utils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class EventUtilsTest {

    @Test
    public void Should_convert_to_double_When_string_with_meters_given() {
        //given
        String distance = "1.50";

        //when
        double actual = EventUtils.convert(distance);

        //then
        assertThat(actual, equalTo(1.50d));
    }

    @Test
    public void Should_convert_to_double_When_string_with_minutes_and_seconds_given() {
        //given
        String duration = "5:25.72";

        //when
        double actual = EventUtils.convert(duration);

        //then
        assertThat(actual, equalTo(325.72d));
    }
}