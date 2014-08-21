import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class PreDeuceScorerTest {

	private PreDeuceScorer scorer = new PreDeuceScorer();
	private ScoreListener listener = mock(ScoreListener.class);

	@Test
	public void notifiesDeuceWhenPlayer1MakesDeuce() {

		scorer.add(listener);

		scorer.playerTwoScores();
		scorer.playerTwoScores();
		scorer.playerTwoScores();
		scorer.playerOneScores();
		scorer.playerOneScores();
		scorer.playerOneScores();

		verify(listener).deuce();
	}


	@Test
	public void notifiesDeuceWhenPlayer2MakesDeuce() {

		scorer.add(listener);

		scorer.playerOneScores();
		scorer.playerOneScores();
		scorer.playerOneScores();
		scorer.playerTwoScores();
		scorer.playerTwoScores();
		scorer.playerTwoScores();

		verify(listener).deuce();
	}

}
