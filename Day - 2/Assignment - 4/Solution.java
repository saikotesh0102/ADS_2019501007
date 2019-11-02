/**
 * @author SaiKotesh0102
 */

public class Solution {
    private Node head;
    private Node tail;
	private int size;
	
    public Solution() {
        this.head = null;
        this.tail = null;
        this.size = 0;
	}
	/**
     * Time Complexity : O(1)
     * @param a
     * @param b
     * @return Removed letter
     */
	public static String Josephus(final int a, final int b) {
		Solution sol = new Solution();
        sol.generateOrder(a - 1);
		String removed = sol.remove(b);
		return removed;
	}
    /**
     * Time Complexity : O(N)
     * @param a
     */
	private void generateOrder(final int a) {
		for (int i = a; i >= 0; i--) {
			this.insert(String.valueOf(i));
        }
    }
    /**
     * Time Complexity : O(1)
     * @param data
     */
    public void insert(final String data) {

        Node firstNode = new Node(data);
        size++;
        if (head == null) {
            head = firstNode;
            firstNode.next = head;
            tail = firstNode;
        } else {
            Node temp = tail;
            firstNode.next = head;
            head = firstNode;
            temp.next = head;
        }
    }
	/**
     * Time Complexity : O(1)
     * @param pos
     * @return
     */
    public String remove(final int pos) {
		int index = 0;
        Node temp = head;
        Node prev = head;
        String removed = "";
        while (temp.next != temp) {
            int count = 1;
            while (count != pos) {
                prev = temp;
                temp = temp.next;
                count++;
            }
            removed = removed + temp.data +  " ";
            prev.next = temp.next;
            temp = prev.next;
        }
        removed = removed + temp.data;
        return removed;
	}
}