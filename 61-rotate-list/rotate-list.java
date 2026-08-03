class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Base case: empty list, single node, or no rotation needed
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Calculate the length of the list and get the tail node
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // 2. Connect tail to head to form a circular list
        tail.next = head;

        // 3. Find the new tail position: (len - (k % len) - 1)
        k = k % len;
        int stepsToNewTail = len - k;
        
        ListNode newTail = tail;
        while (stepsToNewTail > 0) {
            newTail = newTail.next;
            stepsToNewTail--;
        }

        // 4. Break the circular list to form the new list
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}