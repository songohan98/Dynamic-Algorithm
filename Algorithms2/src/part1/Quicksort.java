package part1;

public class Quicksort {
    void quicksort(int A[], int p, int r,int counter2[]) {
        if (p < r) {
            counter2[0] += 1;
            int q = partition(A, p, r, counter2);
            quicksort(A, p, q - 1,counter2);
            quicksort(A, q + 1, r,counter2);
        }

    }

    public int partition(int A[], int p, int r, int counter2[]) {
        int x = A[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (A[j] <= x) {
                i = i + 1;
                int a = A[i];
                int b = A[j];
                A[i] = b;
                A[j] = a;
                counter2[0] += 2;
            }
        }
        int c = A[i + 1];
        int d = A[r];
        A[i + 1] = d;
        A[r] = c;
        counter2[0] += 1;
        return i + 1;
    }



}
