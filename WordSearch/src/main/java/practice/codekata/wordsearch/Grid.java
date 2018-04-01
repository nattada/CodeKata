package practice.codekata.wordsearch;

public class Grid {
	int numRow;
	int numColumn;
	public Grid(int size) {
		this.numColumn = size;
		this.numRow = size;
	}
	public int getNumRow() {
		return numRow;
	}
	public int getNumColumn() {
		return numColumn;
	}

}
