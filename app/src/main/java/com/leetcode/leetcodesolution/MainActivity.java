package com.leetcode.leetcodesolution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.leetcode.leetcodesolution.solution.two_sum_1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        execute();
    }

    private void execute() {
        two_sum_1 q = new two_sum_1();
        q.execute();
    }
}
