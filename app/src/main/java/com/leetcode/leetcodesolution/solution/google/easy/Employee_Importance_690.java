package com.leetcode.leetcodesolution.solution.google.easy;

import com.leetcode.leetcodesolution.solution.basic.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee_Importance_690 {

    /**
     * time complexity: O(N)
     * space complexity: O(N)
     *
     * 思路：典型的 dfs 題型, 跟查找有關, 所以要直覺想到 HashMap<Key: id, Value: Employee>
     */
    Map<Integer, Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        map = new HashMap();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        return dfs(id);
    }

    private int dfs(int id) {
        Employee e = map.get(id);
        int count = e.importance;
        for (Integer subId : e.subordinates) {
            count += dfs(subId);
        }
        return count;
    }
}
