package app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Play {

    private List<String> foundLetters;
    private List<Character> wrongLetters;
    private List<Character> guessedLetters;
    public Words pickedWord = new Words();
    public Word hiddenWord = new Word();

    public boolean CONTINUEGAME = false;
    public boolean WINLOSTGAME;


    public Play() {
        this.foundLetters = new ArrayList<>();
        this.wrongLetters = new ArrayList<>();
        this.guessedLetters = new ArrayList<>();
    }

    public void playHangman() {

        foundLetters = new ArrayList<String>();

        for (int i = 0; i < hiddenWord.getWordLenght(); i++) {

            this.foundLetters.add(" _ ");
        }

        for (int i = 0; i < (hiddenWord.getWordLenght()); i++) {

            String letter = hiddenWord.getContent().substring(i, i + 1);

            if (guessedLetters.size() > 0) {

                for (Character guessedLetter : this.guessedLetters) {

                    if(letter.charAt(0) == Character.toUpperCase(guessedLetter)) {
                        this.foundLetters.remove(i);
                        this.foundLetters.add(i, letter);
                    }
                    
                }

            }

        }

        drawHangman();
        System.out.println(this.foundLetters.toString());
    }

    public boolean addGuessedLetters(Character letter)
        {
            if (Character.isDigit(letter))
            {
                System.out.println("'" + Character.toUpperCase(letter) + "' nao e uma letra valida");
                return false;
            }

            else if (!this.guessedLetters.contains(Character.toUpperCase(letter)))
            {
                this.guessedLetters.add(Character.toUpperCase(letter));
                System.out.print("\033[H\033[2J");
                System.out.println("Letras Adivinhadas : " + buildString(guessedLetters, true));
                return true;
            }

            else
            {
                System.out.println("Desculpe, voce ja adivinhou essa letra '" + Character.toString(Character.toUpperCase(letter))+ "'");
            }

            return false;
        }

    private boolean checkLetter(Character letter) {

        for(int i = 0 ; i < this.hiddenWord.getWordLenght() ; i++) {
            String checkedLetter = this.hiddenWord.getContent().substring(i, i+1).toUpperCase();
            if(checkedLetter.charAt(0) == (Character.toUpperCase(letter)))
            {
                return true;
            }
        }
        return false;
    }

    private String buildString(List<Character> inPutString, Boolean space)
        {
           StringBuilder newStr = new StringBuilder();
           for (Object item : inPutString) {
               if (space) {
                   newStr = newStr.append(item.toString().toUpperCase() + " ");
               }
               else {
                   newStr = newStr.append(item.toString().toUpperCase());
               }
           }
           return newStr.toString();
        }

    private String buildStringForFoundLetters(List<String> inPutString, Boolean space)
        {
           StringBuilder newStr = new StringBuilder();
           for (Object item : inPutString) {
               if (space) {
                   newStr = newStr.append(item.toString().toUpperCase() + " ");
               }
               else {
                   newStr = newStr.append(item.toString().toUpperCase());
               }
           }
           return newStr.toString();
        }

    private void drawHangman() {
        this.wrongLetters = new ArrayList<>();
        for (Character item : guessedLetters) 
        {
            if(!checkLetter(item))
            {
                this.wrongLetters.add(item);
            }
        }

        System.out.println(" ");
        
        if(this.wrongLetters.size() == 0) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 1) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 2) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |     |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 3) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |    \\|");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 4) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |    \\|/");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 5) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |    \\|/");
            System.out.println("  |     |");
            System.out.println("  |");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 6) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |    \\|/");
            System.out.println("  |     |");
            System.out.println("  |    /");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 7) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |    \\|/");
            System.out.println("  |     |");
            System.out.println("  |    / \\");
            System.out.println("__|__");
        }

        else System.out.println(" ");

        System.out.println(" ");
        
    }

    public boolean resultsGame() {
        
        if (this.hiddenWord.getContent().equals(this.buildStringForFoundLetters(this.foundLetters, false).replace(" ",""))) {
            this.WINLOSTGAME = true;
        }
        
        if (wrongLetters.size() == 7){
            this.WINLOSTGAME = false;
        }
        
        return this.WINLOSTGAME;
    }

    public boolean continueGame() {

        if (this.wrongLetters.size() == 7) {
            return false;
        }

        else if (this.hiddenWord.getContent().equals(this.buildStringForFoundLetters(this.foundLetters, false).replace(" ",""))) {
            return false;
        }

        return true;

    }

    public String getFoundLetters() {
        return this.buildStringForFoundLetters(this.foundLetters, false).replace(" ","");
    }
    

}