import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

public class PreDeuceScorerTest {

	private PreDeuceScorer preDeuceScorer = new PreDeuceScorer();
	private ScoreListener listener = mock(ScoreListener.class);

	@Before
	public void setUp() {
		preDeuceScorer.add(listener);
	}

	@Test
	public void initialScoreIsLoveAll() {
		assertEquals("L-L", preDeuceScorer.getScore());
	}

	@Test
	public void playerOneScoresGives15Love() {
		preDeuceScorer.playerOneScores();
		assertEquals("15-L", preDeuceScorer.getScore());
	}

	@Test
	public void playerTwoScoresGivesLove15() {
		preDeuceScorer.playerTwoScores();
		assertEquals("L-15", preDeuceScorer.getScore());
	}

	@Test
	public void bothPlayersScoreAndScoreIs1515() {
		preDeuceScorer.playerOneScores();
		preDeuceScorer.playerTwoScores();
		assertEquals("15-15", preDeuceScorer.getScore());
	}

	@Test
	public void playerOneScoresTwiceAndTheScoreIs30Love() {
		preDeuceScorer.playerOneScores();
		preDeuceScorer.playerOneScores();
		assertEquals("30-L", preDeuceScorer.getScore());
	}

	@Test
	public void playerTwoScoresTwiceAndTheScoreIsLove30() {
		preDeuceScorer.playerTwoScores();
		preDeuceScorer.playerTwoScores();
		assertEquals("L-30", preDeuceScorer.getScore());
	}

	@Test
	public void playerTwoScoresThriceAndTheScoreIsLove40() {
		preDeuceScorer.playerTwoScores();
		preDeuceScorer.playerTwoScores();
		preDeuceScorer.playerTwoScores();
		assertEquals("L-40", preDeuceScorer.getScore());
	}

	@Test
	public void playerOneScoresFourTimesAndWins() {
		preDeuceScorer.playerOneScores();
		preDeuceScorer.playerOneScores();
		preDeuceScorer.playerOneScores();
		preDeuceScorer.playerOneScores();

		verify(listener).playerOneWon();
	}


	@Test
	public void notifiesDeuceWhenPlayer1MakesDeuce() {
		preDeuceScorer.playerTwoScores();
		preDeuceScorer.playerTwoScores();
		preDeuceScorer.playerTwoScores();
		preDeuceScorer.playerOneScores();
		preDeuceScorer.playerOneScores();
		preDeuceScorer.playerOneScores();

		verify(listener).deuce();
	}

	@Test
	public void notifiesDeuceWhenPlayer2MakesDeuce() {
		preDeuceScorer.playerOneScores();
		preDeuceScorer.playerOneScores();
		preDeuceScorer.playerOneScores();
		preDeuceScorer.playerTwoScores();
		preDeuceScorer.playerTwoScores();
		preDeuceScorer.playerTwoScores();

		verify(listener).deuce();
	}
}
