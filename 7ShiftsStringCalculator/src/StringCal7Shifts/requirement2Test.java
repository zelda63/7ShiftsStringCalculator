package StringCal7Shifts;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class requirement2Test {

	@Test
	public void test() {
		 StringCal stringCal = new StringCal();
		    int output = stringCal.Add("1,\\n2,4");
		    assertEquals(7, output);
	}

}
