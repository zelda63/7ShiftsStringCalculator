package StringCal7Shifts;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class requirement4Test {

	@Test
	public void test() {
		 StringCal stringCal = new StringCal();
		    int output = stringCal.Add("//@\\n2@-3@8");
		    assertEquals(10, output);
	}
	
						//Expected to throw an exception and show list of negative numbers

}
