package pokermodel;

public class PokerModel 
{
	/**
	 * The PokerModel class controls the deck and the players.
	 * @author Bryan Pearson
	 * @author Michael Zirpoli
	 */
	
  private Player myPlayer;

  private Player myComputerPlayer;
  
  private Deck myDeck;

  private int myNumberOfDraws;
  
  /**
   * Constructor
   * @author Bryan Pearson
   */
  public PokerModel() 
  {
	  myNumberOfDraws = 0;
	  myDeck = new Deck();
	  beginGame();
  }

  /**
   * Initializes the players
   * @author Bryan Pearson
   */
  public void beginGame()
  {
	  myPlayer = new Player("Bryan");
	  myComputerPlayer = new Player("Michael");
  }

  /**
   * Try to take the top 10 cards from the deck and
   * and deal them to the players. Will fail if either 
   * player's hand is not empty or if the deck has fewer
   * than 10 cards.
   * @return true if the cards are dealt, false if otherwise.
   * @author Bryan Pearson
   */
  public boolean dealHands() 
  {
	  //If any of these booleans are true, return false
	  boolean deckTooSmall = myDeck.getCards().size() < 10;
	  boolean playerHandNotEmpty = myPlayer.getHand().getCards().size() != 0;
	  boolean computerHandNotEmpty = myComputerPlayer.getHand().getCards().size() != 0;
	  
	  if(deckTooSmall)
	  {
		  System.out.println("Cannot deal. Fewer than 10 cards in deck.");
		  return false;
	  }
	  else if(playerHandNotEmpty || computerHandNotEmpty)
	  {
		  System.out.println("Cannot deal. One or more hands are not empty");
		  return false;
	  }
	  
	  /*
	   * Run a loop that takes 10 cards from the
	   * deck and assigns them to the player or
	   * computer player's hands.
	   */
	  for(int i = 0; i < 10; i++)
	  {
		  Card currentCard = myDeck.deal();
		  int playerChoice = i % 2;
		  
		  //If playerChoice is 0, deal to the player
		  if(playerChoice == 0)
		  {
			  myPlayer.getHand().addCard(currentCard);
		  }
		  
		  //If playerChoice is 1, deal to the computer
		  else
		  {
			  myComputerPlayer.getHand().addCard(currentCard);
		  }
	  }
	  
	  return true;
  }

  
  public void playGame() 
  {
	  
  }

 

  public boolean enterPlayers() 
  {
	  return false;
  }
  
  /*
   * ************************
   * 
   * GETTERS AND SETTERS
   * 
   * ************************
   */
  
  public Deck getDeck()
  {
	  return myDeck;
  }
  
  public int getNumberOfDraws()
  {
	  return myNumberOfDraws;
  }
  
  public Player getPlayer()
  {
	  return myPlayer;
  }
  
  public Player getComputerPlayer()
  {
	  return myComputerPlayer;
  }

}