package com.example.nnnnew.dailycost;

import android.app.ListActivity;
import android.os.Bundle;

import com.example.nnnnew.dailycost.Model.IncomeModel;

public class IncomeCatalogueActivity extends ListActivity {

    String[] catalogue = {"Salary", "Bonus", "Investment", "Gift", "Other"};
    int[] idOnAdd = {R.drawable.on_add_salary, R.drawable.on_add_bonus, R.drawable.on_add_investment, R.drawable.on_add_gift, R.drawable.on_add_other};
    String[] idIcon = {"ic_salary", "ic_bonus", "ic_investment", "ic_gift", "ic_other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income_catalogue);

        IncomeModel[] incomeModels = {
                new IncomeModel("Salary", R.drawable.on_add_salary),
                new IncomeModel("Bonus", R.drawable.on_add_bonus)};

        IncomeAdapter adapter = new IncomeAdapter(this, R.layout.list_add_item, incomeModels);
        setListAdapter(adapter);
    }
}
