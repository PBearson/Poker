package pokermodel;

import java.awt.Image;

public class Card 
{
	/**
	 * The Card class has a suit and a value 
	 * associated with it. Cards can be selected
	 * by the players, flipped over, and compared 
	 * to other cards.
	 * @author Bryan Pearson
	 */
	
	private Suit mySuit;
	
	private CardValue myValue;

    private Image myImage;

    private boolean myIsSelected;

    private boolean myIsFaceUp;

  /**
   * Constructor initializes the card
   * @param suit the card's suit
   * @param value the card's value
   * @author Bryan Pearson
   */
  public Card(Suit suit, CardValue value) 
  {
	  mySuit = suit;
	  myValue = value;
	  myIsSelected = false;
	  myIsFaceUp = false;
  }

  /**
   * Flips the card up or down
   * @author Bryan Pearson
   */
  public void flipCard() 
  {
	  if(myIsFaceUp == true)
	  {
		  myIsFaceUp = false;
	  }
	  else
	  {
		  myIsFaceUp = true;
	  }
  }

  /**
   * Toggles the card on or off
   * @author Bryan Pearson
   */
  public void toggleSelected() 
  {
	  if(myIsSelected == true)
	  {
		  myIsSelected = false;
	  }
	  else
	  {
		  myIsSelected = true;
	  }
  }

  /**
   * Compare this card to another card by matching
   * their suits and values.
   * @param card the card that will be compared to
   * @return 0 if the cards are the same, -1 if either
   * the suits or the values are different, and 1 if
   * both the suits and the values are different.
   * @author Bryan Pearson
   */
  public int compareTo(Card card) 
  {
	  Suit otherSuit;
	  CardValue otherValue;
	  int suitSimilarity, valueSimilarity;
	  
	  //Find the other card's suit and value
	  otherSuit = card.getSuit();
	  otherValue = card.getValue();
	  
	  /*
	   * Compare the suits and values.
	   * The reason we take the absolute value is because in the
	   * case that one number returns a positive and the other 
	   * returns a negative, the sum of the numbers could potentially
	   * be 0, even though the cards are clearly different.
	   */
	  suitSimilarity = Math.abs(mySuit.compareTo(otherSuit));
	  valueSimilarity = Math.abs(myValue.compareTo(otherValue));
	  
	  //Return 1 if the suits and values are different
	  if(suitSimilarity != 0 && valueSimilarity != 0)
	  {
		  return 1;
	  }
	  
	  //Return -1 if suits are the same but values different
	  else if(suitSimilarity == 0 && valueSimilarity != 0)
	  {
		  return -1;
	  }
	  
	  //Return -1 if suits are different but values the same
	  else if(suitSimilarity != 0 && valueSimilarity == 0)
	  {
		  return -1;
	  }
	  
	  //Return 0 if the suits and values are the same
	  else
	  {
		  return 0;
	  }
  }

  /**
   * Clone the current card
   * @author Bryan Pearson
   */
  public Object clone() 
  {
	  Card newCard = new Card(mySuit, myValue);
	  return newCard;
  }

  public String toString() 
  {
	  return "Suit: " + mySuit + ", Value: " + myValue;
  }

  /*
   * **************************
   * ACCESSORS
   * **************************
   */
  
  public boolean isFaceUp() 
  {
	  return myIsFaceUp;
  }

  public boolean isSelected() 
  {
	  return myIsSelected;
  }
  
  public Suit getSuit()
  {
	  return mySuit;
  }
  
  public CardValue getValue()
  {
	  return myValue;
  }
  
  public Image getImage()
  {
	  return myImage;
  }
}