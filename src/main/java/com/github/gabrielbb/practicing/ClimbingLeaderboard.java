package com.github.gabrielbb.practicing;

import java.util.Objects;
import java.util.Scanner;

public class ClimbingLeaderboard {

    private static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] ranking = new int[alice.length];
        int currentRank = 0;

        int currentScore = 0;
        int lastScore = Integer.MAX_VALUE;

        int a = alice.length - 1;
        aliceLoop: for (; a >= 0; a--) {

            while (currentScore < scores.length) {

                if (scores[currentScore] < lastScore) {
                    currentRank++;
                }

                lastScore = scores[currentScore];

                if(currentScore == scores.length - 1) {
                    ranking[a] = alice[a] < scores[currentScore] ? ++currentRank : currentRank;
                    break aliceLoop;
                }

                if (alice[a] >= scores[currentScore]) {
                    ranking[a] = currentRank;
                    break;
                }

                currentScore++;
            }
        }

        while(a >= 0) {
            ranking[a] = currentRank;
            a--;
        }

        return ranking;
    }

    public static void main(String[] args) {

        try (var scanner = new Scanner(Objects.requireNonNull(ClimbingLeaderboard.class.getClassLoader().getResourceAsStream("climbing_leaderboard_test_case.txt")))) {
            int scoresCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] scores = new int[scoresCount];

            String[] scoresItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < scoresCount; i++) {
                int scoresItem = Integer.parseInt(scoresItems[i]);
                scores[i] = scoresItem;
            }

            int aliceCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] alice = new int[aliceCount];

            String[] aliceItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < aliceCount; i++) {
                int aliceItem = Integer.parseInt(aliceItems[i]);
                alice[i] = aliceItem;
            }

            int[] result = climbingLeaderboard(scores, alice);

            for (int value : result) {
                System.out.println(value);
            }

        }
    }
}
