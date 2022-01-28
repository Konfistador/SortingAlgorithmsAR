package utils;

import java.lang.reflect.Type;
import java.time.Duration;

public class AnalysisReport {

    private Class sorterTested;
    private Duration timeComplexity;
    private int sizeOfCollection;
    private Type collectionType;
    private long RAMUsed;

    public AnalysisReport(Class sorterTested, Duration timeComplexity, int sizeOfCollection, Type collectionType, long RAMUsed){
        this.sorterTested = sorterTested;
        this.timeComplexity = timeComplexity;
        this.sizeOfCollection = sizeOfCollection;
        this.collectionType = collectionType;
        this.RAMUsed = RAMUsed;
    }

    @Override
    public String toString() {
        return "AnalysisReport{" +
                "sorterTested=" + sorterTested +
                ", timeComplexity=" + timeComplexity +
                ", sizeOfCollection=" + sizeOfCollection +
                ", collectionType=" + collectionType +
                ", RAMUsed" + RAMUsed +
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

    public long getRAMUsed() {return RAMUsed;}
}
