package com.leetcode.leetcodesolution.solution.google.medium;

import java.util.HashMap;
import java.util.TreeMap;

class Time_Based_Key_Value_Store_981 {
}

class TimeMap {

    /**
     * TreeMap 本身的 insert/get 都需要 O(logN) 的 time complexity
     */
    /** Initialize your data structure here. */
    HashMap<String, TreeMap<Integer, String>> map;
    public TimeMap() {
        map = new HashMap();

    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<Integer, String>());
        }

        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        System.out.println("now map: " + map);
        System.out.println("[get] key: " + key + ", ts: " + timestamp);
        if (!map.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) return "";
        System.out.println("treeMap: " + treeMap);
        Integer ts = treeMap.floorKey(timestamp);
        if (ts == null) return "";
        String result = treeMap.get(ts);
        return result;
    }
}