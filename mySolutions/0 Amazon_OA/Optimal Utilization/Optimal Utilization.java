// Amazon | Online Assessment 2019 | Optimal Aircraft Utilization
// https://leetcode.com/discuss/interview-question/318918/Amazon-or-Online-Assessment-2019-or-Optimal-Aircraft-Utilization

public class Main {
    public List<List<Integer>> aircraftUtilization(int maxTravelDist, int[][] forwardRouteList, int[][] returnRouteList){
        int ID = 0;
        int TIME = 1;
        
        List<List<Integer>> res = new ArrayList<>();
        int max = -1;

        Arrays.sort(forwardRouteList, (a, b) -> (a[TIME] - b[TIME]));
        Arrays.sort(returnRouteList, (a, b) -> (a[TIME] - b[TIME]));
        
        int fIndex = 0;
        int rIndex = returnRouteList.length - 1;

        while (fIndex <= forwardRouteList.length - 1 && rIndex >= 0) {
            
            int sum = forwardRouteList[fIndex][TIME] + returnRouteList[rIndex][TIME];

            if (sum < max) {
                fIndex += 1;
            } else if (sum > maxTravelDist) {
                rIndex -= 1;
            } else if (sum <= maxTravelDist && sum >= max) {
                if (sum > max) {
                    res = new ArrayList<>();
                    max = sum;
                }
                res.add(Arrays.asList(forwardRouteList[fIndex][ID], returnRouteList[rIndex][ID]));
                
                int nextIndex = rIndex - 1;
                while (nextIndex >= 0 && returnRouteList[nextIndex][TIME] == returnRouteList[nextIndex + 1][TIME]) {
                    res.add(Arrays.asList(forwardRouteList[fIndex][ID], returnRouteList[nextIndex][ID]));
                    nextIndex -= 1;                    
                }
                
                fIndex += 1;
            } else {
                System.out.print("exception");
            }
            System.out.printf("fIndex: %d, rIndex: %d, sum: %d\n", fIndex, rIndex, sum);
        }

        return res;
    }
    public static void main(String[] args) {
        Main main = new Main();
        int[] maxTravelDists = {7000, 10000, 10000};
        int[][][] forwardRouteLists ={ {{1, 2000}, {2, 4000}, {3, 6000}},
                            {{1, 2000}, {2, 5000}, {3, 7000}, {4, 10000}},
                                      {{1,3000},{2,5000},{3,7000},{4,10000}}}; 
        int[][][] returnRouteLists ={ {{1, 2000}},
                            {{1, 2000}, {2, 3000}, {3, 4000}, {4, 5000}},
                                     {{1,2000},{2,2000},{3,4000},{4,4000}}}; 
        for(int i = 0; i < maxTravelDists.length; ++i){
            System.out.println(main.aircraftUtilization(maxTravelDists[i], forwardRouteLists[i], returnRouteLists[i]));
        }
    }
}