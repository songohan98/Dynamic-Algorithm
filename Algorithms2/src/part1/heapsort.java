package part1;

public class heapsort {
    public void heapSort(int a[],int counter1[]) {
        int n = a.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            sink(a, n, i,counter1);
        for (int i = n - 1; i >= 0; i--) {
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            counter1[0] += 1;

            sink(a, i, 0,counter1);
        }
    }

    void sink(int a[], int n, int i,int counter1[]) {
        int maxValue = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

        if (l < n && a[l] > a[maxValue]){
            maxValue = l;
            counter1[0] += 1;
        }

        if (r < n && a[r] > a[maxValue])
        {
            maxValue = r;
            counter1[0] += 1;
        }

        if (maxValue != i) {
            int swap = a[i];
            a[i] = a[maxValue];
            a[maxValue] = swap;
            counter1[0] += 1;

            sink(a, n, maxValue,counter1);
        }
    }


}