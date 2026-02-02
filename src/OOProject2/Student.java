package OOProject2;

import java.util.ArrayList;

public class Student {
    private String name;
    private int studentID;
    private ArrayList<Double> grades;

    public Student(String name, int studentID, ArrayList<Double> grades) {
        this.name = name;
        this.studentID = studentID;
        this.grades = grades;
    }

    public void addGrade(double grade) {
        this.grades.add(grade);
    }

    public void removeGrade(double grade) {
        this.grades.remove(grade);
    }

    public double getAverageGrade() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public char getLetterGrade(double averageGrade) {
        if (averageGrade <= 100 && averageGrade >= 90) {
            return 'A';
        }
        else if (averageGrade < 90 && averageGrade >= 80) {
            return 'B';
        }else if(averageGrade < 80 && averageGrade >= 75) {
            return 'C';
        }else if(averageGrade < 75 && averageGrade >= 70) {
            return 'D';
        }
        return 'F';
    }
    public static void main(String[] args) {
        Student luis = new Student("Jack", 1000, new ArrayList<>());
        luis.addGrade(95);
        luis.addGrade(80);
        luis.addGrade(99);
        System.out.println(luis.getAverageGrade());
        System.out.println(luis.getLetterGrade(luis.getAverageGrade()));
    }

}
