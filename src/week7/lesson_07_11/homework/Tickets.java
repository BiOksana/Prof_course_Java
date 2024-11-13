package week7.lesson_07_11.homework;

import java.util.*;

public class Tickets {
    //Составить маршрут из заданного списка билетов
    //Имеется перемешанный список билетов. Необходимо найти маршрут, восстановив порядок билетов.
    //Вход:
    //«Berlin» -> «London»
    //«Tokyo» -> «Seoul»
    //«Mumbai» -> «Berlin»
    //«Seoul» -> «Mumbai»
    //
    //
    //Выход:
    //Tokyo->Seoul, Seoul->Mumbai, Mumbai->Berlin, Berlin->London
    public static void main(String[] args) {
        Map<String, String> tickets = Map.of("Berlin", "London", "Tokyo", "Seoul", "Mumbai", "Berlin", "Seoul", "Mumbai");
        System.out.println("makeRout(tickets) = " + makeRout(tickets));
    }

    private static Map<String, String> makeRout(Map<String, String> map) {
        Map<String, String> newMap = new LinkedHashMap<>();
        String currentKey = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!map.containsValue(entry.getKey())) {
                currentKey = entry.getKey();
            }
        }

        while (map.containsKey(currentKey)) {
            newMap.put(currentKey, map.get(currentKey));
            currentKey = map.get(currentKey);
        }
        System.out.println("newMap = " + newMap);

        return newMap;
    }
}
