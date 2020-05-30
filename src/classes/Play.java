package classes;

import java.util.ArrayList;
import java.util.List;

public class Play {
    
    private List<String> foundLetters;
    private List<String> wrongLetters;
    private List<String> guessedLetters;
    public Words pickedWord;

    public Word hiddenWord = this.pickedWord.pickWord();

    public Play() {
        this.foundLetters = new ArrayList<>();
        this.wrongLetters = new ArrayList<>();
        this.guessedLetters = new ArrayList<>();
    }

    public void playHangman() {

        for (int i = 0 ; i < hiddenWord.getWordLenght() ; i++) {

            this.foundLetters.add(" _ ");

        }

        for (int i = 0 ; i < hiddenWord.getWordLenght() ; i++) {

            String letter = hiddenWord.getContent().substring(i, 1);

            if (guessedLetters.size() > 0) {

                for (String guessedLetter : this.guessedLetters) {

                    if(letter.equals(guessedLetter.trim().toUpperCase())) {
                        this.foundLetters.remove(i);
                        this.foundLetters.add(i, " " + letter + "");
                    }
                    
                }

            }

        }

        drawHangman();
    }

    private boolean checkLetter(String letter) {

        for(int i = 0 ; i < this.hiddenWord.getWordLenght() ; i++) {
            String splitterLetter = this.hiddenWord.getContent().substring(i, 1).toUpperCase();
            if(splitterLetter.equals(letter.trim().toUpperCase()))
            {
                return true;
            }
        }
        return false;
    }

    private void drawHangman() {
        this.wrongLetters = new ArrayList<>();
        for (String item : guessedLetters) 
        {
            if(!checkLetter(item))
            {
                this.wrongLetters.add(item);
            }
        }

        System.out.println(" ");
        if(this.wrongLetters.size() == 1) {
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

}