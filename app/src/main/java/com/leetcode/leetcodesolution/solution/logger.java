package com.leetcode.leetcodesolution.solution;

import android.util.Log;

public class logger {
    public void printIntList(String tag, int[] list) {
        String str = "";
        str += "{ ";
        for (int i = 0; i < list.length; i++) {
            str += list[i] + " ";
        }
        str += "}";
        Log.d(tag, "List: " + str);
    }

    public void printCharList(String tag, char[] list) {
        String str = "";
        str += "{ ";
        for (int i = 0; i < list.length; i++) {
            str += list[i] + " ";
        }
        str += "}";
        Log.d(tag, "List: " + str);
    }

    public void printStringList(String tag, String[] list) {
        String str = "";
        str += "{ ";
        for (int i = 0; i < list.length; i++) {
            str += list[i] + " ";
        }
        str += "}";
        Log.d(tag, "List: " + str);
    }

    public void print(Object c){
        Log.d("", "" + c.toString());
    }
}
