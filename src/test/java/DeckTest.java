import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    private Deck deck;

    @Before
    public void before(){
        deck = new Deck();
    }

    @Test
    public void canGetCards(){
        assertEquals(0, deck.getCards().size());
    }

    @Test
    public void canPopulateDeck(){
        deck.populate();
        deck.shuffle();
        deck.shuffle();
        deck.shuffle();
        assertEquals(52, deck.getCards().size());
    }

    @Test
    public void canDealCard(){
        deck.populate();
        deck.dealCard();
        assertEquals(51, deck.getCards().size());
    }

    @Test
    public void canDealCards(){
        deck.populate();
        deck.dealCard();
        deck.dealCard();
        deck.dealCard();
        assertEquals(49, deck.getCards().size());
    }

    @Test
    public void noCards(){
        assertEquals(null, deck.dealCard());
    }

}
