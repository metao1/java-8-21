package com.metao.java8.hackerrank;
//
//import java.io.IOException;
//
//public class RegextTest {
//
//    /*
//     * Write the regular expression in the blank space below
//     */
//    final static String regularExpression = "(\\s*\\w+\\s*=\\s*\\w*\\s*[;]*)+$";
//
//
//    public static void main(String[] args) throws IOException {
//        String ex = "coding=helloworld; foobar=demo; random";
//        System.out.println(ex.matches(regularExpression));
//    }
//}
//

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class RegextTest {
    final static Scanner scan = new Scanner(System.in);
    final static String fileName = System.getenv("OUTPUT_PATH");

    final static String regularExpression = "(\\s*\\w+\\s*=\\s*\\w*\\s*[;]*\\s*)+$";

    public static void main(String[] args) throws IOException {
        int query = Integer.parseInt(scan.nextLine());
        String[] result = new String[query];
        Arrays.fill(result, "False");

        for (int i = 0; i < query; i++) {
            String someString = scan.nextLine();

            if (someString.matches(regularExpression)) {
                result[i] = "True";
            }
        }

        System.out.println(Arrays.toString(result));

    }
}