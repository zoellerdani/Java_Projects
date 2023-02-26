/**
 * Tracks the results of a single test.
 * Tests may optionally report some message describing the test or the result.
 * Each test is marked as having passed, failed, or caused an unexpected exception.
 */
public class TestResult {

    // Constants for printing each type of test result
    public static final String PASSED = "PASSED";
    public static final String FAILED = "FAILED";
    public static final String EXCEPTION = "EXCEPTION";

    public String result;
    public String message;

    public TestResult(String r, String msg){
        result = r;
        message = msg;
    }

    /**
     * Create a TestResult for a passed test.  No message is provided.
     * @return TestResult for a passed test
     */
    public static TestResult createPassedResult() {
        TestResult t = new TestResult(PASSED,"");
        return t;
    }

    /**
     * Create a TestResult for a passed test. 
     * @param msg Message describing the test result
     * @return TestResult for a passed test
     */
    public static TestResult createPassedResult(String msg) {
        TestResult t = new TestResult(PASSED,msg);
        return t;
    }

    /**
     * Create a TestResult for a failed test.  No message is provided.
     * @return TestResult for a failed test
     */
    public static TestResult createFailedResult() {
        TestResult t = new TestResult(FAILED,"");
        return t;
    }

    /**
     * Create a TestResult for a failed test.
     * @param msg Message describing the test result
     * @return TestResult for a failed test
     */
    public static TestResult createFailedResult(String msg) {
        TestResult t = new TestResult(FAILED,msg);
        return t;
    }

    /**
     * Create a TestResult for a test with an unexpected exception.  No message is provided.
     * @return TestResult for an exception test
     */
    public static TestResult createExceptionResult() {
        TestResult t = new TestResult(EXCEPTION,"");
        return t;
    }

    /**
     * Create a TestResult for a test with an unexpected exception.  
     * @param msg  Message describing the test result
     * @return TestResult for an exception test
     */
    public static TestResult createExceptionResult(String msg) {
        TestResult t = new TestResult(EXCEPTION,msg);
        return t;
    }

    /**
     * Test for whether this is a passed test
     * @return true if this is a passed test
     */
    public boolean isPassed() {
        if(result.equals(PASSED)){
            return true;
        }
        return false;
    }

    /**
     * Test for whether this is a failed test
     * @return true if this is a failed test
     */
    public boolean isFailed() {
        if(result.equals(FAILED)){
            return true;
        }
        return false;
    }

    /**
     * Test for whether this is an exception test
     * @return true if this is an exception test
     */
    public boolean isException() {
        if(result.equals(EXCEPTION)){
            return true;
        }
        return false;
        
    }
}
