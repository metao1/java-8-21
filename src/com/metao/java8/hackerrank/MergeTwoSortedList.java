package com.metao.java8.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Stack;

public class MergeTwoSortedList {

    public static void main(String[] args) {
        Stack<LinkedList> topStack = new Stack<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get("merge-two-lists.txt"))) {
            int numberOfTests = Integer.parseInt(br.readLine().trim());
            for (int i = 0; i < numberOfTests; i++) {
                for (int k = 0; k < 2; k++) {
                    int lengthOfList = Integer.parseInt(br.readLine().trim());
                    LinkedList last = null, first = null;
                    for (int in = 0; in < lengthOfList; in++) {
                        try {
                            int data = Integer.parseInt(br.readLine());
                            LinkedList newNode = new LinkedList(data);
                            LinkedList l = last;
                            last = newNode;
                            if (l == null) {
                                first = newNode;
                            } else {
                                l.next = newNode;
                            }
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    topStack.push(first);
                }
                LinkedList l1 = topStack.pop();
                LinkedList l2 = topStack.pop();
                LinkedList mergedLinkList = mergeTwoSortedLinkList(l1, l2);
                while (mergedLinkList != null) {
                    System.out.print(mergedLinkList.data + " ");
                    mergedLinkList = mergedLinkList.next();
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static class LinkedList {
        int data;
        LinkedList next;

        LinkedList(int data) {
            this.data = data;
        }

        public LinkedList next() {
            return next;
        }
    }

    private static LinkedList mergeTwoSortedLinkList(LinkedList l1, LinkedList l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        if (l1.data < l2.data) {
            l1.next = mergeTwoSortedLinkList(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedLinkList(l1, l2.next);
            return l2;
        }
    }
}
