
public class PreDeuceScorer implements Scorer {

	private static final String[] SCORE = { "L", "15", "30", "40" };

	private int playerOneIndex = 0;
	private int playerTwoIndex = 0;

	private ScoreListener listener;

	@Override
	public String getScore() {
		return SCORE[playerOneIndex] + "-" + SCORE[playerTwoIndex];
	}

	@Override
	public void playerOneScores() {
		playerOneIndex++;
		checkForDeuce();
		checkForPlayerOneWon();
	}

	@Override
	public void playerTwoScores() {
		playerTwoIndex++;
		checkForDeuce();
	}

	private void checkForDeuce() {
		if (isDeuce()) {
			listener.deuce();
		}
	}

	private boolean isDeuce() {
		return playerOneIndex >=3 && playerTwoIndex >=3;
	}

	private void checkForPlayerOneWon() {
		if (playerOneIndex == 4)
			listener.playerOneWon();
	}

	public void add(ScoreListener listener) {
		this.listener = listener;
	}

}
