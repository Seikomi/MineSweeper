package game;

import static org.junit.Assert.assertNotSame;
import game.RandomMineField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomMineFieldTest {
	private RandomMineField champMines;
	private RandomMineField champMines2;
	private RandomMineField champMines3;
	private RandomMineField champMines4;
	private RandomMineField champMines5;

	@Before
	public void setUp() throws Exception {
		this.champMines = new RandomMineField(4, 4, 5);
		this.champMines2 = new RandomMineField(4, 4, 5);
		this.champMines3 = new RandomMineField(4, 4, 5);
		this.champMines4 = new RandomMineField(4, 4, 5);
		this.champMines5 = new RandomMineField(4, 4, 5);
	}

	@After
	public void tearDown() throws Exception {
			this.champMines = null;
			this.champMines2 = null;
			this.champMines3 = null;
			this.champMines4 = null;
			this.champMines5 = null;
	}
	
	@Test
	public void testRandomMinefield() {
		assertNotSame(this.champMines.toString(), this.champMines2.toString());
		assertNotSame(this.champMines2.toString(), this.champMines3.toString());
		assertNotSame(this.champMines3.toString(), this.champMines4.toString());
		assertNotSame(this.champMines4.toString(), this.champMines5.toString());
		assertNotSame(this.champMines5.toString(), this.champMines.toString());
	}

}
