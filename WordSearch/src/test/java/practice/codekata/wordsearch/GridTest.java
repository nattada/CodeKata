package practice.codekata.wordsearch;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GridTest {

	public Grid puzzle;

	@Before
	public void setUp() {
		SolvePuzzle buildPuzzle = new SolvePuzzle("puzzleOne.csv");
		buildPuzzle.search();
		puzzle = buildPuzzle.getGridPuzzle();
	}
	
	@Test
	public void whentheSameValueOfRowAndColumnArePassedToGetLettersDiagonallyDescendingThenReturnsAllLettersWhereRowIndexIsEqualToColumnIndex() {
		String [] letters =puzzle.getLettersDiagonallyDescending(0, 0);
		assertEquals("ULUSGYEMECEOZXB",Arrays.stream(letters).reduce("", String::concat));
	}
	

}
