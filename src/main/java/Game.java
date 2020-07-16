import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;
    private Deck deck;

    public Game(ArrayList<Player> players) {
        this.players = players;
        this.deck = new Deck();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Deck getDeck(){
        return this.deck;
    }

    public void startGame(){
        this.deck.populate();
        this.deck.shuffle();
    }

    public void dealCards(){
        for (Player player : this.players){
            player.addCard(this.deck.dealCard());
        }
    }

    public ArrayList<Player> findWinner(){

        ArrayList<Card> playerCards = new ArrayList<Card>();
        for(Player player : this.players){
            playerCards.add(player.getCards().get(0));
        }

        Card highestCard = playerCards.get(0);
        for(Card card : playerCards){
            if (card.getSecondaryValue() > highestCard.getSecondaryValue()){
                highestCard = card;
            }
        }

        ArrayList<Player> winners = new ArrayList<Player>();
        for (Player player : this.players){
            if (player.getCards().get(0).getSecondaryValue() == highestCard.getSecondaryValue()){
                winners.add(player);
            }
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
