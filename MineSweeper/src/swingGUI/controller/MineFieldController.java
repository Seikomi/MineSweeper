package swingGUI.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

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
	
	
	public class MineFieldListenner extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent event) {
			super.mouseClicked(event);
			
			String[] tokens = ((JButton) event.getSource()).getActionCommand().split(" ");
			int x = Integer.parseInt(tokens[0]);
			int y = Integer.parseInt(tokens[1]);
			
			if ((event.getModifiers() & InputEvent.BUTTON1_MASK) != 0) {
				try {
					showCase(x, y);
				} catch (Exception exception) {
					exception.printStackTrace();
				}
			}
			else if ((event.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
				if (mineFieldView.hasJButton(x, y)) {
					if (mineFieldView.hasFlag(x, y)) {
						mineFieldView.removeFlag(x ,y);
					} else {
						mineFieldView.setFlag(x ,y);
					}
				}
			}
		}
		
		
		private void showCase(int x, int y) throws Exception {
			if (caseInView(x, y) && mineFieldView.hasJButton(x, y))
			{
				if (mineFieldModel.hasMine(x, y)) {
					mineFieldView.changeJButtonToJLabel(x, y, "*");
					JOptionPane.showMessageDialog(mineFieldView, "BOUM !!!");
				} else {
					int mineIndicator = mineFieldModel.getMineIndicator(x , y);
					if (mineIndicator > 0) {
						String mineIndicatorLabel = Integer.toString(mineIndicator);
						mineFieldView.changeJButtonToJLabel(x, y, mineIndicatorLabel);
					} else {
						mineFieldView.changeJButtonToJLabel(x, y, "0");
						exploreCaseAround(x, y);
					}
				}
			}
		}
		
		
		private void exploreCaseAround(int x, int y) throws Exception {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					showCase(x + i, y + j);
				}
			}
		}
		
		
		private boolean caseInView(int x, int y) {
			return x >= 0 && y >= 0 && x < mineFieldView.getRows() && y < mineFieldView.getColumns();
		}
		
	}
}
