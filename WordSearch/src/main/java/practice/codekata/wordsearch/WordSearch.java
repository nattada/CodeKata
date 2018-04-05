package practice.codekata.wordsearch;



public class WordSearch {

	public static void main(String[] args) {
		SolvePuzzle puzzle =new SolvePuzzle("puzzleOne.csv");
		puzzle.search();
		System.out.println("Solving Second Puzzle");
		SolvePuzzle secondPuzzle =new SolvePuzzle("puzzleTwo.csv");
		secondPuzzle.search();
	}

}
