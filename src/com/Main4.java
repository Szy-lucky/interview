package com;

/**
 * @PackageName: com
 * @ClassName: Main4
 * @Description:
 * @author:
 * @date: 2021/4/25 10:08
 */
public class Main4 {

    public static void main(String[] args) {
        Node node = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        Node node4 = node;
        while (node4 != null) {
            System.out.println(node4.value);
            node4 = node4.next;
        }
        System.out.println("------------");
        Node f = new Main4().f1(node, 2, 3);
        while (f != null) {
            System.out.println(f.value);
            f = f.next;
        }
    }

    public Node f1(Node node, int n, int m){

        Node result = new Node(0);
        result.next = node;
        Node startNode = result;
        Node endNode = result;
        while (n > 1){
            startNode = startNode.next;
            n--;
        }
        while (m > 0){
            endNode = endNode.next;
            m--;
        }
        Node next = endNode.next;
        endNode.next = null;
        Node f = f(startNode.next);
        Node next1 = startNode.next;
        startNode.next = f;
        next1.next = next;
        return result.next;

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




