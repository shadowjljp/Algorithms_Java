package comparable_comparator;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)  //initailize only once per class
@DisplayName("When running MathUtils")
class MathTest {
	 MathUtils math;
	 TestInfo testInfo;  //dependency injection
	 TestReporter testReporter;
	@BeforeEach    //if @BeforeAll then it has to be static because Junit create new instance (of math in this example)
	 void init(TestInfo testInfo,TestReporter testReporter) {	//for every test method
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		math = new MathUtils();
		testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());
	}
	@BeforeAll  //has to be static
	 static void beforeAllInit() {
		System.out.println("This needs to run before all");
	}
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up....");
	}
	@Test
	@DisplayName("Testing add method")
	void test() {
		
		int expected=2;
		int actual = math.add(1, 1);
		assertEquals(expected,actual,"Suppose to add 2 number together ");
	}
	
	@Nested
	@DisplayName("add method")
	@Tag("Math")
	class AddTest{
		@Test
		@DisplayName("when adding 2 positive numbers")
		void testAddPositive() {
			assertEquals(2,math.add(1, 1),"should returns the right sum");
		}
		@Test
		@DisplayName("when adding 2 negative numbers")
		void testAddNegative() {
			int expected = -2;
			int actual = math.add(-1, -1);
			assertEquals(expected,actual,() -> "should returns sum "+expected+" but return "+actual); 
			//Using lambda to make Strings shown only when the test is failed.
		}
	}
	
	@Tag("Circle")
	@RepeatedTest(3)
	void testComputeCircleRadius(RepetitionInfo repetitionInfo ) {
		if(repetitionInfo.getCurrentRepetition()==1) {
			System.out.println("This is first time.");
		}
		assertEquals(314.1592653589793,math.computeCircleArea(10),"Should return circle area");
	}
	
	@Test
	@DisplayName("multiple method")
	@Tag("Math")
	void testMultiply() {
		testReporter.publishEntry("Running "+testInfo.getDisplayName()+" with tags "+testInfo.getTags());
		assertAll(
				() ->assertEquals(4,math.multiply(2, 2)),
				() -> assertEquals(0,math.multiply(2, 0)),
				() -> assertEquals(-2,math.multiply(2, -1))
				);
	}
	

	//@EnabledOnOs(OS.LINUX)  //if not on linux then this method is not tested.
	@Test
	@Tag("Math")
	void testDivide() {
		boolean isServerUp = false;
		assumeTrue(isServerUp);  //like server is on or not to control whether to test this method or not
		assertThrows(ArithmeticException.class, () ->math.divide(1,0),"divide by zero should throw.");
		//Test methods throw exception as it intended. Failed if there is no exception or wrong type of exception.
	}
	
	@Test
	@Disabled	//Not test this method
	@DisplayName("TDD method. Should not run")
	void testDisabled() {
		fail("This test should be disabled");
	}
	
}
