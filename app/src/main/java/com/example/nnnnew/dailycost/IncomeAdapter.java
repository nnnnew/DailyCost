package com.example.nnnnew.dailycost;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nnnnew.dailycost.Model.IncomeModel;

/**
 * Created by nnnnew on 11/29/2015 AD.
 */
public class IncomeAdapter extends ArrayAdapter<IncomeModel> {

    private Context context;
    private int itemLayoutID;
    private IncomeModel[] incomeModels = null;

    public IncomeAdapter(Context context, int itemLayoutID, IncomeModel[] incomeModels) {
        super(context, itemLayoutID, incomeModels);

        this.itemLayoutID = itemLayoutID;
        this.context = context;
        this.incomeModels = incomeModels;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View item = inflater.inflate(itemLayoutID, parent, false);
        ImageView catalogueImage = (ImageView) item.findViewById(R.id.list_icon);
        TextView catalogueText = (TextView) item.findViewById(R.id.list_catalogue);

        IncomeModel incomeModel = incomeModels[position];
        catalogueImage.setImageResource(incomeModel.getM_on_add_id());
        catalogueText.setText(incomeModel.getM_catalogue());

        return item;
    }
}
