package practice.codekata.wordsearch;

public class Words {

	private String word;
	private boolean found;
	private int fistColumnLetterLocation;
	private int lastColumnLetterLocation;
	private int firstRowLetterLocation;
	private int lastRowLetterLocation;

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

	public int getFirstColumnLetterLocation() {
		return fistColumnLetterLocation;
	}

	public void setFistColumnLetterLocation(int fistColumnLetterLocation) {
		this.fistColumnLetterLocation = fistColumnLetterLocation;
	}

	public int getLastColumnLetterLocation() {
		return lastColumnLetterLocation;
	}

	public void setLastColumnLetterLocation(int lastColumnLetterLocation) {
		this.lastColumnLetterLocation = lastColumnLetterLocation;
	}

	public void setFirstRowLetterLocation(int firstRowLetterLocation) {
		this.firstRowLetterLocation = firstRowLetterLocation;
	}

	public void setLastRowLetterLocation(int lastRowLetterLocation) {
		this.lastRowLetterLocation = lastRowLetterLocation;
	}

	public int getFirstRowLetterLocation() {
		return firstRowLetterLocation;
	}

	public int getLastRowLetterLocation() {
		return lastRowLetterLocation;
	}

	public void updateWordState(int startColPos, int endColPos, int startRowPos, int endRowPos) {
		this.setFistColumnLetterLocation(startColPos);
		this.setLastColumnLetterLocation(endColPos);
		this.setFirstRowLetterLocation(startRowPos);
		this.setLastRowLetterLocation(endRowPos);
		this.setFound(true);
	}

}
