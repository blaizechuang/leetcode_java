package com.leetcode.leetcodesolution.solution.medium;

class Find_Peak_Element_162 {
    public int findPeakElement(int[] arr) {
        return findPeakUntil(arr, 0, arr.length);
    }

    /***
     *
     * 重點就是要直覺想到 divide and conquer
     * 然後再找到 middle 時, 如果位在左右兩側, 需要想到 -1 and n 的 exception
     */
    private int findPeakUntil(int[] arr, int start, int end) {
        if (arr.length == 1) return 0;
        int middle = start + (end-start)/2;
        if (((middle == 0) || (arr[middle-1] < arr[middle])) && ((middle == arr.length-1) || (arr[middle+1] < arr[middle]))) {
            // got it
            return middle;
        } else if (middle > 0 && arr[middle-1] > arr[middle]) {
            return findPeakUntil(arr, start, middle-1);
        } else {
            return findPeakUntil(arr, middle+1, end);
        }
    }
}
