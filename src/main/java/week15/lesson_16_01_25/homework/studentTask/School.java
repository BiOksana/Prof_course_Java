package week15.lesson_16_01_25.homework.studentTask;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.lang.reflect.Field;


@AllArgsConstructor
@NoArgsConstructor
public class School {
    /*
    Создать аннотацию @StudentInfo и соответствующий инжектор через рефлексию, чтобы с их помощью
иметь возможность инициализировать поля типа Student. Например:
     */
    @StudentInfo(name = "Tom", surname = "Smith", groupNumber = 1101, isOnline = true)
    private Student student1;

    @StudentInfo(name = "Mary", surname = "Jennings", groupNumber = 1102, isOnline = false)
    private Student student2;


    public static void main(String[] args) {
        School school = new School();

        Injector.inject(school);
        System.out.println(school.student1);
        System.out.println(school.student2);
    }

    static class Injector {
        public static void inject(Object object) {
            Class<?> objectClass = object.getClass();

            Field[] objectClassDeclaredFields = objectClass.getDeclaredFields();
            for (Field field : objectClassDeclaredFields) {
                if (field.isAnnotationPresent(StudentInfo.class)) {
                    Class<?> fieldType = field.getType();
                    if (fieldType == Student.class) {
                        StudentInfo annotation = field.getAnnotation(StudentInfo.class);
                        Student newInstanceOfStudent = null;
                        try {
                            newInstanceOfStudent = (Student) Class.forName(fieldType.getName())
                                    .getConstructor().newInstance();
                            newInstanceOfStudent.setName(annotation.name());
                            newInstanceOfStudent.setSurname(annotation.surname());
                            newInstanceOfStudent.setGroupNumber(annotation.groupNumber());
                            newInstanceOfStudent.setOnline(annotation.isOnline());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        field.setAccessible(true);
                        try {
                            field.set(object, newInstanceOfStudent);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        }
    }
}
