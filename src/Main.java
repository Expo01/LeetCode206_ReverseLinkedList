import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
    }
}


/* will involve 3 variables. a temp variable, current and next pointer. supposing a linked list of 2,4,6
where 2 points to 4 which points to 6 which points to null. each node has both a value field and a pointer to next item
field. Assign head to 2 and temp to 2. 6 is tail. change 2's next field to null, traverse to 4, change its next to
temp, bring temp forward etc. head pointer and tail pointer must be switched though. could say at end that temp points to
head (6), head points to tail (2) then, tail points to temp (6) so that tail was pointing to 2 and head was pointing to 6
and they have effectively switched

THIS EXCEEDED RUNTIME BUT NOT SURE WHY?
    public ListNode reverseList(ListNode head) {
           if (head == null){ //edge case of empty list
           return head;
       }
       ListNode current = head;
       ListNode temp = current;

       while (current.next!=null){
           current = current.next;
           current.next = temp;
           temp = temp.next;
       }
        return current;
    }


 */

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

// assumes class as above where fields of int value and a ListNode pointer 'next' to another NOde. Contains constructor for the above


class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        return previous;
    }
}


/*



    // first pass
// head = 2
// previous = null
// (null > 2 > 4 > 6 > null)
//temp = 4
// previous = current (2)
// current = temp (4)
// previous changed from null to 2, currnt changed from 2 to 4 and temp also is 4

// in second pass, temp and currnt start pointing to same. on first line of seecond pass temp moves to next (6).
// third pass temp will move to null annd loop will break since temp and current will point to null and previous will
pointn to the new head

// problem is that head still is still '2' and there eis no tail pointer?
 */