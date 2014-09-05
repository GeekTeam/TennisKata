import static org.junit.Assert.*;

import org.junit.Test;


public class PostDeuceScorerTest {

	PostDeuceScorer postDeuceScorer = new PostDeuceScorer();

	@Test
	public void theScoreIsInitiallyDeuce() {
		assertEquals("Deuce", postDeuceScorer.getScore());
	}

	@Test
	public void playerOneScoresTakesTheGameToAdvantagePlayerOne() {
		postDeuceScorer.playerOneScores();

		assertEquals("Adv 1", postDeuceScorer.getScore());
	}

	@Test
	public void playerTwoScoresTakesTheGameToAdvantagePlayerTwo() {
		postDeuceScorer.playerTwoScores();

		assertEquals("Adv 2", postDeuceScorer.getScore());
	}

	@Test
	public void canReturnToDeuceFromAdvantagePlayer1() {
		postDeuceScorer.playerOneScores();
		postDeuceScorer.playerTwoScores();

		assertEquals("Deuce", postDeuceScorer.getScore());
	}

	@Test
	public void canReturnToDeuceFromAdvantagePlayer2() {
		postDeuceScorer.playerTwoScores();
		postDeuceScorer.playerOneScores();

		assertEquals("Deuce", postDeuceScorer.getScore());
	}
}
