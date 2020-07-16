import java.util.ArrayList;

public class Player {

    private int secondaryCardTotal;
    private String name;
    private ArrayList<Card> cards;
    private int cardTotal;

    public Player(String name) {
        this.name = name;
        this.cards = new ArrayList<Card>();
        this.cardTotal = 0;
        this.secondaryCardTotal = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void addCard(Card card){
        this.cards.add(card);
    }

    public int getCardTotal(){
        for (Card card : this.cards){
            this.cardTotal += card.getRankValue();
        }
        return this.cardTotal;
    }

    public int getSecondaryCardTotal(){
        for (Card card : this.cards){
            this.secondaryCardTotal += card.getSecondaryValue();
        }
        return this.secondaryCardTotal;
    }

}
