package swingGUI.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MineFieldView extends JPanel {
	private static final long serialVersionUID = 1L;

	private JComponent[][] jComponentTab;
	
	private final int rows;
	private final int columns;
	
	public MineFieldView(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		this.setLayout(new GridLayout(rows, columns));
		
		this.jComponentTab = new JComponent[rows][columns];
		for (int i = 0; i < jComponentTab.length; i++) {
			for (int j = 0; j < jComponentTab[i].length; j++) {
				this.jComponentTab[i][j] = new JButton();
				((JButton) this.jComponentTab[i][j]).setActionCommand("" + i + j);  //TODO Refactor for i and j > 9
				this.add(this.jComponentTab[i][j]);
			}
		}
	}
	
	public void changeJButtonToJLabel(int row, int column, String label) {
		// TODO remove action listener and type exception
		this.remove(row * this.columns + column);
		this.jComponentTab[row][column] = new JLabel(label, JLabel.CENTER);
		this.add(this.jComponentTab[row][column], row * this.columns + column);
		
		this.validate();
		this.repaint();

	}
	
	public void addMineFieldListener(ActionListener listenerForMineFieldButton) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(this.jComponentTab[i][j] instanceof JButton) {
					((JButton) this.jComponentTab[i][j]).addActionListener(listenerForMineFieldButton);;
				}
			}
		}
	}
	
	
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
}
