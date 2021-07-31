package com.leetcode.leetcodesolution.solution.google.medium;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Reorganize_String_767 extends logger implements base_solution {
    @Override
    public void execute() {
        String s = "bfrbs";
        String result = reorganizeString(s);
        print(result);
    }

    /**
     * Time O(N): fill hash[] + find the letter + write results into char array
     * Space O(N + 26): result + hash[]
     */
    public String reorganizeString(String s) {
        // 先把字串放到一個 int []
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a'] ++;
        }
        printIntList("letter: ", letter);

        // 找到最大的
        int max = 0;
        int maxValueLetter = 0;
        for (int i = 0; i < 26; i++) {
            if (letter[i] > max) {
                max = letter[i];
                maxValueLetter = i;
            }
        }

        // 這時已經找到出現最多次的 char
        // 先判斷出現的次數是不是大於一半, 是的話就一定會重複, 考慮到奇數, 所以要把 length + 1
        if (max > (s.length() + 1)/2) return "";
        int start = 0;
        char[] result = new char[s.length()];
        while (letter[maxValueLetter] > 0) {
            result[start] = (char)('a' + maxValueLetter);
            start += 2;
            letter[maxValueLetter]--;
        }

        // 這時已經把出現最多次的字母塞完了, 繼續塞其他的
        for (int j = 0; j < 26; j++) {
            while (letter[j] > 0) {
                print("-- c: " + letter[j] + ", j = " + j + ", char is " + ((char)(j+'a')));
                print("-- start: " + start + ", length: " + s.length());
                /// 這邊不是 >= 是 >, 因為上面最後有 + 2, 所以這次會從上次的地方開始, 而且還沒寫入
                if (start > s.length() - 1) {
                    start = 1;
                }
                print("-- result[" + start + "] = " + ((char) (j+'a')));
                result[start] = (char) (j + 'a');
                start += 2;
                letter[j]--;
            }
        }
        return String.valueOf(result);
    }
}
