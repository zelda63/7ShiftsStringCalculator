package StringCal7Shifts;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class requirement3Test {

	@Test
	public void test() {
		 StringCal stringCal = new StringCal();
		    int output = stringCal.Add("//@\\n2@3@8");
		    assertEquals(13, output);
	}

}
