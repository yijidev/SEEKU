package com.hanium.seeku.Service;

import io.fabric8.kubernetes.api.model.Namespace;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
@Component
 //생성 시간 계산해주는 메소드
public class DateUtils {

     public String formatDuration(String creationTimestamp) {
        ZonedDateTime creationTime = ZonedDateTime.parse(creationTimestamp, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        Duration duration = Duration.between(creationTime, ZonedDateTime.now(ZoneId.of("UTC")));

        long days = duration.toDays();

        if (days >= 365) {
            long years = days / 365;
            return years + (years > 1 ? " years" : " year");
        }

        if (days >= 30) {
            long months = days / 30;
            return months + (months > 1 ? " months" : " month");
        }

        if (days >= 1) {
            return days + " days";
        }

        long hours = duration.toHoursPart();

        if (hours > 0) {
            return hours + " hours";
        }

        long minutes = duration.toMinutesPart();

        if (minutes > 0) {
            return minutes + " minutes";
        }

        long seconds = duration.toSecondsPart();

        return seconds + " seconds";
    }
}
