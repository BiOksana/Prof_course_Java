package week9.lesson_19_11.practice;

import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

class StreamTask2 {

    @Getter
    static class Person {
        String name;
        int age;
        String city;
        String email;
        double salary;

        Person(String name, int age, String city, String email, double salary) {
            this.name = name;
            this.age = age;
            this.city = city;
            this.email = email;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', age=" + age + ", city='" + city + "', email='" + email + "', salary=" + salary + '}';
        }
    }

    public static void main(String[] args) {
        Person person1 = new Person("Chelsey", 47, "South Edmund", "shavonda.herman@hotmail.com", 2872.00);
        Person person2 = new Person("Debera", 35, "East Milford", "louis.lakin@gmail.com", 4787.54);
        Person person3 = new Person( "Wilbert", 48, "New Shermanmouth", "celsa.gorczany@gmail.com", 3975.64);
        Person person4 = new Person( "Donovan", 22, "Wiegandshire", "darci.huel@gmail.com", 3677.57);
        Person person5 = new Person("Reda", 53, "Lornatown", "stan.shanahan@gmail.com", 2611.97);
        Person person6 = new Person("Isaias", 20, "Pacochaland", "christal.hermann@yahoo.com", 4959.21);
        Person person7 = new Person("Nancie", 65, "North Nola", "aleisha.dicki@yahoo.com", 3984.91);
        Person person8 = new Person("Susie", 45, "Albertside", "chi.rempel@hotmail.com", 4594.19);
        Person person9 = new Person("Stefan", 27, "North Nelson", "fausto.kirlin@gmail.com", 1593.96);
        Person person10 = new Person("Mia", 56, "Jonesmouth", "tom.auer@yahoo.com", 4550.66);
        Person person11 = new Person("Arnetta", 75, "Zanemouth", "phillip.willms@gmail.com", 1273.90);
        Person person12 = new Person("Rocco", 57, "North Gita", "rudolph.marquardt@yahoo.com", 2105.68);
        Person person13 = new Person("Bobby", 61, "Gleasontown", "mandie.torphy@hotmail.com", 2885.59);
        Person person14 = new Person("Barbra", 17, "South Ellena", "david.hermiston@hotmail.com", 1791.91);
        Person person15 = new Person("Wilbert", 44, "Jacqulinestad", "rosena.pouros@gmail.com", 4886.75);
        Person person16 = new Person( "Hilton", 59, "Roweland", "carey.kuvalis@yahoo.com", 3344.14);
        Person person17 = new Person( "Melvina", 28, "South Kyleview", "donald.quitzon@gmail.com", 2796.73);
        Person person18 = new Person("Nathalie", 22, "Rashadmouth", "maurice.zemlak@hotmail.com", 4348.75);
        Person person19 = new Person("Domingo", 18, "Niabury", "renato.mayer@yahoo.com", 2479.07);
        Person person20 = new Person("Darius", 32, "New Lindsy", "lucio.konopelski@hotmail.com", 3772.20);
        Person person21 = new Person("Jared", 25, "Lake Magdafurt", "consuelo.quitzon@gmail.com", 3201.06);
        Person person22 = new Person("Pierre", 23, "Ashleastad", "olen.nolan@hotmail.com", 2142.02);
        Person person23 = new Person("Maegan", 38, "Port Doyleton", "jodee.lang@yahoo.com", 3589.45);
        Person person24 = new Person("Dwight", 61, "Antonettefort", "hugh.brakus@gmail.com", 1876.45);
        Person person25 = new Person("Aundra", 22, "Lake Yichester", "patrick.larson@hotmail.com", 1886.87);
        Person person26 = new Person("Ronnie", 25, "Marlinfurt", "bernie.homenick@gmail.com", 1106.73);
        Person person27 = new Person("Mathilda", 34, "Keelingburgh", "valentin.ernser@gmail.com", 4323.39);
        Person person28 = new Person("Tomeka", 36, "East Winfred", "sybil.emard@hotmail.com", 2308.47);
        Person person29 = new Person("Doug", 41, "Jacquesmouth", "cori.murazik@gmail.com", 1953.03);
        Person person30 = new Person("Ike", 44, "New Lazaro", "annelle.schaefer@gmail.com", 3156.35);
        Person person31 = new Person("Wilson", 49, "Mohrtown", "shon.kuphal@hotmail.com", 2965.15);
        Person person32 = new Person("Raye", 18, "Hilllstad", "lamar.graham@yahoo.com", 1238.92);
        Person person33 = new Person("Miguel", 41, "South Jarrettstad", "seymour.larson@hotmail.com", 2265.66);
        Person person34 = new Person("Taylor", 49, "New Nickolasshire", "mila.deckow@hotmail.com", 2618.13);
        Person person35 = new Person("Duane", 27, "Coyton", "bruno.mclaughlin@gmail.com", 1033.29);
        Person person36 = new Person("Clint", 60, "Lake Springton", "joe.shanahan@gmail.com", 4690.49);
        Person person37 = new Person("Morton", 28, "West Orval", "nigel.connelly@gmail.com", 3991.34);
        Person person38 = new Person("Nila", 64, "Ludieton", "aubrey.ondricka@gmail.com", 2405.02);
        Person person39 = new Person("Geoffrey", 55, "East Carmine", "oscar.turner@yahoo.com", 1295.33);
        Person person40 = new Person("Zonia", 54, "Venettastad", "alonso.pacocha@yahoo.com", 3615.11);

        List<Person> personList = new ArrayList<>(List.of(person1, person2, person3, person4, person5, person6, person7, person8,
                person9, person10, person11, person12, person13, person14, person15, person16, person17, person18, person19, person20,
                person21, person22, person23, person24, person25, person26, person27, person28, person29, person30, person31, person32,
                person33, person34, person35, person36, person37, person38, person39, person40));

        System.out.println("task1(personList) = " + task1(personList).size());
        System.out.println("task2(personList) = " + task2(personList));
        System.out.println("task3(personList) = " + task3(personList));
        System.out.println("task4(personList) = " + task4(personList));
        System.out.println("task7(personList) = " + task7(personList));
        System.out.println("task9(personList) = " + task9(personList));
        System.out.println("task10(personList) = " + task10(personList));
        System.out.println("task11(personList) = " + task11(personList));
        System.out.println("task12(personList) = " + task12(personList));
        System.out.println("task13(personList) = " + task13(personList));
        System.out.println("task14(personList) = " + task14(personList));
        System.out.println("task15(personList) = " + task15(personList));
        System.out.println("task16(personList) = " + task16(personList));
        System.out.println("task17(personList) = " + task17(personList));
        System.out.println("task18(personList) = " + task18(personList));
        System.out.println("task19(personList) = " + task19(personList));
        System.out.println("task20(personList) = " + task20(personList));
        System.out.println("task22(personList) = " + task22(personList));
        System.out.println("task27(personList) = " + task27(personList));
    }

    // 1. Найти всех людей старше 20 лет и вернуть их имена в списке.
    public static List<String> task1(List<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() > 20)
                .map(Person::getName).toList();
    }

    // 2. Найти сумму возрастов всех людей, имя которых начинается с буквы 'A'.
    public static int task2(List<Person> people) {
        return people.stream()
                .filter(person -> person.getName().startsWith("A"))
                .map(Person::getAge)
                .reduce(0, Integer::sum);
    }

    // 3. Получить список уникальных возрастов людей.
    public static List<Integer> task3(List<Person> people) {
        return people.stream()
                .map(Person::getAge)
                .distinct()
                .sorted()
                .toList();
    }

    // 4. Найти средний возраст людей младше 18 лет.
    public static double task4(List<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() < 18)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0.0);
    }

    // 7. Получить список имен всех людей, возраст которых делится на 3.
    public static List<String> task7(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() % 3 == 0)
                .map(person -> person.getName())
                .toList();
    }


    // 9. Получить список имен людей, отсортированных в алфавитном порядке.
    public static List<String> task9(List<Person> people) {
        return people.stream()
                .map(Person::getName)
                .sorted()
                .toList();
    }

    // 10. Найти общую длину всех имен людей, старше 30 лет.
    public static int task10(List<Person> people) {
        return people.stream()
                .filter(person -> person.getAge() > 30)
                .map(person -> person.getName().length())
                .reduce(0, Integer::sum);
    }

    // 11. Получить список людей, чьи имена короче 4 символов.
    public static List<Person> task11(List<Person> people) {
        return people.stream()
                .filter(person -> person.getName().length() < 4)
                .toList();
    }

    // 12. Найти самый длинный возраст человека.
    public static int task12(List<Person> people) {
        return people.stream()
                .map(Person::getAge)
                .reduce(0, Integer::max);
    }

    // 13. Получить список всех людей, отсортированных по длине имени.
    public static List<Person> task13(List<Person> people) {
        return people.stream()
                .sorted((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge()))
                .toList();
    }

    // 14. Найти имя самого молодого человека.
    public static String task14(List<Person> people) {
        Person person = people.stream().min(Comparator.comparingInt(Person::getAge)).get();
        return person.getName();
    }

    // 15. Получить список возрастов людей, имена которых заканчиваются на 'n'.
    public static List<Integer> task15(List<Person> people) {
        return people.stream()
                .filter(person -> person.getName().endsWith("n"))
                .map(Person::getAge)
                .toList();
    }

    // 16. Найти общий возраст всех людей с уникальными именами.
    public static int task16(List<Person> people) {
        return people.stream()
                .collect(Collectors.toMap(Person::getName, Person::getAge, Integer::sum))
                .values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    // 17. Получить список имен всех людей, отсортированных в обратном алфавитном порядке.
    public static List<String> task17(List<Person> people) {
        return people.stream()
                .map(Person::getName)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    // 18. Найти средний возраст людей, чьи имена состоят из 5 символов.
    public static double task18(List<Person> people) {
        return people.stream()
                .filter(p -> p.getName().length() == 5)
                .mapToInt(p -> p.getAge())
                .average()
                .orElse(0.0);
    }

    // 19. Получить список имен людей, возраст которых кратен 5.
    public static List<String> task19(List<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() % 5 == 0)
                .map(Person::getName)
                .toList();
    }

    // 20. Найти сумму длин всех имен людей, у которых возраст четный.
    public static int task20(List<Person> people) {
        return people.stream()
                .filter(p -> p.getAge() % 2 == 0)
                .mapToInt(p -> p.getName().length())
                .sum();
    }


    // 22. Получить список людей, у которых зарплата больше 3000, отсортированных по убыванию зарплаты.
    public static List<Person> task22(List<Person> people) {
        return people.stream()
                .filter(p -> p.getSalary() > 3000)
                .sorted((p1, p2) -> Double.compare(p2.getSalary(), p1.getSalary()))
                .toList();
    }


    // 27. Получить список имен людей с зарплатой больше 50,000 и возрастом меньше 30, отсортированных по возрасту.
    public static List<String> task27(List<Person> people) {
        return people.stream()
                .filter(p -> p.getSalary() > 3000 && p.getAge() < 30)
                .sorted(Comparator.comparingInt(Person::getAge))
                .map(Person::getName)
                .toList();
    }
}
