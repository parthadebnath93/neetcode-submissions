/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        ListNode curr=head;
        while(curr != null){
            curr=curr.next;
            size++;
        }
        if(size==1 && n==1){
            return null;
        }
        if(n==1){
            return removeLast(head,size);
        }

        if(size==n){
            return head.next;
        }
        
        int index=0;
         curr=head;
        while(curr!= null){
            if(index==size-n-1){
                curr.next=curr.next.next;
                break;
            }
            curr=curr.next;
            index++;
        }
        return head;
    }
    private ListNode removeLast(ListNode head, int size){
        int index=1;
        ListNode curr=head;
        while(curr != null){
            if(index==size-1){
                curr.next=null;
                break;
            }
            curr=curr.next;
            index++;
        }
        return head;
    }
}
