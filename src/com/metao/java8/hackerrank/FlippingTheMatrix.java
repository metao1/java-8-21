package com.metao.java8.hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


class FlippingTheMatrix {

    /*
     * Complete the 'flippingMatrix' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY matrix as parameter.
     */

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int sum = 0;
        int max = 0;
        int size = 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println(j);
                sum += Math.max(Math.max(matrix.get(i).get(j), matrix.get(i).get(2*size - j - 1)), Math.max(matrix.get(2*size - i - 1).get(j), matrix.get(2*size - i - 1).get(2*size - j - 1)));
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        List<List<Integer>> matrix = new ArrayList<>();

        //int q = Integer.parseInt(bufferedReader.readLine().trim());

//        for (int qItr = 0; qItr < q; qItr++) {
//            int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//
//            for (int i = 0; i < 2 * n; i++) {
//                String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//                List<Integer> matrixRowItems = new ArrayList<>();
//
//                for (int j = 0; j < 2 * n; j++) {
//                    int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
//                    matrixRowItems.add(matrixItem);
//                }
//
//                matrix.add(matrixRowItems);
//            }

        matrix.add(new LinkedList<>() {{
            add(112);
            add(42);
            add(83);
            add(119);
        }});
        matrix.add(new LinkedList<>() {{
            add(56);
            add(125);
            add(56);
            add(49);
        }});
        matrix.add(new LinkedList<>() {{
            add(15);
            add(78);
            add(101);
            add(43);
        }});
        matrix.add(new LinkedList<>() {{
            add(62);
            add(98);
            add(114);
            add(108);
        }});
        int result = FlippingTheMatrix.flippingMatrix(matrix);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();
        //}

        //bufferedReader.close();
        bufferedWriter.close();
    }
}
