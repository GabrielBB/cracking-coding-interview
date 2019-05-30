package com.github.gabrielbb.practicing;

import java.util.*;

public class NonDivisibleSubset {

    // Complete the nonDivisibleSubset function below.
    private static int nonDivisibleSubset(int k, int[] S) {

        List<Integer>[] divisibles = new List[S.length];

        for(int i = 0; i < S.length; i++) {

            int value = S[i];
            List<Integer> links = divisibles[i];
        
            if(links == null) {
                links = new LinkedList<>();
                divisibles[i] = links;
            }
            
            for(int b = i + 1; b < S.length; b++) {
                
                if((value + S[b]) % k == 0) {
                    List<Integer> bLinks = divisibles[b];

                    if(bLinks == null) {
                        bLinks = new LinkedList<>();
                        divisibles[b] = bLinks;
                    }

                    bLinks.add(i);
                    links.add(b);
                }
            }
        }

        int removed = 0;
        Integer maxLinked = null;

        boolean updated = true;

            while(updated) {
                updated = false;

                for(int i = 0; i < divisibles.length; i++) {
                    List<Integer> links = divisibles[i];

                    if(!links.isEmpty() && (maxLinked == null || links.size() > divisibles[maxLinked].size())) {
                        maxLinked = i;
                        updated = true;
                    }
                }
    
                if(maxLinked != null ) {
                    for(Integer dependency : divisibles[maxLinked]) {
                        List<Integer> links = divisibles[dependency];
                        links.remove(maxLinked);
                    }

                    divisibles[maxLinked].clear();
                    maxLinked = null;
                    removed++;
                }
            }

        return S.length - removed;
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