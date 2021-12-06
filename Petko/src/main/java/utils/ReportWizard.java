package utils;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWizard {

    File outputFile = new File("src/main/resources/analysisReport.csv");
    FileWriter fileWriter;
    CSVWriter csvWriter;

    public ReportWizard() throws IOException {
        fileWriter = new FileWriter(outputFile);
        csvWriter = new CSVWriter(fileWriter);

        String csvHeader[] = {"Sorter", "TimeComplexity", "CollectionSize"};
        csvWriter.writeNext(csvHeader);
    }
    public void saveReport(AnalysisReport reportToBeSaved) throws IOException {
        String[] dataRecord = {
                reportToBeSaved.getSorterTested().getSimpleName(),
                String.valueOf(reportToBeSaved.getTimeComplexity().toNanos()),
                String.valueOf(reportToBeSaved.getSizeOfCollection())
        };
        csvWriter.writeNext(dataRecord);
        csvWriter.close();
    }

    public void saveReports(List<AnalysisReport> reports) throws IOException{
        String[] dataRecord = new String[3];

        for(AnalysisReport report: reports){
            dataRecord[0] = report.getSorterTested().getSimpleName();
            dataRecord[1] = String.valueOf(report.getTimeComplexity().toNanos());
            dataRecord[2] = String.valueOf(report.getSizeOfCollection());

            csvWriter.writeNext(dataRecord);
        }
        csvWriter.close();
    }
}
