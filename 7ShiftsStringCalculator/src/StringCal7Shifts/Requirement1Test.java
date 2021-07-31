package StringCal7Shifts;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Requirement1Test {

	@Test
	public void test() {
		StringCal stringCal = new StringCal();
	    int output = stringCal.Add("1,2,5");
	    assertEquals(8, output);
	}

}
