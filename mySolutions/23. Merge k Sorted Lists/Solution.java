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
        for (int i = 0; i < size ; i++) { // 5  8  6 11 12 7 
            node.next = new ListNode(minheap.poll());
            node = node.next;
        }

        return dummy.next;
    }
}
