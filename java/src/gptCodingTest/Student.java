package gptCodingTest;

import java.util.*;
import java.util.stream.*;

public class Student {
    int grade;
    String name;

    int score;

    int subClass;

    public Student(String name, int score, int grade,int subClass) {
        this.name = name;
        this.score = score;
        this.grade = grade;
        this.subClass = subClass;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    public int getGrade() {
        return grade;
    }

    public int getSubClass() {
        return subClass;
    }

    @Override
    public String toString() {
        return name + ": " + score;
    }
}
