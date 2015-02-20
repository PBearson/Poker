package pokermodel;

public enum Suit 
{

   HEARTS ("Hearts"),

   DIAMONDS ("Diamonds"),

   SPADES ("Spades"),

   CLUBS ("Clubs");

   private final String mySuit;
   
   private Suit(String suit)
   {
 	  mySuit = suit;
   }

  public String getSuit()
  {
	  return mySuit;
  }

 

}