package pokermodel;

public class PokerHand extends Hand 
{

  private PokerHandRanking myRank;

  public PokerHand(int maxCards) 
  {
	  super(maxCards);
  }

  /**
   * Check if the hand is a high card
   * @return if the hand is a high card
   * @author Bryan Pearson
   */
  public boolean isHighCard() 
  {
	  //By default, every hand is at least a high card
	  return true;
  }

  /**
   * Check if the hand is a pair
   * @return true if the hand is a pair
   * @author Bryan Pearson
   */
  public boolean isPair() 
  {
	  /*
	   * This loop runs through all the cards in the hand and
	   * gets the value of each card. Then it runs through the 
	   * cards again and checks to see if any duplicate values
	   * appear
	   */
	  for(int i = 0; i < this.getCards().size(); i++)
	  {
		  Card currentCard = this.getCards().get(i);
		  CardValue currentValue = currentCard.getValue();
		  
		  for(int s = 0; s < this.getCards().size(); s++)
		  {
			  Card otherCard = this.getCards().get(s);
			  CardValue otherValue = otherCard.getValue();
			  
			  //If the values are the same and the cards are different, 
			  //It's a high card
			  if(currentValue.compareTo(otherValue) == 0 && i != s)
			  {
				  return true;
			  }
		  }
	  }
	  
	  return false;
  }

  /**
   * Check if the hand is a two pair
   * @return true if the hand is a two pair
   * @author Bryan Pearson
   */
  public boolean isTwoPair() 
  {
	  int numberOfPairs = 0;
	  
	  /*
	   * Same thing as isPair() method except now we are
	   * checking to see if 2 pairs appear
	   */
	  for(int i = 0; i < this.getCards().size(); i++)
	  {
		  Card currentCard = this.getCards().get(i);
		  CardValue currentValue = currentCard.getValue();
		  
		  for(int s = 0; s < this.getCards().size(); s++)
		  {
			  Card otherCard = this.getCards().get(s);
			  CardValue otherValue = otherCard.getValue();
			  
			  //If the values are the same and the cards are different, 
			  //It's a high card
			  if(currentValue.compareTo(otherValue) == 0 && i != s)
			  {
				  numberOfPairs++;
			  }
		  }
	  }
	  
	  if(numberOfPairs == 2)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }

  public boolean isThreeOfKind() 
  {
	  return false;
  }

  public boolean isStraight() 
  {
	  return false;
  }

  public boolean isFlush() 
  {
	  return false;
  }

  public boolean isFullHouse() 
  {
	  return false;
  }

  public boolean isFourOfKind() 
  {
	  return false;
  }

  public boolean isStraightFlush() 
  {
	  return false;
  }

  public boolean isRoyalFlush() 
  {
	  return false;
  }

  /**
   * Print the poker hand to a string
   * @author Bryan Pearson
   */
  public String toString() 
  {
	  return "Hand: " + this.getCards();
  }
  
  /**
   * Clone the current poker hand
   * @author Bryan Pearson
   */
  public Object clone()
  {
	  PokerHand newHand = new PokerHand(this.getMaxNumberCards());
	  for(int i = 0; i < this.getCards().size(); i++)
	  {
		  Card card = this.getCards().get(i);
		  newHand.addCard(card);
	  }
	  
	  return newHand;
  }

  /**
   * Compare the two hands
   * @param hand the hand being compared
   * @return the amount of difference
   * @author Bryan Pearson
   */
  public int compareTo(PokerHand hand) 
  {
	  return(this.compareTo(hand));
  }

  public int determineRank() 
  {
	  return 0;
  }

  public int discard() 
  {
	  return 0;
  }

}