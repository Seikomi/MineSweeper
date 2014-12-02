package swingGUI.view;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MineFieldView extends JPanel {
	private static final long serialVersionUID = 1L;

	private JLabel[][] casesJLabelTab;
	
	private final int rows;
	private final int columns;
	
	public MineFieldView(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		this.setLayout(new GridLayout(rows, columns));
		
		// TODO Refactoring
		this.casesJLabelTab = new JLabel[rows][columns];
		for (int i = 0; i < this.casesJLabelTab.length; i++) {
			for (int j = 0; j < this.casesJLabelTab[i].length; j++) {
				this.casesJLabelTab[i][j] = new JLabel("");
				this.add(this.casesJLabelTab[i][j]);
			}
		}
	}
	
	public void setCaseLabel(int row, int column, String label) {
		this.casesJLabelTab[row][column].setText(label);
	}
	
	public String getCaseLabel(int row, int column) {
		return this.casesJLabelTab[row][column].getText();
	}
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
}
