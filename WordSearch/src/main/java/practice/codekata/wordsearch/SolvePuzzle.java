
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
			wordsNeededSearch = getListOfWords(br);
			gridPuzzle = buildGrid(br);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Success";// continue with the search
	}

	private Grid buildGrid(BufferedReader br) {
		return new Grid(15);
	}

	private List<Words> getListOfWords(BufferedReader br) {
		List<Words> wordsList = new ArrayList<Words>();
		try {
			String[] firstLine = br.readLine().split(",");
			for(String word:firstLine) {
				Words w = new Words();
				w.setFound(false);
				w.setWord(word);
				wordsList.add(w);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wordsList;
	}

	public List<Words> getWordsNeededSearch() {
		return wordsNeededSearch;
	}
	
	public Grid getGridPuzzle(){
		return gridPuzzle;
	}
	
}
