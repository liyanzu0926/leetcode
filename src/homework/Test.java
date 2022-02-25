package homework;

public class Test {
    public static void main(String[] args) {
        int[] a = {2, 1, 3, 5, 4};
        System.out.println(quickSort(a, 0, 4, 3));
    }

    public static int quickSort(int a[], int low, int high, int k) {
        int i = low, j = high;
        int pivot;
        if (low > high) {
            return -1;
        }
        pivot = a[low];
        while (i < j) {
            while (i < j && a[j] >= pivot) j--;
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] < pivot) i++;
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = pivot;
        if (i == k - 1) {
            return a[i];
        } else if (i < k - 1) {
            return quickSort(a, i + 1, high, k);
        } else {
            return quickSort(a, low, i - 1, k);
        }
    }
}
