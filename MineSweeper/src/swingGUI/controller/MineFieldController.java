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
			
			int x = Character.getNumericValue(((JButton) arg0.getSource()).getActionCommand().charAt(0));
			int y = Character.getNumericValue(((JButton) arg0.getSource()).getActionCommand().charAt(1));
			
			if (mineFieldModel.hasMine(x, y))
			{
				mineFieldView.changeJButtonToJLabel(x, y, "*");
			} else {
				int mineIndicator = mineFieldModel.getMineIndicator(x , y);
				if (mineIndicator == 0) {
					mineFieldView.changeJButtonToJLabel(x, y, "0");
					exploreCaseAround(x, y);
					
				} else {
					String mineIndicatorLabel = Integer.toString(mineIndicator);						
					mineFieldView.changeJButtonToJLabel(x, y, mineIndicatorLabel );
				}
					
			}
			
			
		}
		
		/* TODO refactor */
		private void exploreCaseAround(int x, int y) {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (i != 0 || j != 0)
					{	
						if ((x + i) > -1 && (y + j) > -1 && (x + i) < mineFieldModel.getRows() && (y + j) < mineFieldModel.getColumns()) {
							int mineIndicator = mineFieldModel.getMineIndicator(x + i, y + j);
							if (mineIndicator == 0) {
								if (mineFieldView.hasJButton(x + i, y + j)) {
									mineFieldView.changeJButtonToJLabel(x + i, y + j, "0");
									exploreCaseAround(x + i, y + j);
								}
							} else {
								String mineIndicatorLabel = Integer.toString(mineIndicator);						
								mineFieldView.changeJButtonToJLabel(x + i, y + j, mineIndicatorLabel );
							}
						}
					}
					
				}
			}
		}
		
	}
	
	
	
}
