package game;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import game.MineField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MineFieldTest {
	private MineField champMines;

	@Before
	public void setUp() throws Exception {
		this.champMines = new MineField(4, 7);
	}

	@After
	public void tearDown() throws Exception {
		this.champMines = null;
	}

	@Test
	public void testChampMine4_7_EstVideALaCreation() {
		this.champMines = new MineField(4, 7);
		assertTrue(this.champMines.isEmpty());
	}
	
	@Test
	public void testCreationChampsMineSupTailleMax_envoiExeption() {
		boolean exceptionEnvoyer = false;
		try {
			this.champMines = new MineField(105, 102);
		}
		catch  (Exception e){
			exceptionEnvoyer = true;
		}
		assertTrue(exceptionEnvoyer);
	}
	
	@Test
	public void testCreationChampsMineSupTailleMax2_envoiExeption() {
		boolean exceptionEnvoyer = false;
		try {
			this.champMines = new MineField(90, 102);
		}
		catch  (Exception e){
			exceptionEnvoyer = true;
		}
		assertTrue(exceptionEnvoyer);
	}
	
	@Test
	public void testCreationChampsMineInfTailleMin_envoiExeption() {
		boolean exceptionEnvoyer = false;
		try {
			this.champMines = new MineField(-2, 8);
		}
		catch  (Exception e){
			exceptionEnvoyer = true;
		}
		assertTrue(exceptionEnvoyer);
	}
	
	@Test
	public void testCreationChampsMineInfTailleMin2_envoiExeption() {
		boolean exceptionEnvoyer = false;
		try {
			this.champMines = new MineField(8, -8);
		}
		catch  (Exception e){
			exceptionEnvoyer = true;
		}
		assertTrue(exceptionEnvoyer);
	}
	
	@Test
	public void testCreationChampsMineTailleNegative_envoiExeption() {
		boolean exceptionEnvoyer = false;
		try {
			this.champMines = new MineField(-6, 10);
		}
		catch  (Exception e){
			exceptionEnvoyer = true;
		}
		assertTrue(exceptionEnvoyer);
	}
	
	@Test
	public void testNombreLignesChampsMine4_7_Est4() {
		this.champMines = new MineField(4, 7);
		assertEquals(4, this.champMines.getRows());
	}
	
	@Test
	public void testNombreColonnesChampsMine4_7_Est7() {
		this.champMines = new MineField(4, 7);
		assertEquals(7, this.champMines.getColumns());
	}
	
	@Test
	public void testChampMine4_7_MinerEn3_2() throws Exception {
		this.champMines = new MineField(4, 7);
		this.champMines.mine(3,2);
		assertEquals(true, this.champMines.hasMine(3,2));
	}
	
	
	@Test
	public void testChampMine4_7_Miner_EstNonVide() throws Exception {
		this.champMines = new MineField(4, 7);
		this.champMines.mine(1,1);
		this.champMines.mine(2,1);
		this.champMines.mine(1,3);
		assertFalse(this.champMines.isEmpty());
	}
	
	@Test
	public void testChampMine4_7_MinageHorsLimiteEnvoisException() {
		this.champMines = new MineField(4, 7);
		
		boolean exceptionEnvoyer = false;
		try {
			this.champMines.mine(5,8);
		}
		catch  (Exception e){
			exceptionEnvoyer = true;
		}
		assertTrue(exceptionEnvoyer);
	}
	
	@Test
	public void testChampMine4_7_MinageImpossibleEnvoisException() {
		this.champMines = new MineField(4, 7);
		
		boolean exceptionEnvoyer = false;
		try {
			this.champMines.mine(-1,-1);
		}
		catch  (Exception e){
			exceptionEnvoyer = true;
		}
		assertTrue(exceptionEnvoyer);
	}
	
	@Test
	public void testIncrementationIndicesPresenceDeMineAuMinageCentral() throws Exception {
		this.champMines = new MineField(3,3);
		
		this.champMines.mine(1, 1);
		
		assertEquals(1, this.champMines.getMineIndicator(0,0));
		assertEquals(1, this.champMines.getMineIndicator(0,1));
		assertEquals(1, this.champMines.getMineIndicator(0,2));
		assertEquals(1, this.champMines.getMineIndicator(1,0));
		assertEquals(1, this.champMines.getMineIndicator(1,1));
		assertEquals(1, this.champMines.getMineIndicator(1,2));
		assertEquals(1, this.champMines.getMineIndicator(2,0));
		assertEquals(1, this.champMines.getMineIndicator(2,1));
		assertEquals(1, this.champMines.getMineIndicator(2,2));
		
	}
	
	@Test
	public void testIncrementationIndicesPresenceDeMineAuMinageHautGauche() throws Exception {
		this.champMines = new MineField(3,3);
		
		this.champMines.mine(0, 0);
		
		assertEquals(1, this.champMines.getMineIndicator(0,0));
		assertEquals(1, this.champMines.getMineIndicator(0,1));
		assertEquals(0, this.champMines.getMineIndicator(0,2));
		assertEquals(1, this.champMines.getMineIndicator(1,0));
		assertEquals(1, this.champMines.getMineIndicator(1,1));
		assertEquals(0, this.champMines.getMineIndicator(1,2));
		assertEquals(0, this.champMines.getMineIndicator(2,0));
		assertEquals(0, this.champMines.getMineIndicator(2,1));
		assertEquals(0, this.champMines.getMineIndicator(2,2));
		
	}
	
	@Test
	public void testIncrementationIndicesPresenceDeMineAuMinageBasDroite() throws Exception {
		this.champMines = new MineField(3,3);
		
		this.champMines.mine(2, 2);
		
		assertEquals(0, this.champMines.getMineIndicator(0,0));
		assertEquals(0, this.champMines.getMineIndicator(0,1));
		assertEquals(0, this.champMines.getMineIndicator(0,2));
		assertEquals(0, this.champMines.getMineIndicator(1,0));
		assertEquals(1, this.champMines.getMineIndicator(1,1));
		assertEquals(1, this.champMines.getMineIndicator(1,2));
		assertEquals(0, this.champMines.getMineIndicator(2,0));
		assertEquals(1, this.champMines.getMineIndicator(2,1));
		assertEquals(1, this.champMines.getMineIndicator(2,2));
		
	}
	
	@Test
	public void testIncrementationIndicesPresenceDeMineAuMinage3_3() throws Exception {
		this.champMines = new MineField(3,3);
		
		this.champMines.mine(1, 1);
		this.champMines.mine(2, 2);
		
		assertEquals(1, this.champMines.getMineIndicator(0,0));
		assertEquals(1, this.champMines.getMineIndicator(0,1));
		assertEquals(1, this.champMines.getMineIndicator(0,2));
		assertEquals(1, this.champMines.getMineIndicator(1,0));
		assertEquals(2, this.champMines.getMineIndicator(1,1));
		assertEquals(2, this.champMines.getMineIndicator(1,2));
		assertEquals(1, this.champMines.getMineIndicator(2,0));
		assertEquals(2, this.champMines.getMineIndicator(2,1));
		assertEquals(2, this.champMines.getMineIndicator(2,2));
		
	}
	
	@Test
	public void testToStringMineField() {
		this.champMines = new MineField(3,4);
		
		this.champMines.mine(0, 0);
		this.champMines.mine(1, 1);
		this.champMines.mine(2, 2);
		
		String expected = "* 2 1 0 \n" +
						  "2 * 2 1 \n" +
						  "1 2 * 1 \n";
		assertEquals(expected, this.champMines.toString());
	}
	
}
