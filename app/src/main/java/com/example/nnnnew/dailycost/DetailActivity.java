package com.example.nnnnew.dailycost;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nnnnew.dailycost.Database.DailyCostDB;

public class DetailActivity extends AppCompatActivity {

    private DailyCostDB dbDaily;
    private SQLiteDatabase db;

    private String amount;
    private String catalogue;
    private String note;
    private long id;
    private String type;
    private RelativeLayout bg;

    private TextView amountTextView;
    private TextView catalogueTextView;
    private TextView noteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        amountTextView = (TextView) findViewById(R.id.detail_amount_textView);
        catalogueTextView = (TextView) findViewById(R.id.catalogue_detail_textview);
        noteTextView = (TextView) findViewById(R.id.note_textView);

        dbDaily = new DailyCostDB(getApplicationContext());
        db = dbDaily.getWritableDatabase();

        Intent intent = getIntent();
        id = intent.getLongExtra("_id", 0);
        type = intent.getStringExtra("type");

        bg = (RelativeLayout) findViewById(R.id.detail_backgroud);

        changeBG();
        getData();
        setText();

        Button deleteData = (Button) findViewById(R.id.delete_button);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.execSQL("DELETE FROM " + DailyCostDB.TABLE_NAME + " WHERE " + DailyCostDB.COL_ID + " LIKE '" + id + "%'");
                finish();
            }
        });

        Button backBtn = (Button) findViewById(R.id.back_button3);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void changeBG() {
        if(type.equals("Income")) {
            bg.setBackgroundColor(Color.argb(255, 61, 228, 153));
        } else {
            bg.setBackgroundColor(Color.argb(255, 248, 88, 88));
        }
    }

    private void getData() {
        String selectQuery = "SELECT " +
                DailyCostDB.COL_CATALOGUE + "," +
                DailyCostDB.COL_AMOUNT + "," +
                DailyCostDB.COL_NOTE  +
                " FROM " + DailyCostDB.TABLE_NAME +
                " WHERE " +
                DailyCostDB.COL_ID + " LIKE '" + id + "'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        amount = cursor.getString(cursor.getColumnIndex(DailyCostDB.COL_AMOUNT));
        catalogue = cursor.getString(cursor.getColumnIndex(DailyCostDB.COL_CATALOGUE));
        note = cursor.getString(cursor.getColumnIndex(DailyCostDB.COL_NOTE));
    }

    private void setText() {
        amountTextView.setText(amount);
        catalogueTextView.setText(catalogue);
        noteTextView.setText(note);
    }

}
