package codingPad;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {

    NestedInteger curr;
    Deque<Iterator<NestedInteger>> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        stack.offerLast(nestedList.iterator());

        moveIterator(stack);
    }

    private void moveIterator(Deque<Iterator<NestedInteger>> stack) {
        while (!stack.isEmpty()) { // check if there is iterator (level) in stack
            if (stack.peekLast().hasNext()) {
                boolean foundInt = false;
                while (stack.peekLast().hasNext()) { // check if the current level is done
                    curr = stack.peekLast().next();
                    if (curr.isInteger()) {
                        foundInt = true;
                        break;
                    } else {
                        stack.offerLast(curr.getList().iterator());
                    }
                }
                if (foundInt) break;
            } else {
                stack.pollLast();
            }
        }
    }

    @Override
    public Integer next() {
        NestedInteger res = curr;

        moveIterator(stack);

        return res.getInteger();
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}


