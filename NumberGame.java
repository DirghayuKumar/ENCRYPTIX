import java.util.*;

public class NumberGame {

  // Creating an instance of the Random class
  public static final Random random = new Random();

  // Function to clear the terminal
  public static void clearTerminal() {
    for (int i = 0; i < 2; i++) {
      System.out.println();
    }
  }

  public static void main(String[] args) {
    boolean user = true;
    System.out.println("Welcome Player !!");
    // Displaying the player the number of strikes they get for each round
    System.out.println(
      "You have 3 stikes to guess the correct number between 1 and 100"
    );
    int rounds_won = 0;
    int rounds = 0;
    while (user) {
      // Generating a random number for the player to guess
      int num = random.nextInt(1, 100);
      Scanner sc = new Scanner(System.in);
      int strikes = 1;
      while (strikes <= 3) {
        System.out.println("STRIKE : " + (strikes));
        System.out.println("Guess the number:");
        // Player guesses the number
        int user_guess = sc.nextInt();
        strikes++;
        rounds++;
        if (user_guess == num) {
          // If the player correctly guesses the number then the loop breakes
          break;
        } else if (user_guess < num) {
          // If the player guesses the number less than the target number then prompt the player
          System.out.println("OOPS :( Your guess is too low. Try Again!!");
        } else if (user_guess > num) {
          // If the player guesses the number greater than the target number then prompt the player
          System.out.println("UUH :( Your guess is too high. Try Again!!");
        }
      }
      if (strikes > 3) {
        System.out.println("Sorry all strikes consumed!!");
        System.out.println("GAME OVER :(");
      } else {
        System.out.println("Congratulations !! You have WON :)");
        System.out.println(
          "You guessed the correct number on attempt number " + strikes + 1
        );
        rounds_won++;
      }
      // Asking the player if he/she wants to play the game again?
      System.out.println("Do you want to play again? (yes/no)");
      sc.nextLine();
      String s = sc.nextLine();
      if (!s.equalsIgnoreCase("yes")) {
        sc.close();
        NumberGame.clearTerminal();
        user = false;
      }
      NumberGame.clearTerminal();
    }
    System.out.println(
      "You played a total of " +
      rounds +
      " Rounds and won " +
      rounds_won +
      " Rounds"
    );
    System.out.println(
      "Your correct guess rate is: " + ((rounds_won / rounds) * 100) + "%"
    );
    System.out.println("THANK YOU FOR PLAYING!");
  }
}
