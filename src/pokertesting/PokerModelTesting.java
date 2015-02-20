package pokertesting;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokermodel.Card;
import pokermodel.CardValue;
import pokermodel.PokerModel;
import pokermodel.Suit;

public class PokerModelTesting 
{
	/**
	 * Test cases for the PokerModel class
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
	 * Test that the deck contains the correct number of cards
	 * AFTER the hands have been dealt to the player and computer player
	 * @author Bryan Pearson
	 * @author Michael Zirpoli
	 */
	@Test
	public void handsDealt() 
	{
		PokerModel model = new PokerModel();
		int handSize, deckSize;
		final int NUMBER_OF_PLAYERS = 2;
		
		//Deal the hands to the players
		model.dealHands();
		
		//Find the players' hand sizes and the new deck size
		handSize = model.getPlayer().getHand().getMaxNumberCards();
		deckSize = model.getDeck().getCards().size();
		
		//Assert that the number of cards subtracted from the deck
		//is equal to the number of cards in both players' hands
		assertTrue(52 - deckSize == NUMBER_OF_PLAYERS * handSize);
	}
	
	/**
	 * Test to make sure that each card in the player's
	 * hand is different from each card in the computer
	 * player's hand.
	 * @author Bryan Pearson
	 * @author Michael Zirpoli
	 */
	@Test
	public void handsDifferent()
	{
		PokerModel model = new PokerModel();
		Vector<Card> playerHand, computerHand;
		
		//Deal the hands
		model.dealHands();
		
		//Find the player and the computer player's hands
		playerHand = model.getPlayer().getHand().getCards();
		computerHand = model.getComputerPlayer().getHand().getCards(); 
		
		//Assert that no cards in the player's hand appears in 
		//the computer's hand.
		assertFalse(this.compareCards(playerHand, computerHand));
	}
	
	/**
	 * Test to make sure that each card in the player's
	 * hand is different.
	 * @author Bryan Pearson
	 * @author Michael Zirpoli
	 */
	@Test
	public void playerHasUniqueCards()
	{
		PokerModel model = new PokerModel();
		Vector<Card> playerHand;
		
		//Deal the hand to the player
		model.dealHands();
		
		//Find the player's hand
		playerHand = model.getPlayer().getHand().getCards();
		
		//Assert that the player has no duplicate cards
		assertFalse(this.compareCards(playerHand, playerHand));
		
	}
	
	/**
	 * Test to make sure that each card in the computer's
	 * hand is different.
	 * @author Bryan Pearson
	 */
	@Test
	public void computerHasUniqueCards()
	{
		PokerModel model = new PokerModel();
		Vector<Card> computerHand;
		
		//Deal the hands
		model.dealHands();
		
		//Find the computer's hand
		computerHand = model.getComputerPlayer().getHand().getCards();
		
		//Assert that the computer has no duplicate cards
		assertFalse(this.compareCards(computerHand, computerHand));
	}
	
	/**
	 * Test to make sure that no cards in the players' hands 
	 * can be found in the deck.
	 * @author Bryan Pearson
	 */
	@Test
	public void cardsRemovedFromDeck()
	{
		PokerModel model = new PokerModel();
		Vector<Card> playerHand, computerHand, deck;

		model.dealHands();
		
		playerHand = model.getPlayer().getHand().getCards();
		computerHand = model.getComputerPlayer().getHand().getCards();
		deck = model.getDeck().getCards();
		
		//Assert that no cards in the deck appear in the 
		//player's hand or the computer's hand.
		assertFalse(this.compareCards(deck, playerHand));
		assertFalse(this.compareCards(deck, computerHand));
	}
	
	/**
	 * Compare 2 card sets and return true if a duplicate is found
	 * @param loopSize the size of the loop
	 * @param firstCardSet the first card set, a Vector
	 * @param secondCardSet the second card set, a Vector
	 * @return true if a duplicate is found, false if all cards are unique
	 * @author Bryan Pearson
	 */
	public boolean compareCards(Vector<Card> firstCardSet, Vector<Card> secondCardSet)
	{
		int firstLoopSize = firstCardSet.size();
		int secondLoopSize = secondCardSet.size();
		boolean isSameSet = firstCardSet.equals(secondCardSet);
		boolean suitsEqual = false, valuesEqual = false;
		
		/*
		 * This loop will iterate through the first card set and 
		 * set each card's suit and value to an array. Then it will
		 * run another loop that iterates through the second card
		 * set and sets those card suits and values to another array.
		 * Finally, it will compare the first card to the second card
		 * by comparing the arrays.
		 */
		for (int i = 0; i < firstLoopSize; i++)
		{
			Card firstCard = firstCardSet.get(i);
			Suit firstCardSuit = firstCard.getSuit();
			CardValue firstCardValue = firstCard.getValue();
			
			for (int s = 0; s < secondLoopSize; s++)
			{
				Card secondCard = secondCardSet.get(s);
				Suit secondCardSuit = secondCard.getSuit();
				CardValue secondCardValue = secondCard.getValue();
				
				//If the suits are the same
				if(firstCardSuit.compareTo(secondCardSuit) == 0)
				{
					suitsEqual = true;
				}
				
				//If the values are the same
				if(firstCardValue.compareTo(secondCardValue) == 0)
				{
					valuesEqual = true;
				}
				
				//If the cards have equal suits and values
				if(suitsEqual && valuesEqual)
				{
				   /*
					* If the same set is being referenced 
					* and the counters have different values,
					* then they're equal. (If the counters are 
					* the same, it is referencing the same card.)
					*/
					if(isSameSet && i != s)
					{
						return true;
					}
					
					/*
					 * If the sets are different then there's no need
					 * to check the loop counters.
					 */
					else if (!isSameSet)
					{
						return true;
					}
				}
			}
		}
		
		return false;
		
	}

}
