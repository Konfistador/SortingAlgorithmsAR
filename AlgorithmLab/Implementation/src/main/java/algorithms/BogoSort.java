package algorithms;

public class BogoSort implements TestableAlgorithm
{
// TODO: Apply the changes on the Class Diagram

    int[] collectionForSorting;

    @Override
    public void feedData(int[] collectionInput) {
        if(collectionInput.length < 1) throw new IllegalArgumentException("Sorting Algorithm cannot be fed with empty collection");
        this.collectionForSorting = collectionInput;
    }

    @Override
    public void execude() {
        while(!isSorted()){
            shuffle();
        }
    }

    @Override
    public int[] getOutputCollection() {
        return collectionForSorting;
    }

    private boolean isSorted() {
        for(int x = 0; x < collectionForSorting.length - 1; ++x) {
            if(collectionForSorting[x] > collectionForSorting[x+1]) {
                return false;
            }
        }
        return true;
    }
    private void shuffle(){
        for(int x = 0; x < collectionForSorting.length; ++x) {
            int index1 = (int) (Math.random() * collectionForSorting.length),
                    index2 = (int) (Math.random() * collectionForSorting.length);
            int a = collectionForSorting[index1];
            collectionForSorting[index1] = collectionForSorting[index2];
            collectionForSorting[index2] = a;
        }
    }
}
