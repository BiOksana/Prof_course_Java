package week4.lesson15_10_2024.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
// У вас есть список значений String, вы должны вернуть список со всеми значениями String более трех символов
//У вас есть список значений Integer, вы должны вернуть список, содержащий только нечетные числа
//У вас есть список значений String, вы должны вернуть список этих значений без каких-либо дубликатов
//У вас есть список значений String, вы должны вернуть одну строку, которая представляет собой конкатенацию всех значений.
//У вас есть список значений Integer, вы должны вернуть их сумму
//У вас есть список значений Integer, вы должны вернуть их максимум
//У вас есть список String, вы должны вернуть максимальную длину String
//Напишите метод для объединения двух списков в один общий ArrayList

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("is");
        list.add("the");
        list.add("best");
        list.add("programming");
        list.add("language");
        list.add("but");
        list.add("one");
        list.add("of");
        list.add("the");
        list.add("most");
        list.add("difficult");
        list.add("language");

        List<Integer> listOfIntegers = new ArrayList<Integer>(List.of(7, 9, 23, 14, 78, 54, 0, 11));
        System.out.println(generateListOfBiggerThanThreeSimbolValues(list));    // Ex.1
        System.out.println(generateListOfOddIntegers(listOfIntegers));          // Ex.2
        System.out.println(getListOfUniqueValues(list));                        // Ex.3
        System.out.println(makeStringFromList(list));                           // Ex.4
        System.out.println("SumOfListValues = " + getSumOfListValues(listOfIntegers));        //Ex. 5
        System.out.println("MaxValueOfList = " + getMaxValueOfList(listOfIntegers));        //Ex. 6
        System.out.println("MaxLengthOfListValues = " + getMaxLengthOfListValues(list));        //Ex. 7
        System.out.println(getOneCommonList(list, listOfIntegers));        //Ex. 8

    }

    private static List<Object> getOneCommonList(List<String> list, List<Integer> listOfIntegers) {
        List<Object> newList = new ArrayList<>();
        for (String s : list) {
            newList.add(s);
        }
        for (Integer integer : listOfIntegers) {
            newList.add(integer);
        }
        return newList;
    }

    private static int getMaxLengthOfListValues(List<String> list) {
        int maxLength = 0;
        for (String s : list) {
            if (s.length() > maxLength) {
                maxLength = s.length();
            }
        }
        return maxLength;
    }

    private static int getMaxValueOfList(List<Integer> list) {
        int maxValue = Integer.MIN_VALUE;
        for (Integer integer : list) {
            if (integer > maxValue) {
                maxValue = integer;
            }
        }
        return maxValue;
    }


    private static int getSumOfListValues(List<Integer> list) {
        int sum = 0;
        for (Integer integer : list) {
            sum += integer;
        }
        return sum;
    }

    private static String makeStringFromList(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s).append(" ");
        }
        return stringBuilder.toString();
    }

    private static List<String> getListOfUniqueValues(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (!newList.contains(s)) {
                newList.add(s);
            }
        }
        return newList;
    }

    private static List<Integer> generateListOfOddIntegers(List<Integer> listOfIntegers) {
        List<Integer> newList = new ArrayList<>();
        for (Integer num : listOfIntegers) {
            if (num % 2 != 0) {
                newList.add(num);
            }
        }
        return newList;
    }

    private static List<String> generateListOfBiggerThanThreeSimbolValues(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (s.length() > 3) {
                newList.add(s);
            }
        }
        return newList;
    }
}
