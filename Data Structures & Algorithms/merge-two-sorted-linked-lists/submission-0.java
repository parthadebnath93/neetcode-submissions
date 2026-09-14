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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head=null;
        ListNode result=null;
        while(list1 != null && list2 != null){
            ListNode node=null;
            if(list1.val<list2.val){
                node=new ListNode(list1.val);
                if(head==null){
                    head=node;
                    result=head;
                }else{
                    head.next=node;
                    head=head.next;
                }
                list1=list1.next;
            }
            else{
                node=new ListNode(list2.val);
                if(head==null){
                    head=node;
                    result=head;
                }else{
                    head.next=node;
                    head=head.next;
                }
                list2=list2.next;
            }
        }
        while(list1 != null){
            ListNode node=new ListNode(list1.val);
            if(head==null){
                head=node;
                result=head;
            }else{
                head.next=node;
                head=head.next;
            }
            list1=list1.next;
        }
        while(list2 != null){
            ListNode node=new ListNode(list2.val);
            if(head==null){
                head=node;
                result=head;
            }else{
                head.next=node;
                head=head.next;
            }
            list2=list2.next;
        }
        return result;
    }
}