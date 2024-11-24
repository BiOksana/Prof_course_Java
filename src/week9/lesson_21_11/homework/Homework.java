package week9.lesson_21_11.homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Homework {
    public static void main(String[] args) {
        //    1. Переписать через стримы фрагменты кода:

        //   a)
        List<Double> doubles = new ArrayList<>();
        //	for (Double d : doubleList) {
        //		if (d % 2 == 1) {
        //			doubles.add(d);
        //		}
        //	}
        List<Double> doubleList = List.of(3.0, 5.0, 6.3, 1.0, 7.0, 3.6, 2.2);
        doubleList.stream()
                .filter(d -> d % 2 == 1)
                .forEach(doubles::add);
        System.out.println("Task a: " + doubles);

        //    b)
        String word = null;
        //	for (String t : list){
        //		if (t.length() == 3) {
        //			word = t;
        //			break;
        //		}
        //	}
        List<String> list = List.of("Three", "Two", "Five", "One");
        word = list.stream()
                .filter(s -> s.length() == 3).findFirst().orElse("String not found");
        System.out.println("Task b: " + word);

        //    c)
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        System.out.println("Task c: getSum() = " + getSum(numbers));

        //    d)
//        list.toArray(String[]::new);
        System.out.println("Task d: findIndex element \"One\" = " + findIndex(list.toArray(String[]::new), "One"));


        //    e)
        //        double sum = 0.0;
        //        for (int i = 0; i < 10_000; i++) {
        //            sum += 0.1;
        //        }
        //        System.out.println("sum = " + sum);
        System.out.println("Task e: " + IntStream.rangeClosed(1, 10000)
                .asDoubleStream()
                .reduce(0.0, (r, i) -> r + 0.1));

        //    f)
        List<Integer> integerList = new ArrayList<>();
        fill(integerList, 5);
        System.out.println("Task f: fill(integerList, 5) = " + integerList);

        //    g)
        Set<String> names = Set.of("Ivan", "Peter", "William", "Mary");
        Set<Integer> integerSet = new TreeSet<>();
        //	for (String s : names) {
        //		integerSet.add(s.length());
        //	}
        integerSet = names.stream()
                .map(s -> s.length())
                .collect(Collectors.toSet());
        System.out.println("Task g: integerSet " + integerSet);

        //    h)
        System.out.println("Task h: getMap() : ");
        getMap().entrySet().forEach(System.out::println);

        //2. С помощью IntStream и метода flatmap() получить все тройки пифагоровых чисел менее 1000.
        //(Пифагорова тройка - упорядоченный набор из трёх натуральных чисел (a, b, c),
        //удовлетворяющих уравнению a^2 + b^2 = c^2. Например, [3, 4, 5], [6, 8, 10]).
        //        IntStream.range(1, 1000)
        //                .flatMap(i -> IntStream.rangeClosed(i, i + 2)).peek(System.out::println).collect()

        System.out.println("Task 2: Пифагоровы тройки: ");
        IntStream.range(1, 1000)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, 1000).boxed().flatMap(j -> IntStream.range(j + 1, 1000).filter(v -> i * i + j * j == v * v)
                        .mapToObj(v -> new int[]{i, j, v}))).forEach(v -> System.out.println(Arrays.toString(v)));


    }


    public static int getSum(List<Integer> integers) {
//        int oddSum = 0;
//        for(Integer i: integers) {
//            if(i % 2 != 0) {
//                oddSum += i;
//            }
//        }
//        return oddSum;
        return integers.stream()
                .filter(i -> i % 2 != 0)
                .reduce(0, Integer::sum);
    }


    public static int findIndex(String[] data, String element) {
//        for (int i = 0; i < data.length; i++) {
//            if (data[i].equals(element)) {
//                return i;
//            }
//        }
//        return -1;
        return IntStream.range(0, data.length).filter(i -> data[i].equals(element)).findFirst().orElse(-1);

    }


    public static void fill(List<Integer> list, int capacity) {
//		for (int i = 0; i < capacity; i++) {
//			list.add(i);
//		}

        IntStream.range(0, capacity)
                .forEach(list::add);
    }


    public static Map<Boolean, List<Integer>> getMap() {
        Map<Boolean, List<Integer>> map = new TreeMap<>();
//        for (int i = 0; i < 100; i++) {
//            if (i % 3 == 0) {
//                if (map.containsKey(true)) {
//                    map.get(true).add(i);
//                } else {
//                    map.put(true, new ArrayList<>());
//                    map.get(true).add(i);
//                }
//            } else {
//                if (map.containsKey(false)) {
//                    map.get(false).add(i);
//                } else {
//                    map.put(false, new ArrayList<>());
//                    map.get(false).add(i);
//                }
//            }
//        }

        Map<Boolean, List<Integer>> collect = IntStream.range(0, 100)
                .boxed()
                .collect(Collectors.partitioningBy(v -> v % 3 == 0, Collectors.toCollection(ArrayList::new)));
        return collect;
    }
//


}
