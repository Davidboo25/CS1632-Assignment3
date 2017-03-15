import junit.framework.Test;
import junit.framework.TestSuite;

public class Req8TestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(Cathy3ElementTest.class);
		suite.addTestSuite(Cathy3CathyPictureTest.class);
		return suite;
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
