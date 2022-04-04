package niuke.top100;

public class BM51 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int curr = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == curr) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    curr = array[i];
                    count = 1;
                }
            }
        }
        return curr;
    }
}
