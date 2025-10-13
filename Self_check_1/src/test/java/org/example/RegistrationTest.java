package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest {
    private Registration registration;
    private Student student1, student2;
    private Subject subject1, subject2;
    private Major major1, major2;
    private Lessons lesson1, lesson2, lesson3, lesson4;

    @BeforeEach
    void setUp() {
        registration = new Registration();

        major1 = new Major("AI", "Hiimel Oyun Uhaan");
        major2 = new Major("UH", "Utasgui Holboo");

        subject1 = new Subject("CS101", "Programmchlal undes", 3);
        subject2 = new Subject("CS102", "Tuuh", 4);

        lesson1 = new Lessons();
        lesson1.setLearned(subject1);
        lesson1.setScore(85);

        lesson2 = new Lessons();
        lesson2.setLearned(subject2);
        lesson2.setScore(60);

        lesson3 = new Lessons();
        lesson3.setLearned(subject1);
        lesson3.setScore(20);

        lesson4 = new Lessons();
        lesson4.setLearned(subject2);
        lesson4.setScore(45);

        student1 = new Student("AI12345");
        student1.lessons.add(student1.lessons.size(), lesson3);
        student1.lessons.add(student1.lessons.size(), lesson4);
        student1.lessons.add(student1.lessons.size(), lesson2);

        student2 = new Student("UH67890");
        Lessons lesson3 = new Lessons();
        lesson3.setLearned(subject1);
        lesson3.setScore(95);
        student2.lessons.add(student2.lessons.size(), lesson3);

        registration.majorList.add(registration.majorList.size(), major1);
        registration.majorList.add(registration.majorList.size(), major2);

        registration.subjectList.add(registration.subjectList.size(), subject1);
        registration.subjectList.add(registration.subjectList.size(), subject2);

        registration.studentList.add(registration.studentList.size(), student1);
        registration.studentList.add(registration.studentList.size(), student2);
    }

    @Test
    void testGetAverageGPA() {
        float avg = registration.GetAverageGPA();
        assertEquals(2.0f, avg, 0.1f);
    }

    @Test
    void testGetStudentByCode_found() {
        Student found = registration.GetStudentByCode("AI12345");
        assertNotNull(found);
        assertEquals("AI12345", found.getCode());
    }

    @Test
    void testGetStudentByCode_notFound() {
        Student found = registration.GetStudentByCode("XX99999");
        assertNull(found);
    }

    @Test
    void testStudentExists_true() {
        assertTrue(registration.StudentExists("AI12345"));
    }

    @Test
    void testStudentExists_false() {
        assertFalse(registration.StudentExists("XX00000"));
    }

    @Test
    void testGetSubjectByCode_found() {
        Subject found = registration.GetSubjectByCode("CS101");
        assertNotNull(found);
        assertEquals("CS101", found.getCode());
    }

    @Test
    void testGetSubjectByCode_notFound() {
        Subject found = registration.GetSubjectByCode("XX999");
        assertNull(found);
    }

    @Test
    void testIsFailed_student1() {
        assertTrue(student1.IsFailed());
    }

    @Test
    void testPrintFailedStudents() {
        assertTrue(student1.IsFailed());
        assertFalse(student2.IsFailed());
    }

    @Test
    void testGetMajorByStudentCode() {
        Major major = registration.GetMajorByStudentCode("AI12345");
        assertNotNull(major);
        assertEquals("AI", major.getCode());
        assertEquals("Hiimel Oyun Uhaan", major.getName());
    }

    @Test
    void testGetMajorByStudentCode_notFound() {
        Major major = registration.GetMajorByStudentCode("XX12345");
        assertNull(major);
    }

    @Test
    void testPrintStudentsBySubject() {
        assertDoesNotThrow(() -> registration.PrintStudentsBySubject());
    }

    @Test
    void testPrintStudentsByMajor() {
        assertDoesNotThrow(() -> registration.PrintStudentsByMajor());
    }
}