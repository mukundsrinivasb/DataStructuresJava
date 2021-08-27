package Lab_3_Task1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MarkCalculatorTest {
	/**
	 * Return a list of parameters which are different implementation of 
	 * interface {@linkplain MarkCalculator}. 
	 * Do NOT Modify this part
	*/
	@Parameters
    public static Iterable<? extends Object> getImplementations() {
        return Arrays.asList(
                new MarkCalculator0(),
                new MarkCalculator1(),
                new MarkCalculator2(),
                new MarkCalculator3(),
                new MarkCalculator4(),
                new MarkCalculator5(),
                new MarkCalculator6(),
                new MarkCalculator7(),
                new MarkCalculator8(),
                new MarkCalculator9(),
				new MarkCalculator10(),
				new MarkCalculator11(),
				new MarkCalculator12(),
				new MarkCalculator13(),
				new MarkCalculator14(),
				new MarkCalculator15()
        );
    }

	@Parameter
	public MarkCalculator calculator;

	/*
	 * Hint: Many students get stuck in this lab. Ensure you create out-of-bounds,
	 * 	tests which expect an exception. Furthermore, note that if the first,
	 * 	statement in such a test results in an exception, then later statements
	 * 	will not be executed.
	 */
	// ########## YOUR CODE STARTS HERE ##########
	
	@Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
	public void testException() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(-1, 5, -1, -1, true, false);
		this.calculator.calculateMark(1,11,11,50,true,true);
		this.calculator.calculateMark(1,16,16,50,true,true);
	}

	@Test(timeout = 1000, expected = ComponentOutOfRangeException.class)
	public void testRudimentaryLimits() throws ComponentOutOfRangeException {
		this.calculator.calculateMark(11, 11, 11, 101, true, true);
	}

	@Test(timeout = 1000)
	public void testGradeHD() throws ComponentOutOfRangeException{
		//final exam marks > weighted marks
		assertEquals(new MarkGrade(81,Grade.HD),this.calculator.calculateMark(9,10,8,75,true,true));
		assertEquals(new MarkGrade(100,Grade.HD),this.calculator.calculateMark(8,4,4,100,true,true));
		assertEquals(new MarkGrade(90,Grade.HD),this.calculator.calculateMark(9,10,10,85,true,false));
		//final exam marks < weighted marks
		assertEquals(new MarkGrade(95,Grade.HD),this.calculator.calculateMark(10,10,10,92,true,true));
		assertEquals(new MarkGrade(86,Grade.HD),this.calculator.calculateMark(8,10,10,80,true,true));



		assertEquals(new MarkGrade(85,Grade.HD),this.calculator.calculateMark(8,10,10,79,true,true));

	}


	@Test(timeout = 1000)
	public void testGradeD() throws ComponentOutOfRangeException{
		//final exam marks > weighted marks
		assertEquals(new MarkGrade(75,Grade.D),this.calculator.calculateMark(4,8,6,75,true,true));
		assertEquals(new MarkGrade(70,Grade.D),this.calculator.calculateMark(4,8,6,75,true,false));
		assertEquals(new MarkGrade(75,Grade.D),this.calculator.calculateMark(3,6,4,95,true,false));
		assertEquals(new MarkGrade(75,Grade.D),this.calculator.calculateMark(9,6,4,85,true,false));
		//final exam marks < weighted marks
		assertEquals(new MarkGrade(76,Grade.D),this.calculator.calculateMark(10,6,8,75,true,true));
	}

	@Test(timeout = 1000)
	public void testGradeC() throws ComponentOutOfRangeException{
		//final exam marks > weighted marks
		assertEquals(new MarkGrade(65,Grade.C),this.calculator.calculateMark(6,4,6,65,true,true));
		assertEquals(new MarkGrade(65,Grade.C),this.calculator.calculateMark(6,4,6,65,true,true));
		assertEquals(new MarkGrade(65,Grade.C),this.calculator.calculateMark(2,6,8,70,true,false));
		//final exam marks < weighted marks
		assertEquals(new MarkGrade(69,Grade.C),this.calculator.calculateMark(6,10,8,60,true,true));
	}

	@Test(timeout = 1000)
	public void testGradeP() throws ComponentOutOfRangeException{
		//final exam marks > weighted marks
		assertEquals(new MarkGrade(55,Grade.P),this.calculator.calculateMark(8,4,2,55,true,true));
		assertEquals(new MarkGrade(55,Grade.P),this.calculator.calculateMark(4,2,6,65,true,false));
		//final exam marks < weighted marks
		assertEquals(new MarkGrade(50,Grade.P),this.calculator.calculateMark(5,6,6,45,true,true));
		//spill over from PX
		//final exam marks > weighted marks
		assertEquals(new MarkGrade(50,Grade.P),this.calculator.calculateMark(4,8,2,50,true,true));
		//final exam marks < weighted marks
		assertEquals(new MarkGrade(59,Grade.P),this.calculator.calculateMark(8,8,8,45,true,true));

	}

	@Test(timeout = 1000)
	public void testGradePX() throws ComponentOutOfRangeException{
		//final exam marks > weighted marks
		assertEquals(new MarkGrade(45,Grade.PX),this.calculator.calculateMark(1,4,4,45,true,true));
		//final exam marks < weighted marks
		assertEquals(new MarkGrade(48,Grade.PX),this.calculator.calculateMark(9,2,6,45,true,true));
		//Spill over from N
		//final exam marks > weighted marks
		assertEquals(new MarkGrade(45,Grade.PX),this.calculator.calculateMark(2,6,4,45,true,true));
		//final exam marks < weighted marks
		assertEquals(new MarkGrade(49,Grade.PX),this.calculator.calculateMark(0,0,0,49,true,true));
		assertEquals(new MarkGrade(45,Grade.PX),this.calculator.calculateMark(6,6,4,40,true,false));
	}

	@Test(timeout = 1000)
	public void testGradeN() throws ComponentOutOfRangeException{
		//final exam marks > weighted marks
		assertEquals(new MarkGrade(40,Grade.N),this.calculator.calculateMark(3,2,2,40,true,true));
		assertEquals(new MarkGrade(25,Grade.N),this.calculator.calculateMark(2,2,0,25,true,true));
		assertEquals(new MarkGrade(40,Grade.N),this.calculator.calculateMark(0,0,0,40,true,true));
		assertEquals(new MarkGrade(40,Grade.N),this.calculator.calculateMark(1,6,2,45,true,false));
		assertEquals(new MarkGrade(24,Grade.N),this.calculator.calculateMark(0,0,0,40,true,false));
		//final exam marks < weighted marks
		assertEquals(new MarkGrade(25,Grade.N),this.calculator.calculateMark(7,2,2,20,true,true));

	}

	@Test(timeout = 1000)
	public void testGradeNCN() throws ComponentOutOfRangeException{
		//Unattended final exam
		assertEquals(new MarkGrade(null,Grade.NCN),this.calculator.calculateMark(3,2,2,0,false,true));
	}


	// ########## YOUR CODE ENDS HERE ##########
}
