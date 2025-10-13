package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static Registration registration = new Registration();

    public static void main(String[] args) {
        registration.readSubjects("src/main/resources/Subjects.txt");
        registration.readProfessions("src/main/resources/Professions.txt");
        registration.readExams("src/main/resources/Exams.txt");
        registration.PrintSubjectList();
        registration.PrintMajorList();
        registration.PrintStudentList();
        System.out.printf("Niit oyutnii dundaj GPA : %.3f\n", registration.GetAverageGPA());
        registration.PrintFailedStudents();
        registration.PrintStudentsBySubject();
        registration.PrintStudentsByMajor();
    }
}