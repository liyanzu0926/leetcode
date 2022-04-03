package niuke.top100;

import java.util.*;

public class BM48 {
    List<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        list.sort((a, b) -> a - b);
        if (list.size() % 2 == 0) {
            int mid = list.size() / 2;
            return (list.get(mid - 1) + list.get(mid)) / 2.0;
        } else {
            int mid = list.size() / 2;
            return list.get(mid) * 1.0;
        }

    }


}
