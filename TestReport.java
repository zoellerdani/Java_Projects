import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedWriter;
import java.awt.Desktop;

public class TestReport implements TestReporter{

    File file;
    private int testNum;
    private int pass = 0;
    private int fail = 0;
    private int ex = 0;
    public TestReport(File f,int num){
        file = f;
        testNum = num;
    }

    @Override
    public void generateHtml(List<TestResult> passed, List<TestResult> failed, List<TestResult> exception) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            //This generates the header at the top of the page
            bw.write("<html><head><body><style>.rectangle{height:200px;width:800px;background-color:blue;}" + 
            "</style></body></head><center><div class=\"rectangle\"><p><style> .rectangle p{font-size:60px;" +
            " padding:60px; text-shadow:-1px -1px 0 white,1px -1px 0 white,-1px 1px 0 white,1px 1px 0 white;}>" +
            "</style>&#128507;<b>CS2 Final Project<b>&#128507;</p></div></center><style>.whitespace{height:20px" +
            ";width:800px;background-color:##F0F0F0;padding:20px;}</style><center><div class=\"whitespace\"></div");


            //This generates a table 
            bw.write("<html><title>Final Project</title><style>th, td{padding: 10px;} table{width: 800px;}</style>" +
                "<body bgcolor=\"#F0F0F0\"><table border=\"2\"><thead>" + 
                "<tr bgcolor=\"white\"><td>Test Result</td bgcolor=\"white\"><td>Message</td>" +
                "</tr></thead><tbody>");

            for(TestResult t : passed ) {
                //This adds a row with a passed result and its message to the table
                bw.write(" <tr bgcolor=\"#5FFF33\">" + "<td>" + t.result + "  &#128512;"+ "<td>" + t.message + "</tr>");
                pass++;
            }
            for(TestResult t : failed){ 
                //This adds a row with a failed result and its message to the table
                bw.write(" <tr bgcolor=\"yellow\">" + "<td>" + t.result + "  &#128544;" + "<td>" + t.message + "</tr>");
                fail++;
            }
            for(TestResult t : exception){
                //This adds a row with a unexpected exception and its message to the table
                bw.write(" <tr bgcolor=\"red\">" + "<td>" + t.result + "  &#128557;" + "<td>" + t.message + "</tr>");
                ex++;
            }
            //This ends the table
            bw.write("</tbody></table></body></html>");

            //This writes a sentence about the number of passed, failed, and unexpected excetion tests
            bw.write("<html><body><center><p style=\"font-size:24px\"> There were " + testNum + 
            " tests run. Of these tests, " + pass + " tests passed, " + fail + " tests failed, and " +
            ex + " tests threw an unexpected exception. </p></center></body>");

            bw.close();

            //Show the html in the browser
            Desktop.getDesktop().browse(file.toURI());
        }
        catch(IOException a){

        }
    }
}