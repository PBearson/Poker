package pokertesting;
import pokermodel.*;

import static org.junit.Assert.*;
import org.junit.Test;

public class CardTesting {

	/**
	 * Test making cards and comparing them
	 * Some same & some different
	 */
	
	
	/**
	 * Ace of Hearts compared to Ace of Spades (different suits, same value)
	 */
	@Test
	public void sameValueDifferentSuit() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		Card card2 = new Card(Suit.SPADES, CardValue.ACE);
		assertTrue(card1.compareTo(card2) == 0);
		
	}

	/**
	 * Jack of Diamonds compared to Jack of Diamonds (same)
	 */
	@Test
	public void sameAll() {
		Card card1 = new Card(Suit.DIAMONDS, CardValue.JACK);
		Card card2 = new Card(Suit.DIAMONDS, CardValue.JACK);
		assertTrue(card1.compareTo(card2) == 0);
	}
	
	
	/**
	 * Seven of Spades compared to Six of Spades (same suit, different value)
	 */
	
	@Test
	public void sameSuitDifferentValue() {
		Card card1 = new Card(Suit.SPADES, CardValue.SIX);
		Card card2 = new Card(Suit.SPADES, CardValue.SEVEN);
		assertTrue(card1.compareTo(card2) == -1);
	}
	
	/**
	 * Ace of Hearts compared to King of Diamonds (Fringe case)
	 */
	@Test
	public void differentAll() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		Card card2 = new Card(Suit.DIAMONDS, CardValue.KING);
		assertTrue(card1.compareTo(card2) == 1);
	}
	
	/**
	 * Test if card is selected and test toggle method
	 */
	
	/**
	 * Test if is selected when constructed
	 */
	@Test
	public void isSelected() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		assertFalse(card1.isSelected());
	}
	
	/**
	 * Test toggling once
	 */
	@Test
	public void toggleSelectedOnce() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		card1.toggleSelected();
		assertTrue(card1.isSelected());
	}
	
	/**
	 * Test toggling twice
	 */
	@Test
	public void toggleSelected2Times() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		for (int i = 0; i < 2 ; i++){
			card1.toggleSelected();	
		}
		assertFalse(card1.isSelected());
	}
	
	/**
	 * Test toggling seven times
	 */
	@Test
	public void toggleSelected7Times() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		for (int i = 0; i < 7 ; i++){
			card1.toggleSelected();	
		}
		assertTrue(card1.isSelected());
	}
	
	/**
	 * Test toggling eight times
	 */
	@Test
	public void toggleSelected8Times() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		for (int i = 0; i < 8 ; i++){
			card1.toggleSelected();	
		}
		assertFalse(card1.isSelected());
	}
	
	/**
	 * Test if card is face up 
	 */
		
	@Test
	public void isFaceUp() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		assertFalse(card1.isFaceUp());
	}
	
	@Test
	public void toggleIsFaceUp() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		card1.flipCard();	
		assertTrue(card1.isFaceUp());
	}
	@Test
	public void toggleFaceUp2Times() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		for (int i = 0; i < 2 ; i++){
			card1.flipCard();
		}
		assertFalse(card1.isFaceUp());
	}
	
	@Test
	public void toggleFaceUp5Times() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		for (int i = 0; i < 5 ; i++){
			card1.flipCard();	
		}
		assertTrue(card1.isFaceUp());
	}
	
	@Test
	public void toggleFaceUp6Times() {
		Card card1 = new Card(Suit.HEARTS, CardValue.ACE);
		for (int i = 0; i < 6 ; i++){
			card1.flipCard();	
		}
		assertFalse(card1.isFaceUp());
	}
	
	/**
	 * Test clone(), make card, clone, compare
	 */
	@Test
	public void cloneAndCompare() {
		Card card1 = new Card(Suit.CLUBS, CardValue.THREE);
		Card card2 = (Card)card1.clone();
		assertTrue(card1.compareTo(card2)==0);
	}	
}
