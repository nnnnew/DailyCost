package com.example.nnnnew.dailycost;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.nnnnew.dailycost.Model.ExpenseModel;

public class ExpenseCatalogueActivity extends ListActivity {


    public String[] catalogue = {"Breakfast", "Lunch", "Dinner", "Snack", "Shopping", "Movie", "Music", "Game", "Bill", "Visa", "Other"};

    public int[] idOnAdd = {R.drawable.on_add_breakfast, R.drawable.on_add_lunch, R.drawable.on_add_dinner, R.drawable.on_add_snack, R.drawable.on_shopping,
            R.drawable.on_add_movie, R.drawable.on_add_music, R.drawable.on_add_game, R.drawable.on_add_bill, R.drawable.on_add_visa, R.drawable.on_add_other};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_expense_catalogue);

        ExpenseModel[] expenseModels = new ExpenseModel[11];
        for(int i = 0; i < 11; i++) {
            expenseModels[i] = new ExpenseModel(catalogue[i], idOnAdd[i]);
        }

        ExpenseAdapter adapter = new ExpenseAdapter(this, R.layout.list_add_item, expenseModels);
        setListAdapter(adapter);


    }


}
