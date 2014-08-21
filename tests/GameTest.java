import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GameTest {

	Game game = new Game();

	@Test
	public void initialScoreIsLoveAll() {
		assertEquals("L-L", game.getScore());
	}

	@Test
	public void playerOneScoresGives15Love() {
		game.playerOneScores();
		assertEquals("15-L", game.getScore());
	}

	@Test
	public void playerTwoScoresGivesLove15() {
		game.playerTwoScores();
		assertEquals("L-15", game.getScore());
	}

	@Test
	public void bothPlayersScoreAndScoreIs1515() {
		game.playerOneScores();
		game.playerTwoScores();
		assertEquals("15-15", game.getScore());
	}

	@Test
	public void playerOneScoresTwiceAndTheScoreIs30Love() {
		game.playerOneScores();
		game.playerOneScores();
		assertEquals("30-L", game.getScore());
	}

	@Test
	public void playerTwoScoresTwiceAndTheScoreIsLove30() {
		game.playerTwoScores();
		game.playerTwoScores();
		assertEquals("L-30", game.getScore());
	}

	@Test
	public void playerTwoScoresThriceAndTheScoreIsLove40() {
		game.playerTwoScores();
		game.playerTwoScores();
		game.playerTwoScores();
		assertEquals("L-40", game.getScore());
	}

	@Test
	public void bothPlayersScoreThriceAndTheScoreIsDeuce() {
		game.playerTwoScores();
		game.playerTwoScores();
		game.playerTwoScores();
		game.playerOneScores();
		game.playerOneScores();
		game.playerOneScores();
		assertEquals("Deuce", game.getScore());
	}

	@Test
	public void bothPlayersScoreThriceThenPlayerOneScoresAndTheScoreIsAdvantagePlayerOne() {
		game.playerTwoScores();
		game.playerTwoScores();
		game.playerTwoScores();
		game.playerOneScores();
		game.playerOneScores();
		game.playerOneScores();
		game.playerOneScores();
		assertEquals("Adv 1", game.getScore());
	}

	@Test
	public void canReturnToDeuceFromAdvantage() {
		game.playerTwoScores();
		game.playerTwoScores();
		game.playerTwoScores();
		game.playerOneScores();
		game.playerOneScores();
		game.playerOneScores();
		game.playerOneScores();
		game.playerTwoScores();
		assertEquals("Deuce", game.getScore());
	}
}
