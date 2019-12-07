//https://www.educative.io/courses/grokking-dynamic-programming-patterns-for-coding-interviews/m2EOxJ0Nkp3
class HouseThief {

  public int findMaxSteal(int[] wealth) {

    // for each house 'n'
    // 1. create a new set, include that house, the next target becomes house[n + 2] recursively process the rest houses
    // 2. create a new set, include house[n + 1], the next target becomes house[n + 3] recursively process the rest houses
    // return the set of max sum of two
    if (wealth.length == 0) {
        return 0;
    }
    
    return Math.max(find_rec(wealth, 0), find_rec(wealth, 1));
  }

  private int find_rec(int[] wealth, int start, int[] dp) {

    // exit
    if (start >= wealth.length) {
        return 0;
    }

    int sum1 = 0;
    int sum2 = 0;
    
    sum1 = wealth[start] + find_rec(wealth, start + 2, dp);
    sum2 = wealth[start] + find_rec(wealth, start + 3, dp);
    
    return Math.max(sum1, sum2);
  }

  public static void main(String[] args) {
    HouseThief ht = new HouseThief();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }
}

