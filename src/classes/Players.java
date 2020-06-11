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
            System.out.println("NAME -> " + player.getName() + " " + 
                                "SCORE -> " + player.getScore());
        }
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        
        System.out.println("PLAYER-TEST");

        Players playerList = new Players();
        playerList.addPlayer("Marcello", 100);
        playerList.addPlayer("Marcello", 1012);
        playerList.addPlayer("Marcello", 101212);
        playerList.addPlayer("Marcello", 112);
        playerList.addPlayer("Marcello", 1111);
        playerList.addPlayer("Marcello", 12334);
        playerList.addPlayer("Marcello", 999);
        playerList.addPlayer("Marcello", 111);
        playerList.printPlayersList();

    }

}