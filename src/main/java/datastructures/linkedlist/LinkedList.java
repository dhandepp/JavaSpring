package datastructures.linkedlist;

/*
 *  Creates a wrapper around existing Node class
 * */
public class LinkedList {
    Node head;

    /*
     * append method adds a new node at the end of the list
     * */
    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    /*
     * prepend method adds a node at the beginning of linkedlist
     * */
    public void prepend(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public void createCycle(int dataPointer, int newNodeData){
        if(head == null){
            return;
        }
        Node current = head;
        Node toNode = null;
        while(current.next !=null){
            // Save the node to which we would want to create cycle
            if(current.next.data == dataPointer){
                toNode = current.next;
            }
            current = current.next;
        }
        if(toNode ==  null){
            return;
        }
        current.next = toNode;
    }

    public boolean hasCycle(){
        if(head == null)
            return false;
        Node fast = head.next;
        Node slow = head;

        while(fast != null && fast.next != null && slow !=null){
            if(fast == slow){
                return true;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public void printList(){
        if(head == null){
            System.out.println("List is empty");
        }
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
