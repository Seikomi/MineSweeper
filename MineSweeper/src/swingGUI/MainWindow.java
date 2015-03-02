package swingGUI;

import game.MineField;
import game.RandomMineField;

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
		
		this.mineFieldModel = new RandomMineField(10, 10, 10);
		this.mineFieldView = new MineFieldView(10, 10);
		
		System.out.println(this.mineFieldModel);
		
		this.mineFieldController = new MineFieldController(mineFieldModel, mineFieldView);
		
		this.add(this.mineFieldView);
	}
}
