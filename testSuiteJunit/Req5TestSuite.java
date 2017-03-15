import junit.framework.Test;
import junit.framework.TestSuite;

public class Req5TestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(FibNeg100Test.class);
		suite.addTestSuite(Fib101Test.class);
		suite.addTestSuite(FibStringTest.class);
		suite.addTestSuite(FactorialNeg100Test.class);
		suite.addTestSuite(Factorial101Test.class);
		suite.addTestSuite(FactorialStringTest.class);
		suite.addTestSuite(FibDecimalTest.class);
		suite.addTestSuite(FactorialDecimalTest.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
