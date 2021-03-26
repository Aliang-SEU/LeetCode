package old.Data20180425;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval){
        intervals.sort(new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        List<Interval> res = new ArrayList<>();
        for(int i = 0; i < intervals.size(); i++){
            Interval interval = intervals.get(i);

            if(interval.start > newInterval.end || interval.end < newInterval.start) {
                res.add(interval);
                continue;
            }else{
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        res.add(newInterval);
        res.sort(new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });
        return res;
    }
}
