package org.example;

import dataStructures.Chain;

public class Student {
    public String code;
    public float GPA;
    public Chain lessons;

    public Student() {
        this.code = "";
        this.GPA = 0;
        this.lessons = new Chain();
    }

    public boolean HasLesson(String lessonCode) {
        for (int i = 0; i < lessons.size(); i++) {
            Lessons lesson = (Lessons) lessons.get(i);
            if (lesson.getLearned().getCode().equals(lessonCode)) {
                return true;
            }
        }
        return false;
    }

    public int GetScoreByLessonCode(String lessonCode) {
        for (int i = 0; i < lessons.size(); i++) {
            Lessons lesson = (Lessons) lessons.get(i);
            if (lesson.getLearned().getCode().equals(lessonCode)) {
                return lesson.getScore();
            }
        }
        return 0;
    }

    public boolean IsFailed() {
        int counter = 0;
        for (int i = 0; i < this.lessons.size(); i++) {
            Lessons lesson = (Lessons) this.lessons.get(i);
            if (PointToGPA(lesson.getScore()) == 0) {
                counter++;
            }
        }
        return counter >= 3;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public float getGPA() {
        this.setGPA();
        return GPA;
    }

    public void setGPA() {
        float sumScore = 0;
        float sumCredit = 0;
        for (int i = 0; i < this.lessons.size(); i++) {
            Lessons lesson = (Lessons) this.lessons.get(i);
            sumScore += lesson.getScore() * lesson.getLearned().getCredit();
            sumCredit += lesson.getLearned().getCredit();
        }
        float avgScore = sumScore / sumCredit;
        this.GPA = PointToGPA(avgScore);
    }

    private static float PointToGPA(float point) {
        if (point >= 93 && point <= 100) {
            return 4.0F;
        } else if (point >= 90F && point <= 92F) {
            return 3.7F;
        } else if (point >= 87F && point <= 89F) {
            return 3.3F;
        } else if (point >= 83F && point <= 86F) {
            return 3F;
        } else if (point >= 80F && point <= 82F) {
            return 2.7F;
        } else if (point >= 73F && point <= 76F) {
            return 2F;
        } else if (point >= 67F && point <= 69F) {
            return 1.3F;
        } else if (point >= 65F && point <= 66F) {
            return 1F;
        } else {
            return 0F;
        }
    }

    public Chain getLessons() {
        return lessons;
    }

    public void setLessons(Chain lessons) {
        this.lessons = lessons;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", GPA=" + GPA +
                ", lessons=" + lessons +
                '}';
    }
}
