package minesweeperGame;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Minesweeper {
	Random rand = new Random(10);

	private final int gridSize = 10;
	private final int numBombs = 10;
	private GridCell[][] grid;
	private Set<Integer> bombSet; // Contains random numbers that are used to plant bombs
	private boolean debug; // If true, shows bombs without hiding

	private int[] xNeigh = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
	private int[] yNeigh = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };

	public Minesweeper() {
		bombSet = new HashSet<>();
		grid = new GridCell[gridSize][gridSize];
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				grid[i][j] = new GridCell();
			}
		}
	}

	public void generateGame() {
		// For each bomb generated, update set and grid
		int currBomb = 0;
		while (currBomb <= numBombs) {
			int randLocation = rand.nextInt(gridSize * gridSize);
			int[] bombLoc = getCorrdinates(randLocation);
			int bombXCord = bombLoc[0];
			int bombYCord = bombLoc[1];

			// No duplicate bombing allowed
			if (bombSet.contains(randLocation))
				continue;

			bombSet.add(randLocation);
			grid[bombXCord][bombYCord].setBomb();
			currBomb++;

			// Update neighboring cells
			for (int i = 0; i < xNeigh.length; i++) {
				int x = bombXCord + xNeigh[i];
				int y = bombYCord + yNeigh[i];
				if (isSafe(x, y) && !grid[x][y].isBomb()) {
					grid[bombXCord + xNeigh[i]][bombYCord + yNeigh[i]].incrementVal();

				}
			}
		}
		printGrid();
	}

	// When user makes a move
	public void click(int x, int y) {
		if (grid[x][y].isOpen()) {
			System.out.println("This cell is already opened. Try different one");
			return;
		}
		clickHelper(x, y);
		System.out.println("Clicked on (" + x + "," + y + ")");
		printGrid();
	}

	// Makes recursive call to itself during BFS
	private void clickHelper(int x, int y) {
		if (isSafe(x, y) && !grid[x][y].isFlagged() && !grid[x][y].isOpen()) {
			if (grid[x][y].isBomb())
				gameOver(x, y);
			else if (grid[x][y].getVal() > 0) {
				grid[x][y].open();
			} else if (grid[x][y].getVal() != -1) {
				grid[x][y].open();
				clickHelper(x + 1, y);
				clickHelper(x - 1, y);
				clickHelper(x, y + 1);
				clickHelper(x, y - 1);
			}
		}
	}

	// User sets flag on a cell
	public void setFlag(int x, int y) {
		if (grid[x][y].isOpen()) {
			System.out.println("Cannot set flag as this cell is already opened. Try different one");
			return;
		}
		if (isSafe(x, y) && !grid[x][y].isOpen()) {
			if (!grid[x][y].isFlagged())
				grid[x][y].setFlagged();
			else
				alreadyFlagged(x, y);
		}
		System.out.println("Flagged (" + x + "," + y + ")");
		printGrid();
	}

	// Opens up bomb locations, used when game is over
	private void openAllBombs() {
		for (int bombLoc : bombSet) {
			int[] coords = getCorrdinates(bombLoc);
			grid[coords[0]][coords[1]].setOpen();
		}
	}

	// Get coordinates from random number generated
	private int[] getCorrdinates(int randNum) {
		int[] coords = new int[2];
		coords[0] = randNum / gridSize == 0 ? 0 : randNum / gridSize - 1;
		coords[1] = randNum % gridSize == 0 ? 0 : randNum % gridSize - 1;
		return coords;
	}

	// Prints the grid to the player
	public void printGrid() {
		StringBuilder gridPrint = new StringBuilder();

		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (grid[i][j].isFlagged() && !grid[i][j].isOpen())
					gridPrint.append("X");
				else if (!grid[i][j].isOpen()) {
					gridPrint.append(debug == true ? grid[i][j].getVal() : "O");
				} else if (grid[i][j].isBomb()) {
					gridPrint.append("Bomb");
				} else {
					gridPrint.append(grid[i][j].getVal() == 0 ? " " : grid[i][j].getVal());
				}
				gridPrint.append("	");
			}
			gridPrint.append("\n");
		}
		System.out.println(gridPrint.toString());
		System.out.println("-------------");
	}

	// Utility methods
	private void gameOver(int x, int y) {
		System.out.println("(" + x + "," + y + ") Stepped on the bomb!!! Game Over");
		openAllBombs();
		printGrid();
		System.exit(0);
	}

	private void alreadyFlagged(int x, int y) {
		System.out.println("Chosen location " + x + ", " + y + " is already flagged");
	}

	// Check x and y to be in the grid
	public boolean isSafe(int x, int y) {
		return x >= 0 && x < gridSize && y >= 0 && y < gridSize;
	}

	public void setDebug(boolean val) {
		this.debug = val;
	}
}

// Grid is made up of these grid cells
class GridCell {
	private int val;
	private boolean isOpen;
	private boolean isFlagged;

	public GridCell() {
		this.val = 0;
		this.isOpen = false;
		this.isFlagged = false;
	}

	public GridCell(int val) {
		super();
		this.val = val;
	}

	public void open() {
		this.isOpen = true;
	}

	public boolean isBomb() {
		return this.val == -1;
	}

	public int getVal() {
		return val;
	}

	public void incrementVal() {
		this.val++;
	}

	public void setBomb() {
		this.val = -1;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen() {
		this.isOpen = true;
	}

	public boolean isFlagged() {
		return isFlagged;
	}

	public void setFlagged() {
		this.isFlagged = true;
	}
}
