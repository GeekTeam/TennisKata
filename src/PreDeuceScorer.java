
public class PreDeuceScorer implements Scorer {

	private static final String[] SCORE = {"L","15","30","40"};
	
	private int playerOneIndex = 0;
	private int playerTwoIndex = 0;

	private ScoreListener listener;

	@Override
	public String getScore() {
		if(isDeuce()) {
			
			if (playerOneIndex - playerTwoIndex == 1) {
				return "Adv 1";
			}
			return "Deuce";
		}
		return SCORE[playerOneIndex] + "-" + SCORE[playerTwoIndex];
	}

	private boolean isDeuce() {
		return playerOneIndex >=3 && playerTwoIndex >=3;
	}

	@Override
	public void playerOneScores() {
		playerOneIndex++;
		checkForDeuce();
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

	public void add(ScoreListener listener) {
		this.listener = listener;
	}

}
