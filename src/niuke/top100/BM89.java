package niuke.top100;

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}

class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        intervals.sort((a, b) -> a.start - b.start);
        ArrayList<Interval> res = new ArrayList<Interval>();
        res.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start <= res.get(res.size() - 1).end && intervals.get(i).end > res.get(res.size() - 1).end) {
                res.get(res.size() - 1).end = intervals.get(i).end;
            } else if (intervals.get(i).end > res.get(res.size() - 1).end) {
                res.add(intervals.get(i));
            }
        }
        return res;
    }
}
