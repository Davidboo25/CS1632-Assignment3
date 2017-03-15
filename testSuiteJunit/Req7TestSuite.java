import junit.framework.Test;
import junit.framework.TestSuite;

public class Req7TestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(HelloStringDisplayTest.class);
		suite.addTestSuite(HelloIntDisplayTest.class);
		suite.addTestSuite(HelloDecimalDisplayTest.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
