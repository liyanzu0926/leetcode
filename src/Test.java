import java.util.*;

public class Test {
    static List<Integer> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        int D = cin.nextInt();
        int[] coordinate = new int[N];
        for (int i = 0; i < N; i++) {
            coordinate[i] = cin.nextInt();
        }
        dfs(coordinate, 0, D);
        System.out.println(count);
    }

    public static void dfs(int[] coordinate, int start, int D) {
        if (list.size() == 3) {
            if (list.get(2) - list.get(1) <= D) {
                count++;
            }
            return;
        }
        for (int i = start; i < coordinate.length; i++) {
            if (!list.isEmpty() && coordinate[i] - list.get(0) > D) {
                continue;
            }
            list.add(coordinate[i]);
            dfs(coordinate, i + 1, D);
            list.remove(list.size() - 1);

        }
    }
}