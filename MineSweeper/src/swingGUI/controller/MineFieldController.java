package swingGUI.controller;

import swingGUI.view.MineFieldView;
import game.MineField;

public class MineFieldController {
	private MineField mineFieldModel;
	private MineFieldView mineFieldView;
	
	public MineFieldController(MineField mineFieldModel, MineFieldView mineFieldView) {
		this.mineFieldModel = mineFieldModel;
		this.mineFieldView = mineFieldView;
		
		updateView();
	}
	
	// TODO Refactoring
	private void updateView() {
		for (int i = 0; i < mineFieldView.getRows(); i++) {
			for (int j = 0; j < mineFieldView.getColumns(); j++) {
				if (mineFieldModel.hasMine(i, j)) {
					mineFieldView.setCaseLabel(i, j, "*");
				} else {
					mineFieldView.setCaseLabel(i, j, String.valueOf(mineFieldModel.getMineIndicator(i, j)));
				}
			}	
		}
	}
	
	
}
