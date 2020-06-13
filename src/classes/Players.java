package classes;

import java.util.ArrayList;
import java.util.List;

public class Players {
    
    List<Player> players = new ArrayList<>();

    public Players() {
        
    }

    public void addPlayer(String name, int score) {
        Player p = new Player(name);
        p.setScore(score);
        players.add(p);
    }

    public void printPlayersList() {
        System.out.println("--------TOP PLAYERS--------");
        for (Player player : players) {
            System.out.println("NAME -> " + player.getName().toUpperCase() + " " + 
                                "SCORE -> " + player.getScore());
        }
        System.out.println("---------------------------");
    }

}