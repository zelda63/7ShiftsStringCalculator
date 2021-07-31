package StringCal7Shifts;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class bonusReq1Test {

	@Test
	public void test() {
		StringCal stringCal = new StringCal();
	    int output = stringCal.Add("2,1001");
	    assertEquals(2, output);
	}

}
