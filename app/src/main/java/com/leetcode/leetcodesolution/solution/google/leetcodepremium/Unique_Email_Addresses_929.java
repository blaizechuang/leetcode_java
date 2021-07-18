package com.leetcode.leetcodesolution.solution.google.leetcodepremium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Unique_Email_Addresses_929 {
    /**
     * 我的解法, 有點囉唆, runtime: 27 ms
     */
    public int numUniqueEmails_me(String[] emails) {
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < emails.length; i++) {
            int index = emails[i].indexOf("@");
            String name = emails[i].substring(0, index);
            String removePeriod = name.replace(".", "");
            int plusIndex = removePeriod.indexOf("+");
            String removePlus = removePeriod;
            if (plusIndex != -1) {
                removePlus = removePeriod.substring(0, plusIndex);
            }
            String finalString = removePlus + emails[i].substring(index);
            System.out.println("-- final: " + finalString);
            if (map.containsKey(finalString)) {
                map.put(finalString,(map.get(finalString) +1));
            } else {
                map.put(finalString, 1);
            }
        }

        int count = 0;
        for (String item : map.keySet()) {
            count++;
        }

        return count;
    }

    /***
     * 高手的解法, 感覺很直覺, 而且不囉唆
     * runtime: 4ms
     */
    public int numUniqueEmails(String[] emails) {
        if(emails == null || emails.length == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for(String e : emails) {
            String cur = helper(e, sb);
            if(!set.contains(cur)) {
                set.add(cur);
            }
            sb.setLength(0);

        }

        return set.size();
    }


    private String helper(String e, StringBuilder sb) {
        int idx = 0;
        int ix = e.indexOf('@');
        while(idx < ix) {
            char cur = e.charAt(idx);
            if(cur != '+' && cur != '.') {
                sb.append(cur);
                idx++;
            } else if(cur == '.') {
                idx++;
            } else if(cur == '+') {
                break;
            }
        }


        sb.append(e.substring(ix));

        return sb.toString();
    }
}
