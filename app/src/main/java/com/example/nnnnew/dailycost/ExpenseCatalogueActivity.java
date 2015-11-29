package com.example.nnnnew.dailycost;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.nnnnew.dailycost.Model.ExpenseModel;

public class ExpenseCatalogueActivity extends ListActivity {


    private String[] catalogue = {"Breakfast", "Lunch", "Dinner", "Snack", "Shopping", "Movie", "Music", "Game", "Bill", "Visa", "Other"};

    private int[] idOnAdd = {R.drawable.on_add_breakfast, R.drawable.on_add_lunch, R.drawable.on_add_dinner, R.drawable.on_add_snack, R.drawable.on_shopping,
            R.drawable.on_add_movie, R.drawable.on_add_music, R.drawable.on_add_game, R.drawable.on_add_bill, R.drawable.on_add_visa, R.drawable.on_add_other};

    private int[] idIcon = {R.drawable.ic_breakfast, R.drawable.ic_lunch, R.drawable.ic_dinner, R.drawable.ic_snack, R.drawable.ic_shopping, R.drawable.ic_movie,
            R.drawable.ic_music, R.drawable.ic_game, R.drawable.ic_bill, R.drawable.ic_visa, R.drawable.ic_other};



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

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent();
        intent.putExtra("catalogue", catalogue[position]);
        intent.putExtra("idOnAdd", idOnAdd[position]);
        intent.putExtra("idIcon", idIcon[position]);
        setResult(RESULT_OK, intent);
        finish();

    }
}
