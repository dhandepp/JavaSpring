package datastructures.tree;

public class Node {
    Node left;
    Node right;
    int value;

    public Node(int data) {
        this.value = data;
    }

    public void insert(int data) {
        if (data < value) {
            if (left == null) {
                left = new Node(data);
            } else {
                left.insert(data);
            }
        } else {
            if (right == null) {
                right = new Node(data);
            } else {
                right.insert(data);
            }
        }
    }

    public boolean contains(int data) {
        if (data == value) {
            return true;
        } else if (data < value) {
            if (left == null) {
                return false;
            } else {
                return left.contains(data);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(data);
            }
        }
    }

    public void printInOrder(){
        if(left !=null){
            left.printInOrder();
        }
        System.out.println(value);
        if(right !=null){
            right.printInOrder();
        }
    }
}
