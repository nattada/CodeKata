package practice.codekata.wordsearch;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class HeuristicTest {
	public Grid puzzle;
	public List<Words> words;
	@Before
	public void setUp() {
		SolvePuzzle buildPuzzle =new SolvePuzzle("puzzleOne.csv");
		buildPuzzle.search();
		puzzle =buildPuzzle.getGridPuzzle();
		words = buildPuzzle.getWordsNeededSearch();
		
		
	}
	@Test
	public void whenSearchingHorizontallyWordOnTheXAxisFoundIfItExist() {

		Heuristic heuristic = new Heuristic();
		List<Words> wordFoundList = heuristic.solvePuzzle(words, puzzle);
		Optional<Words> wordFound = wordFoundList.stream().filter(word -> word.getWord().equalsIgnoreCase("SCOTTY")).findAny();
		assertEquals("SCOTTY",wordFound.get().getWord());
	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyReturnTheRowPositionOfThatWordOnTheGrid() {

		Heuristic heuristic = new Heuristic();
		Optional<Words> wordFound = heuristic.solvePuzzle(words, puzzle).stream().filter(word -> word.getWord().equalsIgnoreCase("SCOTTY")).findFirst();
		assertEquals(5,wordFound.get().getRowLetterLocation());
	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyReturnTheFirstColumnPositionOfThatWordOnTheGrid() {

		Heuristic heuristic = new Heuristic();
		Optional<Words> wordFound = heuristic.solvePuzzle(words, puzzle).stream().filter(word -> word.getWord().equalsIgnoreCase("SCOTTY")).findFirst();
		assertEquals(0,wordFound.get().getFistColumnLetterLocation());
	}
	@Test
	public void whenWordIsFoundBySearchingHorizontallyReturnTheLastColumnPositionOfThatWordOnTheGrid() {

		Heuristic heuristic = new Heuristic();
		Optional<Words> wordFound = heuristic.solvePuzzle(words, puzzle).stream().filter(word -> word.getWord().equalsIgnoreCase("SCOTTY")).findFirst();
		assertEquals(5,wordFound.get().getLastColumnLetterLocation());
	}
}
