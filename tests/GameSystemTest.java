import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GameSystemTest {

	Game game = new Game(new PreDeuceScorer(), new PostDeuceScorer());

	@Test
	public void canScoreAGameWherePlayerOneWinsWithoutDeuce() {
		game.playerOneScores();
		assertEquals("15-L", game.getScore());

		game.playerTwoScores();
		assertEquals("15-15", game.getScore());

		game.playerOneScores();
		assertEquals("30-15", game.getScore());

		game.playerOneScores();
		assertEquals("40-15", game.getScore());

		game.playerOneScores();
		assertEquals("Player 1 Won", game.getScore());
	}
}
