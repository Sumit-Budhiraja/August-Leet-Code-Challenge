class Solution {
    public void reorderList(ListNode head) {
        //If there are no nodes or one node then there is nothing to reorder
        if(head == null || head.next == null){
            return;
        }
        
        //Get middle node and disconnect the list at the middle node
        ListNode p = getAndDisconnectMiddleNode(head);
        //We've split the list into 2 halves
        //Store middle node onwards in a stack
        //effectively reversing it.
        Deque<ListNode> stack = new LinkedList<>();
        while(p!=null){
            stack.push(p);
            ListNode prev = p;
            p = p.next;
            //Remove the links as we add to the stack
            //this avoids cycles in the final list
            prev.next = null;
        }
        
        //Reorder the list by merging first half and
        //reversed second half from stack
        ListNode ptr = head;
        while(!stack.isEmpty() && ptr!=null){
            ListNode rev = stack.pop();
            ListNode next = ptr.next;
            ptr.next = rev;
            rev.next = next;
            ptr = next;
            if(next==null && !stack.isEmpty()){
                 //we've run out of nodes from the first half
                //so add the node from the second half as the last node
                 rev.next = stack.pop();
             }
        }
    }
    
    /**
    ** Get's the middle node while also
    ** disconnecting the list
    **/
    private ListNode getAndDisconnectMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = null;
        
        while(fast!=null && fast.next!=null){
            slowPrev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //Break the link between the two portions 
        //of the list (first half and second half)
        //This prevents cycles in the resultant list
        if(slowPrev!=null){
            slowPrev.next = null;
        }
        return slow;
    }
}