package datastructures.stack;

import java.util.*;

class JavaStack {

    public static void main(String[] argh) {
        Scanner sc = new Scanner(System.in);
        MyStack stack = new MyStack();
        while (sc.hasNext()) {
            String input = sc.next();
            char[] chars = input.toCharArray();
            stack.top = null;
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c == '{' || c == '[' || c == '(') {
                    stack.push(c);
                } else if (c == '}' || c == ']' || c == ')') {
                    char peek = stack.pop();
                    if (peek == '\\') {
                        break;
                    }
                    switch (c) {
                        case '}':
                            if (peek != '{') {
                                System.out.println("false");
                                continue;
                            }
                            break;
                        case ']':
                            if (peek != '[') {
                                System.out.println("false");
                                continue;
                            }
                            break;

                        case ')':
                            if (peek != '(') {
                                System.out.println("false");
                                continue;
                            }
                    }
                }
            }
            if (stack.top == null)
                System.out.println("true");
            else
                System.out.println("false");
        }

    }
}

class MyStack {
    Node top;

    public void push(char input) {
        if (top == null) {
            top = new Node(input);
            return;
        }
        Node newNode = new Node(input);
        newNode.next = top;
        top = newNode;
    }

    public char pop() {
        if (top == null) {
            return '\\';
        }
        char val = top.data;
        top = top.next;
        return val;
    }

    private static class Node {
        Node next;
        char data;

        public Node(char data) {
            this.data = data;
        }
    }
}


