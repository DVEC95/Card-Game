import java.util.ArrayList;

public class MultipleGame {

    private ArrayList<Player> players;
    private Deck deck;
    private int cardsPerPlayers;

    public MultipleGame(ArrayList<Player> players, int cardsPerPlayers) {
        this.players = players;
        this.cardsPerPlayers = cardsPerPlayers;
        this.deck = new Deck();
    }

    public boolean validCardAmount(){
        return this.players.size() * this.cardsPerPlayers <= 52;
    }

    public void startGame(){
        this.deck.populate();
        this.deck.shuffle();
    }

    public void dealCards(){
        for (Player player : this.players){
            for (int i = 0; i < this.cardsPerPlayers; i++){
                player.addCard(this.deck.dealCard());
            }
        }
    }

    public ArrayList<Player> findWinner(){

        ArrayList<Integer> playerTotals = new ArrayList<Integer>();
        for(Player player : this.players){
            playerTotals.add(player.getCardTotal());
        }

        int highestTotal = playerTotals.get(0);
        for(int total : playerTotals){
            if (total > highestTotal){
                highestTotal = total;
            }
        }

        ArrayList<Player> winners = new ArrayList<Player>();
        for (Player player : this.players){
            if (player.getCardTotal() == highestTotal){
                winners.add(player);
            }
        }

        if (winners.size() > 1){
            ArrayList<Integer> playerSecondaryTotals = new ArrayList<Integer>();
            for (Player player : winners){
                playerSecondaryTotals.add(player.getSecondaryCardTotal());
            }

            int highestSecondaryTotal = playerSecondaryTotals.get(0);
            for(int total : playerSecondaryTotals){
                if (total > highestTotal){
                    highestSecondaryTotal = total;
                }
            }
            ArrayList<Player> finalWinners = new ArrayList<Player>();
            for (Player player : winners){
                if (player.getSecondaryCardTotal() == highestSecondaryTotal){
                    finalWinners.add(player);
                }
            }
            return finalWinners;
        }

        return winners;

    }

    public String result(){
        ArrayList<Player> winners = this.findWinner();

        if (winners.size() == 1){
            return String.format("The winner is %s", winners.get(0).getName());
        } else if (winners.size() == 2){
            return String.format("It's a draw, the winners are %s and %s", winners.get(0).getName(), winners.get(1).getName());
        } else {
            String nameString = winners.get(0).getName();
            for (int i = 1; i < winners.size() - 1; i++){
                nameString = String.format("%s, %s", nameString, winners.get(i).getName());
            }
            nameString = String.format("%s and %s", nameString, winners.get(winners.size() - 1).getName());
            return String.format("It's a draw, the winners are %s", nameString);
        }
    }


}
