import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.Test;

import com.rentaladda.rent.controller.Arithmetic;

@RunWith(Parameterized.class)
public class ArithmeticTest {
	
	private int firstNumber;
	private int secondNumber;
	private int expectedResult;
	private Arithmetic arithmetic;
	
	public ArithmeticTest(int firstNumber,int secondNumber,int expectedResult) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		this.expectedResult = expectedResult;
	}
	
	@Before
	public void initialize() {
		arithmetic = new Arithmetic();
	}
	
	@SuppressWarnings("rawtypes")
	@Parameterized.Parameters
	public static Collection input() {
		return Arrays.asList(new Object[][] {{1,2,3},{5,5,10},{25,25,50},{9,9,18}});
	}
	
	@Test
	public void testArithmeticTest() {
		System.out.println("Expected sum of numbers ==" +expectedResult);
		assertEquals(expectedResult, arithmetic.add(firstNumber, secondNumber));
	}

}
