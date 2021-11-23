import algorithms.*;
import utils.AlgorithmTester;

public class Main {

    public static void main(String[] args) {
        AlgorithmTester tester = new AlgorithmTester(true);
        tester.setSorter(new BubbleSort());
        System.out.println(tester.executeTest(300));
    }
}
