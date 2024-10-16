package week3.lesson08102024.homework;

public class Teacher {
    private Subject subject;

    public Teacher(Subject subject) {
        this.subject = subject;
    }

    public void teach(Student student) {
        if (student.knows(subject)) {
            return;
        }
        System.out.println(this.getClass().getSimpleName() + " teaches "
                                                            + student.getSurname()
                                                            + " " + subject);
        student.learn(subject);
    }

    public void teach(Student[] students) {
        for (Student student : students) {
            teach(student);
        }
    }
}
