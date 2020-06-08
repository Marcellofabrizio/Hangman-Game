import classes.Play;
import classes.Word;
import classes.Words;
import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Welcome to my Hangman Game!\n");
        String yesNo = ""; 
        do 
        {
            yesNo = execute();
        } while(yesNo.equals("Y") || yesNo.equals("YES"));
    }

    public static String execute() {
        Scanner in = new Scanner(System.in);

        String yesNo = "";
        Words words = new Words();
        Word pickeWord = words.pickWord();
        Play play = new Play();
        play.hiddenWord.setContent(pickeWord.getContent());
        
        for (int i = 0; i < play.hiddenWord.getWordLenght(); i++) {
            System.out.println(" _ ");
        }

        System.out.println("\n");
        play.CONTINUEGAME = true;

        while (play.CONTINUEGAME == true) {
            System.out.println("Enter a letter => \n");
            Character guessedLetter = in.next().charAt(0);
            if (play.addGuessedLetters(guessedLetter)) {
                play.playHangman();
            }

            play.CONTINUEGAME = play.continueGame();
        }

        if (play.resultsGame() == false) {
            System.out.println("Sorry, you lost");
            System.out.println("The hidden word was -> " + play.hiddenWord.getContent());
            System.out.println("Do you want to play again? Y/N");
            yesNo = in.next();
        }

        else if(play.resultsGame() == true) {
            System.out.println("You won!");
            System.out.println("The hidden word was -> " + play.hiddenWord.getContent());
            System.out.println("Do you want to play again? Y/N");
            yesNo = in.next();
        }
        return yesNo.toUpperCase();
    }

}