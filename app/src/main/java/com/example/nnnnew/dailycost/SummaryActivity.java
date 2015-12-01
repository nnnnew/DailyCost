package com.example.nnnnew.dailycost;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nnnnew.dailycost.Database.DailyCostDB;

public class SummaryActivity extends AppCompatActivity {

    private DailyCostDB dbDaily;
    private SQLiteDatabase db;

    private int years;
    private int day;
    private String month;
    private int monthNumber;

    private String accountMode;
    private TextView dateTextView;
    private TextView balanceTextView;
    private TextView incomeTextView;
    private TextView expenseTextView;

    String[] str = {"January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        dbDaily = new DailyCostDB(getApplicationContext());
        db = dbDaily.getWritableDatabase();

        balanceTextView = (TextView) findViewById(R.id.on_balance_textView);
        incomeTextView = (TextView) findViewById(R.id.income_textview);
        expenseTextView = (TextView) findViewById(R.id.expense_textview);

        accountMode = "day";

        Intent intent = getIntent();
        years = intent.getIntExtra("year", 0);
        day = intent.getIntExtra("day", 0);
        month = intent.getStringExtra("month");
        monthNumber = intent.getIntExtra("monthNumber", 0);
        Log.i("SummaryCheckDate", years + " " + month + " " + day);

        dateTextView = (TextView) findViewById(R.id.date_textView2);
        setDate();
        setDetailByDay();

        final LinearLayout btnDay = (LinearLayout)findViewById(R.id.linear_day);
        final LinearLayout btnMonth = (LinearLayout)findViewById(R.id.linear_month);
        final LinearLayout btnYear = (LinearLayout)findViewById(R.id.linear_year);
        final TextView textday = (TextView)findViewById(R.id.textday);
        final TextView textmonth = (TextView)findViewById(R.id.textmonth);
        final TextView textyear = (TextView)findViewById(R.id.textyear);
        btnDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDay.setBackgroundColor(Color.parseColor("#7ba6a3"));
                btnMonth.setBackgroundColor(Color.parseColor("#e9fff8"));
                btnYear.setBackgroundColor(Color.parseColor("#e9fff8"));
                textday.setTextColor(Color.parseColor("#fff3db"));
                textmonth.setTextColor(Color.parseColor("#009688"));
                textyear.setTextColor(Color.parseColor("#009688"));

                accountMode = "day";

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        SummaryActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                years = year;
                                monthNumber = monthOfYear;
                                month = str[monthNumber];
                                day = dayOfMonth;
                                Log.i("SummaryCheckDate", years + " " + month + " " + day);
                                setDetailByDay();
                                setDate();
                            }
                        }, years, monthNumber, day);
                datePickerDialog.show();
            }
        });

        btnMonth.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDay.setBackgroundColor(Color.parseColor("#e9fff8"));
                btnMonth.setBackgroundColor(Color.parseColor("#7ba6a3"));
                btnYear.setBackgroundColor(Color.parseColor("#e9fff8"));
                textday.setTextColor(Color.parseColor("#009688"));
                textmonth.setTextColor(Color.parseColor("#fff3db"));
                textyear.setTextColor(Color.parseColor("#009688"));

                accountMode = "month";
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        SummaryActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                years = year;
                                monthNumber = monthOfYear;
                                month = str[monthNumber];
                                day = dayOfMonth;
                                Log.i("SummaryCheckDate", years + " " + month + " " + day);
                                setDetailByDay();
                                setDate();
                            }
                        }, years, monthNumber, day);
                datePickerDialog.show();
            }
        }));
        btnYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnDay.setBackgroundColor(Color.parseColor("#e9fff8"));
                btnMonth.setBackgroundColor(Color.parseColor("#e9fff8"));
                btnYear.setBackgroundColor(Color.parseColor("#7ba6a3"));
                textday.setTextColor(Color.parseColor("#009688"));
                textmonth.setTextColor(Color.parseColor("#009688"));
                textyear.setTextColor(Color.parseColor("#fff3db"));

                accountMode = "year";
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        SummaryActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                years = year;
                                monthNumber = monthOfYear;
                                month = str[monthNumber];
                                day = dayOfMonth;
                                Log.i("SummaryCheckDate", years + " " + month + " " + day);
                                setDetailByYear();
                                setDate();
                            }
                        }, years, monthNumber, day);
                datePickerDialog.show();

            }
        });

        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void setDate() {
        if (accountMode.equals("day")) {
            dateTextView.setText(day + "/" + month + "/" + years);
        }
        else if(accountMode.equals("month")) {
            dateTextView.setText(month + " ~ " + years);
        }
        else if(accountMode.equals("year")) {
            dateTextView.setText(" ~ " + years + " ~ ");
        }
    }

    private Cursor getExpenseDataByDate() {
        String selectQuery = "SELECT " +
                DailyCostDB.COL_AMOUNT +
                " FROM " + DailyCostDB.TABLE_NAME +
                " WHERE " +
                DailyCostDB.COL_DAY + " LIKE '" + day + "'" +
                " AND " +
                DailyCostDB.COL_MONTH + " LIKE '" + month + "'" +
                " AND " +
                DailyCostDB.COL_YEAR + " LIKE '" + years + "'" +
                " AND " +
                DailyCostDB.COL_TYPE + " LIKE '" + "Expense" + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    private Cursor getIncomeDataByDate() {
        String selectQuery = "SELECT " +
                DailyCostDB.COL_AMOUNT +
                " FROM " + DailyCostDB.TABLE_NAME +
                " WHERE " +
                DailyCostDB.COL_DAY + " LIKE '" + day + "'" +
                " AND " +
                DailyCostDB.COL_MONTH + " LIKE '" + month + "'" +
                " AND " +
                DailyCostDB.COL_YEAR + " LIKE '" + years + "'" +
                " AND " +
                DailyCostDB.COL_TYPE + " LIKE '" + "Income" + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    private Cursor getExpenseDataByMonth() {
        String selectQuery = "SELECT " +
                DailyCostDB.COL_AMOUNT +
                " FROM " + DailyCostDB.TABLE_NAME +
                " WHERE " +
                DailyCostDB.COL_MONTH + " LIKE '" + month + "'" +
                " AND " +
                DailyCostDB.COL_YEAR + " LIKE '" + years + "'" +
                " AND " +
                DailyCostDB.COL_TYPE + " LIKE '" + "Expense" + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    private Cursor getIncomeDataByMonth() {
        String selectQuery = "SELECT " +
                DailyCostDB.COL_AMOUNT +
                " FROM " + DailyCostDB.TABLE_NAME +
                " WHERE " +
                DailyCostDB.COL_MONTH + " LIKE '" + month + "'" +
                " AND " +
                DailyCostDB.COL_YEAR + " LIKE '" + years + "'" +
                " AND " +
                DailyCostDB.COL_TYPE + " LIKE '" + "Income" + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    private Cursor getExpenseDataByYear() {
        String selectQuery = "SELECT " +
                DailyCostDB.COL_AMOUNT +
                " FROM " + DailyCostDB.TABLE_NAME +
                " WHERE " +
                DailyCostDB.COL_YEAR + " LIKE '" + years + "'" +
                " AND " +
                DailyCostDB.COL_TYPE + " LIKE '" + "Expense" + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }

    private Cursor getIncomeDataByYear() {
        String selectQuery = "SELECT " +
                DailyCostDB.COL_AMOUNT +
                " FROM " + DailyCostDB.TABLE_NAME +
                " WHERE " +
                DailyCostDB.COL_YEAR + " LIKE '" + years + "'" +
                " AND " +
                DailyCostDB.COL_TYPE + " LIKE '" + "Income" + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        return cursor;
    }


    private void setDetailByMonth() {
        Cursor cursorIncome;
        Cursor cursorExpense;
        cursorExpense = getExpenseDataByMonth();
        cursorIncome = getIncomeDataByMonth();

        int sumExpense = 0;
        int sumIncome = 0;
        if(cursorExpense.moveToFirst() && cursorIncome.moveToFirst()) {
            sumExpense = getAllAmount(cursorExpense);
            sumIncome = getAllAmount(cursorIncome);
        }
        else if(cursorExpense.moveToFirst()) {
            sumExpense = getAllAmount(cursorExpense);
        }
        else if(cursorIncome.moveToFirst()){
            sumIncome = getAllAmount(cursorIncome);
        }
        int balance = sumIncome - sumExpense;
        if(balance < 0) {
            balanceTextView.setTextColor(Color.parseColor("#FFE65B6B"));
            balanceTextView.setText(String.valueOf(balance));
        }
        else {
            balanceTextView.setTextColor(Color.parseColor("#009688"));
            balanceTextView.setText(String.valueOf(balance));
        }
        incomeTextView.setText(String.valueOf(sumIncome));
        expenseTextView.setText(String.valueOf(sumExpense));
    }

    private void setDetailByDay() {
        Cursor cursorIncome;
        Cursor cursorExpense;
        cursorExpense = getExpenseDataByDate();
        cursorIncome = getIncomeDataByDate();

        int sumExpense = 0;
        int sumIncome = 0;
        if(cursorExpense.moveToFirst() && cursorIncome.moveToFirst()) {
            sumExpense = getAllAmount(cursorExpense);
            sumIncome = getAllAmount(cursorIncome);
        }
        else if(cursorExpense.moveToFirst()) {
            sumExpense = getAllAmount(cursorExpense);
        }
        else if(cursorIncome.moveToFirst()){
            sumIncome = getAllAmount(cursorIncome);
        }
        int balance = sumIncome - sumExpense;
        if(balance < 0) {
            balanceTextView.setTextColor(Color.parseColor("#FFE65B6B"));
            balanceTextView.setText(String.valueOf(balance));
        }
        else {
            balanceTextView.setTextColor(Color.parseColor("#009688"));
            balanceTextView.setText(String.valueOf(balance));
        }
        incomeTextView.setText(String.valueOf(sumIncome));
        expenseTextView.setText(String.valueOf(sumExpense));
    }

    private void setDetailByYear() {
        Cursor cursorIncome;
        Cursor cursorExpense;
        cursorExpense = getExpenseDataByYear();
        cursorIncome = getIncomeDataByYear();

        int sumExpense = 0;
        int sumIncome = 0;
        if(cursorExpense.moveToFirst() && cursorIncome.moveToFirst()) {
            sumExpense = getAllAmount(cursorExpense);
            sumIncome = getAllAmount(cursorIncome);
        }
        else if(cursorExpense.moveToFirst()) {
            sumExpense = getAllAmount(cursorExpense);
        }
        else if(cursorIncome.moveToFirst()){
            sumIncome = getAllAmount(cursorIncome);
        }
        int balance = sumIncome - sumExpense;
        if(balance < 0) {
            balanceTextView.setTextColor(Color.parseColor("#FFE65B6B"));
            balanceTextView.setText(String.valueOf(balance));
        }
        else {
            balanceTextView.setTextColor(Color.parseColor("#009688"));
            balanceTextView.setText(String.valueOf(balance));
        }
        incomeTextView.setText(String.valueOf(sumIncome));
        expenseTextView.setText(String.valueOf(sumExpense));
    }

    private int getAllAmount(Cursor cursor) {
        int sum = 0;
        cursor.moveToFirst();
        do {
            sum += Integer.parseInt(cursor.getString(cursor.getColumnIndex(DailyCostDB.COL_AMOUNT)));
        } while (cursor.moveToNext());
        return sum;
    }

}
