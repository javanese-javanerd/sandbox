package AddTwoNumbers;

public class SolutionTest {
    public static void main (String args[]){

        ListNode l1 = new ListNode(2);
        ListNode nextNode = new ListNode(4);
        attachNode(l1, nextNode);
        nextNode = new ListNode(3);
        attachNode(l1, nextNode);

        ListNode l2 = new ListNode(5);
        nextNode = new ListNode(6);
        attachNode(l2, nextNode);
        nextNode = new ListNode(4);
        attachNode(l2, nextNode);

        Solution s = new Solution();
        ListNode result  = s.addTwoNumbers(l1, l2);
        System.out.println(toString(result));

        l1 = new ListNode(1);
        nextNode = new ListNode(8);
        attachNode(l1, nextNode);

        l2 = new ListNode(0);

        result  = s.addTwoNumbers(l1, l2);
        System.out.println(toString(result));
    }

    private static void attachNode (ListNode list, ListNode newNode) {
        ListNode currNode = list;
        while (null != currNode.next){
            currNode = currNode.next;
        }

        currNode.next = newNode;
    }

    private static String toString(ListNode list){
        if (null == list.next) {
            return "" + list.val;
        }

        String retVal = "";
        ListNode curr = list;
        while (null != curr.next) {
            retVal += curr.val;
            curr = curr.next;
        }
        retVal += curr.val;

        return retVal;
    }
}
