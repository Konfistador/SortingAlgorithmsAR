package utils;

import algorithms.*;

import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.Random;

public class AlgorithmTester {
    Random randomizer = new Random();
    Algorithm sorter;
    boolean printRequired;
    int[] numericalCollectionForSorting;
    char[]charCollectionForSorting;
    ArrayGenerator generator = new ArrayGenerator();

    public AlgorithmTester(boolean printRequired) {
        this.printRequired = printRequired;
    }


    public AnalysisReport executeTest(CollectionSize sizeOfCollection, Type collectionType) {
        if (Objects.isNull(sorter))
            throw new IllegalArgumentException("Sorter required, before starting the Experiment.");

        if(collectionType == int.class){
            this.numericalCollectionForSorting = generator.generateNumericalArray((int) sizeOfCollection.numeralExpression);
        }else if(collectionType == char.class){
            this.charCollectionForSorting = generator.generateCharacterArray((int)sizeOfCollection.numeralExpression);
        }


        if (this.printRequired) {
            System.out.println("Collection prior sorting: ");
            printArr(numericalCollectionForSorting);
        }

        Instant startMoment = Instant.now();
        sorter.execute(numericalCollectionForSorting);
        Instant end = Instant.now();

        if (this.printRequired) {
            System.out.println("Collection after sorting: ");
            printArr(numericalCollectionForSorting);
        }
        return createReport(sorter.getClass(), Duration.between(startMoment, end), (int) sizeOfCollection.numeralExpression, numericalCollectionForSorting.getClass().getComponentType());
    }

    public AnalysisReport executeTest(SorterType sorterSelected, CollectionSize collectionSize, Type collectionType) {
        setSorter(sorterSelected.sorter);
        return this.executeTest(collectionSize, collectionType);
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
        for (int j : inputArray) {
            System.out.println("    " + j);
        }
        System.out.println("]");
    }

    public void setSorter(Algorithm sorter) {
        this.sorter = sorter;
    }

    public AnalysisReport createReport(Class sorterUsed, Duration timeComplexity, int sizeOfCollection , Type collectionType) {
        return new AnalysisReport(sorterUsed, timeComplexity, sizeOfCollection, collectionType);
    }

    public enum CollectionSize {

        EXTRA_EXTRA_SMALL(1, Math.pow(2, 1)),
        EXTRA_SMALL(2, Math.pow(2, 2)),
        SMALL(3, Math.pow(2, 3)),
        MEDIUM_SMALL(4, Math.pow(2, 4)),
        MEDIUM(5, Math.pow(2, 5)),
        MEDIUM_LARGE(6, Math.pow(2, 6)),
        LARGE(7, Math.pow(2, 7)),
        EXTRA_LARGE(8, Math.pow(2, 8)),
        BROAD(9, Math.pow(2, 9)),
        EXTENSIVE(10, Math.pow(2, 10)),
        GIANT(11, Math.pow(2, 11)),
        GIGANTIC(12, Math.pow(2, 12)),
        SPACIOUS(13, Math.pow(2, 13)),
        IMMENSE(14, Math.pow(2, 14)),
        HYPER(15, Math.pow(2, 15)),
        JUMBO(16, Math.pow(2, 16)),
        COSMIC(17, Math.pow(2, 17)),
        ASTRONOMICAL(18, Math.pow(2, 18)),
        ENORMOUS(19, Math.pow(2, 19));


        public final int sizeChartPosition;
        public final double numeralExpression;

        CollectionSize(int sizeChartPosition, double pow) {
            this.numeralExpression = pow;
            this.sizeChartPosition = sizeChartPosition;
        }
    }

    public enum SorterType {
        BOGOSORT(new BogoSort()),
        BUBBLESORT(new BubbleSort()),
        HEAPSORT(new HeapSort()),
        QUICKSORT(new QuickSort()),
        SELECTIONSORT(new SelectionSort());

        public final Algorithm sorter;

        SorterType(Algorithm sorter) {
            this.sorter = sorter;
        }
    }

    static class ArrayGenerator {
        private Random randomizer = new Random();

        int[] generateNumericalArray(int sizeOfArray) {
            int[] inputArray = new int[sizeOfArray];

            for (int i = 0; i < inputArray.length; i++) {
                inputArray[i] = randomizer.nextInt();
            }
            return inputArray;
        }

        char[] generateCharacterArray(int sizeOfArray) {
            char[] outputArr = new char[sizeOfArray];

            for (int i = 0; i < outputArr.length; i++) {
                outputArr[i] = (char) (randomizer.nextInt(sizeOfArray) + 97);
            }
            return outputArr;
        }
    }
}
