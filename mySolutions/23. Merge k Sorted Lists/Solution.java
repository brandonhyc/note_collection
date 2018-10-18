// 三种不同的解法：
// mergeHelper_v1_minHeap 小顶堆（优先队列）
// mergeHelper_v2_Divide_Conquer 分治思想，递归
// mergeHelper_v3_Non_Recursive 两两合并，非递归
// 时间复杂度均为O(nlogk)

// 相似题目1：104. Merge K Sorted Lists 链表形式的解法链接点击此处，见Roger的题解
// 相似题目2：486. Merge K Sorted Arrays 数组形式的解法链接点击此处，见Roger的题解(非九章学员可能没有访问权限)

// 三道题目
// 104. Merge K Sorted Lists
// 486. Merge K Sorted Arrays
// 577. Merge K Sorted Interval Lists
// 实质上是一个问题，均可以采用 v1, v2, v3 三种不一样的解法，每一道题目的每一种解法我都提供了代码

// Time Complexity: O(Nlogk) where k is the number of node list
// 1. for each pop and inertion to the queue,  it's O(logk)

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        PriorityQueue<Integer> minheap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b;
            }
        });
        for (ListNode headerNode : lists) {
                        
            ListNode temp = headerNode;
            while (temp != null) {
                minheap.add(temp.val);
                temp = temp.next;
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int size = minheap.size();
        for (int i = 0; i < size ; i++) { 
            node.next = new ListNode(minheap.poll());
            node = node.next;
        }

        return dummy.next;
    }
}
