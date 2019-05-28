package datastructures.linkedlist;

public class DoublyLinkedList {
    NodeDoubly head;

    public void append(int data){
        if(head == null){
            head = new NodeDoubly(data);
        }
        NodeDoubly current = head;
        while(current.next !=null){
            current = current.next;
        }
        current.next = new NodeDoubly(data);
        current.next.prev = current;
    }

    public void prepend(int data){
        if(head == null){
            head = new NodeDoubly(data);
        }
        NodeDoubly newHead = new NodeDoubly(data);
        newHead.next = head;
        head.prev = newHead;
        head = newHead;
    }

    public void deleteWithValue(int data){
        if(head == null){
            return;
        }
        if(head.data == data){
            NodeDoubly newHead = new NodeDoubly(data);
            newHead.next = head.next;
            head = newHead;
            return;
        }
        NodeDoubly current = head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                current.next.prev = current;
                return;
            }
            current = current.next;
        }
    }
}
