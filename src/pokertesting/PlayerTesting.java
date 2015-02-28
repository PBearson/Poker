package pokertesting;

import static org.junit.Assert.*;

import org.junit.Test;

import pokermodel.Player;

public class PlayerTesting 
{
	/**
	 * Test that the player's name is valid
	 */
	@Test
	public void validPlayerName1() 
	{
		Player player = new Player("Player 1");
		assertTrue(player.isValidName());
	}
	
	/**
	 * Must be 10 or fewer characters long
	 */
	@Test
	public void validPlayerName2()
	{
		Player player = new Player("SupermanII");
		assertTrue(player.isValidName());
	}

	/**
	 * No blank names allowed
	 */
	@Test
	public void invalidPlayerName1()
	{
		Player player = new Player("");
		assertFalse(player.isValidName());
	}
	
	/**
	 * Must be 10 or fewer characters long
	 */
	@Test
	public void invalidPlayerName2()
	{
		Player player = new Player("SupermanMom");
		assertFalse(player.isValidName());
	}
		
	/**
	 * Test that the default score is 0
	 */
	@Test
	public void defaultScoreWorking()
	{
		Player player = new Player("Player 1");
		assertTrue(player.getNumberOfWins() == 0);
	}
	
	/**
	 * Test that the score increments correctly
	 */
	@Test
	public void incrementWorking()
	{
		Player player = new Player("Player 1");
		assertTrue(player.incrementScore() == 1);
	}

}
