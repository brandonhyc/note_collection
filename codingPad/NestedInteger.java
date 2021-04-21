package codingPad;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    boolean isInteger;
    Integer num;
    List<NestedInteger> innerList;

    NestedInteger(Integer i) {
        isInteger = true;
        num = i;
    }
    NestedInteger(List<NestedInteger> nInts) {
        innerList = nInts;
    }

    NestedInteger(int[] nums) {
        innerList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            innerList.add(new NestedInteger(nums[i]));
        }
    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger() {
        return isInteger;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return num;
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return innerList;
    }

    @Override
    public String toString() {
        if (isInteger) {
            return "{" + num + '}';
        }
        return "{" + innerList + '}';
    }
}