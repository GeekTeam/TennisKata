import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class GameUnitTest {

	Game game;

	PreDeuceScorer preDeuceScorer = mock(PreDeuceScorer.class);
	PostDeuceScorer postDeuceScorer = mock(PostDeuceScorer.class);


	@Before
	public void setUp(){
		game = new Game(preDeuceScorer, postDeuceScorer);
	}

	@Test
	public void initiallyDelegatesToPreDeuceScorer() {

		game.playerOneScores();
		verify(preDeuceScorer).playerOneScores();

		game.playerTwoScores();
		verify(preDeuceScorer).playerTwoScores();

		when(preDeuceScorer.getScore()).thenReturn("15-30");
		assertEquals("15-30", game.getScore());
	}

	@Test
	public void delegatesToPostDeuceScorerAfterDeuce() {

		game.deuce();

		game.playerOneScores();
		verify(postDeuceScorer).playerOneScores();

		game.playerTwoScores();
		verify(postDeuceScorer).playerTwoScores();

		when(postDeuceScorer.getScore()).thenReturn("Adv 1");
		assertEquals("Adv 1", game.getScore());
	}

}
