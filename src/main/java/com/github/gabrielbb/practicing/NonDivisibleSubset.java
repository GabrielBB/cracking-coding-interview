package com.github.gabrielbb.practicing;

import java.util.*;

public class NonDivisibleSubset {

    // Complete the nonDivisibleSubset function below.
    private static int nonDivisibleSubset(int k, int[] S) {

        Map<Integer, List<Integer>> divisibles = new HashMap<>();

        for(int i = 0; i < S.length - 1; i++) {

            for(int b = i + 1; b < S.length; b++) {
                if((S[i] + S[b]) % k == 0) {
                    linkNumbers(S, divisibles, i, b);
                    linkNumbers(S, divisibles, b, i);
                }
            }
        }

        int removed = 0;

        if(!divisibles.isEmpty()) {
            Map.Entry<Integer, List<Integer>> maxLinked = null;
            boolean updated = true;

            while(updated) {
                updated = false;

                for (Map.Entry<Integer, List<Integer>> entry : divisibles.entrySet()) {

                    if(maxLinked == null || entry.getValue().size() > maxLinked.getValue().size()) {
                        maxLinked = entry;
                        updated = true;
                    }
                }

                if(maxLinked != null) {
                    for(Integer dependency : maxLinked.getValue()) {
                        List<Integer> links = divisibles.get(dependency);
                        links.remove(maxLinked.getKey());

                        if(links.isEmpty()) {
                            divisibles.remove(dependency);
                        }
                    }

                    divisibles.remove(maxLinked.getKey());
                    maxLinked = null;
                    removed++;
                }
            }
        }

        return S.length - removed;
    }

    private static void linkNumbers(int[] S, Map<Integer, List<Integer>> divisibles, int i, int b) {
        List<Integer> links = divisibles.get(S[i]);

        if(links == null) {
            links = new LinkedList<>();
            divisibles.put(S[i], links);
        }

        links.add(S[b]);
    }

    private static final Scanner scanner = new Scanner("10 5\n770528134 663501748 384261537 800309024 103668401 538539662 385488901 101262949 557792122 46058493");

    public static void main(String[] args) {
        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] S = new int[n];

        String[] SItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int SItem = Integer.parseInt(SItems[i]);
            S[i] = SItem;
        }

        int result = nonDivisibleSubset(k, S);

        System.out.println("Result = " + result);

        scanner.close();
    }
}