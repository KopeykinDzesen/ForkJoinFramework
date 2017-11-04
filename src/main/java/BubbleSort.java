public class BubbleSort {
    private int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
        sort();
    }

    private void sort(){
        for (int i = 0; i < array.length; i++){
            for (int j = i + 1; j < array.length; j++){
                if (array[j] < array[i]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public int[] getArray() {
        return array;
    }
}
