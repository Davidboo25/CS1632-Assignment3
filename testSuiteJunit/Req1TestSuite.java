import junit.framework.Test;
import junit.framework.TestSuite;

public class Req1TestSuite {

  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(Testplan.class);
	suite.addTestSuite(Cathy3CathyPictureTest.class);
	suite.addTestSuite(CathyNavLinkTest.class);
	suite.addTestSuite(Cathy3ElementTest.class);
	suite.addTestSuite(Fact100Test.class);
	suite.addTestSuite(CathyNavDisplayTest.class);
	suite.addTestSuite(Factorial1Test.class);
	suite.addTestSuite(Factorial2Test.class);
	suite.addTestSuite(Factorial50Test.class);
	suite.addTestSuite(Factorial99Test.class);
	suite.addTestSuite(Factorial101Test.class);
	suite.addTestSuite(FactorialDecimalTest.class);
	suite.addTestSuite(FactorialEditable.class);
	suite.addTestSuite(FactorialNavDisplayTest.class);
	suite.addTestSuite(FactorialNavLinkTest.class);
	suite.addTestSuite(FactorialNeg100Test.class);
	suite.addTestSuite(FactorialStringTest.class);
	suite.addTestSuite(Fib2Test.class);
	suite.addTestSuite(Fib50Test.class);
	suite.addTestSuite(Fib99Test.class);
	suite.addTestSuite(Fib100Test.class);
	suite.addTestSuite(Fib101Test.class);
	suite.addTestSuite(FibDecimalTest.class);
	suite.addTestSuite(FibEditable.class);
	suite.addTestSuite(FibNavDisplayTest.class);
	suite.addTestSuite(FibNavLinkTEst.class);
	suite.addTestSuite(FibNeg100Test.class);
	suite.addTestSuite(FibOneTest.class);
	suite.addTestSuite(FibStringTest.class);
	suite.addTestSuite(HelloBaseDisplayTest.class);
	suite.addTestSuite(HelloDecimalDisplayTest.class);
	suite.addTestSuite(HelloIntDisplayTest.class);
	suite.addTestSuite(HelloNavDisplayTest.class);
	suite.addTestSuite(HelloNavLinkTest.class);
	suite.addTestSuite(HelloStringDisplayTest.class);
	suite.addTestSuite(HomepageNavDisplayTest.class);
	suite.addTestSuite(HomepageNavLinkTest.class);
	suite.addTestSuite(Testplan.class);
    return suite;
  }

  public static void main(String[] args) {
    junit.textui.TestRunner.run(suite());
  }
}
