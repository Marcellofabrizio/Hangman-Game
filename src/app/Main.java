package app;

import java.util.Scanner;
public class Main {
    
    static Players playersList = new Players();
    public static void main(String[] args) {
        System.out.print("\033[H\033[2J");
        System.out.println("AS PALAVRAS SÃO GERADAS COM BASE EM DOIS TEMAS ALEATÓRIOS: \n"
                            + "CIDADES DO MUNDO E TERMOS DE COMPUTAÇÃO E PROGRAMAÇÃO.\n"
                            + "PODE HAVER MAIS DE UMA PALAVRA POR JOGADA.\n\n"
                            + "VOCÊ GANHA 100 PONTOS SE ACERTAR UMA PALAVRA CORRETAMENTE,\n"
                            + "E 15 PONTOS POR CADA CAMPO ENCOBERTO.\n"
                            + "VOCÊ SÓ PODE CHUTAR UMA LETRA POR VEZ.\n");
        System.out.println("ATENÇÃO!!!\n" 
                            + "PARA ESPAÇOS USE -\n");

        String yesNo = ""; 
        do 
        {
            yesNo = execute();
        } while(yesNo.equals("Y") || yesNo.equals("YES"));
    }

    public static String execute() {
        Scanner in = new Scanner(System.in);

        String yesNo = "N";
        Themes theme = new Themes();
        Play play = new Play();

        System.out.println("\n");
        play.CONTINUEGAME = true;

        System.out.println("Diga-me o seu nome, jogador!\n");
        String currentPlayerName = in.nextLine();
        Player currentPlayer = new Player(currentPlayerName);
        System.out.print("\033[H\033[2J");
        System.out.println("Bem vindo, " + currentPlayerName.toUpperCase());

        Words words = theme.pickRandomTheme();
        int selector = words.chooseMultipleWords();
        Word pickeWord = words.addMultipleWords(selector);
        play.hiddenWord.setContent(pickeWord.getContent());

        while (play.CONTINUEGAME == true) {
            System.out.println("Digite uma letra => \n");
            Character guessedLetter = in.next().charAt(0);
            if (play.addGuessedLetters(guessedLetter)) {
                play.playHangman();
            }

            play.CONTINUEGAME = play.continueGame();

        }

        if (play.resultsGame() == false) {
            System.out.println("Desculpe, você perdeu");
            System.out.println("A palavra escondida era -> " + play.hiddenWord.getContent());
            System.out.println("Você quer jogar de novo? Y/N");
            int score = currentPlayer.getScoreFromResult(play.getFoundLetters());
            currentPlayer.setScore(score);
            yesNo = in.next();
            playersList.addPlayer(currentPlayer.getName(), currentPlayer.getScore());
            playersList.printPlayersList();
        }

        if(play.resultsGame() == true) {
            System.out.println("Você venceu!");
            System.out.println("A palavra escondida era -> " + play.hiddenWord.getContent());
            System.out.println("Você quer jogar de novo? Y/N");
            currentPlayer.setScore(100);
            yesNo = in.next();
            playersList.addPlayer(currentPlayer.getName(), currentPlayer.getScore());
            playersList.printPlayersList();
        }

        if(yesNo.toUpperCase().equals("Y") || yesNo.toUpperCase().equals("YES"))    
            theme.addNewWordToTheme();
            
        return yesNo.toUpperCase();
        
    }

}