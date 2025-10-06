package org.example;

public class Lessons {
    public Subject learned;
    public int score;

    public Subject getLearned() {
        return learned;
    }

    public void setLearned(Subject learned) {
        this.learned = learned;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "learned=" + learned +
                ", score=" + score +
                '}';
    }
}
