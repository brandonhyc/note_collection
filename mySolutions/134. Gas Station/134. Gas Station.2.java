class Solution {

    // !!! If car starts at A and can not reach B. Any station between A and B can
    // not reach B.(B is the first station that A can not reach.)
    // If the total number of gas is bigger than the total number of cost. There
    // must be a solution.
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int sumGas = 0;
        int sumCost = 0;

        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];

            if (tank < 0) {
                tank = 0;
                start = i;
            }
            tank += gas[i];
            tank -= cost[i];
        }

        return (sumGas >= sumCost) ? start : -1;

    }
}