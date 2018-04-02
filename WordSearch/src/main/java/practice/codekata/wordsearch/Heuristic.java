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
		return 	findWordsHorizontally();

	}

	private List<Words> findWordsHorizontally() {
		List<Words> wordsToSearch = wordsLeftToSearch.stream().filter(word -> !word.isFound())
				.collect(Collectors.toList());
		for (int row = 0; row < grid.getNumRow(); row++) {
			String rowLetters = Arrays.stream((grid.getLettersForRow(row))).reduce("", String::concat);;
			for (Words word : wordsToSearch) {
				String strWord = word.getWord();
				if(rowLetters.contains(strWord)) {
					word.setFound(true);
					word.setFistColumnLetterLocation(rowLetters.indexOf(String.valueOf(strWord.charAt(0))));
					word.setLastColumnLetterLocation(rowLetters.indexOf(String.valueOf(strWord.charAt(strWord.length()-1))));
					word.setRowLetterLocation(row);
					//return the position
				}
			}
		}
		//update the list of unfound words
		wordsLeftToSearch = wordsToSearch; 
		return wordsLeftToSearch;
	}

}
