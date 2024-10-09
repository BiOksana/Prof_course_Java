package week3.lesson08102024.homework;

public class Teacher {
    private Subject subject;

    public Teacher(Subject subject) {
        this.subject = subject;
    }

    public void teach(Student student) {
        if (student.knows(this.subject)) {
            return;
        }

        for (int i = 0; i < student.getSubjects().length; i++) {
            if (student.getSubjects()[i] == null) {
                student.getSubjects()[i] = this.subject;
                System.out.println(student.getName() + " "
                        + student.getSurname() + " studies the "
                        + this.subject);
                break;
            }
        }
    }

    public void teach(Student[] students) {
        for (Student student : students) {
            teach(student);
        }
    }
}
