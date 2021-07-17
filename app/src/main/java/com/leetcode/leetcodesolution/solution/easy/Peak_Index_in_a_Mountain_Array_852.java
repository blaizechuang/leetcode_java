package com.leetcode.leetcodesolution.solution.easy;

class Peak_Index_in_a_Mountain_Array_852 {
    /**
     *
     * 這一題的解法跟 medium 的 Find_Peak_Element_162 一樣
     * 只是這題確保 array 一定有 3 個數值, 且一定為 mountain peak,
     * 所以可以不用特別去考慮到只有一個 item 的 case
     */
    public int peakIndexInMountainArray(int[] arr) {
        return peakIndexFindUntil(arr, 0, arr.length - 1);
    }

    private int peakIndexFindUntil(int[] arr, int start, int end) {
        if (start > end) return -1; // 這行不需要, 因為不會有這樣的狀況
        int middle = start + (end-start)/2;
        if ((middle == 0 || (arr[middle] > arr[middle-1])) && (middle == arr.length - 1 || (arr[middle] > arr[middle+1]))) {
            return middle;
        } else if (middle > 0 && arr[middle] < arr[middle-1]) {
            return peakIndexFindUntil(arr, start, middle-1);
        } else {
            return peakIndexFindUntil(arr, middle+1, end);
        }
    }
}
