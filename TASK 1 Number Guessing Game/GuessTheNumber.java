import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rng = new Random();

        System.out.println("Welcome to the Guess the Number Game!");

        int totalScore = 0;
        boolean continueGame = true;

        while (continueGame) {
            int secretNumber = rng.nextInt(100) + 1;
            int attemptCount = 0;
            int maxTries = 5;

            System.out.println("I've picked a number between 1 and 100. Can you figure out what it is?");

            while (attemptCount < maxTries) {
                System.out.print("Your guess: ");
                int playerGuess = input.nextInt();
                input.nextLine();

                attemptCount++;

                if (playerGuess == secretNumber) {
                    System.out.println("Bravo! You guessed the correct number " + secretNumber + " in " + attemptCount + " tries.");
                    totalScore++;
                    break;
                } else if (playerGuess < secretNumber) {
                    System.out.println("Too low! Give it another shot.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attemptCount >= maxTries) {
                System.out.println("You've used all your chances! The correct number was " + secretNumber + ".");
            }

            System.out.print("Want to play another round? (yes/no): ");
            String response = input.nextLine();
            continueGame = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing! Your final score is: " + totalScore);

        input.close();
    }
}
