package com.github.gabrielbb.practicing;

import java.util.*;

public class NonDivisibleSubset {

    // Complete the nonDivisibleSubset function below.
    private static int nonDivisibleSubset(int k, int[] S) {
        
        if(k == 1) {
            return 1;
        }

        int removed = 0;
        boolean[] blacklist = new boolean[S.length];

        for(int i = 0; i < S.length; i++) {
            
            if (!blacklist[i]) {
                for(int b = i + 1; b < S.length; b++) {
                
                if(!blacklist[b] && (S[i] + S[b]) % k == 0) {
                    removed++;
                    blacklist[b] = true;

                    System.out.println("Found " + S[i] + " and " + S[b]);
                    break;
                    }
                }
            }
        }

        return S.length - removed;
    }

    private static final Scanner scanner = new Scanner("10 4\n1 2 3 4 5 6 7 8 9 10");

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