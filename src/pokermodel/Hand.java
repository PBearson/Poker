package pokermodel;

import java.util.Vector;

public class Hand 
{

  private int myMaxNumberCards;

  private Vector<Card> myCards;

  /**
   * Constructor initalizes the hand
   * @param maxCards the maximum number of cards in the hand
   * @author Bryan Pearson
   */
  public Hand(int maxCards) 
  {
	  myMaxNumberCards = maxCards;
	  myCards = new Vector<Card>(myMaxNumberCards);
  }

  /**
   * Discard up to 3 cards unless 
   * an ace is selected, in which case
   * all cards may be discarded
   * @return the amount of cards discarded
   * @author Bryan Pearson
   */
  public int discard() 
  {
	  Vector<Card> cards = this.getCards();
	  int handSize = this.getCards().size();
	  int numberOfDiscards = 0;
	  
	  for(int i = 0; i < this.getCards().size(); i++)
	  {
		  Card currentCard = cards.get(i);
		  boolean isSelected = currentCard.isSelected();
		  
		  if(isSelected && numberOfDiscards < 3)
		  {
			  cards.remove(i);
			  numberOfDiscards++;
		  }
	  }
	  
	  return numberOfDiscards;
  }

  /**
   * Add a new card if the hand is not full
   * @param card the card being added
   * @return true if the card is added,
   * false if the hand is full
   * @author Bryan Pearson
   */
  public boolean addCard(Card card) 
  {
	  if(this.getCards().size() < myMaxNumberCards)
	  {
		  this.getCards().addElement(card);
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }

  public Vector<Card> getCards()
  {
	  return myCards;
  }
  
  public int getMaxNumberCards()
  {
	  return myMaxNumberCards;
  }

}