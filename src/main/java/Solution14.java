/**
 * 14 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution14 {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;

        ListNode first = null;
        ListNode second = head;
        ListNode third = second.next;

        while (third != null) {
            second.next = first;
            first = second;
            second = third;
            third = second.next;
        }

        second.next = first;

        return second;
    }
}
