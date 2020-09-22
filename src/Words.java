
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
        this.words.add(new Word(word.toUpperCase()));
    }

    public int chooseMultipleWords() {
        Random random = new Random();
        int selector = random.nextInt(2);
        if (selector == 0) {
            return 1;
        }

        else if (selector == 1) {
            return 2;
        }

        return 3;
    }

    public Word addMultipleWords(int selector) {
        Word word1 = pickWord();
        
        Word word2 = pickWord();
        do {
            word2 = pickWord();
        }while(word2.getContent() == word1.getContent());

        Word word3 = pickWord();
        do {
            word3 = pickWord();
        }while(word3.getContent() == word1.getContent() && word3.getContent() == word2.getContent() && word2.getContent() == word1.getContent());

        if (selector == 2) {
            Word aux = new Word();
            String newWord = word1.getContent() + "-" + word2.getContent();
            aux.setContent(newWord);
            return aux;
        }

        else if (selector == 3) {
            Word aux = new Word();
            String newWord = word1.getContent() + "-" + word2.getContent() + "-" + word3.getContent();
            aux.setContent(newWord);
            return aux;
        }
    
        return word1;
    }

}