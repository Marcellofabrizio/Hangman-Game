package app;

public class Word {

    private String content;
    private int wordLenght;

    public Word() {

    }

    public Word(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getWordLenght() {
        this.wordLenght = this.content.length();
        return this.wordLenght;
    }
}