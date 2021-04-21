package codingPad;

public class RandomListNode {

    public RandomListNode next;
    public RandomListNode random;
    public int value;

	public RandomListNode(int val) {
		this.value = val;
	}

	public void build() {
		RandomListNode head = this;
		while (head != null) {
			head.random = head;
			head = head.next;
		}
	}

	@Override
	public String toString() {
		return "RandomListNode [next=" + next + ", random=" + random + ", value=" + value + "]";
	}

}
