package classes;

import java.util.ArrayList;
import java.util.List;

public class Players extends Player {
    
    List<Player> players = new ArrayList<>();

    public Players(String name, int score) {
        super(name, score);
    }

    public void addPlayer(String name, int score) {
        Player p = new Player(name, score);
        players.add(p);
    }

    public void printPlayersList() {
        System.out.println("--------TOP PLAYERS--------");
        for (Player player : players) {
            System.out.println("NAME -> " + player.getName() + " " + 
                                "SCORE -> " + player.getScore());
        }
        System.out.println("---------------------------");
    }

}