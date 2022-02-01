package algorithms;


public class QuickSort implements Algorithm {

    @Override
    public void execute(char[] inputCollection) {
        quickSort(inputCollection,0,inputCollection.length -1);
    }

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(char[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {


            if (arr[j] < pivot) {


                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }


    static void quickSort(char[] arr, int low, int high) {
        if (low < high) {


            int pi = partition(arr, low, high);


            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

}
