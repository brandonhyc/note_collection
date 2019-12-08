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
    
    Integer[] dp = new Integer[wealth.length + 1];

    for (int i = 0; i < wealth.length; i++) {
        if (i == 0) {
            dp[i] = 0;
        }
        int sum1 = 0;
        int sum2 = 0;
        if (i - 1 >= 0) {
            sum1 = wealth[i] + dp[i - 1];
        }
        sum2 = dp[i];
        dp[i + 1] = Math.max(sum1, sum2);
    }

    return dp[wealth.length];
  }

  public static void main(String[] args) {
    HouseThief ht = new HouseThief();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }
}

class HouseThief {

  public int findMaxSteal(int[] wealth) {

    // for each house 'n'
    // 1. create a new set, include that house, the next target becomes house[n + 2] recursively process the rest houses
    // 2. create a new set, include house[n + 1], the next target becomes house[n + 3] recursively process the rest houses
    // return the set of max sum of two
    if (wealth.length == 0) {
        return 0;
    }
    if (wealth.length == 1) {
        return wealth[0];
    }
    
    Integer[] dp = new Integer[wealth.length];

    for (int i = 0; i < wealth.length; i++) {
        if (i <= 2) {
            dp[i] = wealth[i];
            continue;
        }
        dp[i] = wealth[i] + Math.max(dp[i - 1], dp[i - 2]);
    }

    return Math.max(dp[wealth.length - 1], dp[wealth.length - 2]);
  }

  public static void main(String[] args) {
    HouseThief ht = new HouseThief();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }
}

class HouseThief {

  public int findMaxSteal(int[] wealth) {

    // for each house 'n'
    // 1. create a new set, include that house, the next target becomes house[n + 2] recursively process the rest houses
    // 2. create a new set, include house[n + 1], the next target becomes house[n + 3] recursively process the rest houses
    // return the set of max sum of two
    if (wealth.length == 0) {
        return 0;
    }
    
    Integer[] dp = new Integer[wealth.length];

    return find_rec(wealth, 0, dp);
  }

  private int find_rec(int[] wealth, int start, Integer[] dp) {

    // exit
    if (start >= wealth.length) {
        return 0;
    }

    if (dp[start] != null) {
        return dp[start];
    }
    int sum1 = 0;
    int sum2 = 0;
    
    sum1 = wealth[start] + find_rec(wealth, start + 2, dp);
    sum2 = find_rec(wealth, start + 1, dp);
    
    dp[start] = Math.max(sum1, sum2);

    return dp[start];
  }

  public static void main(String[] args) {
    HouseThief ht = new HouseThief();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }
}



class HouseThief {

  public int findMaxSteal(int[] wealth) {

    // for each house 'n'
    // 1. create a new set, include that house, the next target becomes house[n + 2] recursively process the rest houses
    // 2. create a new set, include house[n + 1], the next target becomes house[n + 3] recursively process the rest houses
    // return the set of max sum of two
    if (wealth.length == 0) {
        return 0;
    }
    
    Integer[] dp = new Integer[wealth.length];

    return Math.max(find_rec(wealth, 0, dp), find_rec(wealth, 1, dp));
  }

  private int find_rec(int[] wealth, int start, Integer[] dp) {

    // exit
    if (start >= wealth.length) {
        return 0;
    }

    if (dp[start] != null) {
        return dp[start];
    }
    int sum1 = 0;
    int sum2 = 0;
    
    sum1 = wealth[start] + find_rec(wealth, start + 2, dp);
    sum2 = wealth[start] + find_rec(wealth, start + 3, dp);
    
    dp[start] = Math.max(sum1, sum2);

    return dp[start];
  }

  public static void main(String[] args) {
    HouseThief ht = new HouseThief();
    int[] wealth = {2, 5, 1, 3, 6, 2, 4};
    System.out.println(ht.findMaxSteal(wealth));
    wealth = new int[]{2, 10, 14, 8, 1};
    System.out.println(ht.findMaxSteal(wealth));
  }
}

