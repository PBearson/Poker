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
	  
	  return 0;
  }

  public boolean addCard(Card card) 
  {
	  return false;
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