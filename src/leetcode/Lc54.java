package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc54 {
}

class Solution54_1 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        if (m == 1) {
            for (int i = 0; i < n; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }
        boolean[][] visited = new boolean[m][n];
        int[][] derection = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dere = 0;
        int i = 0;
        int j = 0;
        while (true) {
            if (i >= m || j <= -1 || j >= n || visited[i][j]) {
                // 出界则原路返回
                i -= derection[dere][0];
                j -= derection[dere][1];
                // 改变方向
                dere = (dere + 1) % 4;
                i += derection[dere][0];
                j += derection[dere][1];
                // 如果改变方向还是出界，则结束
                if (visited[i][j]) {
                    break;
                }
            } else {
                visited[i][j] = true;
                list.add(matrix[i][j]);
                i += derection[dere][0];
                j += derection[dere][1];
            }
        }
        return list;
    }
}

class Solution54_2 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rightEnd = n - 1;
        int downEnd = m - 1;
        int leftEnd = 0;
        int upEnd = 1;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(true){
            if(j > rightEnd){
                break;
            }
            while(j <= rightEnd){
                list.add(matrix[i][j++]);
            }
            j--;
            i++;
            if(i > downEnd){
                break;
            }
            while(i <= downEnd){
                list.add(matrix[i++][j]);
            }
            i--;
            j--;
            if(j < leftEnd){
                break;
            }
            while(j >= leftEnd){
                list.add(matrix[i][j--]);
            }
            j++;
            i--;
            if(i < upEnd){
                break;
            }
            while(i >= upEnd){
                list.add(matrix[i--][j]);
            }
            i++;
            j++;

            rightEnd--;
            downEnd--;
            leftEnd++;
            upEnd++;

        }
        return list;
    }
}

class Solution54_3 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rightEnd = n - 1;
        int downEnd = m - 1;
        int leftEnd = 0;
        int upEnd = 1;
        List<Integer> list = new ArrayList<>();
        while(leftEnd <= rightEnd && upEnd - 1 <= downEnd){
            for(int i = leftEnd; i <= rightEnd; i++){
                list.add(matrix[upEnd - 1][i]);
            }
            for(int i = upEnd; i <= downEnd; i++){
                list.add(matrix[i][rightEnd]);
            }
            if(leftEnd < rightEnd && upEnd - 1 < downEnd){
                for(int i = rightEnd - 1; i >= leftEnd; i--){
                    list.add(matrix[downEnd][i]);
                }
                for(int i = downEnd - 1; i >= upEnd; i--){
                    list.add(matrix[i][leftEnd]);
                }
            }

            rightEnd--;
            downEnd--;
            leftEnd++;
            upEnd++;
        }
        return list;
    }
}

class Solution54_4 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rightEnd = n - 1;
        int downEnd = m - 1;
        int leftEnd = 0;
        int upEnd = 0;
        List<Integer> list = new ArrayList<>();
        int count = m * n;
        while(count > 0){
            for(int i = leftEnd; i <= rightEnd; i++){
                list.add(matrix[upEnd][i]);
                count--;
            }
            upEnd++;
            for(int i = upEnd; i <= downEnd; i++){
                list.add(matrix[i][rightEnd]);
                count--;
            }
            rightEnd--;
            for(int i = rightEnd; i >= leftEnd && count > 0; i--){
                list.add(matrix[downEnd][i]);
                count--;
            }
            downEnd--;
            for(int i = downEnd; i >= upEnd && count > 0; i--){
                list.add(matrix[i][leftEnd]);
                count--;
            }
            leftEnd++;
        }
        return list;
    }
}