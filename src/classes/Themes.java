package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
            printRandomThemeName(selector);
            return theme.getComputerTheme();
        }

        printRandomThemeName(selector);
        return theme.getPlacesTheme();
    }

    public static void printRandomThemeName(int selector) {
        if (selector == 0) {
            System.out.println("O tema é TERMOS DE COMPUTAÇÃO E PROGRAMAÇÃO");
        }
        else if (selector ==1){
        System.out.println("O tema é CIDADES DO MUNDO");
        }
    }

    public void addNewWordToTheme() {
        System.out.println("VOCÊ DESEJA ADICIONAR UMA PALAVRA NOVA PARA OS SEGUINTES TEMAS?");
        System.out.println("1 ---- CIDADES DO MUNDO");
        System.out.println("2 ---- TERMOS DE COMPUTAÇÃO E PROGRAMAÇÃO");
        System.out.println("3 ---- CONTINUAR SEM PALAVRA NOVA");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        
        switch(option) {
            case 1: {
                String newWord = in.next();
                this.placesThemeList.addWord(newWord.toUpperCase());
                break;
            }

            case 2: {
                String newWord = in.next();
                this.computerThemeList.addWord(newWord.toUpperCase());
                break;
            }

            case 3: {
                break;
            }
        }
    }

    
}