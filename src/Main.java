import classes.*;

public class Main {
 
    public static void main(String[] args) {
        System.out.println("Welcome to my second OOP assignment!" + 
                            "\n" + 
                            "We are going to play a Hangman game. You have seven chances to guess the right word!");
        System.out.println(execute());
    }

    public static String execute() {
        Words words = new Words();
        Word pickeWord = words.pickWord();
        Play play = new Play();
        play.hiddenWord.setContent(pickeWord.getContent());

    }

}