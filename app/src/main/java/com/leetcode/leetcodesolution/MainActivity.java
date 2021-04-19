package com.leetcode.leetcodesolution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.leetcode.leetcodesolution.solution.container_with_most_water_11;
import com.leetcode.leetcodesolution.solution.two_sum_1;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        execute();
    }

    private void execute() {
        container_with_most_water_11 q = new container_with_most_water_11();
        q.execute();
    }
}
