package practice.codekata.wordsearch;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Heuristic {
	private List<Words> wordsLeftToSearch;
	private Grid grid;

	public void Heristic() {
	}

	public List<Words> solvePuzzle(List<Words> wordsNeededSearch, Grid puzzleGrid) {
		wordsLeftToSearch = wordsNeededSearch;
		grid = puzzleGrid;
		// initial attempt using bruteforce
		findWordsHorizontally();
		findWordsVertically();
		findWordsDiagonallyDescending();
		findWordsDiagonallyAscending();
		return wordsLeftToSearch;

	}

	private void findWordsVertically() {

		for (int col = 0; col < grid.getNumColumn(); col++) {
			String colLetter = Arrays.stream((grid.getLettersForCol(col))).reduce("", String::concat);
			String reverse = reverseString(colLetter);

			for (Words word : getWordsNotFound()) {
				String strWord = word.getWord();
				if (colLetter.contains(strWord)) {
					word.updateWordState(col, col, colLetter.indexOf(strWord, 0),
							strWord.length() - 1 + colLetter.indexOf(strWord, 0));
				}
				if (reverse.contains(strWord)) {
					int startIndex = reverse.length() - 1 - reverse.indexOf(strWord, 0);
					word.updateWordState(col, col, startIndex, startIndex - strWord.length() + 1);
				}

			}
		}

	}

	private void findWordsHorizontally() {

		for (int row = 0; row < grid.getNumRow(); row++) {
			String rowLetters = Arrays.stream((grid.getLettersForRow(row))).reduce("", String::concat);
			String reverse = reverseString(rowLetters);
			for (Words word : getWordsNotFound()) {
				String strWord = word.getWord();

				if (rowLetters.contains(strWord)) {
					word.updateWordState(rowLetters.indexOf(strWord, 0),
							strWord.length() - 1 + rowLetters.indexOf(strWord, 0), row, row);
				}
				if (reverse.contains(strWord)) {
					int startIndex = reverse.length() - 1 - reverse.indexOf(strWord, 0);
					word.updateWordState(startIndex, startIndex - strWord.length() + 1, row, row);
				}
			}
		}

	}

	private void findWordsDiagonallyDescending() {
		for (int row = 0; row < grid.getNumRow(); row++) {
			String letters = Arrays.stream((grid.getLettersDiagonallyDescending(row, 0))).reduce("", String::concat);
			String reverse = reverseString(letters);
			for (Words word : getWordsNotFound()) {
				String strWord = word.getWord();
				if (letters.contains(strWord)) {
					int firstLetterStartIndex = letters.indexOf(strWord, 0);
					word.updateWordState(firstLetterStartIndex, firstLetterStartIndex + (strWord.length() - 1),
							row + firstLetterStartIndex, row + firstLetterStartIndex + strWord.length() - 1);
				}
				if (reverse.contains(strWord)) {
					int firstLetterStartIndex = reverse.length() - 1 - reverse.indexOf(strWord, 0);
					word.updateWordState(firstLetterStartIndex, firstLetterStartIndex - (strWord.length() - 1),
							firstLetterStartIndex + row, firstLetterStartIndex + row - (strWord.length() -1));
				}
			}
		}

		for (int col = 1; col < grid.getNumRow(); col++) {
			String letters = Arrays.stream((grid.getLettersDiagonallyDescending(0, col))).reduce("", String::concat);
			String reverse = reverseString(letters);
			for (Words word : getWordsNotFound()) {
				String strWord = word.getWord();
				if (letters.contains(strWord)) {
					int firstLetterStartIndex = letters.indexOf(strWord, 0);
					word.updateWordState(col + firstLetterStartIndex,
							col + firstLetterStartIndex + (strWord.length() - 1), firstLetterStartIndex,
							firstLetterStartIndex + (strWord.length() - 1));
				}
				if (reverse.contains(strWord)) {
					int firstLetterStartIndex = reverse.indexOf(strWord, 0);
					int firstLetterColPos = col + reverse.length()-1 - firstLetterStartIndex;
					int firstLetterRowPos = (reverse.length() -1)-firstLetterStartIndex;
					word.updateWordState(firstLetterColPos,  firstLetterColPos -(strWord.length() -1)
							,firstLetterRowPos,firstLetterRowPos - (strWord.length() -1));
				}
			}
		}

	}
	
	private void findWordsDiagonallyAscending() {
		for (int row = grid.getNumRow()-1; row > 0; row--) {
			String letters = Arrays.stream((grid.getLettersDiagonallyAscending(row, 0))).reduce("", String::concat);
			for (Words word : getWordsNotFound()) {
				String strWord = word.getWord();
				if (letters.contains(strWord)) {
					word.updateWordState(0,0,0,0);
				}
			}
		}
	}

	private List<Words> getWordsNotFound() {
		return wordsLeftToSearch.stream().filter(word -> !word.isFound()).collect(Collectors.toList());
	}

	private String reverseString(String original) {
		return new StringBuilder(original).reverse().toString();
	}
}
