package swingGUI.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MineFieldView extends JPanel {
	private static final long serialVersionUID = -8823017965021678697L;

	private JComponent[][] jComponentTab;
	
	private boolean[][] flagsTab;
	
	private final int rows;
	private final int columns;
	
	
	public MineFieldView(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		
		setLayout(new GridLayout(rows, columns));
		
		initializeJComponentTabWithJButton(rows, columns);
	}

	
	private void initializeJComponentTabWithJButton(int rows, int columns) {
		jComponentTab = new JComponent[rows][columns];
		for (int i = 0; i < jComponentTab.length; i++) {
			for (int j = 0; j < jComponentTab[i].length; j++) {
				jComponentTab[i][j] = new JButton();
				((JButton) jComponentTab[i][j]).setActionCommand(i + " " + j);
				add(jComponentTab[i][j]);
			}
		}
		
		this.flagsTab = new boolean[rows][columns];
	}
	
	
	public void changeJButtonToJLabel(int rowIndex, int columnIndex, String label) throws Exception {
		if (this.hasJButton(rowIndex, columnIndex)) {
			int position = getPositionInContainer(rowIndex, columnIndex);
			
			remove(position);
			
			jComponentTab[rowIndex][columnIndex] = new JLabel(label, JLabel.CENTER);
			add(this.jComponentTab[rowIndex][columnIndex], position);
			
			validate();
		} else {
			throw new Exception("Object Type error : this methode attempt a JButton to the location");
		}

	}
	
	
	public void addMineFieldListener(MouseListener listenerForMineFieldButton) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if(this.hasJButton(i, j)) {
					((JButton) jComponentTab[i][j]).addMouseListener(listenerForMineFieldButton);;
				}
			}
		}
	}
	
	
	public boolean hasJButton(int rowIndex, int columnIndex) {
		return jComponentTab[rowIndex][columnIndex] instanceof JButton;
	}
	
	
	public boolean hasJLabel(int rowIndex, int columnIndex) {
		return jComponentTab[rowIndex][columnIndex] instanceof JLabel;
	}
	
	
	public int getRows() {
		return rows;
	}

	
	public int getColumns() {
		return columns;
	}


	public void setFlag(int rowIndex, int columnIndex) {
		((JButton) this.jComponentTab[rowIndex][columnIndex]).setText("F");
		
		this.flagsTab[rowIndex][columnIndex] = true;
		
	}


	private int getPositionInContainer(int rowIndex, int columnIndex) {
		return rowIndex * this.columns + columnIndex;
	}


	public void removeFlag(int rowIndex, int columnIndex) {
		((JButton) this.jComponentTab[rowIndex][columnIndex]).setText("");
		
		this.flagsTab[rowIndex][columnIndex] = false;
		
	}


	public boolean hasFlag(int rowIndex, int columnIndex) {
		return this.flagsTab[rowIndex][columnIndex];
	}
	
}
