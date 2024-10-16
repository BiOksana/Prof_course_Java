package week3.lesson08102024.homework;

import java.util.Arrays;

public class Student implements Cloneable {
    private String name;
    private String surname;
    private Subject[] subjects;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        subjects = new Subject[Subject.values().length];
    }

    public Student(Student student) {
        this.name = student.name;
        this.surname = student.surname;
        this.subjects = student.subjects;
    }

    public Student makeCopy() {
        return new Student(this);
    }

    public Student deepCopy() {
        String newNameStr = new String(name);
        String newSurnameStr = new String(surname);
        Subject[] newSubjectsArray = Arrays.copyOf(subjects, subjects.length);
        Student newStudent = new Student(newNameStr, newSurnameStr);
        newStudent.subjects = newSubjectsArray;
        return newStudent;
    }

    public boolean knows(Subject subject) {
        return subjects[subject.ordinal()] == subject;
    }

    public void learn(Subject subject) {
        subjects[subject.ordinal()] = subject;
        System.out.println("Student " + name + " " + surname + " learns " + subject);
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

    public void setName(String name) {
        this.name = name;
    }

    public Subject[] getAllStudiedSubjects() {
        Subject[] studiedSubjects = new Subject[subjects.length];
        int index = 0;
        for (Subject subject : subjects) {
            if (subject != null) {
                studiedSubjects[index] = subject;
                index++;
            }
        }
        studiedSubjects = Arrays.copyOf(studiedSubjects, index);
        return studiedSubjects;
    }

    @Override
    public String toString() {
        return name + " " + surname + " knows: "
                + Arrays.toString(getAllStudiedSubjects());
    }
}
