package practice.codekata.wordsearch;

import java.io.File;

public class SolvePuzzle {
	private String inputFile;
	public SolvePuzzle(String inputFile) {
		this.inputFile = inputFile;
	}

	public String search() {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		try {
		File file = new File(classLoader.getResource(inputFile).getFile());
		}catch (NullPointerException ex) {
			return "Fail";
		}
		return "Success";//continue with the search
	}
}
