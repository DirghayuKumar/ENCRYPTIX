/**
 * GradeCalculator
 */
import java.util.*;

public class GradeCalculator {

  // Initialize subjects and marks variable
  int subjects;
  int marks[];

  // Accept user inputs such as number of subjects and marks
  void get(int subjects, Scanner sc) {
    this.subjects = subjects;
    marks = new int[subjects];
    // Enter marks in each subject
    for (int i = 0; i < subjects; i++) {
      System.out.println("Enter the marks in subject " + (i + 1));
      marks[i] = sc.nextInt();
    }
  }

  // Function which calculates and returns the total marks obtained
  public int totalMarks() {
    int sum = 0;
    for (int i = 0; i < subjects; i++) {
      sum += marks[i];
    }
    return sum;
  }

  // Function that calculates and returns the average percentage of the student
  public double percentage() {
    return (totalMarks() / subjects);
  }

  // Function that assigns corresponding grade to the student
  public String Grade() {
    double p = percentage();
    if (p >= 90) return "A+"; else if (p < 90 && p >= 80) return "A"; else if (
      p < 80 && p >= 70
    ) return "B+"; else if (p < 70 && p >= 60) return "B"; else if (
      p < 60 && p >= 50
    ) return "C+"; else if (p < 50 && p >= 40) return "C"; else return "F";
  }

  // Main function
  public static void main(String[] args) {
    GradeCalculator ob = new GradeCalculator();
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of subjects:");
    int subjects = sc.nextInt();
    ob.get(subjects, sc);
    System.out.println("Dear Student");
    // Displaying the total marks obtained
    System.out.println(
      "Your total marks in " + subjects + " subjects are: " + ob.totalMarks()
    );
    // Displaying the average percentage obtained
    System.out.println("Average Percentage obtained: " + ob.percentage() + "%");
    // Displaying the obtained grade of the student
    System.out.println("Your corresponding Grade: " + ob.Grade());
    sc.close();
  }
}
