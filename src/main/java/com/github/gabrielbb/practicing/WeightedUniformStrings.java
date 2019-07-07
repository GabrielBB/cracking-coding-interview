package com.github.gabrielbb.practicing;

import java.io.IOException;
import java.util.Scanner;

public class WeightedUniformStrings {

    // Complete the weightedUniformStrings function below.
    static String[] weightedUniformStrings(String s, int[] queries) {

        boolean[] weighs = new boolean[(int) Math.pow(10, 7)];

        int carrying = 1;
        weighs[s.charAt(0) - 96] = true;

        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i);

            weighs[curr - 96] = true;

            if (curr == s.charAt(i - 1)) {
                carrying++;
                weighs[(curr - 96) * carrying] = true;
            } else if (carrying > 1) {
                carrying = 1;
            }
        }

        String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = weighs[queries[i]] ? "Yes" : "No";
        }

        return result;
    }

    public static void main(String[] args) throws IOException {

        try (var scanner = new Scanner(WeightedUniformStrings.class.getClassLoader()
                .getResourceAsStream("weighted_uniform_strings_test_case.txt"))) {
            String s = scanner.nextLine();

            int queriesCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] queries = new int[queriesCount];

            for (int i = 0; i < queriesCount; i++) {
                int queriesItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                queries[i] = queriesItem;
            }

            String[] result = weightedUniformStrings(s, queries);

            for (String value : result) {
                System.out.println(value);
            }
        }
    }
}
