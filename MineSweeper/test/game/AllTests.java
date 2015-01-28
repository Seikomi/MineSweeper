package game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ MineFieldTest.class, MineSweeperTest.class,
		RandomMineFieldTest.class })
public class AllTests {

}
