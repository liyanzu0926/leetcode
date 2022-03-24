package leetcode;


import java.util.*;

public class Test {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int[] grade = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            grade[i] = cin.nextInt();
        }
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n - 1; i++) {
            int u = cin.nextInt();
            int v = cin.nextInt();
            // 双向边
            edges.get(u).add(v);
            edges.get(v).add(u);
        }
        int minDist = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int currDist = bfs(edges, i, grade);
            if (currDist != -1) {
                minDist = Math.min(minDist, currDist);
            }
        }
        if (minDist == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minDist);
        }
    }

    private static int bfs(List<List<Integer>> edges, int start, int[] grade) {
        int size = grade.length;
        boolean[] visited = new boolean[size];
        Deque<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        // last记录当前层有多少个结点，相当于指向当前层的最后一个结点
        // 每出队一个结点first就加1，当first=last时，说明当前层所有结点都已出队，则树的深度加1
        int currLevelNodeNum = 1;
        int dist = 0;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            currLevelNodeNum--;
            if (u != start && grade[u] == grade[start]) {
                return dist;
            }
            for (Integer v : edges.get(u)) {
                if (!visited[v]) {
                    queue.offer(v);
                    visited[v] = true;
                }
            }
            // 当前层所有结点都已出队
            if (currLevelNodeNum == 0) {
                currLevelNodeNum = queue.size();
                dist++;
            }
        }
        return -1;
    }
}