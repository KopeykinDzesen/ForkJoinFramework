import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static final int ARRAY_SIZE = 10_000_000;

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long startTime;
        long endTime;
        int[] array = createArray(ARRAY_SIZE);
        MergeSort mergeSort = new MergeSort(array, 0, ARRAY_SIZE - 1);

        startTime = System.currentTimeMillis();
        forkJoinPool.invoke(mergeSort);
        System.out.println("В массиве " + ARRAY_SIZE + " элементов. (шаг 100_000) :");
        endTime = System.currentTimeMillis();
        printArray(array);
        System.out.println("На сортировку понадобилось: " + (endTime-startTime) + " ms!");

    }

    private static int[] createArray(final int size){
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            array[i] = random.nextInt(900)+100;
        }
        return array;
    }

    private static void printArray(int[] array){
        int size = array.length;
        for (int i = 0; i < size; i += 100_000){
            if(i%1000_000 == 0) {
                System.out.println();
//                System.out.print(i + "-" + (i+1000_000) + ":\t");
            }
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.println();
    }
}


