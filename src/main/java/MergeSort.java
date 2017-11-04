import java.util.concurrent.RecursiveAction;

public class MergeSort extends RecursiveAction {
    private int[] array;
    private int left;
    private int right;

    public MergeSort(int[] array, int left, int right) {
        this.array = array;
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if (left < right) {
            int mid = (left + right) / 2;
            RecursiveAction leftSort = new MergeSort(array, left, mid);
            RecursiveAction rightSort = new MergeSort(array, mid + 1, right);
            invokeAll(leftSort, rightSort);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int x = left;
        int y = mid + 1;
        int z = 0;
        while (x <= mid && y <= right) {
            if (array[x] <= array[y]) {
                temp[z] = array[x];
                x++;
                z++;
            } else {
                temp[z] = array[y];
                y++;
                z++;
            }
        }
        while (x <= mid) {
            temp[z++] = array[x++];
        }
        while (y <= right) {
            temp[z++] = array[y++];
        }
        for (z = 0; z < temp.length; z++) {
            array[left + z] = temp[z];
        }
    }
}
