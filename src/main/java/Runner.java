import java.util.ArrayList;
import java.util.Scanner;

public class Runner {

    private ArrayList<Player> players;

    public static void main(String[] args) {
        System.out.println("Welcome to the game!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many players are playing?");
        int numberOfPlayers = scanner.nextInt();

        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 1; i <= numberOfPlayers; i++){
            scanner = new Scanner(System.in);
            System.out.println(String.format("Player %s, what is your name?", i));
            String name = scanner.nextLine();
            players.add(new Player(name));
        }

//        System.out.println("How many cards should each player get?");
//        int numberOfCards = scanner.nextInt();

//        MultipleGame game = new MultipleGame(players, numberOfCards);
//
//        while (game.validCardAmount() == false){
//            System.out.println("Please enter a valid amount.");
//            numberOfCards = scanner.nextInt();
//            game = new MultipleGame(players, numberOfCards);
//        }
//
//        game.startGame();
//        System.out.println("Type anything to deal cards.");
//        String begin = scanner.nextLine();
//        game.dealCards();
//        System.out.println(game.result());

        Game game = new Game(players);
        game.startGame();

        scanner = new Scanner(System.in);
        System.out.println("Type anything to deal cards.");
        String begin = scanner.nextLine();
        game.dealCards();
        for (Player player : players){
            System.out.println(String.format("%s has been dealt the %s of %s",
                    player.getName(),
                    player.getCards().get(0).getRank(),
                    player.getCards().get(0).getSuit()));
        }

        System.out.println(game.result());
    }

}
