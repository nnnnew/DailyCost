package com.example.nnnnew.dailycost;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AddActivity extends AppCompatActivity {

    private AddExpenseFragment addExpenseFragment = new AddExpenseFragment();
    private AddIncomeFragment addIncomeFragment = new AddIncomeFragment();
    private String statusTypeNow = "Expense";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        loadExpenseFragment();

        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Button expens = (Button) findViewById(R.id.expense_add_button);
        final Button income = (Button) findViewById(R.id.income_add_button);
        expens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int colorClick = Color.argb(255, 248, 88, 88);
                int colorNonClick = Color.argb(255,255,255,255);
                int textcolorClick = Color.argb(255,255,255,255);
                int textcolorNonClick = Color.argb(255,0,0,0);
                expens.setBackgroundColor(colorClick);
                income.setBackgroundColor(colorNonClick);
                expens.setTextColor(textcolorClick);
                income.setTextColor(textcolorNonClick);

                loadExpenseFragment();
            }
        });


        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int colorClick = Color.argb(255, 61, 228, 153);
                int colorNonClick = Color.argb(255,255,255,255);
                int textcolorClick = Color.argb(255,255,255,255);
                int textcolorNonClick = Color.argb(255,0,0,0);
                income.setBackgroundColor(colorClick);
                expens.setBackgroundColor(colorNonClick);
                income.setTextColor(textcolorClick);
                expens.setTextColor(textcolorNonClick);

                loadInfomceFragment();


            }
        });

    }

    private void loadExpenseFragment() {

        statusTypeNow = "Expense";
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_add, addExpenseFragment);
        ft.commit();
    }

    private void loadInfomceFragment() {

        statusTypeNow = "Income";
        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_add, addIncomeFragment);
        ft.commit();
    }

}
