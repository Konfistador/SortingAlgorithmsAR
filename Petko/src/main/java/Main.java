import algorithms.*;
import utils.AlgorithmTester;
import utils.ReportWizard;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AlgorithmTester tester = new AlgorithmTester(true);
        ReportWizard reportWizard = new ReportWizard();

        tester.setSorter(new BubbleSort());
        var results = tester.executeTest(300);
        System.out.println(results);
        reportWizard.saveReport(results);
    }
}
