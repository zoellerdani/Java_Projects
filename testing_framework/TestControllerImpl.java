import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class TestControllerImpl implements TestController{

    File file;
    int numTests;
    ArrayList<Entry> suite = new ArrayList<Entry>();//This stores the queue of tests to be run

    List<TestResult> passed = new ArrayList<TestResult>();//These will store the results of the test
    List<TestResult> failed = new ArrayList<TestResult>();
    List<TestResult> except = new ArrayList<TestResult>();


    /* The constructor function
    @param f, the html file for the results to be written to
    */
    public TestControllerImpl(String f){
        file = new File(f);
        numTests = 0;
    }

    @Override
    public void addTest(Test test, double rank) {
        Entry e = new Entry(test,rank);
        suite.add(e);
        numTests++;
    }

    @Override
    public void runTests() {
        sortArray();
        for(int i = 0; i<suite.size(); i++){
            if(suite.get(i)!=null){
                Test curTest = (Test) suite.get(i).key;
                TestResult r = curTest.runTest();
                if(r.isPassed()){
                    passed.add(r);
                }
                else if(r.isFailed()){
                    failed.add(r);
                }
                else{
                    except.add(r);
                }
            }
        }
        
    }


    @Override
    public void createReport() {
        TestReport report = new TestReport(file,numTests);
        report.generateHtml(passed, failed, except);
    }
    

    /* A function to swap two entries in an array
    @param i, the first index of the entry to be sawpped
    @param j, the index of the other entry to be swapped
    @param array, the array in which items will be swapped
    */
    private void swap(int i, int j){//this function is O(1)
        Entry tmp = suite.get(i);
        suite.set(i,suite.get(j));
        suite.set(j,tmp);
    }


    /* A function to sort an array 
    @param arr, the array to be sorted
    @return Entry[], the sorted array
    */
    private void sortArray(){//selection sort, based on what we did in class 
        for(int i = 0; i < suite.size(); i++){
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int j = i; j < suite.size(); j++){
                Double curD = (Double) suite.get(j).value;
                int curI = curD.intValue();
                if(curI < min){
                min = curI;
                minIdx = j;
                }
            }
            swap(i, minIdx);
        }
    }
    

}