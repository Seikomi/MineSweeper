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
	
	/* TODO refactor */
	public class MineFieldListenner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String[] tokens = ((JButton) arg0.getSource()).getActionCommand().split(" ");
			int x = Integer.parseInt(tokens[0]);
			int y = Integer.parseInt(tokens[1]);
			
			try {
				showCase(x, y);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
		
		private void showCase(int x, int y) throws Exception {
			if (mineFieldModel.hasMine(x, y)) {
				mineFieldView.changeJButtonToJLabel(x, y, "*");
			} else {
				int mineIndicator = mineFieldModel.getMineIndicator(x , y);
				if (mineIndicator < 0) {
					mineFieldView.changeJButtonToJLabel(x, y, Integer.toString(mineIndicator));
				} else {
					mineFieldView.changeJButtonToJLabel(x, y, "0");
					exploreCaseAround(x, y);
				}
			}
		}
		
		private void exploreCaseAround(int x, int y) throws Exception {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					int caseX = x + i;
					int caseY = y + j;
					if (caseInView(caseX, caseY) && mineFieldView.hasJButton(caseX, caseY))
					{	
						int mineIndicator = mineFieldModel.getMineIndicator(caseX, caseY);
						if (mineFieldView.hasJButton(caseX, caseY)) {
							if (mineIndicator == 0) {
									mineFieldView.changeJButtonToJLabel(caseX, caseY, "0");
									exploreCaseAround(caseX, caseY);
							} else {
								String mineIndicatorLabel = Integer.toString(mineIndicator);						
								mineFieldView.changeJButtonToJLabel(caseX, caseY, mineIndicatorLabel );
							}
						}
					}
					
				}
			}
		}
		
		private boolean caseInView(int x, int y) {
			return x >= 0 && y >= 0 && x < mineFieldView.getRows() && y < mineFieldView.getColumns();
		}
		
	}
	
	
	
}
