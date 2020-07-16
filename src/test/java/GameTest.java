import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;
    private ArrayList<Player> players;
    private Card cards;

    @Before
    public void before(){
        players = new ArrayList<Player>();
        player1 = new Player("one");
        player2 = new Player("two");
        player3 = new Player("three");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        game = new Game(players);
    }

    @Test
    public void hasPlayers(){
        assertEquals(3, game.getPlayers().size());
    }

    @Test
    public void canStartGame(){
        game.startGame();
        assertEquals(52, game.getDeck().getCards().size());
    }

    @Test
    public void playerHasCards(){
        game.startGame();
        game.dealCards();

        ArrayList<Player> winners = game.findWinner();

        assertEquals(1, player1.getCards().size());
        assertEquals(1, player2.getCards().size());
        assertEquals(49, game.getDeck().getCards().size());
    }

    @Test
    public void canHandleDraw(){
        player1.addCard(new Card(SuitType.HEARTS, RankType.SEVEN));
        player2.addCard(new Card(SuitType.SPADES, RankType.SEVEN));
        player3.addCard(new Card(SuitType.CLUBS, RankType.SEVEN));
        assertEquals(3, game.findWinner().size());
    }

    @Test
    public void canGetDrawResponse(){
        player1.addCard(new Card(SuitType.HEARTS, RankType.SEVEN));
        player2.addCard(new Card(SuitType.SPADES, RankType.SEVEN));
        player3.addCard(new Card(SuitType.CLUBS, RankType.SEVEN));
        assertEquals("It's a draw, the winners are one, two and three", game.result());
    }


}
