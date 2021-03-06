package test.root;

import test.root.utils.JUnitPerfAdaptor;
import junit.framework.Test;

import com.clarkware.junitperf.TimedTest;

public class BucketSortPerformanceTest {

	public static Test performanceTest() {
		long maxTime = 1000;

		JUnitPerfAdaptor factory = new JUnitPerfAdaptor(BucketSortTest.class);
		Test testCase = factory.makeTestSuite();
		Test tiempoMaximoTest = new TimedTest(testCase, maxTime);
		return tiempoMaximoTest;
	}
	
	/**
	 * Running the execution of the test case according to the performance restrictions. 
	 */
	public static void main(String[] args) {
		junit.textui.TestRunner.run(performanceTest());
	}
}
