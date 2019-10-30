import java.util.Scanner;

class Game{

    void letsPlay() {
        double randomNumber = Math.random();
        randomNumber *= 100;
        randomNumber += 1;
        boolean hasWon = false;
        int randomInt = (int) randomNumber;
        Scanner scanner = new Scanner(System.in);
        for (int i=10; i>0; i--) {
            System.out.println("You have "+ i +" chances left. Guess properly: ");
            int guess = scanner.nextInt();
            if (guess > randomInt) {
                System.out.println("The random number is smaller than "+ guess);
            }else if (guess < randomInt) {
                System.out.println("The random number is larger than "+ guess);
            }else {
                hasWon = true;
                break;
            }
        }
        if (hasWon) {
            System.out.println("HURRAY!! You correctly guessed it.");
        } else {
            System.out.println("The number was: "+ randomInt);
            System.out.println("Sorry, you are out of attempts. Better luck next time.");
            System.out.println("You lost!");
        }
    }
}

public class GuessGame {
    public static void main(String[] args) {
        System.out.println(" Hey, There. Let's play a guessing game");
        System.out.println("I will generate a random number between 1 to 100 and you have to "+ 
                            "guess that number within a given chance limit");
        
        Scanner scanner = new Scanner(System.in);
        Game new_game = new Game();
        new_game.letsPlay();
        System.out.println("Want to play again? ");
        String choice = scanner.nextLine();
        if (choice.startsWith("Y") || choice.startsWith("y")) {
            new_game.letsPlay();
            System.out.println("Want to play again? ");
            choice = scanner.nextLine();
        }
        System.out.println("Bye. Have a good day!");
    }
}