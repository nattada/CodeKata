package practice.codekata.wordsearch;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
		assertEquals("Success",solve.buildPuzzle());
	}
	@Test
	public void whenSolvePuzzlePassedAFileIsNotFound() {
		SolvePuzzle solve =  new SolvePuzzle("nofilefound.csv");
		assertEquals("Fail", solve.buildPuzzle());
	}
	@Test
	public void whenSolvePuzzleFoundInputFileReadFirstRowForListOfWords() {
		solve.buildPuzzle();
		List<Words>words = solve.getWordsNeededSearch();
		assertEquals("BONES", words.get(0).getWord());
		assertEquals("KHAN", words.get(1).getWord());
		assertEquals("KIRK", words.get(2).getWord());
		assertEquals("SCOTTY",words.get(3).getWord());
		assertEquals("SPOCK", words.get(4).getWord());
		assertEquals("SULU", words.get(5).getWord());
		assertEquals("UHURA", words.get(6).getWord());

	}
	@Test
	public void whenSolvePuzzleFoundInputFileAndReadFirstRowForListOfWordsThenCheckNumberOfWords() {
		solve.buildPuzzle();
		List<Words>words = solve.getWordsNeededSearch();		
		assertEquals(7, words.size());

	}
	
	@Test
	public void whenSolvePuzzleReadAFileToBuildAGridItReturnsCorrectNumberOfRowsAndColumns() {
		solve.buildPuzzle();
		Grid grid = solve.getGridPuzzle();
		assertEquals(15, grid.getNumColumn());
		assertEquals(15, grid.getNumRow());

	}
	@Test
	public void whenSolvePuzzleReadAFileToBuildAGridItReturnsCorrect2DArrayRepresentationOfTheGrid() {
		solve.buildPuzzle();
		Grid grid = solve.getGridPuzzle();
		assertEquals("U", grid.getGridSquare()[0][0]);
		assertEquals("B", grid.getGridSquare()[14][14]);

	}
	

}
