package com.metao.java8.challenges;

import java.util.LinkedList;
import java.util.List;

public class BetterProgrammerTask {
    /*
      Please implement this method to
      return a new array where the order of elements has been reversed from the original
      array.
    */
    public static Object[] reverseArray(Object[] a) {
        Object[] reveresed = a;
        for (int i = 0; i < a.length / 2; i++) {
            Object temp = reveresed[i];
            reveresed[i] = reveresed[a.length - 1 - i];
            reveresed[a.length - 1 - i] = temp;
        }
        return reveresed;
    }

    public static String capitalizeFirstLetters(String s) {
        /*
          Please implement this method to
          capitalize all first letters of the words in the given String.
          All other symbols shall remain intact. If a word starts not with a letter, it shall remain intact too.
          Assume that the parameter String can only contain spaces and alphanumeric characters.

          NOTE: please keep in mind that the words can be divided by single or multiple spaces.
          The spaced also can be found at the beginning or the end of the parameter string,
          and you need to preserve them.
         */
        int pos = 0;
        boolean capitalize = true;
        StringBuilder sb = new StringBuilder(s);
        while (pos < sb.length()) {
            if (sb.charAt(pos) == '.' || sb.charAt(pos) == ' ' || sb.charAt(pos) == ',') {
                capitalize = true;
            } else if (capitalize && !Character.isWhitespace(sb.charAt(pos))) {
                sb.setCharAt(pos, Character.toUpperCase(sb.charAt(pos)));
                capitalize = false;
            }
            pos++;
        }
        return sb.toString();
    }


    // Please do not change this interface
    public static interface Node {
        int getValue();

        List<Node> getChildren();
    }

    static class T implements Node {

        int val;
        List<Node> children = new LinkedList<>();

        T(int val) {
            this.val = val;
        }

        @Override
        public int getValue() {
            return this.val;
        }

        void setChildren(Node... children) {
            this.children = List.of(children);
        }

        @Override
        public List<Node> getChildren() {
            return this.children;
        }
    }

    public static int getLevelSum(Node root, int N) {
        /*
          Please implement this method to
          traverse the tree and return the sum of the values (Node.getValue()) of all nodes
          at the level N in the tree.
          Node root is assumed to be at the level 1. All its children are level 2, etc.
         */
        if (N <= 0) {
            throw new IllegalArgumentException("N must be positive");
        }

        // We're at the level we want to sum, return the value
        if (N == 1) {
            return root.getValue();
        }

        int sum = 0;
        for (Node child : root.getChildren()) {
            sum += getLevelSum(child, N - 1);
        }
        return sum;
    }

    public static List<String> transferFromAtoC(int n) {
        /*
          Towers Of Hanoi.
          There are three pegs: A, B and C. There are n disks. All disks are different in size.
          The disks are initially stacked on peg A so that they increase in size from the top to the bottom.
          The goal is to transfer the entire tower from the A peg to the C peg.
          One disk at a time can be moved from the top of a stack either to an empty peg or to
          a peg with a larger disk than itself on the top of its stack.

          The method should return a sequence of disk moves, each move is a String with two letters (A, B or C)
          corresponding to the peg the disk moves from and the peg it moves to.
          For example, the move "AC" means that a top disk from peg A should be moved to peg C.
         */
        List<String> moveMentList = new LinkedList<>();
        hanoi(moveMentList, n, "A", "B", "C");
        return moveMentList;
    }

    private static void hanoi(List<String> movementList, int n, String rodFrom, String rodMiddle, String rodTo) {
        if (n == 1) {
            System.out.println("Disk 1 moved from " + rodFrom + " to " + rodTo);
            String st = rodFrom + rodTo;
            movementList.add(st);
            return;
        }

        //Move top n-1 disks from A to B using C as middle
        hanoi(movementList, n - 1, rodFrom, rodTo, rodMiddle);

        //Move last disk from A to C
        System.out.println("Disk " + n + " moved from " + rodFrom + " to " + rodTo);
        String st = rodFrom + rodTo;
        movementList.add(st);
        //Move n-1 disks from B to C using A as middle
        hanoi(movementList, n - 1, rodMiddle, rodFrom, rodTo);
    }

    public static void main(String[] args) {
//        final T t = new T(1);
//        t.setChildren(new T(1), new T(2));
//
//        final int levelSum = getLevelSum(t, 1);
//        //final String s = capitalizeFirstLetters(" This is, 12 done       for me.");
//        System.out.println(levelSum);
        final List<String> movementList = transferFromAtoC(4);
        System.out.println(movementList);

    }

}
