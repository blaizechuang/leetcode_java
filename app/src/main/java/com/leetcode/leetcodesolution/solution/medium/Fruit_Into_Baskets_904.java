package com.leetcode.leetcodesolution.solution.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Fruit_Into_Baskets_904 extends logger implements base_solution {
    @Override
    public void execute() {
        //
    }

    /***
     * 這題就是 sliding window 題型，因為有兩個籃子, 所以定義 second_last_fruit & last_fruit
     * 去移動這個 list, 然後就看題目有什麼條件去判斷就行
     */

    public int totalFruit(int[] tree) {
        int second_last_fruit = -1, last_fruit = -1;
        int current_max = 0;
        int last_fruit_count = 0;
        int max = 0;
        for (Integer fruit : tree) {
            if (fruit == second_last_fruit || fruit == last_fruit) {
                current_max ++;
            } else {
                current_max = last_fruit_count + 1;
            }

            if (fruit == last_fruit) {
                last_fruit_count++;
            } else {
                last_fruit_count = 1;
            }


            if (last_fruit != fruit) {
                second_last_fruit = last_fruit;
                last_fruit = fruit;
            }

            max = Math.max(current_max, max);
        }

        return max;
    }
}
