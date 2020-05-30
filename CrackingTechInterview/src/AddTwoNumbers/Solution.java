package AddTwoNumbers;

public class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOver = 0;
        String tempResult = "";
        ListNode c1 = l1;
        ListNode c2 = l2;
        while (null != c1 || null != c2) {
            int sum = add(c1, c2, carryOver);
            int result = sum % 10;
            carryOver  = sum / 10;
            tempResult += result;
            if (null != c1) c1 = c1.next;
            if (null != c2) c2 = c2.next;
        }
        if (carryOver > 0){
            tempResult += carryOver;
        }
        
        int index = 0;
        ListNode retList = new ListNode(-1);
        while (index < tempResult.length()) {
            int value = Integer.parseInt("" + tempResult.charAt(index));
            ListNode tempNode = new ListNode(value);

            if (-1 == retList.val) {
                retList = tempNode;
            }
            else {
                // loop until the end of non null node
                ListNode currNode = retList;
                while (null != currNode.next) {
                    currNode = currNode.next;
                }
                currNode.next = tempNode;
            }

            index++;
        }

        return retList;
    }

    private int add(ListNode n1, ListNode n2, int carryOver) {
        int result = 0;

        if (null != n1 && null != n2) {
            result = n1.val + n2.val + carryOver;
        }
        else if (null != n1) {
            result = n1.val + carryOver;
        }
        else if (null != n2) {
            result = n2.val + carryOver;
        }

        return result;
    }
}
