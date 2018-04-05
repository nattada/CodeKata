package practice.codekata.wordsearch;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GridTest {

	public Grid puzzle;

	@Before
	public void setUp() {
		SolvePuzzle solvPuzzle = new SolvePuzzle("puzzleOne.csv");
		solvPuzzle.buildPuzzle();
		puzzle = solvPuzzle.getGridPuzzle();
	}
	
	@Test
	public void whenBothRowIndexAndColumnIndexAreZeroPassToGetLettersDiagonallyDescendingReturnLettersDiagonallyDescendingFromThatPoint() {
		String [] letters =puzzle.getLettersDiagonallyDescending(0, 0);
		assertEquals("ULUSGYEMECEOZXB",Arrays.stream(letters).reduce("", String::concat));
	}
	
	@Test
	public void whenRowIndexIsNonZeroAndColumnIndexIsZeroPassToGetLettersDiagonallyDescendingReturnLettersDiagonallyDescendingFromThatPoint() {
		String [] letters =puzzle.getLettersDiagonallyDescending(4, 0);
		assertEquals("ACQIYKIECBC",Arrays.stream(letters).reduce("", String::concat));
	}
	@Test
	public void whenRowIndexIsZeroAndColumnIndexIsNonZeroPassToGetLettersDiagonallyDescendingReturnLettersDiagonallyDescendingFromThatPoint() {
		String [] letters =puzzle.getLettersDiagonallyDescending(0, 3);
		assertEquals("HKPQRRVFRYWK",Arrays.stream(letters).reduce("", String::concat));
	}
	
	@Test
	public void whenBothRowIndexAndColmnIndexAreTheSizeOfTheGridPassToGetLettersDiagonallyAscendingReturnLettersDiagonallyAscendingFromThatPoint() {
		String [] letters =puzzle.getLettersDiagonallyAscending(puzzle.getNumRow()-1,0);
		assertEquals("KZYBMKQMEEHKXYE", Arrays.stream(letters).reduce("", String::concat));
	}
	@Test
	public void whenColumnIndexIsZeroPassToGetLettersDiagonallyAscendingReturnLettersDiagonallyAscendingFromThatPoint() {
		String [] letters =puzzle.getLettersDiagonallyAscending(11, 0);
		assertEquals("TJZIKNKRTHGO",Arrays.stream(letters).reduce("", String::concat));
	}
	
	@Test
	public void whenIsNonZeroPassToGetLettersDiagonallyAscendingReturnLettersDiagonallyAscendingFromThatPoint() {
		String [] letters =puzzle.getLettersDiagonallyAscending(14, 8);
		assertEquals("DBYOKAS",Arrays.stream(letters).reduce("", String::concat));
	}

}
