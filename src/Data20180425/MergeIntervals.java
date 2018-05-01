package Data20180425;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args){


    }
    public List<Interval> merge(List<Interval> intervals){
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));

        List<Interval> res = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(Interval interval : intervals){
            if(interval.start <= end){
                end = Math.max(interval.end, end);
            }else{
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}
