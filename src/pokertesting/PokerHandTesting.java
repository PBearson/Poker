package pokertesting;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokermodel.PokerHand;
import pokermodel.PokerModel;

public class PokerHandTesting 
{
	/*
	 * Test cases for the PokerHand classes
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
	 * Test to make sure that the poker hand
	 * can actually determine the correct rank.
	 * @author Michael Zirpoli
	 * @author Bryan Pearson
	 */
	@Test
	public void rankDeterminationWorks()
	{
		PokerModel model = new PokerModel();
		PokerHand hand = model.getPlayer().getHand();
		int rank;
		
		//Deal the hand and determine the rank
		model.dealHands();
		rank = hand.determineRank();
		
		//Assert that the correct rank was determined
		switch(rank)
		{
			case 1: assertTrue(hand.isHighCard());
					break;
					
			case 2: assertTrue(hand.isPair());
					break;
					
			case 3: assertTrue(hand.isTwoPair());
					break;
					
			case 4: assertTrue(hand.isThreeOfKind());
					break;
					
			case 5: assertTrue(hand.isStraight());
					break;
					
			case 6: assertTrue(hand.isFlush());
					break;
					
			case 7: assertTrue(hand.isFullHouse());
					break;
					
			case 8: assertTrue(hand.isFourOfKind());
					break;
			
			case 9: assertTrue(hand.isStraightFlush());
					break;
					
			case 10: assertTrue(hand.isRoyalFlush());
					 break;
		}
	}

}
