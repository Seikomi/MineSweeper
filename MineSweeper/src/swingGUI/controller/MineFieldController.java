package swingGUI.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import swingGUI.view.MineFieldView;
import game.MineField;

public class MineFieldController {
	private MineField mineFieldModel;
	private MineFieldView mineFieldView;
	
	public MineFieldController(MineField mineFieldModel, MineFieldView mineFieldView) {
		this.mineFieldModel = mineFieldModel;
		this.mineFieldView = mineFieldView;
		
		this.mineFieldView.addMineFieldListener(new MineFieldListenner());
		
	}
	
	public class MineFieldListenner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			int x = Character.getNumericValue(((JButton) arg0.getSource()).getActionCommand().charAt(0));
			int y = Character.getNumericValue(((JButton) arg0.getSource()).getActionCommand().charAt(1));
			
			String mineIndicatorLabel;
			if (mineFieldModel.hasMine(x, y))
			{
				mineIndicatorLabel = "*";
			} else {
				mineIndicatorLabel = Integer.toString(mineFieldModel.getMineIndicator(x, y));
			}
			
			mineFieldView.changeJButtonToJLabel(x, y, mineIndicatorLabel );
			
		}
		
	}
	
}
