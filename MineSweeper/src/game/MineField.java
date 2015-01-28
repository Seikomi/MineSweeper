package game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;


public class MineField {
	private static final int MAX_SIZE = 100;
	
	private List<Point> minePositionList;
	private int[][] mineIndicatorTab;
	
	final private int rows;
	final private int columns;
	
	
	public MineField(int rows, int columns) {
		if (rows > MAX_SIZE || columns > MAX_SIZE) {
			throw new ArrayIndexOutOfBoundsException("rows and columns MAX_SIZE = " + MAX_SIZE);
		} else if (rows <= 0 || columns <= 0) {
			throw new ArrayIndexOutOfBoundsException("rows and columns MIN_SIZE = 1");
		}
		this.rows = rows;
		this.columns = columns;
		this.minePositionList = new ArrayList<Point>();
		this.mineIndicatorTab = new int[rows][columns];
	}

	
	public boolean isEmpty() {		
		return this.minePositionList.isEmpty();
	}

	
	public void mine(int rowIndex, int columnIndex){
		if (miningOutOfBounds(rowIndex, columnIndex)) {			
			throw new ArrayIndexOutOfBoundsException("Mining out of bounds");
		}
		
		incrementMineIndicator(rowIndex, columnIndex);
		
		this.minePositionList.add(new Point(rowIndex, columnIndex));	
	}
	
	
	public boolean hasMine(int rowIndex, int columnIndex) {
		return this.minePositionList.contains(new Point(rowIndex, columnIndex));
	}
	
	
	public int getMineIndicator(int rowIndex, int columnIndex) {
		
		return this.mineIndicatorTab[rowIndex][columnIndex];
	}
	

	public int getRows() {
		return this.rows;
	}
	

	public int getColumns() {
		return this.columns;
	}
	
	
	@Override
	public String toString() {
		String description = "";
		for(int i = 0; i < this.rows; i++) { 
			for (int j = 0; j < this.columns; j++) {
				if (hasMine(i, j)) {
					description += "* ";
				}
				else {
					description += this.mineIndicatorTab[i][j] + " ";
				}
			}
			description += "\n";
		}
		return description;
	}

	
	private boolean miningOutOfBounds(int rowIndex, int columnIndex) {
		return (rowIndex >= this.rows || rowIndex < 0
				|| columnIndex >= this.columns || columnIndex < 0);
	}

	
	private void incrementMineIndicator(int rowIndex, int columnIndex) {
		for (int i = -1 ; i <= 1 ; i++) {
			for (int j = -1 ; j <= 1 ; j++) {
				if (!miningOutOfBounds(rowIndex + i, columnIndex + j)) {
					this.mineIndicatorTab[rowIndex + i][columnIndex + j]++;
				}
			}
		}
	}

}
