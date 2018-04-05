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
	public Optional<Words> wordFounHorizontally;
	public Optional<Words> wordFoundHorizonallyReverse;
	public Optional<Words> wordFoundVertically;
	public Optional<Words> wordFoundVerticallyReverse;
	public Optional<Words> wordFoundDiagonallyDescendingAboveCenterLine;
	public Optional<Words> wordFoundDiagonallyDescendingBelowCenterLine;
	public Optional<Words> wordFoundDiagonallyDescendingBackwardAboveCenterLine;
	public Optional<Words> wordFoundDiagonallyDescendingBackwardBelowCenterLine;
	public Optional<Words> wordFoundDiagonallyAscendingAboveCenterLine;
	public Optional<Words> wordFoundDiagonallyAscendingBelowCenterLine;
	public Optional<Words> wordFoundDiagonallyAscendingBackwardAboveCenterLine;
	public Optional<Words> wordFoundDiagonallyAscendingBackwardBelowCenterLine;

	@Before
	public void setUp() {
		SolvePuzzle buildPuzzle =new SolvePuzzle("puzzleOne.csv");
		buildPuzzle.search();
		puzzle =buildPuzzle.getGridPuzzle();
		words = buildPuzzle.getWordsNeededSearch();
		heuristic = new Heuristic();

		Words descendingBelowCenterLineWord = new Words("RIGQB");
		words.add(descendingBelowCenterLineWord);
		Words descendingBackwardBelowCenterLineWord = new Words("PFPHI");
		words.add(descendingBackwardBelowCenterLineWord);
		
		Words ascendingAboveCenterWord = new Words("OPZI");
		words.add(ascendingAboveCenterWord);
		
		Words ascendingBelowCenterWord = new Words("JEMUP");
		words.add(ascendingBelowCenterWord);
		

		Words ascendingBackwordBelowCenterWord = new Words("PUMEJ");
		words.add(ascendingBackwordBelowCenterWord);
		
		wordFoundList = heuristic.solvePuzzle(words, puzzle);
		wordFounHorizontally = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("SCOTTY") && word.isFound()).findFirst();
		wordFoundHorizonallyReverse = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("KIRK") && word.isFound()).findFirst();
		wordFoundVertically = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("BONES") && word.isFound()).findFirst();
		wordFoundVerticallyReverse = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("KHAN") && word.isFound()).findFirst();
		wordFoundDiagonallyDescendingAboveCenterLine = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("SPOCK") && word.isFound()).findFirst();
		wordFoundDiagonallyDescendingBelowCenterLine = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("RIGQB") && word.isFound()).findFirst();
		wordFoundDiagonallyDescendingBackwardBelowCenterLine = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("SULU") && word.isFound()).findFirst();
		wordFoundDiagonallyDescendingBackwardAboveCenterLine = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("PFPHI") && word.isFound()).findFirst();
		wordFoundDiagonallyAscendingAboveCenterLine = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("OPZI") && word.isFound()).findFirst();
		wordFoundDiagonallyAscendingBelowCenterLine = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("JEMUP") && word.isFound()).findFirst();
		wordFoundDiagonallyAscendingBackwardAboveCenterLine = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("UHURA") && word.isFound()).findFirst();
		wordFoundDiagonallyAscendingBackwardBelowCenterLine  = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("PUMEJ") && word.isFound()).findFirst();


		
	}
	//Center line is a diagonally line from bottom left corner of the grid to top right corner
	
	@Test
	public void whenSearchingDiagonallyAscendingBackwardAboveCenterLineAWordShouldBeFound() {
		assertEquals("UHURA",wordFoundDiagonallyAscendingBackwardAboveCenterLine.get().getWord());
	}
	
	@Test
	public void whenSearchingDiagonallyAscendingBackwardBelowCenterLineAWordShouldBeFound() {
		assertEquals("PUMEJ",wordFoundDiagonallyAscendingBackwardBelowCenterLine.get().getWord());
	}
	@Test
	public void whenSearchingDiagonallyAscendingAboveCenterLineAWordShouldBeFound() {
		assertEquals("OPZI",wordFoundDiagonallyAscendingAboveCenterLine.get().getWord());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyAscendingAboveCenterLineReturnTheFirstLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(4, wordFoundDiagonallyAscendingAboveCenterLine.get().getFirstLetterColumnPosition());
	}
	
	@Test
	public void whenWordIsFoundBySearchingDiagonallyAscendingAboveCenterLineReturnTheLastLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(7, wordFoundDiagonallyAscendingAboveCenterLine.get().getLastLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyAscendingAboveCenterLineReturnTheFirstLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(3, wordFoundDiagonallyAscendingAboveCenterLine.get().getFirstLetterRowPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyAscendingAboveCenterLineReturnTheLastLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(0, wordFoundDiagonallyAscendingAboveCenterLine.get().getLastLetterRowPosition());
	}
	
	@Test
	public void whenSearchingDiagonallyAscendingBelowCenterLineAWordShouldBeFound() {
		assertEquals("JEMUP",wordFoundDiagonallyAscendingBelowCenterLine.get().getWord());
	}
	
	@Test
	public void whenWordIsFoundBySearchingDiagonallyAscendingBelowCenterLineReturnTheFirstLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(7, wordFoundDiagonallyAscendingBelowCenterLine.get().getFirstLetterColumnPosition());
	}
	
	@Test
	public void whenWordIsFoundBySearchingDiagonallyAscendingBelowCenterLineReturnTheLastLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(11, wordFoundDiagonallyAscendingBelowCenterLine.get().getLastLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyAscendingBelowCenterLineReturnTheFirstLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(9, wordFoundDiagonallyAscendingBelowCenterLine.get().getFirstLetterRowPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyAscendingBelowenterLineReturnTheLastLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(5, wordFoundDiagonallyAscendingBelowCenterLine.get().getLastLetterRowPosition());
	}
	


	@Test
	public void whenSearchingDiagonallyDescendingBackwardAboveCenterLineAWordShouldBeFound() {
		assertEquals("PFPHI",wordFoundDiagonallyDescendingBackwardAboveCenterLine.get().getWord());
	}
	
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBackwardAboveCenterLineReturnTheFirstLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(13, wordFoundDiagonallyDescendingBackwardAboveCenterLine.get().getFirstLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBackwardAboveCenterLineReturnTheLastLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(9, wordFoundDiagonallyDescendingBackwardAboveCenterLine.get().getLastLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBackwardAboveCenterLineReturnTheFirstLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(7, wordFoundDiagonallyDescendingBackwardAboveCenterLine.get().getFirstLetterRowPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBackwardAboveCenterLineReturnTheLastLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(3, wordFoundDiagonallyDescendingBackwardAboveCenterLine.get().getLastLetterRowPosition());
	}
	@Test
	public void whenSearchingDiagonallyDescendingBackwardOnOrBelowCenterLineAWordShouldBeFound() {
		assertEquals("SULU",wordFoundDiagonallyDescendingBackwardBelowCenterLine.get().getWord());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBackwardOnOrBelowCenterLineReturnTheFirstLetterColumnPositionOfThatWordOnTheGrid(){
		assertEquals(3,wordFoundDiagonallyDescendingBackwardBelowCenterLine.get().getFirstLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBackwardOnOrBelowCenterLineReturnTheLastLetterColumnPositionOfThatWordOnTheGrid(){
		assertEquals(0,wordFoundDiagonallyDescendingBackwardBelowCenterLine.get().getLastLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBackwardOnOrBelowCenterLineReturnTheFirstLetterRowPositionOfThatWordOnTheGrid(){
		assertEquals(3,wordFoundDiagonallyDescendingBackwardBelowCenterLine.get().getFirstLetterRowPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBackwardOnOrBelowCenterLineReturnTheLastLetterRowPositionOfThatWordOnTheGrid(){
		assertEquals(0,wordFoundDiagonallyDescendingBackwardBelowCenterLine.get().getLastLetterRowPosition());
	}
	
	@Test
	public void whenSearchingDiagonallyDescendingBelowCenterLineAWordShouldBeFound() {
		assertEquals("RIGQB",wordFoundDiagonallyDescendingBelowCenterLine.get().getWord());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBelowCenterLineReturnTheFirstLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(2,wordFoundDiagonallyDescendingBelowCenterLine.get().getFirstLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBelowCenterLineReturnTheLastLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(6,wordFoundDiagonallyDescendingBelowCenterLine.get().getLastLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBelowCenterLineReturnTheFirstRowLetterPositionOfThatWordOnTheGrid() {
		assertEquals(7,wordFoundDiagonallyDescendingBelowCenterLine.get().getFirstLetterRowPosition());
	}
	
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingBelowCenterLineReturnTheLastRowLetterPositionOfThatWordOnTheGrid() {
		assertEquals(11,wordFoundDiagonallyDescendingBelowCenterLine.get().getLastLetterRowPosition());
	}
	
	@Test
	public void whenSearchingDiagonallyDescendingOnOrAboveCenterLineAWordShouldBeFound() {
		assertEquals("SPOCK",wordFoundDiagonallyDescendingAboveCenterLine.get().getWord());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingOnOrAboveCenterLineTheFirstLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(2,wordFoundDiagonallyDescendingAboveCenterLine.get().getFirstLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingOnOrAboveCenterLineReturnTheLastLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(6,wordFoundDiagonallyDescendingAboveCenterLine.get().getLastLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundDiagonallyDescendingOnOrAboveCenterLineReturnTheFirstLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(1,wordFoundDiagonallyDescendingAboveCenterLine.get().getFirstLetterRowPosition());
	}
	
	@Test
	public void whenWordIsFoundBySearchingDiagonallyDescendingOnOrAboveCenterLineReturnTheLastLertterRowPositionOfThatWordOnTheGrid() {
		assertEquals(5,wordFoundDiagonallyDescendingAboveCenterLine.get().getLastLetterRowPosition());
	}

	@Test
	public void whenSearchingHorizontallyAWordShouldBeFound() {
		assertEquals("SCOTTY",wordFounHorizontally.get().getWord());
	}
	
	@Test
	public void whenWordIsFoundBySearchingHorizontallyReturnTheRowPositionOfThatWordOnTheGrid() {
		assertEquals(5,wordFounHorizontally.get().getFirstLetterRowPosition());
		assertEquals(5,wordFounHorizontally.get().getLastLetterRowPosition());

	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyReturnTheFirstLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(0,wordFounHorizontally.get().getFirstLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyReturnTheLastLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(5,wordFounHorizontally.get().getLastLetterColumnPosition());
	}

	@Test
	public void whenSearchingHorizontallyBackwardAWordShouldBeFound() {
		assertEquals("KIRK",wordFoundHorizonallyReverse.get().getWord());
	}
	
	@Test
	public void whenWordIsFoundBySearchingHorizontallyBackwardReturnTheRowPositionOfThatWordOnTheGrid() {
		assertEquals(7,wordFoundHorizonallyReverse.get().getFirstLetterRowPosition());
		assertEquals(7,wordFoundHorizonallyReverse.get().getLastLetterRowPosition());

	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyBackwordReturnTheFirstLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(4,wordFoundHorizonallyReverse.get().getFirstLetterColumnPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyBackWardReturnTheLastLetterColumnPositionOfThatWordOnTheGrid() {
		assertEquals(1,wordFoundHorizonallyReverse.get().getLastLetterColumnPosition());
	}
	
	@Test
	public void whenSearchingVerticallAWordShouldBeFound() {
		assertEquals("BONES",wordFoundVertically.get().getWord());
	}
	

	@Test
	public void whenWordIsFoundBySearchingVerticallyReturnTheFirstLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(6,wordFoundVertically.get().getFirstLetterRowPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingVerticallyReturnTheLastLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(10,wordFoundVertically.get().getLastLetterRowPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingVerticallyReturnThColumnPositionOfThatWordOnTheGrid() {
		assertEquals(0,wordFoundVertically.get().getFirstLetterColumnPosition());		
		assertEquals(0,wordFoundVertically.get().getLastLetterColumnPosition());

	}
	
	@Test
	public void whenSearchingVerticallyAWordShouldFoud() {
		assertEquals("KHAN",wordFoundVerticallyReverse.get().getWord());
	}
	@Test
	public void whenWordIsFoundBySearchingVerticallyUpwardReturnTheFirstLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(9,wordFoundVerticallyReverse.get().getFirstLetterRowPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingVerticallyUpwardReturnTheLastLetterRowPositionOfThatWordOnTheGrid() {
		assertEquals(6,wordFoundVerticallyReverse.get().getLastLetterRowPosition());
	}
	@Test
	public void whenWordIsFoundBySearchingVerticallyUpwardReturnTheColumnLteerPositionOfThatWordOnTheGrid() {
		assertEquals(5,wordFoundVerticallyReverse.get().getFirstLetterColumnPosition());		
		assertEquals(5,wordFoundVerticallyReverse.get().getLastLetterColumnPosition());

	}
	
	
}
