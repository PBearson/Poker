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
import pokermodel.Suit;

public class DeckTesting 
{
	
	/*
	 * Test cases for the Deck class
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
	 * Make sure that 52 cards are in the deck.
	 * @author Bryan Pearson
	 */
	@Test
	public void allCardsInDeck()
	{
		Deck deck = new Deck();
		int deckSize = deck.getCards().size();
		
		assertTrue(deckSize == 52);
	}
	
	/**
	 * Test to make sure that shuffling works.
	 * @author Bryan Pearson
	 */
	@Test
	public void shuffleWorks()
	{
		Deck deck = new Deck();
		Vector<Card> initialSet, newSet;
		int deckSize, numberOfEqualCards = 0;
		deckSize = deck.getCards().size();
		
		//Get the initial set of cards (before the deck is shuffled)
		initialSet = deck.getCards();
		
		//Shuffle the deck
		deck.shuffle();
		
		//Get the newly shuffled set of cards
		newSet = deck.getCards();
		
		/*
		 * Run a loop that iterates through the deck
		 * and compares the initial card to the new 
		 * card in the same position. This will keep 
		 * track of how many cards were either shuffled 
		 * back into the same spot or were not shuffled 
		 * to begin with.
		 */
		for(int i = 0; i < deckSize; i++)
		{
			Card initialCard, newCard;
			Suit initialSuit, newSuit;
			boolean suitsEqual = false, valuesEqual = false;
			CardValue initialValue, newValue;
			
			//Get the cards
			initialCard = initialSet.get(i);
			newCard = newSet.get(i);
			
			//Get the suits
			initialSuit = initialCard.getSuit();
			newSuit = newCard.getSuit();
			
			//Get the values
			initialValue = initialCard.getValue();
			newValue = newCard.getValue();
			
			//Are the suits equal?
			if(initialSuit.compareTo(newSuit) == 0)
			{
				suitsEqual = true;
			}
			
			//Are the values equal?
			if(initialValue.compareTo(newValue) == 0)
			{
				valuesEqual = true;
			}
			
			//If the suit and value are equal, the cards are equal
			//so increase the counter
			if(suitsEqual && valuesEqual)
			{
				numberOfEqualCards++;
			}
		}
		
		/*
		 * Assert that at least one card (and therefore
		 * at least 2 cards) was shuffled into a different
		 * position.
		 */
		assertTrue(numberOfEqualCards < deckSize);
	}
	
	/**
	 * Test to make sure that every card in the deck is unique
	 * @author Bryan Pearson
	 */
	@Test
	public void noDuplicateCards()
	{
		Deck deck = new Deck();
		Vector<Card> deckSet = deck.getCards();
		
		/*
		 * The PokerModelTesting class has a method that
		 * can compare 2 card sets and return a boolean
		 * that tells whether any duplicate cards exist.
		 */
		PokerModelTesting pmt = new PokerModelTesting();
		
		//Assert that no duplicate cards appear in the deck
		assertFalse(pmt.compareCards(deckSet, deckSet));
	}
	
	/*
	 * *********************************
	 * 
	 * Check to make sure all card suits
	 * and values appear in the deck.
	 * (13 of each suit should appear,
	 * and 4 of each value should appear.)
	 * 
	 * *********************************
	 */
	
	/**
	 * Check to make sure that all aces, 
	 * jacks, queens, kings, and numbers
	 * 2-10 appear thirteen times each.
	 * @author Bryan Pearson
	 */
	@Test
	public void allValues()
	{
		Deck deck = new Deck();
		Vector<Card> deckSet = deck.getCards();
		final int NUMBER_OF_VALUES = 13;
		
		/*
		 * This loop iterates through all values and counts
		 * how many times each value appears in the deck.
		 */
		for(int i = 1; i <= NUMBER_OF_VALUES; i++)
		{
			int valueFrequency = this.checkValueFrequency(deckSet, i);
			assertTrue(valueFrequency == 4);		
		}
	}
	
	/**
	 * Check to make sure that spades appears thirteen times.
	 * @author Bryan Pearson
	 */
	@Test
	public void allSpades()
	{
		Deck deck = new Deck();
		Vector<Card> deckSet = deck.getCards();
		int numberOfSpades = this.checkSuitFrequency(deckSet, "Spades");
		assertTrue(numberOfSpades == 13);
	}
	
	/**
	 * Check to make sure that diamonds appears thirteen times.
	 * @author Bryan Pearson
	 */
	@Test
	public void allDiamonds()
	{
		Deck deck = new Deck();
		Vector<Card> deckSet = deck.getCards();
		int numberOfDiamonds = this.checkSuitFrequency(deckSet, "Diamonds");
		
		assertTrue(numberOfDiamonds == 13);
	}
	
	/**
	 * Check to make sure that hearts appears thirteen times.
	 * @author Bryan Pearson
	 */
	@Test
	public void allHearts()
	{
		Deck deck = new Deck();
		Vector<Card> deckSet = deck.getCards();
		int numberOfHearts = this.checkSuitFrequency(deckSet, "Hearts");
		
		assertTrue(numberOfHearts == 13);
	}
	
	/**
	 * Check to make sure that clubs appears thirteen times.
	 * @author Bryan Pearson
	 */
	@Test
	public void allClubs()
	{
		Deck deck = new Deck();
		Vector<Card> deckSet = deck.getCards();
		int numberOfClubs = this.checkSuitFrequency(deckSet, "Clubs");
		
		assertTrue(numberOfClubs == 13);
	}
	
	/**
	 * Test to make sure that cloning returns a Deck object
	 * @author Bryan Pearson
	 */
	@Test
	public void cloningWorks()
	{
		Deck deck = new Deck();
		assertTrue(deck.clone().getClass().equals(deck.getClass()));
	}
	
	/**
	 * Check how many times a certain suit appears in a set of cards
	 * @param cardSet the set of cards
	 * @param matchSuit the suit that will be matched to the cards in the set
	 * @return how many times the suit appeared in the set
	 * @author Bryan Pearson
	 */
	private int checkSuitFrequency(Vector<Card> cardSet, String matchSuit)
	{
		int counter = 0;
		int setSize = cardSet.size();
		
		/*
		 * Run a loop that iterates through every card in the
		 * set and counts how many times a card's suit matches
		 * with the matchSuit.
		 */
		for(int i = 0; i < setSize; i++)
		{
			Card currentCard = cardSet.get(i);
			String currentSuit = currentCard.getSuit().getSuit();
			
			if(currentSuit.compareTo(matchSuit) == 0)
			{
				counter++;
			}
		}
		
		return counter;
	}
	
	/**
	 * Check how many times a certain card value appears in a set of cards
	 * @param cardSet the set of cards
	 * @param matchValue the card value that will be matched to the cards in the set
	 * @return how many times the card value appeared in the set
	 * @author Bryan Pearson
	 */
	private int checkValueFrequency(Vector<Card> cardSet, int matchValue)
	{
		int counter = 0;
		int setSize = cardSet.size();
		
		/*
		 * Run a loop that iterates through every card in the
		 * set and counts how many times a card's value matches
		 * with the matchValue.
		 */
		for(int i = 0; i < setSize; i++)
		{
			Card currentCard = cardSet.get(i);
			int currentValue = currentCard.getValue().getValue();
			
			if(currentValue == matchValue)
			{
				counter++;
			}
		}
		
		return counter;
	}

}
