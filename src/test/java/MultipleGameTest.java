import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MultipleGameTest {

    private MultipleGame multipleGame;
    private Player player1;
    private Player player2;
    private Player player3;
    private ArrayList<Player> players;
    private Card cards;

    @Before
    public void before() {
        players = new ArrayList<Player>();
        player1 = new Player("one");
        player2 = new Player("two");
        player3 = new Player("three");
        players.add(player1);
        players.add(player2);
        players.add(player3);
    }

    @Test
    public void canStartWithFiveCards(){
        multipleGame = new MultipleGame(players, 10);
        assertEquals(true, multipleGame.validCardAmount());
    }

    @Test
    public void canNotStartWithTwentyCards(){
        multipleGame = new MultipleGame(players, 20);
        assertEquals(false, multipleGame.validCardAmount());
    }

}

