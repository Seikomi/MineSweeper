package game;

import java.util.Random;

public class RandomMineField extends MineField {

	public RandomMineField(int rows, int columns, int numberOfMine) {
		super(rows, columns);
		
		generateRandomMines(numberOfMine);
	}

	private void generateRandomMines(int numberOfMine) {
		Random randomNumberGenerator = new Random();
		
		int randomXPosition, randomYPosition;
		for (int i = 0; i < numberOfMine; i++) {
			do {
				randomXPosition = randomNumberGenerator.nextInt(this.getRows());
				randomYPosition = randomNumberGenerator.nextInt(this.getColumns());
			} while (this.hasMine(randomXPosition, randomYPosition));
				
			
			this.mine(randomXPosition, randomYPosition);
		}
	}

}
