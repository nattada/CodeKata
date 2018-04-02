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
	public Optional<Words> verticleWord;

	@Before
	public void setUp() {
		SolvePuzzle buildPuzzle =new SolvePuzzle("puzzleOne.csv");
		buildPuzzle.search();
		puzzle =buildPuzzle.getGridPuzzle();
		words = buildPuzzle.getWordsNeededSearch();
		heuristic = new Heuristic();
		wordFoundList = heuristic.solvePuzzle(words, puzzle);
		horizontalWord = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("SCOTTY")).findFirst();
		verticleWord = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("BONES")).findFirst();
		
		
	}
	@Test
	public void whenSearchingHorizontallyWordOnTheXAxisFoundIfItExists() {
		assertEquals("BONES",verticleWord.get().getWord());
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
	public void whenSearchingVerticallyWordOnTheYAxisFoundIfItExists() {
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
	
	
}
