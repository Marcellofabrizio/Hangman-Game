import classes.Play;
import classes.Word;
import classes.Words;
import jdk.nashorn.api.tree.IfTree;

import java.util.Scanner;
public class Main {
    
    public static void main(String[] args) {
        System.out.println("Welcome to my Hangman Game!\n");
        System.out.println(execute());
    }

    public static String execute() {
        Scanner in = new Scanner(System.in);

        Words words = new Words();
        Word pickeWord = words.pickWord();
        Play play = new Play();
        play.hiddenWord.setContent(pickeWord.getContent());
        for (int i = 0; i < play.hiddenWord.getWordLenght(); i++) {
            System.out.println(" _ ");
        }
        System.out.println("\n");
        while (play.resultsContinueGame() == true) {
            System.out.println("Enter a letter => \n");
            Character guessedLetter = in.next().charAt(0);
            if (play.addGuessedLetters(guessedLetter)) {
                play.playHangman();
            }
        }
        if (play.resultsLostGame() == true) {
            System.out.println("Sorry, you lost");
            System.out.println("The hidden word was -> " + play.hiddenWord.getContent());
        }

    }

}