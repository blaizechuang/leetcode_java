package com.leetcode.leetcodesolution.solution.hard;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Find_in_Mountain_Array_1095 extends logger implements base_solution {
    @Override
    public void execute() {
        int[] input = {1,2,3,5,3};
        int target = 0;
        int result = findInMountainArray(target, input);
        print("result: " + result);
    }

    /**
     * 看到鬼, 把 arrLength 跟 middle 的暫存拿掉就變成
     * runtime: 0ms, faster than 100%
     * memory usage: 38.8MB
     */
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeakUntil(mountainArr, 0, mountainArr.length());
        if (mountainArr.get(peak) == target) return peak;
        int value = bs_sort(mountainArr, target, 0, peak-1, false);
        if (value == -1) {
            return bs_sort(mountainArr,target, peak+1, mountainArr.length()-1, true);
        }
        return value;
    }

    private int findPeakUntil(MountainArray arr, int start, int end) {
        int middle = start + (end-start)/2;
        int middleValue = arr.get(middle);
        int left = middle > 0 ? arr.get(middle-1) : -1;
        int right = middle < arr.length() - 1 ? arr.get(middle+1) : -1;
        if (((middle == 0) || (left < middleValue)) && ((middle == arr.length()-1) || (right < middleValue))) {
            // got it
            return middle;
        } else if (middle > 0 && left > middleValue) {
            return findPeakUntil(arr, start, middle-1);
        } else {
            return findPeakUntil(arr, middle+1, end);
        }
    }

    private int bs_sort(MountainArray arr, int target, int start, int end, boolean dec) {
        if (start > end) return -1;
        int middle = start + (end-start)/2;
        int middleValue = arr.get(middle);
        if (middleValue == target) {
            return middle;
        } else if (middleValue < target) {
            if (!dec) {
                return bs_sort(arr, target, middle+1, end, dec);
            } else {
                return bs_sort(arr, target, start, middle-1, dec);
            }
        } else {
            if (!dec) {
                return bs_sort(arr, target, start, middle-1, dec);
            } else {
                return bs_sort(arr, target, middle+1, end, dec);
            }
        }
    }


    /**
     * Runtime 16 ms, faster than 5.37%,
     * Memory usage: 39.5MB, 好慘的成績
     */
//    int arrLength = 0;
//    public int findInMountainArray(int target, int[] mountainArr) {
//        arrLength = mountainArr.length;
//        int peak = findPeakUntil(mountainArr, 0, arrLength);
//        System.out.println("peak: " + peak + ", value: " + mountainArr[peak]);
//        int peakValue = mountainArr[peak];
//        if (peakValue == target) return peak;
//        int value = bs_sort(mountainArr, target, 0, peak-1, false);
//        System.out.println("left: " + value);
//        if (value == -1) {
//            return bs_sort(mountainArr,target, peak+1, arrLength-1, true);
//        }
//        return value;
//    }
//
//    private int findPeakUntil(int[] arr, int start, int end) {
//        int middle = start + (end-start)/2;
//        int middleValue = arr[middle];
//        int left = middle > 0 ? arr[middle-1] : arr[0];
//        print("-- middle: " + middle + ", arrLength" + arrLength + ", end-1 value: " + arr[end-1]);
//        int right = middle < arrLength - 1 ? arr[middle+1] : arr[end-1];
//        System.out.println("middle index: " + middle + ", middleValue: " + middleValue + ", left: " + left + ", right: " + right);
//        if (((middle == 0) || (left < middleValue)) && ((middle == arrLength-1) || (right < middleValue))) {
//            // got it
//            return middle;
//        } else if (middle > 0 && left > middleValue) {
//            return findPeakUntil(arr, start, middle-1);
//        } else {
//            return findPeakUntil(arr, middle+1, end);
//        }
//    }
//
//    private int bs_sort(int[] arr, int target, int start, int end, boolean dec) {
//        if (start > end) return -1;
//        System.out.println("start: " + start + ", end: " + end);
//        int middle = start + (end-start)/2;
//        int middleValue = arr[middle];
//        if (middleValue == target) {
//            return middle;
//        } else if (middleValue < target) {
//            if (!dec) {
//                return bs_sort(arr, target, middle+1, end, dec);
//            } else {
//                return bs_sort(arr, target, start, middle-1, dec);
//            }
//        } else {
//            if (!dec) {
//                return bs_sort(arr, target, start, middle-1, dec);
//            } else {
//                return bs_sort(arr, target, middle+1, end, dec);
//            }
//        }
//    }
}
