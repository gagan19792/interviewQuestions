package org.interview.questions.array;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost){
        int totalGas = 0;
        int totalCost = 0;
        int start = 0;
        int tank =0;

        for(int i=0; i< gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];
            if(tank < 0){
                start = i+1;
                tank =0;
            }
        }

        if(totalGas < totalCost){
            return -1;
        }
        return start;
    }

    public static void main(String[] args) {
        int[] gas = new int[] {1,2,3,4,5};
        int[] cost = new int[] {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
