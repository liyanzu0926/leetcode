package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc399 {
}

class Solution399_1 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionFind unionFind = new UnionFind(equations.size() * 2);
        Map<String, Integer> map = new HashMap<>();
        double[] res = new double[queries.size()];
        int id = 0;
        for (int i = 0; i < equations.size(); i++) {
            String key1 = equations.get(i).get(0);
            String key2 = equations.get(i).get(1);
            if (!map.containsKey(key1)) {
                map.put(key1, id++);
            }
            if (!map.containsKey(key2)) {
                map.put(key2, id++);
            }
            unionFind.union(map.get(key1), map.get(key2), values[i]);
        }

        for (int i = 0; i < queries.size(); i++) {
            String key1 = queries.get(i).get(0);
            String key2 = queries.get(i).get(1);
            Integer id1 = map.get(key1);
            Integer id2 = map.get(key2);
            if (id1 == null || id2 == null){
                res[i] = -1.0d;
            }else {
                res[i] = unionFind.isConnected(id1, id2);
            }
        }
        return res;
    }

    private class UnionFind {
        private int[] parent;
        private double[] weight;

        public UnionFind(int length) {
            parent = new int[length];
            weight = new double[length];
            for (int i = 0; i < length; i++) {
                parent[i] = i;
                weight[i] = 1.0d;
            }
        }

        public void union(Integer x, Integer y, double value) {
            Integer xRoot = find(x);
            Integer yRoot = find(y);
            if (xRoot == yRoot){
                return;
            }
            parent[xRoot] = yRoot;
            weight[xRoot] = value * weight[y] / weight[x];
        }

        private Integer find(Integer x) {
            if (x != parent[x]){
                Integer origin = parent[x];
                parent[x] = find(parent[x]);
                weight[x] *= weight[origin];
            }
            return parent[x];
        }

        public double isConnected(Integer id1, Integer id2) {
            int xRoot = find(id1);
            int yRoot = find(id2);
            if (xRoot != yRoot){
                return -1.0d;
            }else {
                return weight[id1] / weight[id2];
            }
        }
    }
}
