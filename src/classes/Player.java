package classes;

public class Player {

    private String name;
    private int score = 0;

    public Player (String name) {
        this.name = name;
    }

    public void setScore(int pointsMade) {
        this.score += pointsMade;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScoreFromResult(String foundLetters) {
        int score = 0;
        for (int i = 0 ; i < foundLetters.length() ; i++) {
            if(foundLetters.charAt(i) == '_') {
                score += 15;
            }
        }
        return score;
    }
    
}