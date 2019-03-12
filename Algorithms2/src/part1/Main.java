package part1;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Main {

    static void getCounter(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; ++i)
            System.out.print(a[i]);
    }

    static int[] setRandomArray(int size) {
        int min = 0;
        int max = size;
        Random ran = new Random();
        int a[] = new int[size];
        for (int i = 0; i < size; i++) {
            int numb = min + ran.nextInt(max);
            a[i] = numb;
        }
        return a;
    }

    static void shuffleArray(int[][] arr,int indexlist)
    {
        int ar[] = arr[indexlist];
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }



    public static void main(String args[]) {

        String run[] = {"run1", "run2", "run3", "run4", "run5", "run6", "run7", "run8", "run9", "run10"};
        int size[] = {100_000, 250_000, 500_000, 750_000, 1_000_000, 1_250_000, 5_000_000, 7_500_000, 10_000_000};

        int fixedArray[][]= new int[9][];
        for(int k = 0; k<9;k++)
        {
             fixedArray[k] = setRandomArray(size[k]);
        }
//        System.out.println(fixedArray.length);//test code
//        for(int[] values: fixedArray)//test code
//        System.out.println(values.length);//test code

        for (int j = 0; j < 10; j++) {

            for (int i = 0; i < 9; i++) {
                shuffleArray(fixedArray,i);

                int a[] = fixedArray[i];

                int b[] = a.clone();

                int c[] = a.clone();


                System.out.println(" Heapsort: " + size[i] + run[j]);

                int CompExch2[] = {0};

                heapsort ob2 = new heapsort();
                long startTime2 = System.nanoTime();
                ob2.heapSort(b, CompExch2);
                long endTime2 = System.nanoTime();

                long totalTime2 = endTime2 - startTime2;

                System.out.print(" Compares and Exchanges: ");
                getCounter(CompExch2);
                System.out.print("  Time taken: ");
                System.out.println(totalTime2);


                System.out.println(" Quicksort: " + size[i] + " "+ run[j]);
                int n = a.length;
                int CompExch[] = {0};
                Quicksort ob = new Quicksort();
                long startTime = System.nanoTime();
                ob.quicksort(c, 0, n - 1, CompExch);
                long endTime = System.nanoTime();

                long totalTime = endTime - startTime;

                System.out.print(" Compares and exchanges: ");
                getCounter(CompExch);
                System.out.print(" Time taken: ");
                System.out.println(totalTime);


            }
        }
    }
}