import junit.framework.Test;
import junit.framework.TestSuite;

public class Req4TestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(FibOneTest.class);
		suite.addTestSuite(FibEditable.class);
		suite.addTestSuite(Fib100Test.class);
		suite.addTestSuite(Fib2Test.class);
		suite.addTestSuite(Fib99Test.class);
		suite.addTestSuite(Fib50Test.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
