package practice.codekata.wordsearch;

public class Grid {
	int numRow;
	int numColumn;
	String[][] gridSquare;
	public Grid(int size, String[][] charArray ) {
		this.numColumn = size;
		this.numRow = size;
		gridSquare = new String[size][size];
		System.arraycopy(charArray, 0, gridSquare, 0, size);
	}
	public int getNumRow() {
		return numRow;
	}
	public int getNumColumn() {
		return numColumn;
	}
	
	public String[][] getGridSquare(){
		return gridSquare;
	}

}
