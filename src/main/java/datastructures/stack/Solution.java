package datastructures.stack;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack1 stack = new Stack1();

        for(int i = 0; i<n;i++){
            int queryNo = sc.nextInt();

            switch(queryNo){
                case 1:
                    int data = sc.nextInt();
                    stack.push(data);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
                    System.out.println(stack.printMaximum());
                    break;
            }
        }
        sc.close();
    }
}

class Stack1{
    private static class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }

    private Node top;

    public void push(int data){
        Node node = new Node(data);
        if(top == null){
            top = node;
            return;
        }
        node.next = top;
        top = node;
    }

    public void pop(){
        if(top == null){
            return;
        }
        top = top.next;
    }

    public int printMaximum(){
        int max = 0;
        while(top != null){
            if(top.data > max){
                max = top.data;
            }
            top = top.next;
        }
        return max;
    }

}

