package minesweeperGame;

public class MinesweeperTest {
	public static void main(String args[]) {
		Minesweeper ms = new Minesweeper();
//		ms.setDebug(true);
		ms.generateGame();
		ms.click(2, 0);
		ms.click(0, 8);
		ms.click(0, 1);
		ms.setFlag(0, 2);
		ms.setFlag(1, 4);
		ms.click(8, 4);
		ms.click(4, 2);
	}
}
