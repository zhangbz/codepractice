/**
 * 15 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Solution15 {


    static public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode listNode10 = new ListNode(1);
        ListNode listNode11 = new ListNode(3);
        ListNode listNode12 = new ListNode(5);
        ListNode listNode20 = new ListNode(2);
        ListNode listNode21 = new ListNode(4);
        ListNode listNode22 = new ListNode(6);

        listNode10.next = listNode11;
        listNode11.next=listNode12;
        listNode20.next = listNode21;
        listNode21.next= listNode22;

        ListNode result = Merge(listNode10, listNode20);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    static public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummyHead = new ListNode(-1);
        if (list1.val <= list2.val) {
            dummyHead.next = list1;
            list1 = list1.next;
        } else {
            dummyHead.next = list2;
            list2 = list2.next;
        }

        ListNode tmpNode = dummyHead.next;

        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tmpNode.next = list1;
                list1 = list1.next;
            } else {
                tmpNode.next = list2;
                list2 = list2.next;
            }
            tmpNode = tmpNode.next;
        }

        if (list1!= null) {
            tmpNode.next = list1;
        }

        if (list2 != null) {
            tmpNode.next = list2;
        }

        return dummyHead.next;
    }
}
