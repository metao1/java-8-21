package com.metao.java8.code;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        //method1();
        LinkedListNode list1 = new LinkedListNode(1, new LinkedListNode(13, new LinkedListNode(34, null)));
        LinkedListNode list2 = new LinkedListNode(16, new LinkedListNode(21, new LinkedListNode(53, null)));
//        LinkedListNode node = mergeSortMethod1(list1, list2);
//        while (node != null) {
//            System.out.println(node.data);
//            node = node.next();
//        }
        LinkedListNode node2 = mergeSortMethod2(list1, list2);
        while (node2 != null) {
            System.out.println(node2.data);
            node2 = node2.next();
        }
    }

    public static LinkedListNode mergeSortMethod2(LinkedListNode head1, LinkedListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.data < head2.data) {
            head1.next = mergeSortMethod2(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeSortMethod2(head1, head2.next);
            return head2;
        }
    }

    public static LinkedListNode mergeSortMethod1(LinkedListNode head1, LinkedListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        LinkedListNode node = new LinkedListNode(-1);
        LinkedListNode head = node;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                node.next = head1;
                head1 = head1.next;
            } else {
                node.next = head2;
                head2 = head2.next;
            }
            node = node.next;
        }
        if (head1 != null) {
            node.next = head1;
        }
        if (head2 != null) {
            node.next = head2;
        }
        return head.next;
    }

    static class LinkedListNode {
        int data;
        LinkedListNode next;

        public LinkedListNode(int data, LinkedListNode next) {
            this.data = data;
            this.next = next;
        }

        public LinkedListNode(int data) {
            this.data = data;
        }

        public LinkedListNode next() {
            return next;
        }

        public boolean hasNext() {
            return next != null;
        }
    }
}
