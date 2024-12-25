package com.metao.examples.hackerrank;

import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BalancedBrackets {

    public static void main(String[] args) {
        try (BufferedReader ir = Files.newBufferedReader(Path.of("files/input09.txt"), StandardCharsets.UTF_8)) {
            try (BufferedReader or = Files.newBufferedReader(Path.of("files/output09.txt"), StandardCharsets.UTF_8)) {
                final int count = Integer.parseInt(ir.readLine().trim());
                for (int i = 0; i < count; i++) {
                    final String line = ir.readLine().trim();
                    if(!or.readLine().equals(isBalanced(line))){
                        System.out.println("NO");
                        System.out.println(line);
                    }
                }
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void get(){
    }

    public static String isBalanced(String s) {
        if (s.length() % 2 != 0) {
            return "NO";
        }
        int i =07;
        System.out.println(i);
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Deque<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                queue.push(map.get(ch));
            } else {
                if(queue.isEmpty()) {
                    return "NO";
                }
                if (queue.pop() != ch) {
                    return "NO";
                }
            }
        }
        if (!queue.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
