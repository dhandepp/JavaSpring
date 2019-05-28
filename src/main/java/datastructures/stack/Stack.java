package datastructures.stack;

public class Stack {

    private static class Node{
        private Node next;
        private int data;
        public Node(int data){
            this.data = data;
        }
    }

    private Node top;

    public boolean isEmpty(){
        return top == null;
    }

    public int peek(){
        return top.data;
    }

    public void push(int data){
        Node node = new Node(data);
        if(top == null){
            top = node;
            return;
        }
        node.next = top;
        top = node;
    }

    public int pop(){
        int data = top.data;
        top = top.next;
        return data;
    }
}
