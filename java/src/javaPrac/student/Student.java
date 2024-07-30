package javaPrac.student;

public class Student {


    private String name;
    private int score;
    private int year;
    private int subClass;
    public Student(String name, int score, int year, int subClass) {
        this.name = name;
        this.score = score;
        this.year = year;
        this.subClass = subClass;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSubClass() {
        return subClass;
    }

    public void setSubClass(int subClass) {
        this.subClass = subClass;
    }
}
