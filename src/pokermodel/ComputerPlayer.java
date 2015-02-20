package pokermodel;

public class ComputerPlayer extends Player 
{

  public static final int RANDOM_ALGORITHM = 1;

  public static final int SMART_ALGORITHM = 2;

  public ComputerPlayer(String name) 
  {
	  super(name);
  }

  public boolean discard(int algorithm) 
  {
	  return false;
  }

}