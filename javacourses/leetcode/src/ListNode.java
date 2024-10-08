public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode initFirstNode() {
        return new ListNode(1, new ListNode(2, new ListNode(4)));
    }

    public static ListNode initSecondNode() {
        return new ListNode(1, new ListNode(3, new ListNode(4)));
    }

    @Override
    public String toString() {
        return val + " " + next;
    }
}
