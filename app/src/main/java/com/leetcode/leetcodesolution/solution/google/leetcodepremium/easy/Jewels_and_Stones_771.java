package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

class Jewels_and_Stones_771 {

    /**
     * time complexity: O(jewels x stones);
     * space complexity: O(1)
     */
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    count++;
                    break;
                }
            }
        }

        return count;

        /**
         * Below is HashSet method, same time complexity and space complexity
         */
//        Set<Character> Jset = new HashSet();
//        for (char j: J.toCharArray())
//            Jset.add(j);
//
//        int ans = 0;
//        for (char s: S.toCharArray())
//            if (Jset.contains(s))
//                ans++;
//        return ans;
    }
}
