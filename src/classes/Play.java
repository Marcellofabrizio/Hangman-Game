package classes;

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
    public boolean WINGAME = false;
    public boolean LOSTGAME = false;


    public Play() {
        this.foundLetters = new ArrayList<>();
        this.wrongLetters = new ArrayList<>();
        this.guessedLetters = new ArrayList<>();
    }

    public void playHangman() {

        for (int i = 0; i < hiddenWord.getWordLenght(); i++) {

            this.foundLetters.add(" _ ");
        }

        for (int i = 0; i < (hiddenWord.getWordLenght() - 1); i++) {

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
                System.out.println("'" + Character.toUpperCase(letter) + "' is not a valid letter");
                return false;
            }
            else if (!this.guessedLetters.contains(Character.toUpperCase(letter)))
            {
                this.guessedLetters.add(Character.toUpperCase(letter));
                System.out.println("Guessed Letters : " + buildString(guessedLetters, true));
                return true;
            }
            else
            {
                System.out.println("Sorry, you already guessed '" + Character.toString(Character.toUpperCase(letter))+ "'");
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
           for (Character item : inPutString) {
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
            System.out.println("  |     |");
            System.out.println("  |    \\|");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 4) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |     |");
            System.out.println("  |    \\|/");
            System.out.println("  |");
            System.out.println("  |");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 5) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |     |");
            System.out.println("  |    \\|/");
            System.out.println("  |     |");
            System.out.println("  |");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 6) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |     |");
            System.out.println("  |    \\|/");
            System.out.println("  |     |");
            System.out.println("  |    /");
            System.out.println("__|__");
        }

        else if(this.wrongLetters.size() == 7) {
            System.out.println("   _____");
            System.out.println("  |     |");
            System.out.println("  |     O");
            System.out.println("  |     |");
            System.out.println("  |    \\|/");
            System.out.println("  |     |");
            System.out.println("  |    / \\");
            System.out.println("__|__");
        }

        else System.out.println(" ");

        System.out.println(" ");
        
    }

    public boolean resultsLostGame() {
        
        if (this.wrongLetters.size() == 7) {
            return this.LOSTGAME = true;
        }
        return false;
    }

    public boolean resultsWinGame() {
        
        if(this.pickedWord.getContent().toUpperCase().equals(foundLetters.toString().replaceAll(" ","") )) {
            return this.WINGAME = true;
        }
        return false;
    }

    public boolean resultsContinueGame() {
        
        return this.CONTINUEGAME = true;   
    
    }
    
    public static void main(String[] args) {
        
        System.out.println("TEST");

        Play p = new Play();
        Words randomWords = new Words();
        Word randomWord = randomWords.pickWord();
        p.hiddenWord.setContent(randomWord.getContent());
        System.out.println(p.hiddenWord.getContent());

        p.addGuessedLetters('A');
        p.addGuessedLetters('A');
        p.addGuessedLetters('B');
        p.addGuessedLetters('c');
        p.playHangman();
    }

}