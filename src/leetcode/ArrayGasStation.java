package leetcode;

public class ArrayGasStation{
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i=0;i<len;i++){
            int gasleft = 0;
            for (int j=i;j<i+len;j++){
                gasleft = gasleft + gas[j>=len?j-len:j] - cost[j>=len?j-len:j];
                if (gasleft<0){
                    break;
                }
            }
            if (gasleft>=0){
                return i;
            }
        }
        return -1;
    }
    //following is faster method
    //if sum of gas equals to or greater than caost sum
    //then we have at least one station to start at to finish the cycle
    public int CanCompleteCircuit(int[] gas, int[] cost) {
        if (sum(gas)<sum(cost)){
            return -1;
        }
        int len = gas.length;
        int gasleft = 0;
        int index = 0;
        for (int i=0;i<len;i++){
            gasleft = gasleft + gas[i] - cost[i];
            if (gasleft<0){
                gasleft = 0;
                index = i+1;
            }
        }
        return index;
    }
    public int sum(int[] Vol){
        int sum = 0;
        for (int vol:Vol){
            sum+=vol;
        }
        return sum;
    }
}