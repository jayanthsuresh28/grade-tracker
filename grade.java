import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class grade{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Marks (0-100): ");
            int marks = sc.nextInt();
            sc.nextLine();

            students.add(new Student(name, marks));
        }

        int total = 0;
        int highest = students.get(0).marks;
        int lowest = students.get(0).marks;
        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        System.out.println("\n========== STUDENT REPORT ==========");
        System.out.printf("%-20s %-10s %-10s\n", "Name", "Marks", "Grade");

        for (Student s : students) {
            total += s.marks;

            if (s.marks > highest) {
                highest = s.marks;
                highestStudent = s.name;
            }

            if (s.marks < lowest) {
                lowest = s.marks;
                lowestStudent = s.name;
            }

            System.out.printf("%-20s %-10d %-10s\n", s.name, s.marks, getGrade(s.marks));
        }

        double average = (double) total / students.size();

        System.out.println("\n========== SUMMARY ==========");
        System.out.println("Total Students : " + students.size());
        System.out.printf("Average Marks  : %.2f\n", average);
        System.out.println("Highest Score  : " + highest + " (" + highestStudent + ")");
        System.out.println("Lowest Score   : " + lowest + " (" + lowestStudent + ")");
    }

    public static String getGrade(int marks) {
        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }
}