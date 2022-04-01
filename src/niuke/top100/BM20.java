package niuke.top100;

public class BM20 {
    int count;

    public int InversePairs(int[] array) {
        if (array.length < 2) {
            return 0;
        }
        int[] tempArr = new int[array.length];
        mergeSort(array, 0, array.length - 1, tempArr);
        return count;
    }

    private void mergeSort(int[] array, int left, int right, int[] tempArr) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid, tempArr);
            mergeSort(array, mid + 1, right, tempArr);
            merge(array, left, mid, right, tempArr);
        }
    }

    private void merge(int[] array, int left, int mid, int right, int[] tempArr) {
        int i = left;
        int j = mid + 1;
        int index = 0;
        while (i <= mid && j <= right) {
            if (array[i] <= array[j]) {
                tempArr[index++] = array[i++];
            } else {
                tempArr[index++] = array[j++];
                count += mid - i + 1;
                count %= 1000000007;
            }
        }
        while (i <= mid) {
            tempArr[index++] = array[i++];
        }
        while (j <= right) {
            tempArr[index++] = array[j++];
        }
        index = 0;
        i = left;
        while (i <= right) {
            array[i++] = tempArr[index++];
        }
    }
}
