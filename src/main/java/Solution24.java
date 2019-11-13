/**
 * 复杂链表的复制
 *
 * 特别需要注意判断子节点是否为空
 * 在遍历链表的时候优先使用while(currentNode !=null)，而不是while(currentNode.next !=null)
 */
public class Solution24 {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if (pHead == null) return null;
        CloneNodes(pHead);
        // printList(pHead);
        CloneRandomNodes(pHead);
        // printList(pHead);
        //return getTargetNode(pHead);

        RandomListNode currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }

    private void CloneNodes(RandomListNode pHead) {
        RandomListNode currentNode = pHead;
        RandomListNode tmpNode;
        while(currentNode !=null) {
            tmpNode = new RandomListNode(currentNode.label);
            tmpNode.next = currentNode.next;
            currentNode.next = tmpNode;
            currentNode = tmpNode.next;
        }
    }

    private void CloneRandomNodes(RandomListNode pHead) {
        RandomListNode currentNode = pHead;
        while (currentNode != null) {
//            currentNode.next.random = currentNode.random.next;
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;

            currentNode = currentNode.next.next;
        }
    }

    private RandomListNode getTargetNode(RandomListNode pHead) {

//        RandomListNode currentNode = pHead.next;
//        while (currentNode != null) {
////            currentNode.next = currentNode.next.next;
//            currentNode.next = currentNode.next==null?null:currentNode.next.next;
//
//            currentNode = currentNode.next==null?null:currentNode.next.next;
//        }
//
//        //currentNode.next = null;
//
//        RandomListNode currentNode2 = pHead;
//        while (currentNode2 != null) {
//            currentNode2.next.next = currentNode2.next.next ==null?null:currentNode2.next.next.next;
//            currentNode2 = currentNode2.next.next;
//        }
//
//        return pHead.next;


        RandomListNode currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;

        }

        return pCloneHead;
    }


    private void printList(RandomListNode head) {
        RandomListNode tmpNode = head;
        while (tmpNode != null) {
            System.out.println((tmpNode.next==null?"null":tmpNode.next.label) + ":" + (tmpNode.random==null?"null":tmpNode.random.next) + "\n");
            tmpNode = tmpNode.next;
        }
    }


    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
