package OOProject2;

import java.util.Arrays;

public class Student implements Comparable<Student> {
    private String name;
    private int studentID;
    private double gpa;

    public Student(String name, int studentID, double gpa) {
        this.name = name;
        this.studentID = studentID;
        this.gpa = gpa;
    }

    public char getLetterGrade(double averageGrade) {
        if (averageGrade <= 100 && averageGrade >= 90) {
            return 'A';
        } else if (averageGrade < 90 && averageGrade >= 80) {
            return 'B';
        } else if (averageGrade < 80 && averageGrade >= 75) {
            return 'C';
        } else if (averageGrade < 75 && averageGrade >= 70) {
            return 'D';
        }
        return 'F';
    }

    @Override
    public int compareTo(Student o) {
        if (o.gpa > this.gpa) {
            return 1;
        } else if (o.gpa < this.gpa) {
            return -1;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Student "+this.name+" has a gpa of: "+this.gpa;
    }

    public static void main(String[] args) {
        Student[] students = {
                new Student("Alice", 1, 3.8),
                new Student("Bob", 2, 3.5),
                new Student("Charlie", 3, 3.9),
                new Student("Diana", 4, 3.2)
        };

        System.out.println("Before sorting:");
        for (Student s : students) {
            System.out.println(s);
        }

        Arrays.sort(students);  // Uses your compareTo method

        System.out.println("\nAfter sorting (highest GPA first):");
        for (Student s : students) {
            System.out.println(s);
        }
    }

}
