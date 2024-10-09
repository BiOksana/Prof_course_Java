package week3.lesson08102024.homework;

public class School {
   //    Реализовать модель школы:
//    класс Teacher
//    класс Student
//    класс School c методом main()
//    a) Создать перечисление Subject с названием предметов в школе. Каждый
//    учитель знает только один предмет.
//    b) Создать массивы предметов у учеников (с изученными предметами).
//    При инициализации - пустые.
//    c) Реализовать логику методов
//    teach(Student student)
//    teach(Student[] students)
//    у учителя с данными перечислениями, чтобы после выполнения teach()
//    у соответствующих учеников добавлялась информация о пройденном предмете.
//    d) В классе Student добавить метод проверки knows(Subject subject).
//    Метод выдает true если студент изучил данный предмет и false в противном случае.
//    e) Продемонстрировать работу функционала в классе School
    public static void main(String[] args) {
       Teacher mathTeacher = new Teacher(Subject.MATHEMATICS);
       Teacher informaticsTeacher = new Teacher(Subject.INFORMATICS);
       Teacher englishTeacher = new Teacher(Subject.ENGLISH);
       Teacher historyTeacher = new Teacher(Subject.HISTORY);
       Teacher geographyTeacher = new Teacher(Subject.GEOGRAPHY);
       Teacher physicsTeacher = new Teacher(Subject.PHYSICS);
       Teacher chemistryTeacher = new Teacher(Subject.CHEMISTRY);
       Teacher biologyTeacher = new Teacher(Subject.BIOLOGY);
       Teacher literatureTeacher = new Teacher(Subject.LITERATURE);
       Teacher physicalEducationTeacher = new Teacher(Subject.PHYSICAL_EDUCATION);

       Student student1 = new Student("Anton", "Sidorov");
       Student student2 = new Student("Sergey", "Petrov");
       Student student3 = new Student("Mikhail", "Andreev");
       Student student4 = new Student("Anrew", "Sergeev");
       Student student5 = new Student("Olga", "Ivanova");
       Student student6 = new Student("Irina", "Alexeeva");
       Student student7 = new Student("Svetlana", "Egorova");
       Student student8 = new Student("Oleg", "Svetlov");
       Student student9 = new Student("Nata", "Pavlova");
       Student student10 = new Student("Elena", "Nikolaeva");
       Student student11 = new Student("Ihor", "Belov");
       Student student12 = new Student("Lev", "Shevchenko");

       Student[] studentsOfTheFirstGroup = {student1, student2, student3, student4, student5, student6};
       Student[] studentsOfTheSecondGroup = {student7, student8, student9, student10, student11, student12};
       Student[] studentsOfTheEnglishLesson = {student6, student11, student4, student5, student9, student12};
       Student[] studentsOfTheTheHistory = {student8, student3, student1, student10, student6, student11, student9};
               mathTeacher.teach(studentsOfTheFirstGroup);

       geographyTeacher.teach(student7);
       student7.knows(Subject.PHYSICAL_EDUCATION);
       student7.knows(Subject.GEOGRAPHY);
       System.out.println();

       geographyTeacher.teach(studentsOfTheSecondGroup);

       System.out.println();

       englishTeacher.teach(studentsOfTheEnglishLesson);

       System.out.println();

       historyTeacher.teach(studentsOfTheTheHistory);

       System.out.println();

       physicsTeacher.teach(studentsOfTheFirstGroup);

       System.out.println();

       chemistryTeacher.teach(studentsOfTheSecondGroup);

       for (Student student : studentsOfTheSecondGroup) {
          System.out.println(student);
       }
    }

}
