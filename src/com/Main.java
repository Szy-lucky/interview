package com;

/**
 * @PackageName: com
 * @ClassName: Main
 * @Description:
 * @author:
 * @date: 2021/4/24 16:15
 */
public class Main {
    public static void main(String[] args) {
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node node4 = node;
        while (node4 != null){
            System.out.println(node4.value);
            node4 = node4.next;
        }
        System.out.println("------------");
        Node f = new Main().f(node);
        while (f != null){
            System.out.println(f.value);
            f = f.next;
        }
    }

    public Node f(Node node){
        Node pre = null;
        Node now;
        while (node != null){
            now = node;
            node = node.next;
            now.next = pre;
            pre = now;
        }
        return pre;
    }
}

class Node{
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node() {

    }
}
