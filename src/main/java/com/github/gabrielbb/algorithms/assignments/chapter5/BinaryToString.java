package com.github.gabrielbb.algorithms.assignments.chapter5;

public class BinaryToString {

    private static int getBase2(int num) {
        return (int) Math.pow(2, (int) (Math.log(num) / Math.log(2)));
    }

    public static String convert(int num) {

        if (num == 0)
            return "0";

        var binary = new StringBuilder();
        int remaining = num;

        for (int i = getBase2(num); i > 0; i = (i > 2 ? i / 2 : i - 1)) {

            if (i <= remaining) {
                remaining -= i;
                binary.append(1);
            } else if (remaining < num) {
                binary.append(0);
            }
        }

        return binary.toString();
    }

    /*
     * Given a real number between O and 1 (e.g., 0.72) that is passed in as a
     * double, print the binary representation
     */
    public static String convert(double num) {

        if (num == 0)
            return "0";

        if (num < 0 || num > 1) {
            return "ERROR";
        }

        var binary = new StringBuilder("0.");
        int count = 0;

        while (num != 1) {
            num *= 2;

            if(num == 1) {
                binary.append(1);
            }
            else if (num > 1) {
                num--;
                binary.append(1);
            } else {
                binary.append(0);
            }

            if (++count > 32) {
                return "ERROR";
            }
        }

        return binary.toString();
    }
}