import classes.Play;
import classes.Player;
import classes.Players;
import classes.Themes;
import classes.Word;
import classes.Words;
import java.util.Scanner;
public class Main {
    
    static Players playersList = new Players();
    public static void main(String[] args) {
        System.out.println("THE WORDS ARE GENERATED BASED ON TWO RANDOM THEMES: \n"
                            + "CITIES OF THE WORLD, AND COMPUTER AND PROGRAMING TERMS\n"
                            + "THERE CAN BE MORE THAN ONE WORD PER PLAY\n\n"
                            + "YOUR SCORE 100 POINTS IF YOU CORRECTLY GUESS THE WORD\n"
                            + "AND 15 POINT FOR EACH HIDDEN SLOT LEFT\n"
                            + "YOU CAN ONLY GUESS ONE LETTER AT A TIME\n");
        System.out.println("ATENTION!!!\n" 
                            + "FOR SPACES USE -\n");

        String yesNo = ""; 
        do 
        {
            yesNo = execute();
        } while(yesNo.equals("Y") || yesNo.equals("YES"));
    }

    public static String execute() {
        Scanner in = new Scanner(System.in);

        String yesNo = "N";
        Themes theme = new Themes();
        Words words = theme.pickRandomTheme();
        int selector = words.chooseMultipleWords();
        Word pickeWord = words.addMultipleWords(selector);
        Play play = new Play();
        play.hiddenWord.setContent(pickeWord.getContent());

        System.out.println("\n");
        play.CONTINUEGAME = true;

        System.out.println("TELL ME YOUR NAME, PLAYER!\n");
        String currentPlayerName = in.next();
        Player currentPlayer = new Player(currentPlayerName);
        System.out.println("WELCOME, " + currentPlayerName);

        while (play.CONTINUEGAME == true) {
            System.out.println("Enter a letter => \n");
            Character guessedLetter = in.next().charAt(0);
            if (play.addGuessedLetters(guessedLetter)) {
                play.playHangman();
                //System.out.println(play.hiddenWord.getContent());
            }

            play.CONTINUEGAME = play.continueGame();

        }

        if (play.resultsGame() == false) {
            System.out.println("Sorry, you lost");
            System.out.println("The hidden word was -> " + play.hiddenWord.getContent());
            System.out.println("Do you want to play again? Y/N");
            int score = currentPlayer.getScoreFromResult(play.getFoundLetters());
            currentPlayer.setScore(score);
            yesNo = in.next();
            playersList.addPlayer(currentPlayer.getName(), currentPlayer.getScore());
            playersList.printPlayersList();
        }

        if(play.resultsGame() == true) {
            System.out.println("You won!");
            System.out.println("The hidden word was -> " + play.hiddenWord.getContent());
            System.out.println("Do you want to play again? Y/N");
            currentPlayer.setScore(100);
            yesNo = in.next();
            playersList.addPlayer(currentPlayer.getName(), currentPlayer.getScore());
            playersList.printPlayersList();
        }

        if(yesNo.toUpperCase().equals("Y") || yesNo.toUpperCase().equals("YES"))    
            theme.addNewWordToTheme();
            
        return yesNo.toUpperCase();
        
    }

}