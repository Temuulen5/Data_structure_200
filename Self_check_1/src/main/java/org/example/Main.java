package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Registration registration = new Registration();

    public static void main(String[] args) {
        readSubjects();
        readProfessions();
        readExams();
        registration.PrintSubjectList();
        registration.PrintMajorList();
        registration.PrintStudentList();
        System.out.printf("Niit oyutnii dundaj GPA : %.3f\n", registration.GetAverageGPA());
        registration.PrintFailedStudents();
        registration.PrintStudentsBySubject();
        registration.PrintStudentsByMajor();
    }

    private static void readSubjects() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/main/resources/Subject.txt"));
            String line;

            while ((line = input.readLine()) != null) {
                String[] values = line.split("/");
                Subject subject = new Subject();
                subject.setCode(values[0]);
                subject.setName(values[1]);
                subject.setCredit(Float.parseFloat(values[2]));
                registration.subjectList.add(registration.subjectList.size(), subject);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static void readProfessions() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/main/resources/Professions.txt"));
            String line;

            while ((line = input.readLine()) != null) {
                String[] values = line.split("/");
                Major major = new Major();
                major.setCode(values[0]);
                major.setName(values[1]);
                registration.majorList.add(registration.majorList.size(), major);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private static void readExams() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("src/main/resources/Exams.txt"));
            String line;

            while ((line = input.readLine()) != null) {
                String[] values = line.split("/");

                Student student = registration.GetStudentByCode(values[0]);
                Lessons lesson = new Lessons();
                Subject subject = registration.GetSubjectByCode(values[1]);

                lesson.setLearned(subject);
                lesson.setScore(Integer.parseInt(values[2]));

                if (student == null) {
                    student = new Student();
                    student.setCode(values[0]);
                    student.lessons.add(student.lessons.size(), lesson);
                    registration.studentList.add(registration.studentList.size(), student);
                } else {
                    student.lessons.add(student.lessons.size(), lesson);
                }
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}