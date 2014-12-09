package swingGUI;

import game.MineField;

import javax.swing.JFrame;

import swingGUI.controller.MineFieldController;
import swingGUI.view.MineFieldView;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = -7212932681219676873L;
	
	private MineField mineFieldModel;
	private MineFieldView mineFieldView;
	
	@SuppressWarnings("unused")
	private MineFieldController mineFieldController;
	
	
	public MainWindow() {
		this.setTitle("MineSweeper v0.0.1");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		
		this.mineFieldModel = new MineField(10, 10);
		this.mineFieldView = new MineFieldView(10, 10);
		
		// TODO Make the controller method
		this.mineFieldModel.mine(0, 0);
		this.mineFieldModel.mine(2, 2);
		this.mineFieldModel.mine(4, 4);
		this.mineFieldModel.mine(5, 5);
		this.mineFieldModel.mine(7, 7);
		this.mineFieldModel.mine(9, 9);
		this.mineFieldModel.mine(1, 0);
		this.mineFieldModel.mine(2, 0);
		this.mineFieldModel.mine(4, 5);
		this.mineFieldModel.mine(3, 5);
		this.mineFieldModel.mine(7, 2);
		this.mineFieldModel.mine(9, 8);
		
		this.mineFieldController = new MineFieldController(mineFieldModel, mineFieldView);
		
		this.add(this.mineFieldView);
	}
}
