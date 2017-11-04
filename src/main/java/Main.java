import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    public static final int ARRAY_SIZE = 1_000_000;
    public static final int STEP_SIZE = ARRAY_SIZE/100;

    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long startTime;
        long endTime;
        int[] array = createArray(ARRAY_SIZE);
        MergeSort mergeSort = new MergeSort(array, 0, ARRAY_SIZE - 1);

        System.out.println("-------------------------------------------------------------------------------------");

        startTime = System.currentTimeMillis();
        forkJoinPool.invoke(mergeSort);
        endTime = System.currentTimeMillis();
        System.out.println("В массиве " + ARRAY_SIZE + " элементов. (шаг " + STEP_SIZE + ") :");
        printArray(array, STEP_SIZE);
        System.out.println("На сортировку с помощью ForkJoinFramework понадобилось: " + (endTime-startTime) + " ms!");

        System.out.println("-------------------------------------------------------------------------------------");

        int[] ints = createArray(ARRAY_SIZE);
        startTime = System.currentTimeMillis();
        BubbleSort bubbleSort = new BubbleSort(ints);
        endTime = System.currentTimeMillis();
        System.out.println("В массиве " + ARRAY_SIZE + " элементов. (шаг " + STEP_SIZE + ") :");
        printArray(bubbleSort.getArray(), STEP_SIZE);
        System.out.println("На сортировку с помощью Bubbl понадобилось: " + (endTime-startTime) + " ms!");

        System.out.println("-------------------------------------------------------------------------------------");

    }

    private static int[] createArray(final int size){
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            array[i] = random.nextInt(900)+100;
        }
        return array;
    }

    private static void printArray(int[] array, int step){
        int size = array.length;
        for (int i = 0; i < size; i += step){
            if(i%(step*10) == 0) {
                System.out.println();
//                System.out.print(i + "-" + (i+1000_000) + ":\t");
            }
            System.out.print(array[i] + ", ");
        }
        System.out.println();
        System.out.println();
    }
}


