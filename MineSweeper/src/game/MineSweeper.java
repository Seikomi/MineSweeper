package game;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class MineSweeper {
	private List<MineField> mineFieldList;
	
	public MineSweeper(String input) throws InputMismatchException {
		this.mineFieldList = new ArrayList<>();
		try {
			executeInput(input);
		} catch (InputMismatchException e) {
			this.mineFieldList.clear();
			throw e;
		}
	}
	
	private void executeInput(String input) throws InputMismatchException {
		Scanner sc = new Scanner(input);
		 
		boolean endOfInput = false;
		while (!endOfInput) {
			int rowsCount = sc.nextInt();
			int columnCount = sc.nextInt();
			
			if(rowsCount == 0 && columnCount == 0) {
				endOfInput = true;
			}
			else {
				MineField newMineField = new MineField(rowsCount, columnCount);	
				addMines(sc, newMineField);
				this.mineFieldList.add(newMineField);	
			}
		}
		
		sc.close();
	}

	public MineField getChampMines(int numero) {
		return this.mineFieldList.get(numero - 1);
	}

	private void addMines(Scanner sc, MineField mineFieldToChange) throws InputMismatchException {
		for(int i = 0; i < mineFieldToChange.getRows(); i++) { 
			for (int j = 0; j < mineFieldToChange.getColumns(); j++) {
				String symbol = sc.next("[*.]");
				if (symbol.equals("*")) {
					mineFieldToChange.mine(i, j);
				}
			}
		}
	}

	@Override
	public String toString() {
		String description = "";
		if (!this.mineFieldList.isEmpty()) {
			int i = 1;
			for (MineField c : this.mineFieldList) {
				description += "Field#" + i + ":\n";
				description += c.toString();
				i++;
			}
		}
		else {
			description = "Aucuns champs de mine";
		}
		
		return description;
	}

}
