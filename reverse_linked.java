public class reverse_linked {
    public int pairSum(ListNode head) {
        if(head == null) return 0;
        int maxSum=0;
        ListNode slow=head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null ) {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode prev=null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        slow=prev;
        ListNode left=head;
        while(slow!=null){
            maxSum=Math.max(maxSum,left.val + slow.val);
            slow=slow.next;
            left=left.next;
        }
        return maxSum;

        
    }
}
