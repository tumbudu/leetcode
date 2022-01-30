// 2. Add Two Numbers
// https://leetcode.com/problems/add-two-numbers/


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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode Ans=null;
        ListNode tmp=null;
        int carry=0;
        ListNode t1=l1;
        ListNode t2=l2;
        
        for(;;){
        
            int n1 = val(t1);
            int n2 = val(t2);
            
            int s;
            if(n1+n2+carry >9){
                s = (n1+n2+carry) %10;
                carry = 1;
            }else{
                s = n1+n2+carry;
                carry = 0;
            }
            
            ListNode newNode = new ListNode(s, null);
            
            if(Ans == null){
                  Ans = newNode; 
                  tmp = newNode;
            }else{
                tmp.next = newNode;
                tmp = newNode;
            }
            
            if(t1 != null){
                t1=t1.next;
            }
            if(t2 != null){
                t2 = t2.next;
            }
            
            if((t1 == t2) && (t1 == null))
                break;
        }
        if(carry!=0){
            ListNode newNode = new ListNode(carry, null);
            tmp.next = newNode;
        }
        
        return Ans;
    }
    
    
    private int val(ListNode node) {
        if (node == null){
            return 0;
        }
        return node.val;
    }
}
