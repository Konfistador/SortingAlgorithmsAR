package algorithms;

public class SelectionSort implements Algorithm{
    @Override
    public void execute(char[] inputCollection) {
        sort(inputCollection);
    }


    void sort(char[] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j =i+1; j<arr.length; j++)
            {
                if(arr[i] > arr[j])
                {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }
}
