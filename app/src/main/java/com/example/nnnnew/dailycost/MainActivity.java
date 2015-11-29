package com.example.nnnnew.dailycost;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.nnnnew.dailycost.Database.DailyCostDB;

public class MainActivity extends AppCompatActivity {

    private DailyCostDB dbDaily;
    private SQLiteDatabase db;

    public int day;
    private String month;
    private int monthNumber;
    private int years;

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
        setContentView(R.layout.activity_main);
        setCurrentDate();

        Log.i("DateChekk", years + "/" + month + "/" + day);

        dbDaily = new DailyCostDB(getApplicationContext());
        db = dbDaily.getWritableDatabase();

        Button addButton = (Button) findViewById(R.id.add_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                intent.putExtra("day", day);
                intent.putExtra("month", month);
                intent.putExtra("year", years);
                startActivity(intent);
            }
        });

        LinearLayout settingButton = (LinearLayout) findViewById(R.id.setting_button);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });

        LinearLayout summaryButton = (LinearLayout) findViewById(R.id.summary_button);
        summaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
                startActivity(intent);
            }
        });

        Button calendarButton = (Button) findViewById(R.id.calendar_button);
        calendarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                Log.i("DateChekk", years + "/" + month + "/" + day);
                                years = year;
                                monthNumber = monthOfYear;
                                day = dayOfMonth;
                                month = str[monthOfYear];
                                setDateText();

                            }
                        }, years, monthNumber, day);
                datePickerDialog.show();
            }
        });

    }

    private void setDateText() {
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        int tmpYear = today.year;
        int tmpMonth = today.month;
        int tmpDay = today.monthDay;

        TextView dateTV = (TextView) findViewById(R.id.data_textview);
        if (day == tmpDay && monthNumber == tmpMonth && years == tmpYear) {
            dateTV.setText("TODAY");
        }
        else {
            dateTV.setText(day + "/" + month + "/" + years);
        }
    }

    private void setCurrentDate() {
        Time today = new Time(Time.getCurrentTimezone());
        today.setToNow();
        years = today.year;
        monthNumber = today.month;
        day = today.monthDay;
        month = str[monthNumber];
    }

}
