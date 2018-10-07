/**
 * Definition for ListNode public class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
    /**
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        ListNode[] newTable = new ListNode[hashTable.length * 2];
        
        for (int i = 0; i < hashTable.length; i++){
            ListNode listNodePtr = hashTable[i];
            if (listNodePtr == null) {
                continue;
            }
            
            while (listNodePtr != null) {
                int value = listNodePtr.val;
                listNodePtr = listNodePtr.next;
                insertHashTable(value, newTable);
            }
        }
        return newTable;
    }
    private void insertHashTable(int key, ListNode[] hashTable) {
        int size = hashTable.length;
        int value = ((key % size) + size) % size;

        ListNode node = new ListNode(key);
        ListNode nodePtr = hashTable[value];
        if (nodePtr == null) {
            hashTable[value] = node;
        } else {
            while (nodePtr.next != null) {
                nodePtr = nodePtr.next;
            }          
            nodePtr.next = node;
        }
    }
}
