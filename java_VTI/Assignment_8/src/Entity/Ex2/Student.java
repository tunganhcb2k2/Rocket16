package Entity.Ex2;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private LocalDate DateOfBirth;
    private float score;

    public Student(int id, String name, LocalDate dateOfBirth, float score) {
        this.id = id;
        this.name = name;
        DateOfBirth = dateOfBirth;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", DateOfBirth=" + DateOfBirth +
                ", score=" + score +
                '}';
    }

//    @Override
//    public int compareTo(Student o) {
//        return this.name.compareTo(o.getName());
//    }

    @Override
    public int compareTo(Student o) {
        int flagCompare = this.name.compareTo(o.getName());
        if (flagCompare == 0) {
            if (this.score > o.score) {
                return 1;
            } else if (this.score < o.score) {
                return -1;
            } else if (this.score == o.score) {
                return this.DateOfBirth.compareTo(o.getDateOfBirth());
            }
        } else {
            return flagCompare;
        }
        return 0;
    }
}
