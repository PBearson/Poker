package pokertesting;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import pokermodel.Card;
import pokermodel.CardValue;
import pokermodel.Hand;
import pokermodel.Suit;

public class HandTesting 
{
		
	/**
	 * Test to make sure that the player can actually
	 * discard cards.
	 */
	@Test
	public void discardWorks()
	{
		Hand hand = new Hand(5);
		hand.addCard(new Card(Suit.SPADES, CardValue.JACK));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.HEARTS, CardValue.NINE));

		int discardedCount, initialHandSize, newHandSize;
		
		initialHandSize = hand.getCards().size();
		Vector<Card> cards = hand.getCards();
		((Card)cards.get(0)).toggleSelected();
		((Card)cards.get(3)).toggleSelected();
		discardedCount = hand.discard();
		
		//Assert that exactly two cards were discarded
		assertTrue(discardedCount == 2);
		newHandSize = hand.getCards().size();
		
		//Assert that the new hand size is equal to the initial
		//hand size minus the amount of discarded cards
		assertTrue(newHandSize == initialHandSize - discardedCount);
	}
	
	/**
	 * Make sure that the player cannot add cards
	 * if the hand is currently full.
	 */
	@Test
	public void cannotAddCard()
	{
		Hand hand = new Hand(5);
		hand.addCard(new Card(Suit.SPADES, CardValue.JACK));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.HEARTS, CardValue.NINE));
		
		//Assert that addCard returns false if the 
		//player tries to add to a full deck
		assertFalse(hand.addCard(new Card(Suit.SPADES, CardValue.TEN)));
	}
	
	/**
	 * Make sure that the player CAN add cards
	 * if the hand isn't currently full
	 */
	@Test
	public void canAddCard()
	{
		boolean added = true;
		Hand hand = new Hand(5);
		added = added && hand.addCard(new Card(Suit.SPADES, CardValue.JACK));
		added = added && hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		added = added && hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		added = added && hand.addCard(new Card(Suit.HEARTS, CardValue.SEVEN));
		added = added && hand.addCard(new Card(Suit.HEARTS, CardValue.NINE));
		
		assertTrue(added);
	}
	
	/**
	 * assert constructor works 
	 * 
	 */
	@Test
	public void testMaxCards(){
		Hand hand = new Hand(12);
		assertTrue(hand.getMaxNumberCards() == 12);
	} 
	
	/**
	 * test when a invalid value is passes, it reverts to a default max hand size
	 */
	
	@Test
	public void testDefaultMax(){
		Hand hand = new Hand(-1);
		assertTrue(hand.getMaxNumberCards() == 5);
		
	}
	
	/**
	 * Discard one card, test if the hand size is reduced by one
	 */
	
	public void reduceByOne(){
		Vector<Card> cards = new Vector<Card>();
		cards.add(new Card(Suit.HEARTS, CardValue.ACE));
		cards.add(new Card(Suit.CLUBS, CardValue.SIX));
		cards.add(new Card(Suit.SPADES, CardValue.TEN));
		cards.add(new Card(Suit.DIAMONDS, CardValue.QUEEN));
		cards.add(new Card(Suit.SPADES, CardValue.THREE));
		
		Hand hand = new Hand(12);

		for (Card c : cards) {
			hand.addCard(c);
		}

		hand.getCards().get(0).toggleSelected();
		hand.discard();
		assertTrue(hand.getCards().size() == 4);
	}
	
	/**
	 * Add a card, if the hand is already full, return false
	 * Testing the addCard() method
	 */
	public void exceedMax(){
		Hand hand = new Hand(1);
		
		Card card1 = new Card(Suit.CLUBS, CardValue.TWO);
		Card card2 = new Card(Suit.HEARTS, CardValue.TWO);
		assertTrue(hand.addCard(card1));
		assertFalse(hand.addCard(card2));
	}
	
}
