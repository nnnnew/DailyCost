package com.example.nnnnew.dailycost;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nnnnew.dailycost.Model.TransectionModel;

/**
 * Created by nnnnew on 11/29/2015 AD.
 */
public class MainListAdapter extends ArrayAdapter<TransectionModel> {

    private Context context;
    private int itemLayoutID;
    private TransectionModel[] transectionModels = null;

    public MainListAdapter(Context context, int itemLayoutID, TransectionModel[] transectionModel) {
        super(context, itemLayoutID, transectionModel);

        this.itemLayoutID = itemLayoutID;
        this.context = context;
        this.transectionModels = transectionModel;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View item = inflater.inflate(itemLayoutID, parent, false);
        ImageView catalogueImage = (ImageView) item.findViewById(R.id.list_ic);
        TextView catalogueText = (TextView) item.findViewById(R.id.list_catalogues);
        TextView amountText = (TextView) item.findViewById(R.id.list_amount);

        TransectionModel transectionModel = transectionModels[position];
        catalogueImage.setImageResource(transectionModel.getIdIcon());
        catalogueText.setText(transectionModel.getCatalogue());
        amountText.setText(transectionModel.getAmount());

        return item;
    }
}
