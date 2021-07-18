package com.leetcode.leetcodesolution.solution.easy;

class sqrtx_69 {
    /**
     * 不用 long 去塞, 要注意 x == 0 以及 x < 4 的情況, 另外也要注意除０的錯誤處理
     */
    public int mySqrt_int(int x) {
        if (x == 0) return 0;
        if (x < 4) return 1;
        // x must not be negative
        // Get middle of x
        int end = x/2 + 1;
        int start = 0;
        while (start <= end) {
            int middle = start + (end-start)/2;
            if (middle == 0) return -1;
            if (middle == x/middle) {
                return middle;
            } else if (middle < x/middle) {
                start = middle+1;
            } else {
                end = middle -1;
            }
        }
        return end;

    }
    /**
     * my method, runtime: 100ms, 把 print 拿掉就變成 1ms
     */
    public int mySqrt(int x) {
        // x must not be negative
        // Get middle of x
        long end = x/2 + 1;
        long start = 0;
        while (start <= end) {
            long middle = start + (end-start)/2;

            System.out.println("middle: " + middle + ", x^2: " + middle*middle);
            if (middle * middle == x) {
                return (int)middle;
            } else if (middle * middle < x) {
                start = middle+1;
                System.out.println("start: " + start);
            } else {
                end = middle -1;
                System.out.println("end: " + end);

            }
        }
        return (int)end;

    }
}
