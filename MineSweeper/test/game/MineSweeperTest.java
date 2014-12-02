package game;
import static org.junit.Assert.*;
import game.MineField;
import game.MineSweeper;

import java.awt.Point;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MineSweeperTest {
	private MineSweeper jeu;
	
	private ArrayList<Point> listePositionsMines;
	private ArrayList<Point> listePositionsMines2;
	
	@Before
	public void setUp() throws Exception {
		this.listePositionsMines = new ArrayList<>(); // 
		this.listePositionsMines.add(new Point(0,0)); // 
		this.listePositionsMines.add(new Point(0,4)); // Correspond to design:
		this.listePositionsMines.add(new Point(1,0)); // * . . . *            
		this.listePositionsMines.add(new Point(1,1)); // * * . * .            
		this.listePositionsMines.add(new Point(1,3)); // . . . . .            
		this.listePositionsMines.add(new Point(3,1)); // . * . * *            
		this.listePositionsMines.add(new Point(3,3)); //
		this.listePositionsMines.add(new Point(3,4)); //
		
		this.listePositionsMines2 = new ArrayList<>(); // 
		this.listePositionsMines2.add(new Point(0,1)); // Correspond to design:
		this.listePositionsMines2.add(new Point(1,0)); // . * .                
		this.listePositionsMines2.add(new Point(1,2)); // * . *                
		this.listePositionsMines2.add(new Point(2,1)); // . * .                           

	}

	@After
	public void tearDown() throws Exception {
		this.jeu = null;
	}

	private void testDesign(ArrayList<Point> design, MineField c) { 
		for(int i = 0; i < c.getRows(); i++) {
			for (int j = 0; j < c.getColumns(); j++) {
				if (design.contains(new Point(i, j))) {
					assertEquals("Fail ligne " + i + "colonne " + j,
							true, c.hasMine(i, j));
				}
				else {
					assertEquals("Fail ligne " + i + "colonne " + j,
							false, c.hasMine(i, j));
				}
			}
		}

	}
	
	@Test
	public void testCreationPlusieurChampMine_Entree() throws Exception {
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
		
		this.jeu = new MineSweeper(entree);
		
		MineField c1 = this.jeu.getChampMines(1);
		assertEquals(4, c1.getRows());
		assertEquals(5, c1.getColumns());
		testDesign(this.listePositionsMines, c1);
		
		MineField c2 = this.jeu.getChampMines(2);
		assertEquals(3, c2.getRows());
		assertEquals(3, c2.getColumns());
		testDesign(this.listePositionsMines2, c2);
		
	}

}
