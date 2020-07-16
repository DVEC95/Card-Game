import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest{

    private Player player;
    private Card card;

    @Before
    public void before(){
        player = new Player("player1");
        card = new Card(SuitType.SPADES, RankType.SEVEN);
    }

    @Test
    public void canGetName(){
        assertEquals("player1", player.getName());
    }

    @Test
    public void hasCards(){
        assertEquals(0, player.getCards().size());
    }

    @Test
    public void canAddCard(){
        player.addCard(card);
        assertEquals(1, player.getCards().size());
    }

}
