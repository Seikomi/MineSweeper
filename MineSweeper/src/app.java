
import game.MineSweeper;

import javax.swing.JFrame;

import swingGUI.MainWindow;


public class app {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String entree = "4 5" + '\n' +
				"* . . . *" + '\n' +
				"* * . * ." + '\n' +
				". . . . ." + '\n' +
				". * . * *" + '\n' +
				"3 3" + '\n' +
				". * ." + '\n' +
				"* . *" + '\n' +
				". * ." + '\n' +
				"0 0";
		
		MineSweeper testInput = new MineSweeper(entree);

		System.out.println("GO");
		System.out.println(testInput.toString());
		
		JFrame win = new MainWindow();
		
		System.out.println(win.getContentPane());
		win.setVisible(true);
	}
}
