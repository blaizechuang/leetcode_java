package com.leetcode.leetcodesolution.solution.medium;

class Count_Primes_204 {
    /**
     * 思路
     * 埃拉托斯特尼筛法 (http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     * time complexity: O(N)
     * space complexity: O(N)
     * run time: 140 ms
     */
    public int countPrimes(int n) {
        int count = 0;
        boolean[] nonPrimes = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!nonPrimes[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    if (nonPrimes[i*j]) {
                        continue;
                    }
                    nonPrimes[i*j] = true;
                }
            }
        }
        return count;
    }
}
