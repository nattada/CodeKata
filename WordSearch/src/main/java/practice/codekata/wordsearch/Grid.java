package practice.codekata.wordsearch;

public class Grid {
	int numRow;
	int numColumn;
	String[][] gridSquare;

	public Grid(int size, String[][] charArray) {
		this.numColumn = size;
		this.numRow = size;
		gridSquare = new String[size][size];
		copyArray(charArray);
		// System.arraycopy(charArray, 0, gridSquare, 0, size);
	}

	private void copyArray(String[][] srcArray) {
		for (int i = 0; i < getNumRow(); i++) {
			String[] row = srcArray[i];
			gridSquare[i] = new String[getNumRow()];
			System.arraycopy(row, 0, gridSquare[i], 0, getNumRow());
		}
	}

	public int getNumRow() {
		return numRow;
	}

	public int getNumColumn() {
		return numColumn;
	}

	public String[][] getGridSquare() {
		return gridSquare;
	}

	public String getLetterFromPosition(int row, int col) {
		return gridSquare[row][col];
	}

	public String[] getLettersForRow(int row) {
		return gridSquare[row];
	}

	public String[] getLettersForCol(int col) {
		int columnSize = getNumColumn();
		String[] letters = new String[columnSize];
		for (int i = 0; i < getNumRow(); i++) {
			letters[i] = gridSquare[i][col];
		}
		return letters;
	}

	public String[] getLettersDiagonallyDescending(int row, int col) {
		String[] letters;
		int size;
		if (row == col) {
			size = getNumRow();

		} else if (row > col) {
			size = getNumColumn() - row;
		} else {
			size = getNumColumn() - col;

		}
		letters = new String[size];
		for (int i = 0; i < size; i++) {
			letters[i] = gridSquare[row++][col++];
		}

		return letters;
	}

	public String[] getLettersDiagonallyAscending(int row, int col) {
		String[] letters = null;
		int index = 0;
		int columnIndex = 0;
		int size;
		if (row == col) {
			size = getNumRow();
		} else if (row > col) {
			size = row + 1;

		} else {
			size = col + 1;
		}
		letters = new String[size];
		for (int i = size - 1; i >= 0; i--) {
			letters[index++] = gridSquare[i][columnIndex++];
		}

		return letters;
	}

}
