import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Choices
        String[] choices = {"rock", "paper", "scissors"};

        System.out.println("Welcome to Rock-Paper-Scissors Game!");
        System.out.println("Enter your move (rock, paper, or scissors): ");
        String playerMove = scanner.nextLine().toLowerCase();

        // Validate user input
        if (!playerMove.equals("rock") && !playerMove.equals("paper") && !playerMove.equals("scissors")) {
            System.out.println("Invalid move. Please enter rock, paper, or scissors.");
            return;
        }

        // Computer makes a move
        int index = random.nextInt(3); // 0, 1, or 2
        String computerMove = choices[index];
        System.out.println("Computer chose: " + computerMove);

        // Determine the winner
        if (playerMove.equals(computerMove)) {
            System.out.println("It's a draw!");
        } else if (
            (playerMove.equals("rock") && computerMove.equals("scissors")) ||
            (playerMove.equals("paper") && computerMove.equals("rock")) ||
            (playerMove.equals("scissors") && computerMove.equals("paper"))
        ) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }

        scanner.close();
    }
}
