package org.example;

import dataStructures.ArrayLinearList;

public class Registration {
    public ArrayLinearList studentList;
    public ArrayLinearList subjectList;
    public ArrayLinearList majorList;

    public Registration() {
        studentList = new ArrayLinearList();
        subjectList = new ArrayLinearList();
        majorList = new ArrayLinearList();
    }

    public ArrayLinearList getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayLinearList studentList) {
        this.studentList = studentList;
    }

    public ArrayLinearList getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(ArrayLinearList subjectList) {
        this.subjectList = subjectList;
    }

    public ArrayLinearList getMajorList() {
        return majorList;
    }

    public void setMajorList(ArrayLinearList majorList) {
        this.majorList = majorList;
    }

    public Student GetStudentByCode(String code) {
        for (int i = 0; i < this.studentList.size(); i++) {
            Student student = (Student) this.studentList.get(i);
            if (student.getCode().equals(code)) {
                return student;
            }
        }
        return null;
    }

    public void PrintStudentList() {
        System.out.println("________________________________ALL STUDENTS__________________________________");

        for (int i = 0; i < this.studentList.size(); i++) {
            System.out.println(this.studentList.get(i));
        }
        System.out.println();
    }

    public void PrintMajorList() {
        System.out.println("________________________________ALL MAJORS____________________________________");

        for (int i = 0; i < this.majorList.size(); i++) {
            System.out.println(this.majorList.get(i));
        }
        System.out.println();
    }

    public void PrintSubjectList() {
        System.out.println("________________________________ALL SUBJECTS____________________________________");
        for (int i = 0; i < this.subjectList.size(); i++) {
            System.out.println(this.subjectList.get(i));
        }
        System.out.println();
    }

    public Boolean StudentExists(String code) {
        for (int i = 0; i < getStudentList().size(); i++) {
            Student student = (Student) this.studentList.get(i);
            if (student.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public Subject GetSubjectByCode(String code) {
        for (int i = 0; i < getSubjectList().size(); i++) {
            Subject subject = (Subject) getSubjectList().get(i);
            if (subject.getCode().equals(code)) {
                return subject;
            }
        }
        return null;
    }

    public float GetAverageGPA() {
        float sum = 0F;
        for (int i = 0; i < getStudentList().size(); i++) {
            Student student = (Student) this.studentList.get(i);
            sum += student.getGPA();
        }
        System.out.println("________________________________AVG GPA ALL__________________________________");
        return sum / this.studentList.size();
    }

    public void PrintFailedStudents() {
        System.out.println("________________________________FAILED STUDENTS______________________________");
        for (int i = 0; i < this.studentList.size(); i++) {
            Student student = (Student) this.studentList.get(i);
            if (student.IsFailed()) {
                System.out.println(student);
            }
        }
        System.out.println();
    }

    public void PrintStudentsBySubject() {
        System.out.println("________________________________SCORE BY SUBJECT_____________________________");
        for (int i = 0; i < this.subjectList.size(); i++) {
            Subject subject = (Subject) this.subjectList.get(i);
            System.out.println(subject);
            for (int j = 0; j < this.studentList.size(); j++) {
                Student student = (Student) this.studentList.get(j);
                if (student.HasLesson(subject.getCode())) {
                    int point = student.GetScoreByLessonCode(subject.getCode());
                    System.out.println("    " + student.getCode() + "    " + point);
                }
            }
            System.out.println();
        }
    }

    public Major GetMajorByStudentCode(String studentCode) {
        String majorCode = studentCode.substring(0, 2);
        for (int i = 0; i < majorList.size(); i++) {
            Major major = (Major) majorList.get(i);
            if (major.getCode().equals(majorCode)) {
                return major;
            }
        }
        return null;
    }

    public void PrintStudentsByMajor() {
        System.out.println("________________________________STUDENTS BY MAJOR_____________________________");
        for (int i = 0; i < this.majorList.size(); i++) {
            Major major = (Major) majorList.get(i);
            System.out.printf("%s(%s) angiin oyutnuud : \n", major.getName(), major.getCode());
            for (int j = 0; j < this.studentList.size(); j++) {
                Student student = (Student) this.studentList.get(j);
                if (major.getCode().equals(student.getCode().substring(0, 2))) {
                    System.out.println(student.getCode() + " " + student.getGPA());
                }
            }
            System.out.println();
        }
    }
}