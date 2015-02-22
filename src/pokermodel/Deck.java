package pokermodel;

import java.util.Vector;
import java.util.*;

public class Deck 
{
	/**
	 * Handles the deck
	 * @author Michael Zirpoli
	 * @author Bryan Pearson
	 */
  private Vector<Card> myCards;

  public static int MAX_NUM_CARDS = 52;
  public static int NUM_SUITS = 4;
  public static int NUM_VALUES = 13;

  /**
   * Constructor creates and shuffles the deck
   * Bryan Pearson
   */
  public Deck() 
  {
	  initializeDeck();
	  shuffle();
	  cut();
  }
  
  /**
   * This private method creates a new vector of cards
   * in order (aces first, then twos, then threes, etc.).
   * @author Bryan Pearson
   */
  private void initializeDeck()
  {
	  myCards = new Vector<Card>(MAX_NUM_CARDS);
	  
	  /*
	   * This loop runs through 1 to 13 and assigns 
	   * a card value to a new card. Then it
	   * loops through 1 to 4 and assigns a suit to
	   * the same card. 52 unique cards are generated.
	   */
	  for(int i = 1; i <= NUM_VALUES; i++)
	  {
		  //Initialize suit and card value
		  Suit suit = Suit.CLUBS;
		  CardValue value = CardValue.ACE;
		  Card card;
	
		  for(int s = 1; s <= NUM_SUITS; s++)
		  {
			  //Find the corresponding card value
			  switch(i)
			  {
			  	case 1: value = CardValue.ACE;
			  			break;
			  	
			  	case 2: value = CardValue.TWO;
			  			break;
			  			
			  	case 3: value = CardValue.THREE;
			  			break;
			  			
			  	case 4: value = CardValue.FOUR;
			  			break;
			  			
			  	case 5: value = CardValue.FIVE;
			  			break;
			  			
			  	case 6: value = CardValue.SIX;
			  			break;
			  			
			  	case 7: value = CardValue.SEVEN;
			  			break;
			  			
			  	case 8: value = CardValue.EIGHT;
			  			break;
			  			
			  	case 9: value = CardValue.NINE;
			  			break;
			  			
			  	case 10: value = CardValue.TEN;
			  			 break;
			  			
			  	case 11: value = CardValue.JACK;
			  			 break;
			  			 
			  	case 12: value = CardValue.QUEEN;
			  			 break;
			  			 
			  	case 13: value = CardValue.KING;
			  			 break;
			  }
			  
			  //Find the corresponding suit
			  switch(s)
			  {
			  	case 1: suit = Suit.CLUBS;
			  			break;
			  			
			  	case 2:	suit = Suit.HEARTS;
			  			break;
			  			
			  	case 3: suit = Suit.DIAMONDS;
			  			break;
			  			
			  	case 4: suit = Suit.SPADES;
			  			break;
			  }
			  
			  //Initialize a new card with the correct
			  //suit and card value
			  card = new Card(suit, value);
			  
			  //Add the card to the vector
			  myCards.add(card);
		  }  
	  }
  }
  
  /**
   * Mix up all of the cards into a different location
   * @author Bryan Pearson
   */
  public void shuffle() 
  {
	  //The Collections class has a method that can 
	  //automatically shuffle vectors
	  Collections.shuffle(myCards);
  }

  /**
   * Deal the top card from the deck
   * @return the card being dealt
   * @author Bryan Pearson
   */
  public Card deal() 
  {
	  //Get the top card
	  Card card = myCards.get(0);
	  
	  //The card is now removed from the deck
	  myCards.remove(card);
	  
	  return card;
  }

  /**
   * Take the top half of the deck and move it to the bottom 
   * @return true if the deck has enough cards (more than one), 
   * false if otherwise
   * @author Bryan Pearson
   */
  public boolean cut() 
  {
	  int cutSize = myCards.size() / 2;
	  return true;
  }

  public String toString() 
  {
	  return null;
  }

  public Object clone() 
  {
	  return null;
  }

  public Vector<Card> getCards()
  {
	  return myCards;
  }

}