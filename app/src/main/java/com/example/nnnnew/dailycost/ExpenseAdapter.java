package com.example.nnnnew.dailycost;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nnnnew.dailycost.Model.ExpenseModel;

/**
 * Created by nnnnew on 11/29/2015 AD.
 */
public class ExpenseAdapter extends ArrayAdapter<ExpenseModel> {

    private Context context;
    private int itemLayoutID;
    private ExpenseModel[] expenseModels = null;

    public ExpenseAdapter(Context context, int itemLayoutID, ExpenseModel[] expenseModel) {
        super(context, itemLayoutID, expenseModel);

        this.itemLayoutID = itemLayoutID;
        this.context = context;
        this.expenseModels = expenseModel;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View item = inflater.inflate(itemLayoutID, parent, false);
        ImageView catalogueImage = (ImageView) item.findViewById(R.id.list_icon);
        TextView catalogueText = (TextView) item.findViewById(R.id.list_catalogue);

        ExpenseModel expenseModel = expenseModels[position];
        catalogueImage.setImageResource(expenseModel.getM_on_add_id());
        catalogueText.setText(expenseModel.getM_catalogue());

        return item;
    }
}
