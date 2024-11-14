package week8.lesson_12_11.test;

import java.util.*;

public class DoctorsAppointment {
    // Используя одну из коллекций, напишите программу «Очередь к врачу». Пациенты могут бронировать любой временной слот
    // (например, 1 - 9:00, 2 - 9:30, 3 - 10:00 и т.д.) для приёма у доктора, при этом указывая в записи своё имя.
    // В день приёма программа должна выводить врачу имя следующего пациента строго в порядке номера временного слота.
    public static void main(String[] args) {
        List<String> timeSlotsList = new ArrayList<>(List.of("9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00",
                "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30"));

        Collections.shuffle(timeSlotsList);

        Comparator<String> comparator = (o1, o2) -> {
            String[] splitStr1 = o1.split(":");
            String[] splitStr2 = o2.split(":");
            int result = Integer.compare(Integer.parseInt(splitStr1[0]), Integer.parseInt(splitStr2[0]));
            if (result == 0) {
                result = Integer.compare(Integer.parseInt(splitStr1[1]), Integer.parseInt(splitStr2[1]));
            }
            return result;
        };

        Map<String, String> timeNamesSlots = new TreeMap<>(comparator);

        for (int i = 0; i < timeSlotsList.size(); i++) {
            timeNamesSlots.put(timeSlotsList.get(i), "Name" + i);
        }

        timeNamesSlots.entrySet().forEach(System.out::println);

    }
}
