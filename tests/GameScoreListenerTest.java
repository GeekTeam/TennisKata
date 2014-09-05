import org.junit.Test;
import static org.mockito.Mockito.*;

public class GameScoreListenerTest {

	GameScoreListener listener;

	Game game = mock(Game.class);

	@Test
	public void noitfiesTheGameWhenDeuceIsReached() {
		listener = new GameScoreListener(game);

		listener.deuce();

		verify(game).deuce();
	}


	@Test
	public void noitfiesTheGameWhenPlayerOneWins() {
		listener = new GameScoreListener(game);

		listener.playerOneWon();

		verify(game).playerOneWon();
	}

}
