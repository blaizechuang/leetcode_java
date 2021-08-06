package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

public class Bulls_and_Cows_299 {

    /**
     * 這題的思路有點訣竅, 同頭開始找是基本的, 然後是不符合的 case
     * 要把出現的次數記到各自的 int [] 裏面, 再去判斷
     * guess 裏面猜的數字有沒有在 secret 裏面, 有的話就回傳最小值
     *
     * time complexity: O(n)
     * space complexity: O(1), 因為 array count 是固定的 O(10) = O(1)
     */
    public String getHint(String secret, String guess) {
        int[] countS = new int[10];
        int[] countG = new int[10];
        int bulls = 0;
        int cows = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                countS[secret.charAt(i) - '0']++;
                countG[guess.charAt(i) - '0']++;
            }
        }

        for (int j = 0; j < 10; j++) {
            if (countG[j] != 0 && countS[j] != 0) {
                cows += Math.min(countG[j], countS[j]);
            }
        }

        return bulls + "A" + cows + "B";
    }
}
