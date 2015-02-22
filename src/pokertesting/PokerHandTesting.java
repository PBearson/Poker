package pokertesting;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import pokermodel.Card;
import pokermodel.CardValue;
import pokermodel.PokerHand;
import pokermodel.PokerHandRanking;
import pokermodel.Suit;

public class PokerHandTesting 
{
	/**
	 * Check all ranking evaluators 
	 */
	
	@Test
	public void highCardTest() {
		PokerHand hand = new PokerHand(5);	
		hand.addCard(new Card(Suit.SPADES, CardValue.JACK));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.HEARTS, CardValue.NINE));
		
		assertTrue(hand.isHighCard());
		
		//Make hand NOT a high card:
		hand = new PokerHand(5);	
		hand.addCard(new Card(Suit.SPADES, CardValue.NINE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.SEVEN));
		
		assertFalse(hand.isHighCard());
	}
	
	@Test
	public void pairTest() {
		PokerHand hand = new PokerHand(5);	
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.HEARTS, CardValue.NINE));
		
		assertTrue(hand.isPair());
		
		//Make hand NOT a pair:
		hand = new PokerHand(5);	
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.QUEEN));
		hand.addCard(new Card(Suit.HEARTS, CardValue.KING));
		hand.addCard(new Card(Suit.HEARTS, CardValue.TEN));
		hand.addCard(new Card(Suit.HEARTS, CardValue.JACK));
		
		assertFalse(hand.isPair());
	}
	
	@Test
	public void twoPairTest() {
		PokerHand hand = new PokerHand(5);	
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.HEARTS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.HEARTS, CardValue.QUEEN));
		
		assertTrue(hand.isTwoPair());
		
		hand = new PokerHand(5);	
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.EIGHT));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.NINE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.TEN));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.JACK));

		assertFalse(hand.isTwoPair());
	}
	
	@Test
	public void threeOfKind() {
		PokerHand hand = new PokerHand(5);	
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.addCard(new Card(Suit.CLUBS, CardValue.ACE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.JACK));
		
		assertTrue(hand.isThreeOfKind());
		
		hand = new PokerHand(5);	
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.FOUR));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.EIGHT));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.NINE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.TEN));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.QUEEN));

		assertFalse(hand.isThreeOfKind());
	}
	
	@Test
	public void straightTest() {
		PokerHand hand = new PokerHand(5);	
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.addCard(new Card(Suit.CLUBS, CardValue.FOUR));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.FIVE));
		hand.addCard(new Card(Suit.SPADES, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.TWO));
		
		assertTrue(hand.isStraight());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.FOUR));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.EIGHT));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.TEN));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.ACE));

		assertFalse(hand.isStraight());
	}
	
	@Test
	public void flushTest() {
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.FOUR));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.EIGHT));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.QUEEN));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.ACE));
		
		assertTrue(hand.isFlush());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.FOUR));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.EIGHT));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.QUEEN));
		hand.addCard(new Card(Suit.CLUBS, CardValue.ACE));

		assertFalse(hand.isFlush());
	}
	
	@Test
	public void fullHouseTest() {
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.CLUBS, CardValue.FOUR));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.FOUR));
		hand.addCard(new Card(Suit.HEARTS, CardValue.FOUR));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.ACE));
		hand.addCard(new Card(Suit.SPADES, CardValue.ACE));
		
		assertTrue(hand.isFullHouse());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.FOUR));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.EIGHT));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.QUEEN));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.ACE));

		assertFalse(hand.isFullHouse());
	}
	
	@Test
	public void fourOfKindTest() {
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.CLUBS, CardValue.FOUR));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.FOUR));
		hand.addCard(new Card(Suit.HEARTS, CardValue.FOUR));
		hand.addCard(new Card(Suit.SPADES, CardValue.FOUR));
		hand.addCard(new Card(Suit.SPADES, CardValue.ACE));
		
		assertTrue(hand.isFourOfKind());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.HEARTS, CardValue.JACK));
		hand.addCard(new Card(Suit.HEARTS, CardValue.THREE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.HEARTS, CardValue.NINE));

		assertFalse(hand.isFourOfKind());
	}
	
	@Test
	public void straightFlushTest() {
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.SPADES, CardValue.ACE));
		hand.addCard(new Card(Suit.SPADES, CardValue.FOUR));
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.addCard(new Card(Suit.SPADES, CardValue.FIVE));
		hand.addCard(new Card(Suit.SPADES, CardValue.TWO));
		
		assertTrue(hand.isStraightFlush());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.SPADES, CardValue.JACK));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.HEARTS, CardValue.NINE));

		assertFalse(hand.isStraightFlush());
	}
	
	@Test
	public void royalFlushTest() {
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.SPADES, CardValue.ACE));
		hand.addCard(new Card(Suit.SPADES, CardValue.QUEEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.KING));
		hand.addCard(new Card(Suit.SPADES, CardValue.TEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.JACK));
		
		assertTrue(hand.isRoyalFlush());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.SPADES, CardValue.ACE));
		hand.addCard(new Card(Suit.SPADES, CardValue.FOUR));
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.addCard(new Card(Suit.SPADES, CardValue.FIVE));
		hand.addCard(new Card(Suit.SPADES, CardValue.TWO));

		assertFalse(hand.isRoyalFlush());
	}
	
	/**
	 * Check determineRank() class with 5 different hands
	 */
	
	@Test
	public void hand1RoyalFlush() 
	{
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.SPADES, CardValue.ACE));
		hand.addCard(new Card(Suit.SPADES, CardValue.QUEEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.KING));
		hand.addCard(new Card(Suit.SPADES, CardValue.TEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.JACK));
		hand.determineRank();
		
		assertTrue(hand.determineRank() == PokerHandRanking.ROYAL_FLUSH.getRanking());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.SPADES, CardValue.ACE));
		hand.addCard(new Card(Suit.SPADES, CardValue.FOUR));
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.addCard(new Card(Suit.SPADES, CardValue.FIVE));
		hand.addCard(new Card(Suit.SPADES, CardValue.TWO));
		hand.determineRank();
		
		assertTrue(hand.determineRank()!= PokerHandRanking.ROYAL_FLUSH.getRanking());
		
	}
	
	@Test
	public void hand2Flush() 
	{
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.SPADES, CardValue.FOUR));
		hand.addCard(new Card(Suit.SPADES, CardValue.SEVEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.ACE));
		hand.addCard(new Card(Suit.SPADES, CardValue.QUEEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.determineRank();
		
		assertTrue(hand.determineRank()==PokerHandRanking.FLUSH.getRanking());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.SPADES, CardValue.FOUR));
		hand.addCard(new Card(Suit.CLUBS, CardValue.THREE));
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.addCard(new Card(Suit.SPADES, CardValue.TWO));
		hand.determineRank();
		
		assertTrue(hand.determineRank()!=PokerHandRanking.FLUSH.getRanking());
		
	}
	
	@Test
	public void hand3FullHouse()
	{
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.HEARTS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.CLUBS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.SEVEN));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.QUEEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.QUEEN));
		hand.determineRank();
		
		assertTrue(hand.determineRank()==PokerHandRanking.FULL_HOUSE.getRanking());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.FOUR));
		hand.addCard(new Card(Suit.HEARTS, CardValue.FIVE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.THREE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.TWO));
		hand.determineRank();
		
		assertTrue(hand.determineRank()!=PokerHandRanking.FULL_HOUSE.getRanking());
		
	}
	
	@Test
	public void hand4Pair() 
	{
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.HEARTS, CardValue.SEVEN));
		hand.addCard(new Card(Suit.CLUBS, CardValue.TWO));
		hand.addCard(new Card(Suit.SPADES, CardValue.SIX));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.QUEEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.QUEEN));
		hand.determineRank();
		
		assertTrue(hand.determineRank()==PokerHandRanking.PAIR.getRanking());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.SPADES, CardValue.ACE));
		hand.addCard(new Card(Suit.HEARTS, CardValue.FIVE));
		hand.addCard(new Card(Suit.CLUBS, CardValue.FIVE));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.TWO));
		hand.determineRank();
		
		assertTrue(hand.determineRank()!=PokerHandRanking.PAIR.getRanking());
	}
	
	@Test
	public void hand5HighCard() 
	{
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.CLUBS, CardValue.SIX));
		hand.addCard(new Card(Suit.SPADES, CardValue.TEN));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.QUEEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.determineRank();
		
		assertTrue(hand.determineRank()==PokerHandRanking.HIGH_CARD.getRanking());
		
		hand = new PokerHand(5);
		hand.addCard(new Card(Suit.HEARTS, CardValue.ACE));
		hand.addCard(new Card(Suit.CLUBS, CardValue.SIX));
		hand.addCard(new Card(Suit.SPADES, CardValue.QUEEN));
		hand.addCard(new Card(Suit.DIAMONDS, CardValue.QUEEN));
		hand.addCard(new Card(Suit.SPADES, CardValue.THREE));
		hand.determineRank();
		
		assertTrue(hand.determineRank()!=PokerHandRanking.HIGH_CARD.getRanking());
	}
	
	/**
	 * Test overwritten discard() method, ensuring that cards 
	 * are added after discard to fill to max hand size (in this case 5)
	 */
	
	@Test
	public void discardAndHandSizeTest() 
	{
		PokerHand hand = new PokerHand(5);	
		hand = new PokerHand(5);
		Vector<Card> cards = new Vector<Card>();
		cards.add(new Card(Suit.HEARTS, CardValue.ACE));
		cards.add(new Card(Suit.CLUBS, CardValue.SIX));
		cards.add(new Card(Suit.SPADES, CardValue.TEN));
		cards.add(new Card(Suit.DIAMONDS, CardValue.QUEEN));
		cards.add(new Card(Suit.SPADES, CardValue.THREE));
		for (Card c : cards )
		{
			c.toggleSelected();
			hand.addCard(c);
		}
		hand.getCards().get(1).toggleSelected();
		hand.discard();
		assertTrue(hand.getCards().size() == 5);
	}

	/**
	 * Test the compareTo() method with 2 different cases and an identical case
	 */
	
	@Test
	public void identicalHands() 
	{
		PokerHand hand1 = new PokerHand(5);	
		hand1 = new PokerHand(5);
		PokerHand hand2 = new PokerHand(5);	
		hand2 = new PokerHand(5);
		
		Vector<Card> cards = new Vector<Card>();
		cards.add(new Card(Suit.HEARTS, CardValue.ACE));
		cards.add(new Card(Suit.CLUBS, CardValue.SIX));
		cards.add(new Card(Suit.SPADES, CardValue.TEN));
		cards.add(new Card(Suit.DIAMONDS, CardValue.QUEEN));
		cards.add(new Card(Suit.SPADES, CardValue.THREE));
		
		for (Card c : cards )
		{
			hand1.addCard(c);
			hand2.addCard(c);
		}
		assertTrue(hand1.compareTo(hand2)==0);
	}
	
	@Test
	public void handOneIsBetter() {
		PokerHand hand1 = new PokerHand(5);	
		hand1 = new PokerHand(5);
		PokerHand hand2 = new PokerHand(5);	
		hand2 = new PokerHand(5);
		
		// FULL HOUSE
		hand1.addCard(new Card(Suit.SPADES, CardValue.ACE));
		hand1.addCard(new Card(Suit.SPADES, CardValue.QUEEN));
		hand1.addCard(new Card(Suit.SPADES, CardValue.KING));
		hand1.addCard(new Card(Suit.SPADES, CardValue.TEN));
		hand1.addCard(new Card(Suit.SPADES, CardValue.JACK));
		
		// THREE OF KIND
		hand2.addCard(new Card(Suit.CLUBS, CardValue.FOUR));
		hand2.addCard(new Card(Suit.DIAMONDS, CardValue.FOUR));
		hand2.addCard(new Card(Suit.HEARTS, CardValue.FOUR));
		hand2.addCard(new Card(Suit.DIAMONDS, CardValue.ACE));
		hand2.addCard(new Card(Suit.SPADES, CardValue.ACE));
		
		assertTrue(hand1.compareTo(hand2) == 1);
	}
	
	@Test
	public void handOneIsWorse() {
		PokerHand hand1 = new PokerHand(5);	
		hand1 = new PokerHand(5);
		PokerHand hand2 = new PokerHand(5);	
		hand2 = new PokerHand(5);
		
		// STRAIGHT
		hand1.addCard(new Card(Suit.CLUBS, CardValue.FOUR));
		hand1.addCard(new Card(Suit.DIAMONDS, CardValue.THREE));
		hand1.addCard(new Card(Suit.HEARTS, CardValue.TWO));
		hand1.addCard(new Card(Suit.DIAMONDS, CardValue.FIVE));
		hand1.addCard(new Card(Suit.SPADES, CardValue.ACE));

		// FULL HOUSE
		hand2.addCard(new Card(Suit.SPADES, CardValue.ACE));
		hand2.addCard(new Card(Suit.SPADES, CardValue.QUEEN));
		hand2.addCard(new Card(Suit.SPADES, CardValue.KING));
		hand2.addCard(new Card(Suit.SPADES, CardValue.TEN));
		hand2.addCard(new Card(Suit.SPADES, CardValue.JACK));
		
		assertTrue(hand1.compareTo(hand2) == -1);
	}
}
