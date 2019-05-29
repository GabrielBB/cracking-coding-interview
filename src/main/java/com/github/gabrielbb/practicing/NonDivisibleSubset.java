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
            Map.Entry<Integer, List<Integer>> maxLinked = divisibles.entrySet().iterator().next();
            boolean updated = true;

            while(updated) {
                updated = false;

                for (Map.Entry<Integer, List<Integer>> entry : divisibles.entrySet()) {

                    if(!entry.getValue().isEmpty() && entry.getValue().size() > maxLinked.getValue().size()) {
                        maxLinked = entry;
                        updated = true;
                    }
                }

                if(updated) {
                    for(Integer dependency : maxLinked.getValue()) {
                        List<Integer> links = divisibles.get(dependency);
                        links.remove(maxLinked.getKey());

                        if(links.isEmpty()) {
                            divisibles.remove(dependency);
                        }
                    }

                    divisibles.remove(maxLinked.getKey());
                    removed++;
                }
            }
        }

        return S.length - removed;
    }

    private static void linkNumbers(int[] S, Map<Integer, List<Integer>> divisibles, int i, int b) {
        if(!divisibles.containsKey(S[i])) {
            List<Integer> links = new LinkedList<>();
            links.add(S[b]);
            divisibles.put(S[i], links);
        } else {
            divisibles.get(S[i]).add(S[b]);
        }
    }

    private static final Scanner scanner = new Scanner("15 7\n278 576 496 727 410 124 338 149 209 702 282 718 771 575 436");

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