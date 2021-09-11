package com.leetcode.leetcodesolution.solution.google.easy;

import com.leetcode.leetcodesolution.solution.basic.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Employee_Importance_690 {

    /**
     * time complexity: O(N)
     * space complexity: O(N)
     *
     * 思路：典型的 dfs 題型, 跟查找有關, 所以要直覺想到 HashMap<Key: id, Value: Employee>
     *     下面有我自己想到的 bfs 解法, 不過相較於 dfs 代碼就多了點
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

    public int getImportance_bfs(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }

        Stack<Integer> list = new Stack<>();
        list.add(id);
        int value = 0;
        while (!list.isEmpty()) {
            Employee e = map.get(list.pop());
            value += e.importance;
            if (e.subordinates.size() > 0) {
                for (int i = 0; i < e.subordinates.size(); i++) {
                    list.push(e.subordinates.get(i));
                }
            }
        }
        return value;
    }
}
