package com.learning.java8;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class DateApiTest {
    @Test
    @DisplayName("New Java Date API")
    public void testGetFormatDateTimeJava8() {
        LocalDateTime dateTime = LocalDateTime.of(2018, Month.JANUARY, 1, 10, 11, 50);

        String formatDateTimeJava8 = new DateApi().getFormatDateTimeJava8(dateTime);

        log.info("formatDateTimeJava8: {}", formatDateTimeJava8);

        assertThat(formatDateTimeJava8).isEqualTo("2018-01-01T10:11:50");
    }

    @Test
    @DisplayName("Java Date Old Way")
    public void testGetFormatDateTimeOldWay() {
        Calendar calendar = new GregorianCalendar(2018, 0, 1, 10, 11, 50); //Ugly month starts with 0 = January

        String formatDateTimeOldWay = new DateApi().getFormatDateTimeOldWay(calendar);

        log.info("formatDateTimeOldWay: {}", formatDateTimeOldWay);

        assertThat(formatDateTimeOldWay).isEqualTo("2018-01-01T10:11:50");
    }
}
