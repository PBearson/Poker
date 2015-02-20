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
import pokermodel.Deck;
import pokermodel.Hand;
import pokermodel.PokerModel;
import pokermodel.Suit;

public class HandTesting 
{
	/*
	 * Test cases for the Hand class
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
	 * Test to make sure that the player can actually
	 * discard cards.
	 * @author Bryan Pearson
	 * @author Michael Zirpoli
	 */
	@Test
	public void discardWorks()
	{
		PokerModel model = new PokerModel();
		model.dealHands();
		
		Hand hand = model.getPlayer().getHand();
		int discardedCount, initialHandSize, newHandSize;
		
		initialHandSize = hand.getCards().size();
		discardedCount = hand.discard();
		newHandSize = hand.getCards().size();
		
		//Assert that the new hand size is equal to the initial
		//hand size minus the amount of discarded cards
		assertTrue(newHandSize == initialHandSize - discardedCount);
	}
	
	/**
	 * Make sure that the player cannot add cards
	 * if the hand is currently full.
	 * @author Bryan Pearson
	 * @author Michael Zirpoli
	 */
	@Test
	public void cannotAddCard()
	{
		PokerModel model = new PokerModel();
		model.dealHands();
		
		Hand hand = model.getPlayer().getHand();
		Deck deck = new Deck();
		Card card = deck.getCards().firstElement();
		
		//Assert that addCard returns false if the 
		//player tries to add to a full deck
		assertFalse(hand.addCard(card));
	}
	
	/**
	 * Make sure that the player CAN add cards
	 * if the hand isn't currently full
	 * @author Bryan Pearson
	 * @author Michael Zirpoli
	 */
	@Test
	public void canAddCard()
	{
		PokerModel model = new PokerModel();
		model.dealHands();
		
		Hand hand = model.getPlayer().getHand();
		Deck deck = new Deck();
		Card card = deck.getCards().firstElement();
		int oldHandSize, newHandSize;
		
		oldHandSize = hand.getCards().size();
		hand.discard();
		newHandSize = hand.getCards().size();
		
		if(newHandSize < oldHandSize)
		{
			assertTrue(hand.addCard(card));
		}
	}
	
	/**
	 * Test to make sure that that adding cards
	 * actually works. That is, make sure that
	 * the card that is added appeared in the deck
	 * before but does not appear afterwards.
	 * @author Bryan Pearson
	 * @author Michael Zirpoli
	 */
	@Test
	public void addCardWorks()
	{
		PokerModel model = new PokerModel();
		model.dealHands();
		
		Hand hand = model.getPlayer().getHand();
		Deck deck = new Deck();
		Card card = deck.getCards().firstElement();
		Vector<Card> initialDeckSet, newDeckSet;
		int oldHandSize, newHandSize;
		
		oldHandSize = hand.getCards().size();
		initialDeckSet = deck.getCards();
		hand.discard();
		newHandSize = hand.getCards().size();
		
		if(newHandSize < oldHandSize)
		{
			hand.addCard(card);
		}
		
		newDeckSet = deck.getCards();
		
		assertTrue(this.cardAppearsInSet(card, initialDeckSet));
		assertFalse(this.cardAppearsInSet(card, newDeckSet));
		
	}
	
	/**
	 * Tests whether a specific card appears in a set or not
	 * @param matchingCard the card being referenced
	 * @param cardSet the set of cards being referenced
	 * @return whether the card is found in the set or not
	 * @author Bryan Pearson
	 * @author Michael Zirpoli
	 */
	private boolean cardAppearsInSet(Card matchingCard, Vector<Card> cardSet)
	{
		int setSize = cardSet.size();
		Suit matchingSuit = matchingCard.getSuit();
		CardValue matchingValue = matchingCard.getValue();
		boolean suitsMatch = false;
		boolean valuesMatch = false;
		
		/*
		 * Run a loop that iterates through the card set and finds the suit
		 * and value of every card in the set. If the loop finds a card that matches
		 * the matching suit and value, it will return true. 
		 */
		for(int i = 0; i < setSize; i++)
		{
			Card currentCard = cardSet.get(i);
			Suit currentSuit = currentCard.getSuit();
			CardValue currentValue = currentCard.getValue();
			
			//Do the suits match?
			if(matchingSuit.equals(currentSuit))
			{
				suitsMatch = true;
			}
			
			//Do the card values match?
			if(matchingValue.equals(currentValue))
			{
				valuesMatch = true;
			}
			
			//If the suits and values match, return true
			if(suitsMatch && valuesMatch)
			{
				return true;
			}
		}
		
		return false;
		
		//What's up Dr. Plante.
	}

}
