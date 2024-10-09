package week3.lesson08102024.homework;

import java.util.Arrays;

public class Student {
    private String name;
    private String surname;
    private Subject[] subjects;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        subjects = new Subject[Subject.values().length];
    }

    public boolean knows(Subject subject) {
        for (Subject subj : subjects) {
            if (subject == subj) {
                System.out.println(name + " " + surname + " has already studied "
                        + subject.name());
                return true;
            }
        }
        System.out.println(name + " " + surname + " hasn't studied "
                + subject.name() + " yet");
        return false;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public String getAllStudiedSubjects() {
        StringBuilder studiedSubjects = new StringBuilder();
        for (Subject subject : subjects) {
            if (subject != null) {
                studiedSubjects.append(subject.name())
                        .append(" ");
            }
        }
        return studiedSubjects.toString();
    }

    @Override
    public String toString() {
        return name + " " + surname + " knows: "
                + getAllStudiedSubjects().trim();
    }
}
