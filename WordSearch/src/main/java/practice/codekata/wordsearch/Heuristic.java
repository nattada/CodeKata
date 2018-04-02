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
		return wordsLeftToSearch;

	}

	private void findWordsVertically() {

		for (int col = 0; col < grid.getNumColumn(); col++) {
			String colLetter = Arrays.stream((grid.getLettersForCol(col))).reduce("", String::concat);
			String reverse = new StringBuilder(colLetter).reverse().toString();

			for (Words word : getWordsNotFound()) {
				String strWord = word.getWord();
				if (colLetter.contains(strWord)) {
					word.updateWordState(col, col, colLetter.indexOf(strWord, 0),
							strWord.length() - 1 + colLetter.indexOf(strWord, 0));
				}
				if(reverse.contains(strWord)) {
					int startIndex =reverse.length() - 1 - reverse.indexOf(strWord, 0);
					word.updateWordState(col, col, startIndex, startIndex - strWord.length()+1);
				}

			}
		}

	}

	private void findWordsHorizontally() {

		for (int row = 0; row < grid.getNumRow(); row++) {
			String rowLetters = Arrays.stream((grid.getLettersForRow(row))).reduce("", String::concat);
			String reverse = new StringBuilder(rowLetters).reverse().toString();
			for (Words word : getWordsNotFound()) {
				String strWord = word.getWord();
				
				if (rowLetters.contains(strWord)) {
					word.updateWordState(rowLetters.indexOf(strWord, 0),
							strWord.length() - 1 + rowLetters.indexOf(strWord, 0), row, row);
				}
				if(reverse.contains(strWord)) {
					int startIndex =reverse.length() - 1 - reverse.indexOf(strWord, 0);
					word.updateWordState(startIndex, startIndex - strWord.length() +1,row,row);
				}
			}
		}

	}

	private List<Words> getWordsNotFound() {
		return wordsLeftToSearch.stream().filter(word -> !word.isFound()).collect(Collectors.toList());
	}

}
