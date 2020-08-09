package com.study.offer;

import java.util.Stack;

/**
 * @author hangwu
 * @date 2020/8/4 10:40
 */
public class TraversingList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        /*visitList(node1);*/
        reversePrint(node1);

    }

    public static void visitList(Node node) {
        if (node.next != null) {
            visitList(node.next);
        }
        System.out.println(node.value);
    }

    private static void reversePrint(Node node) {
        Stack<Node> stack = new Stack<>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop().value);
        }
    }

    static class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

}
