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
		List<String> wordFoundList = heuristic.solvePuzzle(words, puzzle);
		Optional<String> wordFound = wordFoundList.stream().filter(word -> word.equalsIgnoreCase("SCOTTY")).findAny();
		assertEquals("SCOTTY",wordFound.get());
	}
}
