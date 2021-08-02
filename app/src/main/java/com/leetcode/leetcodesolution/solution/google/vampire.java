package com.leetcode.leetcodesolution.solution.google;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class vampire extends logger implements base_solution {
    @Override
    public void execute() {
//        int value = 1260;
//        int value = 136948;
        int value = 125460;
        boolean result = isVampire(value);
        print("result: " + result);
    }

    /**
     * 這題重點在於限縮範圍, 以及確認限制
     * 1. x, y 可以相等嗎？可以為 0 嗎？
     * 2. value 我可以假設最多只有五位數嗎？或是有沒有位數限制
     * 3. 有可能為負嗎？
     *
     * 代碼要注意:
     * 1. j, k 不能跟 i 重複, 條件不可以寫在 for loop 裏面, 要在 scope 內 continue
     * 2. 求得的兩個值有可能不合法, 所以要再做一次確認, 這邊暫時只能想到 O(n) 時間的 map 檢查
     *
     * time complexity: O(n^2)
     * space complexity: O(1)
     */
    private boolean isVampire(int value) {
        char[] nums = String.valueOf(value).toCharArray();

        int len = nums.length;
        if (len < 6) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j != i; j++) {
//                    print("Value of i: " + Character.getNumericValue(nums[i]) + ", value of j: " + Character.getNumericValue(nums[j]) + ", sum: " + (Character.getNumericValue(nums[i]) * 10 + Character.getNumericValue(nums[j])));
                    int firstValue = (Character.getNumericValue(nums[i]) * 10 + Character.getNumericValue(nums[j]));
                    if (value % firstValue == 0) {
                        int secondValue = value / firstValue;
                        if (isValid(value, firstValue, secondValue)) {
                            print("Two values are " + firstValue + ", " + secondValue);
                            return true;
                        } else {
                            continue;
                        }
                    }
                }
            }
        } else {
            // Digits of value larger than 6
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (j == i) {
                        continue;
                    }
                    for (int k = 0; k < len; k++) {
                        if (k == i && k == j) {
                            continue;
                        }
//                        print("3 digits: Value of i: " + Character.getNumericValue(nums[i]) + ", value of j: " + Character.getNumericValue(nums[j]) + ", value of k: " + Character.getNumericValue(nums[k]) + ", sum: " + (Character.getNumericValue(nums[i]) * 100 + Character.getNumericValue(nums[j]) * 10 + Character.getNumericValue(nums[k])));
                        int firstValue = (Character.getNumericValue(nums[i]) * 100 + Character.getNumericValue(nums[j]) * 10 + Character.getNumericValue(nums[k]));
                        if (value % firstValue == 0) {
                            int secondValue = value / firstValue;
                            if (isValid(value, firstValue, secondValue)) {
                                print("3 digits: Two values are " + firstValue + ", " + secondValue);
                                return true;
                            } else {
                                continue;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean isValid(int source, int firstValue, int secondValue) {
        int[] sourceList = new int[10];
        while (source != 0) {
            sourceList[source % 10]++;
            source = source / 10;
        }

        while (firstValue != 0) {
            sourceList[firstValue%10]--;
            if (sourceList[firstValue%10] < 0) return false;
            firstValue = firstValue / 10;
        }

        while (secondValue != 0) {
            sourceList[secondValue%10]--;
            if (sourceList[secondValue%10] < 0) return false;
            secondValue = secondValue / 10;
        }

        return true;
    }
}
