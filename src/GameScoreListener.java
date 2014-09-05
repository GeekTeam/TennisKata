
final class GameScoreListener implements ScoreListener {

	private final Game game;

	GameScoreListener(Game game) {
		this.game = game;
	}

	@Override
	public void deuce() {
		game.deuce();
	}

	@Override
	public void playerOneWon() {
		game.playerOneWon();
	}
}
