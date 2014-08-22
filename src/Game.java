
public class Game {

	private final PreDeuceScorer preDeuceScorer;
	private final PostDeuceScorer postDeuceScorer;
	private Scorer scorer;

	public Game(PreDeuceScorer preDeuceScorer, PostDeuceScorer postDeuceScorer) {

		this.preDeuceScorer = preDeuceScorer;
		this.postDeuceScorer = postDeuceScorer;

		init(preDeuceScorer);
	}

	private void init(PreDeuceScorer preDeuceScorer) {

		scorer = preDeuceScorer;

		addListener(preDeuceScorer);
	}

	private void addListener(PreDeuceScorer preDeuceScorer) {
		ScoreListener listener = new GameScoreListener(this);

		preDeuceScorer.add(listener);
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

	void deuce() {
		scorer = postDeuceScorer;
	}
}
