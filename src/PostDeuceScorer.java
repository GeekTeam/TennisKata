
public class PostDeuceScorer implements Scorer {

	private static final String[] SCORE = {"L","15","30","40"};

	private int playerOneIndex = 3;
	private int playerTwoIndex = 3;

	@Override
	public String getScore() {
		if(playerOneIndex >=3 && playerOneIndex >=3) {

			if (playerOneIndex - playerTwoIndex == 1) {
				return "Adv 1";
			}
			return "Deuce";
		}
		return SCORE[playerOneIndex] + "-" + SCORE[playerTwoIndex];
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
