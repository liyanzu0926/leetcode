package niuke.alibaba;

import java.util.*;

/**
 * 树上最短链
 * https://www.nowcoder.com/questionTerminal/4b0fd3cd06dc4a899abf74996796f5c0
 */
public class ShortestPath {
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

    private static int dfs(List<List<Integer>> edges, int start, int[] grade) {
        int size = grade.length;
        boolean[] visited = new boolean[size];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(start);
        visited[start] = true;
        int dist = 0;
        while (!stack.isEmpty()){
            // 这里先不要出栈，因为待会还要回来遍历它的其它孩子结点
            int u = stack.peek();
            if (u != start && grade[u] == grade[start]){
                return dist;
            }
            for(Integer v : edges.get(u)){
                if (!visited[v]){
                    stack.push(v);
                    visited[v] = true;
                    dist++;
                    break;
                }
            }
            // 栈顶结点和当前结点相同，说明上面循环没有找到它的孩子结点
            // 即该结点的所有孩子结点都已遍历过，则出栈
            if (stack.peek() == u){
                stack.pop();
                dist--;
            }
        }
        return -1;
    }
}
