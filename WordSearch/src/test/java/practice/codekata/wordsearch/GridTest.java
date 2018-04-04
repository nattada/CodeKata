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
	public void whenValueOfRowAndColumnAreZeroAndArePassedToGetLettersDiagonallyDescendingReturnsAllLettersWhereRowIndexIsEqualToColumnIndexStartingFromTheLeftTopCorner() {
		String [] letters =puzzle.getLettersDiagonallyDescending(0, 0);
		assertEquals("ULUSGYEMECEOZXB",Arrays.stream(letters).reduce("", String::concat));
	}
	
	@Test
	public void whenValueOfRowIsGreaterThanColumnArePassedToGetLettersDiagonallyDescendingReturnsAllLettersWhereRowIndexIsOneLessToColumnIndexFromTheStartingIndex() {
		String [] letters =puzzle.getLettersDiagonallyDescending(4, 0);
		assertEquals("ACQIYKIECBC",Arrays.stream(letters).reduce("", String::concat));
	}
	@Test
	public void whenValueOfRowIsLessThanColumnArePassedToGetLettersDiagonallyDescendingThenReturnsAllLettersWhereRowIndexIsOneLessToColumnIndexFromTheStartingIndex() {
		String [] letters =puzzle.getLettersDiagonallyDescending(0, 3);
		assertEquals("HKPQRRVFRYWK",Arrays.stream(letters).reduce("", String::concat));
	}
	
	@Test
	public void whenValueOfRowAndColumnAreSizeOfTheGridAndPassedToGetLettersDiagonallyAscendingReturnsAllLettersAlongTheDiagnolLineStartingFromTheLeftBottomCorner() {
		String [] letters =puzzle.getLettersDiagonallyAscending(puzzle.getNumRow(), puzzle.getNumColumn());
		assertEquals("KZYBMKQMEEHKXYE", Arrays.stream(letters).reduce("", String::concat));
	}
	@Test
	public void whenValueOfRowIsGreaterThanColumnArePassedToGetLettersDiagonallyAscendingReturnsAllLettersWhereRowIndexIsOneLessToColumnIndexFromTheStartingIndex() {
		String [] letters =puzzle.getLettersDiagonallyAscending(11, 0);
		assertEquals("TJZIKNKRTHGO",Arrays.stream(letters).reduce("", String::concat));
	}
	
	@Test
	public void whenValueOfRowIsLessThanColumnArePassedToGetLettersDiagonallyAscendingThenReturnsAllLettersWhereRowIndexIsOneLessToColumnIndexFromTheStartingIndex() {
		String [] letters =puzzle.getLettersDiagonallyAscending(0, 5);
		assertEquals("SYJPKL",Arrays.stream(letters).reduce("", String::concat));
	}

}
