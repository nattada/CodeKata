
package practice.codekata.wordsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SolvePuzzle {
	private String inputFile;
	private List<Words> wordsNeededSearch;
	private Grid puzzleGrid;
	public Heuristic heuristic;

	public SolvePuzzle(String inputFile) {
		this.inputFile = inputFile;
		heuristic = new Heuristic();
	}

	public String search() {
		String result;
		result = buildPuzzle();
		List<Words> wordFound = heuristic.solvePuzzle(wordsNeededSearch, puzzleGrid);
		printingResults(wordFound);

		return result;// continue with the search
	}

	private void printingResults(List<Words> wordFound) {
		for (Words word : wordFound) {
			System.out.println(word.getWord() + ":" + " " + lettersPosition(word));
		}

	}

	private String lettersPosition(Words word) {
		
		if (word.getFirstLetterRowPosition() == word.getLastLetterRowPosition()) {
			// horizontal
			String position="t";
			int column =  word.getFirstLetterRowPosition();
			int row = word.getFirstLetterRowPosition();
			for(int i = 0; i<word.getWord().length(); i++) {
				String pos = (" (" + row + "," +  column + ") ");
				position.concat(pos);
			}
			return position;
		}
		if(word.getFirstLetterColumnPosition() == word.getLastLetterRowPosition()) {
			//vertical
			return "";
		}
		
		if (word.getFirstLetterRowPosition() > word.getLastLetterRowPosition()) {
			// Diagonally Descending
			return "";
		}
		if(word.getFirstLetterColumnPosition() < word.getLastLetterRowPosition()) {
			//Diagonally Ascending
			return "";
		}
		

		return "";
	}

	public String buildPuzzle() {
		try {
			InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(inputFile);
			if (inputStream == null) {
				return "Fail";
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			wordsNeededSearch = getListOfWords(br.readLine());
			puzzleGrid = buildGrid(br);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Success";
	}

	private Grid buildGrid(BufferedReader br) {
		String[][] charArray = new String[256][256];
		int row = 0, col = 0;
		try {
			String line;
			while ((line = br.readLine()) != null) {
				String[] letterArray = line.split(",");
				for (String letter : letterArray) {
					charArray[row][col] = letter;
					col++;
				}
				row++;
				col = 0;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new Grid(row, charArray);
	}

	private List<Words> getListOfWords(String line) {
		List<Words> wordsList = new ArrayList<Words>();

		String[] firstLine = line.split(",");
		for (String word : firstLine) {
			Words w = new Words(word);
			wordsList.add(w);
		}
		return wordsList;
	}

	public List<Words> getWordsNeededSearch() {
		return wordsNeededSearch;
	}

	public Grid getGridPuzzle() {
		return puzzleGrid;
	}

}
