package swingGUI.view;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import javax.swing.JButton;
import javax.swing.JLabel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MineFieldViewTest {
	private MineFieldView windowView;
	
	@Before
	public void setUp() throws Exception {
		this.windowView = new MineFieldView(10,10);
	}

	@After
	public void tearDown() throws Exception {
		this.windowView = null;
	}
	
	@Test
	public void testCreate() {
		assertEquals(10, this.windowView.getRows());
		assertEquals(10, this.windowView.getColumns());
	}

	@Test
	public void testChangeJLabelToJButton() throws Exception {
		this.windowView.changeJButtonToJLabel(5, 5, "test OK");
		assertEquals(true, this.windowView.hasJLabel(5, 5));
		assertEquals("test OK", ((JLabel) this.windowView.getComponent(5 * 10 + 5) ).getText());
	}
	
	@Test
	public void testChangeJlabelToJButton_Exception() {
		try {
			testChangeJLabelToJButton();
			this.windowView.changeJButtonToJLabel(5, 5, "test OK");
			fail();
		} catch (Exception e) {
			assertEquals("Object Type error : this methode attempt a JButton to this location",
					e.getMessage());
		}
		
	}
	
	
	@Test
	public void testSetFlagsToJButton() {
		this.windowView.setFlag(5, 5);
		assertEquals("F", ((JButton) this.windowView.getComponent(5 * 10 + 5) ).getText());
		assertEquals(true, this.windowView.hasFlag(5, 5));
	}
	
	@Test
	public void testRemoveFlagsToJButton() {
		testSetFlagsToJButton();
		this.windowView.removeFlag(5, 5);
		assertEquals(null, ((JButton) this.windowView.getComponent(5 * 10 + 5) ).getText());
		assertEquals(false, this.windowView.hasFlag(5, 5));
	}

}
