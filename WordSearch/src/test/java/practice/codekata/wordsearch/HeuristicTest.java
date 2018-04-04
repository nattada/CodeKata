package practice.codekata.wordsearch;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class HeuristicTest {
	public Grid puzzle;
	public List<Words> words;
	public List<Words> wordFoundList;
	public Heuristic heuristic;
	public Optional<Words> horizontalWord;
	public Optional<Words> reverseHorizontalWord;
	public Optional<Words> verticleWord;
	public Optional<Words> reverseVerticleWord;
	public Optional<Words> diagonallyDescendingAboveWord;
	public Optional<Words> diagonallyDescendingBelowWord;
	public Optional<Words> diagonallyDescendingBackwardWord;
	public Optional<Words> diagonallyDescendingBackwardBelowWord;
	public Optional<Words> diagonallyAscending;




	@Before
	public void setUp() {
		SolvePuzzle buildPuzzle =new SolvePuzzle("puzzleOne.csv");
		buildPuzzle.search();
		puzzle =buildPuzzle.getGridPuzzle();
		words = buildPuzzle.getWordsNeededSearch();
		heuristic = new Heuristic();

		Words descendingBelowWord = new Words("RIGQB");
		words.add(descendingBelowWord);
		Words descendingBelowBackwardWord = new Words("PFPHI");
		words.add(descendingBelowBackwardWord);
		wordFoundList = heuristic.solvePuzzle(words, puzzle);
		horizontalWord = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("SCOTTY") && word.isFound()).findFirst();
		reverseHorizontalWord = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("KIRK") && word.isFound()).findFirst();
		verticleWord = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("BONES") && word.isFound()).findFirst();
		reverseVerticleWord = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("KHAN") && word.isFound()).findFirst();
		diagonallyDescendingAboveWord = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("SPOCK") && word.isFound()).findFirst();
		diagonallyDescendingBelowWord = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("RIGQB") && word.isFound()).findFirst();
		diagonallyDescendingBackwardWord = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("SULU") && word.isFound()).findFirst();
		diagonallyDescendingBackwardBelowWord = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("PFPHI") && word.isFound()).findFirst();
		diagonallyAscending = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("UHURA") && word.isFound()).findFirst();
 
		
	}
	//Center line is a diagonally line from top left corner of the grid to bottom right corner

	@Test
	public void whenSearchingDiagonallyDescendingBackwardAboveenterLineAWordShouldBeFound() {
		assertEquals("PFPHI",diagonallyDescendingBackwardBelowWord.get().getWord());
	}
	
	@Test
	public void whenWordIsFoundAboveCenterLineBySearchingDiagonallyDescendingBackwardReturnTheFirstLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(13, diagonallyDescendingBackwardBelowWord.get().getFirstColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundAboveCenterLineBySearchingDiagonallyDescendingBackwardReturnTheLastLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(9, diagonallyDescendingBackwardBelowWord.get().getLastColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundAboveCenterLineBySearchingDiagonallyDescendingBackwardReturnTheFirstLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(7, diagonallyDescendingBackwardBelowWord.get().getFirstRowLetterLocation());
	}
	@Test
	public void whenWordIsFoundAboveCenterLineBySearchingDiagonallyDescendingBackwardReturnTheLastLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(3, diagonallyDescendingBackwardBelowWord.get().getLastRowLetterLocation());
	}
	@Test
	public void whenSearchingDiagonallyDescendingAndWordFoundBackWard() {
		assertEquals("SULU",diagonallyDescendingBackwardWord.get().getWord());
	}
	@Test
	public void whenWordIsFoundOnOrAboveCenterLineBySearchingDiagonallyDescendingReturnTheFirstLetterColumnPositionOfThatWordOnTheGrid(){
		assertEquals(3,diagonallyDescendingBackwardWord.get().getFirstColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundOnOrAboveCenterLineBySearchingDiagonallyDescendingReturnTheLastLetterColumnPositionOfThatWordOnTheGrid(){
		assertEquals(0,diagonallyDescendingBackwardWord.get().getLastColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundOnOrAboveCenterLineBySearchingDiagonallyDescendingReturnTheFirstLetterRowPositionOfThatWordOnTheGrid(){
		assertEquals(3,diagonallyDescendingBackwardWord.get().getFirstRowLetterLocation());
	}
	@Test
	public void whenWordIsFoundOnOrAboveCenterLineBySearchingDiagonallyDescendingReturnTheLastLetterRowPositionOfThatWordOnTheGrid(){
		assertEquals(0,diagonallyDescendingBackwardWord.get().getLastRowLetterLocation());
	}
	@Test
	public void whenSearchingDiagonallyDescengingAndWordFoundAboveCenterLine() {
		assertEquals("SPOCK",diagonallyDescendingAboveWord.get().getWord());
	}
	@Test
	public void whenSearchingDiagonallyDescengingAndWordFoundBelowCenterLine() {
		assertEquals("RIGQB",diagonallyDescendingBelowWord.get().getWord());
	}
	@Test
	public void whenWordIsFoundBelowCenterLineBySearchingDiagonallyDescengingReturnTheFirstColumnPositionOfThatWordOnTheGrid() {
		assertEquals(2,diagonallyDescendingBelowWord.get().getFirstColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundBelowCenterLineBySearchingDiagonallyDescengingReturnTheLastColumnPositionOfThatWordOnTheGrid() {
		assertEquals(6,diagonallyDescendingBelowWord.get().getLastColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundBelowCenterLineBySearchingDiagonallyDescengingReturnTheFirstRowPositionOfThatWordOnTheGrid() {
		assertEquals(7,diagonallyDescendingBelowWord.get().getFirstRowLetterLocation());
	}
	
	@Test
	public void whenWordIsFoundBelowCenterLineBySearchingDiagonallyDescengingReturnTheLastRowPositionOfThatWordOnTheGrid() {
		assertEquals(11,diagonallyDescendingBelowWord.get().getLastRowLetterLocation());
	}
	
	@Test
	public void whenWordIsFoundAboveCenterLineBySearchingDiagonallyDescengingReturnTheFirstColumnPositionOfThatWordOnTheGrid() {
		assertEquals(2,diagonallyDescendingAboveWord.get().getFirstColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundAboveCenterLineBySearchingDiagonallyDescengingReturnTheLastColumnPositionOfThatWordOnTheGrid() {
		assertEquals(6,diagonallyDescendingAboveWord.get().getLastColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundAboveCenterLineBySearchingDiagonallyDescengingReturnTheFirstRowPositionOfThatWordOnTheGrid() {
		assertEquals(1,diagonallyDescendingAboveWord.get().getFirstRowLetterLocation());
	}
	
	@Test
	public void whenWordIsFoundAboveCenterLineBySearchingDiagonallyDescengingReturnTheLastRowPositionOfThatWordOnTheGrid() {
		assertEquals(5,diagonallyDescendingAboveWord.get().getLastRowLetterLocation());
	}
	
	@Test
	public void whenSearchingHorizontallyAndWordOnTheXAxisFoundIfItExists() {
		assertEquals("SCOTTY",horizontalWord.get().getWord());
	}
	
	@Test
	public void whenWordIsFoundBySearchingHorizontallyReturnTheRowPositionOfThatWordOnTheGrid() {
		assertEquals(5,horizontalWord.get().getFirstRowLetterLocation());
		assertEquals(5,horizontalWord.get().getLastRowLetterLocation());

	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyReturnTheFirstColumnPositionOfThatWordOnTheGrid() {
		assertEquals(0,horizontalWord.get().getFirstColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyReturnTheLastColumnPositionOfThatWordOnTheGrid() {
		assertEquals(5,horizontalWord.get().getLastColumnLetterLocation());
	}

	@Test
	public void whenSearchingHorizontallyAndWordOnTheXAxisFoundIfItExistsInABackwardDirection() {
		assertEquals("KIRK",reverseHorizontalWord.get().getWord());
	}
	
	@Test
	public void whenWordIsFoundBySearchingHorizontallyBackwardReturnTheRowPositionOfThatWordOnTheGrid() {
		assertEquals(7,reverseHorizontalWord.get().getFirstRowLetterLocation());
		assertEquals(7,reverseHorizontalWord.get().getLastRowLetterLocation());

	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyBackwordReturnTheFirstColumnPositionOfThatWordOnTheGrid() {
		assertEquals(4,reverseHorizontalWord.get().getFirstColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyBackWardReturnTheLastColumnPositionOfThatWordOnTheGrid() {
		assertEquals(1,reverseHorizontalWord.get().getLastColumnLetterLocation());
	}
	
	@Test
	public void whenSearchingVerticallAndWordOnTheYAxisFoundIfItExistsInDownWordDirection() {
		assertEquals("BONES",verticleWord.get().getWord());
	}
	

	@Test
	public void whenWordIsFoundBySearchingVerticallyReturnTheFirstRowPositionOfThatWordOnTheGrid() {
		assertEquals(6,verticleWord.get().getFirstRowLetterLocation());
	}
	@Test
	public void whenWordIsFoundBySearchingVerticallyReturnTheLastRowPositionOfThatWordOnTheGrid() {
		assertEquals(10,verticleWord.get().getLastRowLetterLocation());
	}
	@Test
	public void whenWordIsFoundBySearchingVerticallyReturnTheColumnPositionOfThatWordOnTheGrid() {
		assertEquals(0,verticleWord.get().getFirstColumnLetterLocation());		
		assertEquals(0,verticleWord.get().getLastColumnLetterLocation());

	}
	
	@Test
	public void whenSearchingVerticallyAndWordOnTheYAxisFoundIfItExistsInUpwardDirection() {
		assertEquals("KHAN",reverseVerticleWord.get().getWord());
	}
	@Test
	public void whenWordIsFoundBySearchingVerticallyUpwardReturnTheFirstRowPositionOfThatWordOnTheGrid() {
		assertEquals(9,reverseVerticleWord.get().getFirstRowLetterLocation());
	}
	@Test
	public void whenWordIsFoundBySearchingVerticallyUpwardReturnTheLastRowPositionOfThatWordOnTheGrid() {
		assertEquals(6,reverseVerticleWord.get().getLastRowLetterLocation());
	}
	@Test
	public void whenWordIsFoundBySearchingVerticallyUpwardReturnTheColumnPositionOfThatWordOnTheGrid() {
		assertEquals(5,reverseVerticleWord.get().getFirstColumnLetterLocation());		
		assertEquals(5,reverseVerticleWord.get().getLastColumnLetterLocation());

	}
	
	
}
