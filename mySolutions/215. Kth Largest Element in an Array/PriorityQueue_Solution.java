// 思考: 可以使用maxheap做. 
//      但优化的话, 需要用Minheap. 遍历加入minheap, 并把最小的几个取出,这样就保证heap中为最大的k个数.
//      并要注意到输出为从小至大. 因此需要倒置顺序. 
// 记忆点: java 默认是minheap; 后减前是maxheap

public class Solution {
    /**
     * @param nums: an integer array
     * @param k: An integer
     * @return: the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(k); // minheap

        for (int num : nums) {
            minheap.add(num);

            if (minheap.size() > k) {
                minheap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[k - i - 1] = minheap.poll();
        }

        return result;

    }
}