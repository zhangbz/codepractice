/**
 * 13 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution13 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode FindKthToTail(ListNode head,int k) {
        if (head == null || k<=0) return null;

        ListNode preNode = head;
        ListNode targetNode = head;
        boolean error = false;
        for (int i = 0; i < k-1; i++) {
            if (preNode.next != null) {
                preNode = preNode.next;
            } else {
                error = true;
                break;
            }

        }

        if (error) return null;

        while (preNode.next != null) {
            preNode = preNode.next;
            targetNode = targetNode.next;
        }

        return targetNode;

    }
}



