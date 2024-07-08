import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int MAX_TRIES = 8;
        final int LOWER_BOUND = 1;
        final int UPPER_BOUND = 100;
        final int NUMBER_CLOSE_TO_RANDOM_NUM = 10;

        Random random = new Random();
        int randomNum = random.nextInt(LOWER_BOUND, UPPER_BOUND + 1);

        System.out.printf("Guess the number between %d and %d! You have %d tries.%n", LOWER_BOUND, UPPER_BOUND, MAX_TRIES);

        int tries = 0;
        boolean won = false;

        while (tries < MAX_TRIES) {
            System.out.print("Enter your guess: ");
            int number;
            try {
                number = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            tries++;

            if (number == randomNum) {
                System.out.println("You win!");
                won = true;
                break;

            } else if (tries < MAX_TRIES) {
                if (number < randomNum && randomNum - number <= NUMBER_CLOSE_TO_RANDOM_NUM) {
                    System.out.println("You're close!");
                } else if (randomNum < number) {
                    System.out.println("Wrong number! Too high.");
                } else {
                    System.out.println("Wrong number! Too low.");
                }
            }
        }
        if (!won) {
            System.out.printf("You lose! The number was %d.%n", randomNum);
        }
        scanner.close();
    }
}
