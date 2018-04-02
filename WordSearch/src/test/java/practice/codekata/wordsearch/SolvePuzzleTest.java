package practice.codekata.wordsearch;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SolvePuzzleTest {
	public SolvePuzzle solve;
	@Before
	public void setUp() {
		 solve  = new SolvePuzzle("puzzleOne.csv");
	}
	@Test
	public void whenSolvePuzzlePassedAFileIsFound() {
		assertEquals("Success", solve.search());
	}
	@Test
	public void whenSolvePuzzlePassedAFileIsNotFound() {
		SolvePuzzle solve =  new SolvePuzzle("nofilefound.csv");
		assertEquals("Fail", solve.search());
	}
	@Test
	public void whenSolvePuzzleFoundInputFileReadFirstRowForListOfWords() {
		solve.search();
		assertEquals("BONES", solve.getWordsNeededSearch().get(0).getWord());
		assertEquals("KHAN", solve.getWordsNeededSearch().get(1).getWord());
		assertEquals("KIRK", solve.getWordsNeededSearch().get(2).getWord());
		assertEquals("SCOTTY", solve.getWordsNeededSearch().get(3).getWord());
		assertEquals("SPOCK", solve.getWordsNeededSearch().get(4).getWord());
		assertEquals("SULU", solve.getWordsNeededSearch().get(5).getWord());
		assertEquals("UHURA", solve.getWordsNeededSearch().get(6).getWord());

	}
	@Test
	public void whenSolvePuzzleFoundInputFileAndReadFirstRowForListOfWordsThenCheckNumberOfWords() {
		solve.search();
		assertEquals(7, solve.getWordsNeededSearch().size());

	}
	
	@Test
	public void whenSolvePuzzleReadAFileToBuildAGridItReturnsCorrectNumberOfRowsAndColumns() {
		solve.search();
		assertEquals(15, solve.getGridPuzzle().getNumColumn());
		assertEquals(15, solve.getGridPuzzle().getNumRow());

	}
	@Test
	public void whenSolvePuzzleReadAFileToBuildAGridItReturnsCorrect2DArrayRepresentationOfTheGrid() {
		solve.search();
		assertEquals("U", solve.getGridPuzzle().getGridSquare()[0][0]);

	}
}
