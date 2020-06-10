package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Words extends Word {
    
    List<Word> words = new ArrayList<>();

    public Words() {
        
    }

    public Word pickWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.words.size());
        return this.words.get(randomIndex);
    }

    public void addWord(String word) {
        this.words.add(new Word(word));
    }
}