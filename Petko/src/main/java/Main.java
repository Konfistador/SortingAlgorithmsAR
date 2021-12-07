import algorithms.*;
import utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        AlgorithmTester tester = new AlgorithmTester(false);
        ReportWizard reportWizard = new ReportWizard();
        List<AnalysisReport> reports = new ArrayList<>();

        //reports.addAll(testRun(AlgorithmTester.SorterType.QUICKSORT, tester));
        //reports.addAll(testRun(AlgorithmTester.SorterType.HEAPSORT, tester));
        //reports.addAll(testRun(AlgorithmTester.SorterType.SELECTIONSORT, tester));
       // reports.addAll(testRun(AlgorithmTester.SorterType.BUBBLESORT, tester));
       // reports.addAll(testRun(AlgorithmTester.SorterType.BOGOSORT, tester));
       reports.add(tester.executeTest(AlgorithmTester.SorterType.SELECTIONSORT, AlgorithmTester.CollectionSize.SPACIOUS));
       reports.add(tester.executeTest(AlgorithmTester.SorterType.QUICKSORT, AlgorithmTester.CollectionSize.LARGE));
        reportWizard.saveReports(reports);

    }

    public static List<AnalysisReport> testRun(AlgorithmTester.SorterType sorterForTesting, AlgorithmTester tester){
        var returnableList = new ArrayList<AnalysisReport>();
        var allSizeValues = AlgorithmTester.CollectionSize.values();

        for(int i = 0; i < allSizeValues.length; i++){
            returnableList.add(tester.executeTest(sorterForTesting,allSizeValues[i]));
        }
        return returnableList;
    }
}
