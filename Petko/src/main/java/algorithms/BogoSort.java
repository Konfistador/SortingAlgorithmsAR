package algorithms;

import java.util.List;

public class BogoSort implements Algorithm{

    @Override
    public void execute(char[] inputCollection) {
        System.out.println("Not working.");
    }
//    @Override
//    public void execute(int[] inputCollection) {
//       bogoSort(inputCollection);
//    }

    void bogoSort(int[] a)
    {
        while (!isSorted(a))
            shuffle(a);

    }

    void shuffle(int[] a)
    {
        //System.out.println("Working");
        for (int i = 0; i < a.length; i++)
            swap(a, i, (int)(Math.random() * i));
    }
    void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    boolean isSorted(int[] a)
    {
        for (int i = 1; i < a.length; i++)
            if (a[i] < a[i - 1])
                return false;
        return true;
    }

}
