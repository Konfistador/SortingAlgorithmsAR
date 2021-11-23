package utils;

import java.time.Duration;

public class AnalysisReport {

    private Class sorterTested;
    private Duration timeComplexity;
    private int sizeOfCollection;


    public AnalysisReport(Class sorterTested, Duration timeComplexity, int sizeOfCollection){
        this.sorterTested = sorterTested;
        this.timeComplexity = timeComplexity;
        this.sizeOfCollection = sizeOfCollection;
    }

    @Override
    public String toString() {
        return "AnalysisReport{" +
                "sorterTested=" + sorterTested.getSimpleName() +
                ", timeComplexity=" + timeComplexity +
                ", sizeOfCollection=" + sizeOfCollection +
                '}';
    }
}
