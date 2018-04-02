package practice.codekata.wordsearch;

public class Words {
	
	private String word;
	private boolean found;
	private int fistColumnLetterLocation;
	private int lastColumnLetterLocation;
	private int rowLetterLocation;
	
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
	public int getFistColumnLetterLocation() {
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
	public void setRowLetterLocation(int rowLetterLocation) {
		this.rowLetterLocation = rowLetterLocation;
	}
	public int getRowLetterLocation() {
		return rowLetterLocation;
	}
	
}
