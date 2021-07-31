package StringCal7Shifts;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class bonusReq4Test {

	@Test
	public void test() {
		StringCal stringCal = new StringCal();
	    int output = stringCal.Add("//$$,@@@\\n1$$2@@@3");
	    assertEquals(6, output);
	}

}
