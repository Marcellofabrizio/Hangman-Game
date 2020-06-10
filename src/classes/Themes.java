package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Themes  {
    
    public Words computerThemeList = new Words();
    public Words placesThemeList = new Words(); 
 

    public Themes() {
        this.generateComputerWords();
        this.generatePlacesWords();
    }

    private void generateComputerWords() {
        this.computerThemeList.addWord("COMPUTER");
        this.computerThemeList.addWord("HARDWARE");
        this.computerThemeList.addWord("SOFTWARE");
        this.computerThemeList.addWord("PYTHON");
        this.computerThemeList.addWord("JAVA");
        this.computerThemeList.addWord("LINUX");
        this.computerThemeList.addWord("UBUNTU");
        this.computerThemeList.addWord("WINDOWS");
    }

    private void generatePlacesWords() {
        this.placesThemeList.addWord("MANCHESTER");
        this.placesThemeList.addWord("NAGASAKY");
        this.placesThemeList.addWord("VLADIVOSTOK");
        this.placesThemeList.addWord("SAINT-PETERSBURG");
        this.placesThemeList.addWord("RIO-DE-JANEIRO");
        this.placesThemeList.addWord("WASHINGTON");
        this.placesThemeList.addWord("ISTANBUL");
        
    }

    public Words getComputerTheme() {
        return this.computerThemeList;
    }

    public Words getPlacesTheme() {
        return this.placesThemeList;
    }

    public Words pickRandomTheme() {
        Random random = new Random();
        int selector = random.nextInt(2);
        Themes theme = new Themes();
        if (selector == 0) {
            return theme.getComputerTheme();
        }

        return theme.getPlacesTheme();
    }


    public static void main(String[] args) {
        Themes theme = new Themes();
        Words selectedTheme = theme.pickRandomTheme();
        Word pickedWord = selectedTheme.pickWord();
        System.out.println(pickedWord.getContent());
    }
}