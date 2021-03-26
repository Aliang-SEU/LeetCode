package old.Data20180424;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
 * You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost){
        int start = 0;
        int idx = 1;
        int left = gas[start] - cost[start];    //第一次的油量
        while(idx < gas.length){
            //检查上一次的油量
            while(start != idx && left < 0){
                start = ((start == 0) ? gas.length - 1: start - 1);
                left += (gas[start] - cost[start]);
            }
            if(start == idx)
                return (left < 0) ? -1 : start;

            left += (gas[idx] - cost[idx]);
            idx = ((idx == gas.length - 1) ? 0: idx + 1);
        }
        return (left < 0) ? -1 : start;
    }

}
