
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
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Success";// continue with the search
	}

	private List<Words> getListOfWords(BufferedReader br) {
		List<Words> wordsList = new ArrayList<Words>();
		Words w = new Words();
		w.setFound(false);
		w.setWord("BONES");
		wordsList.add(w);
		return wordsList;
	}

	public List<Words> getWordsNeededSearch() {
		return wordsNeededSearch;
	}
}
