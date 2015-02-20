package pokertesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses
(
	{ 
		DeckTesting.class, 
		HandTesting.class, 
		PlayerTesting.class,
		PokerHandTesting.class, 
		PokerModelTesting.class 
	}
)
public class AllTests 
{

}
