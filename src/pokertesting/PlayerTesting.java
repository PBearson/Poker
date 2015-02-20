package pokertesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokermodel.Player;

public class PlayerTesting 
{
	
	/**
	 * Test cases for the Player class
	 * @author Bryan Pearson
	 * @author Michael Zirpoli
	 */
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
	}

	@Before
	public void setUp() throws Exception 
	{
	}


	@After
	public void tearDown() throws Exception
	{
	}

	/**
	 * Test that the player's name is valid
	 * @author Bryan Pearson
	 */
	@Test
	public void validPlayerName() 
	{
		Player player = new Player("Player 1");
		assertTrue(player.isValidName());
	}
	
	/**
	 *No blank names allowed
	 *@author Bryan Pearson
	 */
	@Test
	public void invalidPlayerName()
	{
		Player player = new Player("");
		assertFalse(player.isValidName());
	}
	
	/**
	 * Test that the default score is 0
	 * @author Bryan Pearson
	 */
	@Test
	public void defaultScoreWorking()
	{
		Player player = new Player("Player 1");
		assertTrue(player.getNumberOfWins() == 0);
	}
	
	/**
	 * Test that the score increments correctly
	 * @author Bryan Pearson
	 */
	@Test
	public void incrementWorking()
	{
		Player player = new Player("Player 1");
		assertTrue(player.incrementScore() == 1);
	}

}
