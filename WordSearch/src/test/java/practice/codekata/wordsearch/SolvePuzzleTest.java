package practice.codekata.wordsearch;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SolvePuzzleTest {
	@Test
	public void whenSolvePuzzlePassedAFileIsFound() {
		SolvePuzzle solve =  new SolvePuzzle("puzzleOne.csv");
		assertEquals("Success", solve.search());
	}
	@Test
	public void whenSolvePuzzlePassedAFileIsNotFound() {
		SolvePuzzle solve =  new SolvePuzzle("nofilefound.csv");
		assertEquals("Fail", solve.search());
	}
	@Test
	public void whenSolvePuzzleFoundInputFileReadFirstRowForListOfWords() {
		SolvePuzzle solve  = new SolvePuzzle("puzzleOne.csv");
		solve.search();
		assertEquals("BONES", solve.getWordsNeededSearch().get(0).getWord());
	}
}
