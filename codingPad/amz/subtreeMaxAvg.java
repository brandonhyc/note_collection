package codingPad.amz;

import java.util.*;
import java.util.function.Function;

public class subtreeMaxAvg {

    class Solution {
        public  class Node<T> {
            public T val;
            public List<Node<T>> children;

            public Node(T val) {
                this(val, new ArrayList<>());
            }

            public Node(T val, List<Node<T>> children) {
                this.val = val;
                this.children = children;
            }
        }

        public  int subtreeMaxAvg(Node<Integer> root) {
            if (root == null) return -1;
            Double[] res = new Double[2];
            postorderTraverse(root, res);

            return res[1].intValue();
        }

        private  int[] postorderTraverse(Node<Integer> root, Double[] maxAvg) { // return the [sum, # of nodes] under this node

            int[] curr = new int[] { root.val, 1 };

            for (Node child : root.children) {
                int[] childRes = postorderTraverse(child, maxAvg);
                curr[0] += childRes[0];
                curr[1] += childRes[1];
            }

            // maxAvg  [max avg val, node val]
            Double curAvg = (curr[0] / ((double)curr[1]));
            if (maxAvg[0] == null || maxAvg[0] < curAvg) {
                maxAvg[0] = curAvg;
                maxAvg[1] = (double) root.val;
            }

            return curr;
        }

        public  <T> Node<T> buildTree(Iterator<String> iter, Function<String, T> f) {
            String val = iter.next();
            int num = Integer.parseInt(iter.next());
            ArrayList<Node<T>> children = new ArrayList<>();
            for (int i = 0; i < num; i++)
                children.add(buildTree(iter, f));
            return new Node<T>(f.apply(val), children);
        }

        public  void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Node<Integer> root = buildTree(Arrays.stream(scanner.nextLine().split(" ")).iterator(), Integer::parseInt);
            scanner.close();
            int res = subtreeMaxAvg(root);
            System.out.println(res);
        }
    }


}
