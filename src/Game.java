
public class Game {

	private final PreDeuceScorer preDeuceScorer = new PreDeuceScorer();
	private Scorer scorer = preDeuceScorer;

	public Game() {
		preDeuceScorer.add(new ScoreListener() {
			
			@Override
			public void deuce() {
			}
		});
	}

	public String getScore() {
		return scorer.getScore();
	}

	public void playerOneScores() {
		scorer.playerOneScores();
	}

	public void playerTwoScores() {
		scorer.playerTwoScores();
	}
}
