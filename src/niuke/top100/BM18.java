package niuke.top100;

class BM18_1 {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0 || array[0] == null || array[0].length == 0) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (binarySearch(array[i], 0, array[i].length - 1, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] array, int left, int right, int target) {
        if (left > right) {
            return false;
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

/**
 * 走阶梯
 */
class BM18_2 {
    public boolean Find(int target, int [][] array) {
        if(array.length == 0 || array[0].length == 0){
            return false;
        }
        int m = array.length;
        int n = array[0].length;
        int i = 0;
        int j = n - 1;
        while(i < m && j >= 0){
            if(array[i][j] == target){
                return true;
            }else if(array[i][j] < target){
                i++;
            }else{
                j--;
            }
        }
        return false;

    }
}
