package com.leetcode.leetcodesolution.solution.google.easy;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

import java.util.HashMap;

public class Reformat_Date_1507 extends logger implements base_solution {
    @Override
    public void execute() {
        String date = "20th Oct 2052";
    }

    public String reformatDate(String date) {
        String[] splits = date.split(" ");
        String day = splits[0];
        String month = splits[1];
        String year = splits[2];
        StringBuilder sb = new StringBuilder();

        HashMap<String, String> map = getMonths();
        String dayString = day.substring(0, day.length() - 2);
        return sb.append(year).append("-").append(map.get(month)).append("-").append(dayString.length() == 2 ? dayString : ("0" + dayString)).toString();

    }

    private HashMap<String, String> getMonths(){
        HashMap<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        return months;
    }
}
