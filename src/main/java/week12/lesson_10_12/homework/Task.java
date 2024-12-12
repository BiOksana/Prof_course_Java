package week12.lesson_10_12.homework;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Task {

    public static void main(String[] args) {

//    1) Составить список времен начала всех занятий по Java на декабрь 2024,
//  если предположить, что они проходят каждый вторник/четверг/пятницу c 9:30 CET.
        LocalDate start = LocalDate.of(2024, 12, 1);
        LocalDate end = LocalDate.of(2024, 12, 21);

        List<String> lessonsOfJava = start.datesUntil(end, Period.ofDays(1))
                .filter(d -> d.getDayOfWeek().equals(DayOfWeek.TUESDAY)
                        || d.getDayOfWeek().equals(DayOfWeek.THURSDAY)
                        || d.getDayOfWeek().equals(DayOfWeek.FRIDAY))
                .map(d -> d.atTime(9, 30))
                .map(d -> d.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
                .toList();

        lessonsOfJava.forEach(System.out::println);

//2) Рейс из Лос-Анджелеса во Франкфурт отправляется в 15:05 по местному времени и длится 10 ч. 50 м. Во сколько он прилетит?
// Написать метод, который мог бы совершать подобные вычисления.

        System.out.println();
        System.out.println("departureTime in LA = " + ZonedDateTime.of(LocalDate.now(), LocalTime.of(15, 5), ZoneId.of("America/Los_Angeles"))
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        ZonedDateTime arrivalTime = getArrivalTime("America/Los_Angeles", "Europe/Berlin", 15, 5, 10, 50);
        System.out.println("arrivalTime in Frankfurt = " + arrivalTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));

    }

    public static ZonedDateTime getArrivalTime(String departureZone, String arrivalZone,

                                               int departureHour, int departureMinute,
                                               int flightHours, int flightMinutes) {

        LocalTime localTime = LocalTime.of(departureHour, departureMinute);
        LocalDate localDate = LocalDate.now(ZoneId.of(departureZone));
        ZonedDateTime departureTime = ZonedDateTime.of(localDate, localTime, ZoneId.of(departureZone));
        ZonedDateTime zonedDateArrivalTime = departureTime.plus(flightHours, ChronoUnit.HOURS).plus(flightMinutes, ChronoUnit.MINUTES)
                .withZoneSameInstant(ZoneId.of(arrivalZone));
        return zonedDateArrivalTime;
    }


}


