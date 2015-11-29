package com.example.nnnnew.dailycost;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.nnnnew.dailycost.Model.IncomeModel;

public class IncomeCatalogueActivity extends ListActivity {

    String[] catalogue = {"Salary", "Bonus", "Investment", "Gift", "Other"};
    int[] idOnAdd = {R.drawable.on_add_salary, R.drawable.on_add_bonus, R.drawable.on_add_investment, R.drawable.on_add_gift, R.drawable.on_add_other};
    int[] idIcon = {R.drawable.ic_salary, R.drawable.ic_bonus, R.drawable.ic_investment, R.drawable.ic_gift, R.drawable.ic_other};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_income_catalogue);

        IncomeModel[] incomeModels = new IncomeModel[5];
        for(int i = 0; i < 5; ++i){
            incomeModels[i] = new IncomeModel(catalogue[i], idOnAdd[i]);
        }

        IncomeAdapter adapter = new IncomeAdapter(this, R.layout.list_add_item, incomeModels);
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
