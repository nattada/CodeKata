
package practice.codekata.wordsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SolvePuzzle {
	private String inputFile;
	private List<Words> wordsNeededSearch;
	private Grid gridPuzzle;

	public SolvePuzzle(String inputFile) {
		this.inputFile = inputFile;
	}

	public String search() {
		try {
			InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(inputFile);
			if (inputStream == null) {
				return "Fail";
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
			wordsNeededSearch = getListOfWords(br.readLine());
			gridPuzzle = buildGrid(br);

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Success";// continue with the search
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

		return new Grid(row,charArray);
	}

	private List<Words> getListOfWords(String line) {
		List<Words> wordsList = new ArrayList<Words>();

		String[] firstLine = line.split(",");
		for (String word : firstLine) {
			Words w = new Words();
			w.setFound(false);
			w.setWord(word);
			wordsList.add(w);
		}
		return wordsList;
	}

	public List<Words> getWordsNeededSearch() {
		return wordsNeededSearch;
	}

	public Grid getGridPuzzle() {
		return gridPuzzle;
	}

}
