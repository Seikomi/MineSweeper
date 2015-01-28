package swingGUI;

import static org.junit.Assert.assertEquals;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import swingGUI.MainWindow;

public class MainWindowTest {
	private MainWindow mainWindow;

	@Before
	public void setUp() throws Exception {
		this.mainWindow = new MainWindow();
	}

	@After
	public void tearDown() throws Exception {
		this.mainWindow = null;
	}

	@Test
	public void testProprieteALaCreationMainWindow() {
		assertEquals("MineSweeper v0.0.1", this.mainWindow.getTitle());
		assertEquals(JFrame.EXIT_ON_CLOSE, this.mainWindow.getDefaultCloseOperation());
		assertEquals(new Dimension(600, 600), this.mainWindow.getSize());
	}

}
