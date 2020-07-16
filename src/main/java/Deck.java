import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void populate() {
        RankType[] ranks = RankType.values();
        SuitType[] suits = SuitType.values();

        for (RankType rank : ranks){
            for (SuitType suit : suits){
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(this.cards);
    }

    public Card dealCard() {
        if (this.cards.size() > 0){
            return this.cards.remove(0);
        }
        return null;
    }

}
