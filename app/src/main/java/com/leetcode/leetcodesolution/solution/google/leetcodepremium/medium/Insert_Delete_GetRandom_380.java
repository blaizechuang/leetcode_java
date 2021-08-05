package com.leetcode.leetcodesolution.solution.google.leetcodepremium.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

class Insert_Delete_GetRandom_380 {
}

/**
 * 題目有要求所有的動作都要在 O(1) 完成
 * 但是 HashMap 沒辦法去 get random, 所以要多一個 ArrayList 去處理
 * 但是 ArrayList 要刪除需要 O(n), 所以訣竅在這邊
 * 先用 HashMap 去得到該 val 的 index, 然後再去 ArrayList 中把該 index 跟最後一個做交換, 然後刪除最後一個就可以
 * 好聰明的做法
 * 然後是 random 的用法, 這個常常忘記
 */
class RandomizedSet {

    HashMap<Integer, Integer> dict;
    ArrayList<Integer> array;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        dict = new HashMap<Integer, Integer>();
        array = new ArrayList<Integer>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }

        array.add(val);
        dict.put(val, array.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }

        int index = dict.get(val);
        Collections.swap(array, index, array.size() - 1);
        int swapedValue = array.get(index);
        dict.put(swapedValue, index);
        int removedValue = array.get(array.size()-1);
        array.remove(array.size() - 1);
        dict.remove(removedValue);
        return true;
        /**
         * 下面這個是 run time 比較快的寫法, 比我寫得再快一點, 也比較簡潔
         * 主要是利用 HashMap remove 的特性, 刪除後順便拿到 index,
         * 再去 ArrayList 把該 index 刪除
         * 如果刪除的 index 不是最後一個, 透過 remove 把 ArrayList 的最後一個刪除, 順便拿到 val
         * 再把這個 val 塞到原本 index 的位置, 這樣 ArrayList 就處理完了
         * 然後再把這個 val 塞到 HashMap 的 index, 這樣 HashMap 也處理完了
         */
//        if(valIndexLookup.containsKey(val)){
//
//            int index = valIndexLookup.remove(val);
//            vals.remove(index);
//
//            if(index < vals.size()){
//
//                int end = vals.remove(vals.size() - 1);
//                vals.add(index, end);
//                valIndexLookup.put(end, index);
//            }
//
//            return true;
//        }
//
//        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return array.get(rand.nextInt(array.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
