package week15.lesson_16_01_25.homework.studentTask;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentInfo {

    String name();
    String surname();
    int groupNumber();
    boolean isOnline();
}
