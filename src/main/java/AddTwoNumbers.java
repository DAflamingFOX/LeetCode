
class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode worker = ret;

        int carry = 0;
        while (!(l1 == null) || !(l2 == null) || carry != 0) {
            if (worker.next == null) {
                worker.next = new ListNode();
            }
            worker = worker.next;

            int n1, n2;
            n1 = n2 = 0;
            if (l1 != null) {
                n1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                n2 = l2.val;
                l2 = l2.next;
            }

            int val = worker.val + n1 + n2;
            carry = val / 10; // relative 10s place
            val %= 10; // 1s place

            worker.val = val;
            if (carry != 0) {
                worker.next = new ListNode();
                worker.next.val = carry;
            }
            carry = 0; // clear carry
        }

        return ret.next;
    }

    public static void main(String[] args) {
        ListNode l2 = new ListNode(3, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
        ListNode l1 = new ListNode(7);

        var ans = new Solution().addTwoNumbers(l1, l2);

        while (ans != null) {
            System.out.print(ans.val);
            ans = ans.next;
        }
        System.out.println();

    }
}