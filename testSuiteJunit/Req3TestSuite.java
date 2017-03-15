import junit.framework.Test;
import junit.framework.TestSuite;

public class Req3TestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(FactorialEditable.class);
		suite.addTestSuite(Fact100Test.class);
		suite.addTestSuite(Factorial1Test.class);
		suite.addTestSuite(Factorial2Test.class);
		suite.addTestSuite(Factorial50Test.class);
		suite.addTestSuite(Factorial99Test.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
