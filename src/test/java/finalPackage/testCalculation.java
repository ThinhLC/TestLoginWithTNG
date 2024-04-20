package finalPackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import finalPackage.Calculation;
public class testCalculation {
	
	@Test
	public void testAddition() {
		Calculation cal = new Calculation();
		Assert.assertEquals(4, cal.add(2, 2));
	}
	
	
}
