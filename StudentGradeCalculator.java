import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hey there! Let's calculate your grade.");

        System.out.print("How many subjects do you have? ");
        int subjectCount;

        while (true) {
            try {
                subjectCount = Integer.parseInt(scanner.nextLine());
                if (subjectCount <= 0) {
                    System.out.print("Hmm, that doesn’t look right. Try a positive number: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }

        int[] marks = new int[subjectCount];
        int totalMarks = 0;

        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter your marks for Subject " + (i + 1) + " (out of 100): ");
            while (true) {
                try {
                    int mark = Integer.parseInt(scanner.nextLine());
                    if (mark < 0 || mark > 100) {
                        System.out.print("That should be between 0 and 100. Try again: ");
                        continue;
                    }
                    marks[i] = mark;
                    totalMarks += mark;
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Oops! Numbers only. Try again: ");
                }
            }
        }

        double average = (double) totalMarks / subjectCount;
        String grade;

        if (average >= 90) {
            grade = "A+";
        } else if (average >= 80) {
            grade = "A";
        } else if (average >= 70) {
            grade = "B";
        } else if (average >= 60) {
            grade = "C";
        } else if (average >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\nAlright, here’s how you did:");
        System.out.println("Total Marks: " + totalMarks + " out of " + (subjectCount * 100));
        System.out.printf("Average: %.2f%%\n", average);
        System.out.println("Your Grade: " + grade);

        System.out.println("\nThanks for using the Grade Calculator. Good luck!");
        scanner.close();
    }
}
