package com.leetcode.leetcodesolution.solution.mypractice;

import com.leetcode.leetcodesolution.solution.base_solution;
import com.leetcode.leetcodesolution.solution.logger;

public class Split_String_value_to_prime_list extends logger implements base_solution {
    @Override
    public void execute() {
        String input = "11373";
        int result = splitIntoPrimes(input);
        print("Prime count: " + result);
    }

    private boolean checkPrime(String number) {
        int num = Integer.valueOf(number);
        for (int i = 2; i * i <= num; i++) {
            if ((num % i) == 0) {
                return false;
            }
        }
        return true;
    }

// A recursive function to find the minimum
// number of segments the given String can
// be divided such that every segment is a prime

    private int splitIntoPrimes(String number) {
        // If the number is null
        if (number.length() == 0) {
            return 0;
        }

        // checkPrime function is called to check if
        // the number is a prime or not.
        if (number.length() <= 6 && checkPrime(number))
            return 1;

        else {
            int numLen = number.length();
            // A very large number denoting maximum
            int ans = 1000000;

            // Consider a minimum of 6 and length
            // since the primes are less than 10 ^ 6
            for (int i = 1; i <= 6 && i <= numLen; i++) {
                if (checkPrime(number.substring(0, i))) {
                    // Recursively call the function
                    // to check for the remaining String
                    print("-- prime: " + number.substring(i));
                    int val = splitIntoPrimes(number.substring(i));
                    if (val != -1) {
                        // Evaluating minimum splits
                        // into Primes for the suffix
                        ans = Math.min(ans, 1 + val);
                    }
                }
            }

            // Checks if no combination found
            if (ans == 1000000)
                return -1;

            return ans;
        }
    }

}
