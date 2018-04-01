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
		assertEquals("KHAN", solve.getWordsNeededSearch().get(1).getWord());
		assertEquals("KIRK", solve.getWordsNeededSearch().get(2).getWord());
		assertEquals("SCOTTY", solve.getWordsNeededSearch().get(3).getWord());
		assertEquals("SPOCK", solve.getWordsNeededSearch().get(4).getWord());
		assertEquals("SULU", solve.getWordsNeededSearch().get(5).getWord());
		assertEquals("UHURA", solve.getWordsNeededSearch().get(6).getWord());

	}
}
