
public class PostDeuceScorer implements Scorer {

	private int playerOneIndex = 0;
	private int playerTwoIndex = 0;

	@Override
	public String getScore() {
		if (playerOneIndex - playerTwoIndex == 1) {
			return "Adv 1";
		}

		if (playerTwoIndex - playerOneIndex == 1) {
			return "Adv 2";
		}

		return "Deuce";
	}

	@Override
	public void playerOneScores() {
		playerOneIndex++;
	}

	@Override
	public void playerTwoScores() {
		playerTwoIndex++;
	}
}
