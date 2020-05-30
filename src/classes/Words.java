package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Words extends Word {
    
    List<Word> words = new ArrayList<>();

    public Words() {
        this.words.add(new Word("ABACAXI"));
        this.words.add(new Word("COMPUTADOR"));
        this.words.add(new Word("SOFTWARE"));
        this.words.add(new Word("HARDWARE"));
        this.words.add(new Word("OBJETIVO"));
        this.words.add(new Word("JAVA"));
    }

    public Word pickWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(this.words.size());
        return this.words.get(randomIndex);
    }
}