package classes;

public class Player {

    private String name;
    private int score;

    public Player (String name, int score) {
        this.name = name;
        this.score = score;
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
    
}