import java.util.Scanner;

public class StudentGradeEvaluator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the total number of subjects: ");
        int subjectCount = input.nextInt();

        int totalScore = 0;

        for (int subject = 1; subject <= subjectCount; subject++) {
            System.out.print("Enter the marks for subject " + subject + ": ");
            int marksObtained = input.nextInt();
            totalScore += marksObtained;
        }

        double percentage = (double) totalScore / (subjectCount * 100) * 100;

        char grade;
        if (percentage >= 90) {
            grade = 'A';
        } else if (percentage >= 80) {
            grade = 'B';
        } else if (percentage >= 70) {
            grade = 'C';
        } else if (percentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("-----------------------------------");
        System.out.println("Total Score: " + totalScore);
        System.out.println("Overall Percentage: " + percentage + "%");
        System.out.println("Final Grade: " + grade);

        input.close();
    }
}
