package com.metao.java8.hackerrank;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TowerBreakers {

    public static void main(String[] args) {
        new TowerBreakers();
    }

    TowerBreakers() {
        try {
            Method method1 = TowerBreakers.class.getDeclaredMethod("method1", int.class, int.class);
            Method method2 = TowerBreakers.class.getDeclaredMethod("method2", int.class, int.class);
            int i = towerBreakers(this, 1, 2, (a, b) -> method1);
            System.out.println(i);
            i = towerBreakers(this, 1, 2, (a, b) -> method2);
            System.out.println(i);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static int towerBreakers(Object ref, int n, int m, TowerBreakersFunction function) throws InvocationTargetException, IllegalAccessException {
        return (int) function.apply(n, m).invoke(ref, n, m);
    }

    interface TowerBreakersFunction {
        Method apply(Integer a, Integer b);
    }

    static Integer method2(int n, int m) {
        if (m == 1) {
            return 2;
        }
        if (n % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }

    static Integer method1(int n, int m) {
        if (m <= 1) {
            return 2;
        }
        int[] tower = new int[n];
        Arrays.fill(tower, m);
        List<Integer> towers = Arrays.stream(tower).boxed().collect(Collectors.toList());

        int player1 = 1;
        int player2 = 2;
        int currPlayer = player1;
        boolean[] able = new boolean[3];
        Arrays.fill(able, false);
        while (able[player1] && able[player2]) {
            for (int i = 0; i < towers.size(); i++) {
                int towerSize = towers.get(i) - 1;
                if (towerSize > 1) {
                    int divider = towerSize;
                    for (divider = towerSize; divider > 1; divider--) {
                        if (divider % towerSize == 0) {
                            break;
                        }
                    }
                    towerSize -= divider;
                    towers.add(i, towerSize);
                    able[currPlayer] = true;
                    currPlayer = currPlayer == player1 ? player2 : player1;
                    break;
                } else {
                    able[currPlayer] = false;
                }
            }
        }
        return able[player2] ? player2 : player1;
    }
}
