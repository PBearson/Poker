package pokermodel;

import java.awt.Image;

public class Card 
{

  private Suit mySuit;

  private CardValue myValue;

  private Image myImage;

  private boolean myIsSelected;

  private boolean myIsFaceUp;

  public Card(Suit suit, CardValue value) 
  {
	  mySuit = suit;
	  myValue = value;
  }

  public void flipCard() 
  {
  }

  public boolean isFaceUp() 
  {
	  return false;
  }

  public boolean isSelected() 
  {
	  return false;
  }

  public void toggleSelected() 
  {
  }

  public int compareTo(Card card) 
  {
	  return 0;
  }

  public Object clone() 
  {
	  return null;
  }

  public String toString() 
  {
	  return null;
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