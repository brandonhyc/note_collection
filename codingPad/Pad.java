package codingPad;

import java.util.Arrays;

public class Pad {
    public static void main(String[] args) {
        Solution s = new Solution();

//        4 4
//        1 2
//        3 6
//        77

        int res = s.minContainerSize(
                Arrays.asList(
                        10

                ),
                2
        );
        System.out.println(res);
    }
}
