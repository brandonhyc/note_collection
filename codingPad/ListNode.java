package codingPad;

public class ListNode {
	ListNode next;
	int value;
	
	ListNode(int val) {
		this.value = val;
	}
	
	ListNode(int[] array) {
		if (array == null || array.length == 0) {
			this.value = 0;
			return;
		}
		
		ListNode head = this;
		head.value = array[0];
		
		for (int i = 1; i < array.length; i++) {
			head.next = new ListNode(array[i]);
			head = head.next;
		}
		
	}
	
	ListNode() {
		
	}

	@Override
	public String toString() {
		return "( " + this.value + " ) -> " + this.next;
	}
}
