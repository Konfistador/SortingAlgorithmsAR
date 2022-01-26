package utils;

import java.lang.reflect.Type;
import java.time.Duration;

public class AnalysisReport {

    private Class sorterTested;
    private Duration timeComplexity;
    private int sizeOfCollection;
    private Type collectionType;

    public AnalysisReport(Class sorterTested, Duration timeComplexity, int sizeOfCollection, Type collectionType){
        this.sorterTested = sorterTested;
        this.timeComplexity = timeComplexity;
        this.sizeOfCollection = sizeOfCollection;
        this.collectionType = collectionType;
    }

    @Override
    public String toString() {
        return "AnalysisReport{" +
                "sorterTested=" + sorterTested +
                ", timeComplexity=" + timeComplexity +
                ", sizeOfCollection=" + sizeOfCollection +
                ", collectionType=" + collectionType +
                '}';
    }

    public Class getSorterTested() {
        return sorterTested;
    }

    public Duration getTimeComplexity() {
        return timeComplexity;
    }

    public int getSizeOfCollection() {
        return sizeOfCollection;
    }

    public Type getCollectionType() {
        return collectionType;
    }
}
