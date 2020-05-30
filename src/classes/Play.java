package classes;

import java.util.ArrayList;
import java.util.List;

public class Play {
    
    private List<String> foundLetters;
    private List<String> wrongLetters;
    private List<String> guessedLetters;
    public Words pickedWord;

    public Play() {
        this.foundLetters = new ArrayList<>();
        this.wrongLetters = new ArrayList<>();
        this.guessedLetters = new ArrayList<>();
    }

    public void playHangman() {

        Word hiddenWord = this.pickedWord.pickWord();

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

    }

}