package test.root.utils;

import junit.framework.JUnit4TestAdapter;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.clarkware.junitperf.TestFactory;

public class JUnitPerfAdaptor extends TestFactory {

	/** Adaptor class serving as a bridge between JUnit3 and JUnit4.  */
   private static class AdaptorClass extends TestCase {}

   /** Class containing the test case called in the performance test. */
   private Class<?> testClass;
   
   /**
    * Constructor by default
    * @param testClass. Class containing the test case called in the performance test.
    */
   public JUnitPerfAdaptor(Class<?> testClass) {
		super(AdaptorClass.class);
		this.testClass = testClass;
	}
	
   /**
    * Returns a test suite that knows how to execute a test class written in JUnit4 in JUnitPerf
    * @return testSuite
    */
   @Override
public TestSuite makeTestSuite() {
       JUnit4TestAdapter unit4TestAdapter = new JUnit4TestAdapter(this.testClass);
       TestSuite testSuite = new TestSuite("Adaptor");
       testSuite.addTest(unit4TestAdapter);
       return testSuite;
   }
}