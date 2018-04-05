package practice.codekata.wordsearch;

public class Words {

	private String word;
	private boolean found;
	private int firstLetterColumnPosition;
	private int lastLetterColumnPosition;
	private int firstLetterRowPosition;
	private int lastLetterRowPosition;
	private enum direction {HORIZONTALLY,VERTICALLY,HORIZONTALLYBACKWARD,VERTICALLYBACKWORD,
		DIAGONALLYDESCENDING,DIAGONALLYDESCENDINGBACKWARD,DIAGONALLYDASCENDING,DIAGONALLYASCENDINGBACKWARD};

	public Words(String text) {
		this.word = text;
		this.found = false;
	}
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public boolean isFound() {
		return found;
	}

	public void setFound(boolean found) {
		this.found = found;
	}

	public int getFirstLetterColumnPosition() {
		return firstLetterColumnPosition;
	}

	public void setFirstLetterColumnPosition(int firstLetterColumnPosition) {
		this.firstLetterColumnPosition = firstLetterColumnPosition;
	}

	public int getLastLetterColumnPosition() {
		return lastLetterColumnPosition;
	}

	public void setLastLetterColumnPosition(int lastLetterColumnPosition) {
		this.lastLetterColumnPosition = lastLetterColumnPosition;
	}

	public void setFirstLetterRowPosition(int firstLetterRowPosition) {
		this.firstLetterRowPosition = firstLetterRowPosition;
	}

	public void setLastLetterRowPosition(int lastLetterRowPosition) {
		this.lastLetterRowPosition = lastLetterRowPosition;
	}

	public int getFirstLetterRowPosition() {
		return firstLetterRowPosition;
	}

	public int getLastLetterRowPosition() {
		return lastLetterRowPosition;
	}

	public void updateWordState(int startColPos, int endColPos, int startRowPos, int endRowPos) {
		this.setFirstLetterColumnPosition(startColPos);
		this.setLastLetterColumnPosition(endColPos);
		this.setFirstLetterRowPosition(startRowPos);
		this.setLastLetterRowPosition(endRowPos);
		this.setFound(true);
	}
	
}
