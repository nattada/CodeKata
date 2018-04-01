package practice.codekata.wordsearch;

public class Grid {
	long numRow;
	long numColumn;
	public Grid(long size) {
		this.numColumn = size;
		this.numRow = size;
	}
	public long getNumRow() {
		return numRow;
	}
	public long getNumColumn() {
		return numColumn;
	}

}
