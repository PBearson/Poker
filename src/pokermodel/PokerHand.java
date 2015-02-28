package pokermodel;

import java.util.Collections;
import java.util.Vector;

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
	  Card cardMatch1, cardMatch2;
	  cardMatch1 = new Card(Suit.CLUBS, CardValue.ACE);
	  cardMatch2 = new Card(Suit.CLUBS, CardValue.ACE);
	  
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
			  int comparingCards = currentValue.compareTo(otherValue);
			  
			  /*
			   * If the values are the same and the cards are different,
			   * it's a high card.
			   */
			  if(comparingCards == 0 && i != s)
			  {
				  /*
				   * If a match hasn't been found yet, add the match
				   * and record the cards that were matched.
				   */
				  if(numberOfPairs == 0)
				  {
					  numberOfPairs++;
					  cardMatch1 = currentCard;
					  cardMatch2 = otherCard;
				  }
				  
				  /*
				   * If one match has been found, we need to make sure that
				   * any other match includes new cards
				   */
				  else if(currentCard != cardMatch1 && currentCard != cardMatch2)
				  {
					  if(otherCard != cardMatch1 && otherCard != cardMatch2)
					  {
						  return true;
					  }
				  }
			  }
		  }
	  }
	  
	  return false;
  }

  public boolean isThreeOfKind() 
  {
<<<<<<< HEAD
int numberOfDuplicates = 1;
=======
   int numberOfDuplicates = 0;
>>>>>>> 75fba1c605769dcd5af68fa26503f5861f4fe7b1
	  
	  /*
	   * Same thing as isPair() method except now we are
	   * checking to see if 3 duplicate cards appear
	   */
	  for(int i = 0; i < this.getCards().size(); i++)
	  {
		  Card currentCard = this.getCards().get(i);
		  CardValue currentValue = currentCard.getValue();
		  
		  for(int s = 0; s < this.getCards().size(); s++)
		  {
			  Card otherCard = this.getCards().get(s);
			  CardValue otherValue = otherCard.getValue();
			  numberOfDuplicates = 0;
			  
			  //If the values are the same and the cards are different, 
			  //It's a high card
			  if(currentValue.compareTo(otherValue) == 0 && i != s)
			  {
				  numberOfDuplicates++;
				  
				  if(numberOfDuplicates == 2)
				  {
					  return true;
				  }
			  }
		  }
	  }
	  
	  return false;
  }

  /**
   * Check if the hand is a straight
   * @return true if the hand is a straight
   * @author Bryan Pearson
   */
  public boolean isStraight() 
  {  
	  
	  return false;
  }

  /**
   * Check if the hand is a flush
   * @return true if the hand is a flush
   * @author Bryan Pearson
   */
  public boolean isFlush() 
  {
	  int handSize = this.getCards().size();
	  int numberOfMatches = 0;
	  int maxNumberOfMatches = this.getCards().size() - 1;
	  
	  Suit firstSuit = this.getCards().get(0).getSuit();
	  
	  for(int i = 1; i <= handSize; i++)
	  {
		  if(this.getCards().get(i).getSuit().compareTo(firstSuit) == 0)
		  {
			  numberOfMatches++;
		  }
	  }
	  
	  if(numberOfMatches == maxNumberOfMatches)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
  }

  public boolean isFullHouse() 
  {
	  return false;
  }

  public boolean isFourOfKind() 
  {
int numberOfDuplicates = 0;
	  
	  /*
	   * Same thing as isPair() method except now we are
	   * checking to see if 4 duplicate cards appear
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
				  numberOfDuplicates++;
			  }
		  }
	  }
	  
	  if(numberOfDuplicates == 4)
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
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