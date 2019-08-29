import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Solution02 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> result = new ArrayList<>();

        ListNode prev = null;
        ListNode cur = listNode;
        if (cur == null) {
            return  result;
        }
        ListNode next = cur.next;

        while (next != null) {
            cur.next = prev;
            prev = cur;
            cur = next;
            next = next.next;
        }

        cur.next = prev;

        while (cur != null) {
            result.add(cur.val);
            cur = cur.next;
        }

        return result;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
