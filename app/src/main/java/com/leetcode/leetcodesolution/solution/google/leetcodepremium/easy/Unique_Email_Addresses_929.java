package com.leetcode.leetcodesolution.solution.google.leetcodepremium.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Unique_Email_Addresses_929 {

    /**
     * time complexity: O(N)
     * space complexity: O(N)
     *
     * 這個版本我覺得最好 2021/08/15
     */
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet();
        for (String string : emails) {
            String afterFormat = formatIt(string);
            if (!set.contains(afterFormat)) {
                set.add(afterFormat);
            }
        }

        return set.size();
    }

    String formatIt(String mail) {
        StringBuilder builder = new StringBuilder();
        int index = mail.indexOf("@");
        int start = 0;
        while (start < index) {
            if (mail.charAt(start) == '.') {
                start++;
            } else if (mail.charAt(start) == '+') {
                break;
            } else {
                builder.append(mail.charAt(start));
                start++;
            }
        }
        builder.append(mail.substring(index));
        return builder.toString();
    }

    /**
     * 我的解法, 有點囉唆, runtime: 27 ms
     */
//    public int numUniqueEmails_me(String[] emails) {
//        HashMap<String, Integer> map = new HashMap();
//        for (int i = 0; i < emails.length; i++) {
//            int index = emails[i].indexOf("@");
//            String name = emails[i].substring(0, index);
//            String removePeriod = name.replace(".", "");
//            int plusIndex = removePeriod.indexOf("+");
//            String removePlus = removePeriod;
//            if (plusIndex != -1) {
//                removePlus = removePeriod.substring(0, plusIndex);
//            }
//            String finalString = removePlus + emails[i].substring(index);
//            System.out.println("-- final: " + finalString);
//            if (map.containsKey(finalString)) {
//                map.put(finalString,(map.get(finalString) +1));
//            } else {
//                map.put(finalString, 1);
//            }
//        }
//
//        int count = 0;
//        for (String item : map.keySet()) {
//            count++;
//        }
//
//        return count;
//    }

    /***
     * 高手的解法, 感覺很直覺, 而且不囉唆
     * runtime: 4ms
     */
//    public int numUniqueEmails(String[] emails) {
//        if(emails == null || emails.length == 0) {
//            return 0;
//        }
//
//        Set<String> set = new HashSet<>();
//        StringBuilder sb = new StringBuilder();
//
//        for(String e : emails) {
//            String cur = helper(e, sb);
//            if(!set.contains(cur)) {
//                set.add(cur);
//            }
//            sb.setLength(0);
//
//        }
//
//        return set.size();  // Set 好方便, 直接 size() 取內容
//    }
//
//    // 不需要把 sb 傳進去
//    private String helper(String e, StringBuilder sb) {
//        int idx = 0;
//        int ix = e.indexOf('@');
//        while(idx < ix) {
//            char cur = e.charAt(idx);
//            if(cur != '+' && cur != '.') {
//                sb.append(cur);
//                idx++;
//            } else if(cur == '.') {
//                idx++;
//            } else if(cur == '+') {
//                break;
//            }
//        }
//
//
//        sb.append(e.substring(ix));
//
//        return sb.toString();
//    }
}
