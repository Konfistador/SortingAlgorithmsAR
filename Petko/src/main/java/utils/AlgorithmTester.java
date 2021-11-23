package utils;

import algorithms.Algorithm;

import javax.management.RuntimeOperationsException;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.Random;

public class AlgorithmTester {
    Random randomizer = new Random();
    Algorithm sorter;
    boolean printRequired;
    int[] collectionForSorting;

    public AlgorithmTester(){
        this(false);
    }
    public AlgorithmTester(boolean printRequired){
        this.printRequired = printRequired;
    }


    public AnalysisReport executeTest(int sizeOfCollection) {
        if (Objects.isNull(sorter)) throw new IllegalArgumentException("Sorter required, before starting the Analysis");

        this.collectionForSorting = generateArray(randomizer, sizeOfCollection);

        if(this.printRequired) {
            System.out.println("Collection prior sorting: ");
            printArr(collectionForSorting);
        }

        Instant startMoment =  Instant.now();
        sorter.execute(collectionForSorting);
        Instant end = Instant.now();

        if(this.printRequired){
            System.out.println("Collection after sorting: ");
            printArr(collectionForSorting);
        }
        return createReport(sorter.getClass(), Duration.between(startMoment,end), sizeOfCollection);
    }

    public AnalysisReport executeTest(Algorithm sorter, int sizeOfCollection) {
        setSorter(sorter);
        return this.executeTest(sizeOfCollection);
    }

    private int[] generateArray(Random randomizer, int sizeOfArray) {
        int[] inputArray = new int[sizeOfArray];

        for (int i = 0; i < inputArray.length; i++) {
            inputArray[i] = randomizer.nextInt();
        }
        return inputArray;
    }

    public void printArr(int[] inputArray) {
        System.out.println("[");
        for (int i = 0; i < inputArray.length; i++) {
            System.out.println("    " + inputArray[i]);
        }
        System.out.println("]");
    }

    public void setSorter(Algorithm sorter) {
        this.sorter = sorter;
    }

    public AnalysisReport createReport(Class sorterUsed, Duration timeComplexity, int sizeOfCollection){
        return new AnalysisReport(sorterUsed, timeComplexity, sizeOfCollection);
    }

    public void setPrintRequired(boolean printRequired) {
        this.printRequired = printRequired;
    }
}
