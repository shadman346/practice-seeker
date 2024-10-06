package com.shadman.practice.dppractice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Start {
    public static void main(String[] args) {
        minStepsToClimbStair(10, new int[]{5,2,3,0,4,1,0,3,2,4});
    }

    private static void minStepsToClimbStair(int n, int[] steps) {
        Map<Character, Integer> map = new HashMap<>();
        String str = "string";
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int minSteps = Integer.MAX_VALUE;
            for(int j = 1; j <= steps[i] && j+i < dp.length; j++) {
                dp[i] = Math.min(dp[i + j], minSteps) + 1;
            }
            if(dp[i] == Integer.MAX_VALUE) {
                dp[i] = 0;
            }
            System.out.println(dp[i]);
        }
    }

    private static int stairs(int i, HashMap<Integer, Integer> dpMap) {
        if(i == 0) return 1;

        if(i < 0) return 0;
        if(dpMap.containsKey(i)) return dpMap.get(i);
        int path1 = stairs(i-1, dpMap);
        int path2 = stairs(i-2, dpMap);
        int path3 = stairs(i-3, dpMap);
        int possiblePaths = path1 + path2 + path3;
        dpMap.put(i, possiblePaths);
        return possiblePaths;
    }

    /**
     * 0, 1, 1, 2, 3, 5, 8, 13, 21
     */
    private static int fib(int n, HashMap<Integer, Integer> dpMap) {
        if(n == 0 || n == 1) {
            return n;
        }
        if(dpMap.containsKey(n)) {
            return dpMap.get(n);
        }
        int fib1 = fib(n-1, dpMap);
        int fib2 = fib(n-2, dpMap);
        int fibn = fib1+fib2;
        dpMap.put(n, fibn);
        System.out.println(fibn);
        return fibn;
    }
}
