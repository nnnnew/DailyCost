package com.example.nnnnew.dailycost;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    private String statusTypeNow = "Expense";
    private String selectedCatalog = "";
    private String note = "";
    private int idIcon = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button backButton = (Button) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final Button expens = (Button) findViewById(R.id.expense_add_button);
        final Button income = (Button) findViewById(R.id.income_add_button);
        final LinearLayout linearAmount=(LinearLayout)findViewById(R.id.linearAmount);
        expens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int colorClick = Color.argb(255, 248, 88, 88);
                int colorNonClick = Color.argb(255,255,255,255);
                int textcolorClick = Color.argb(255,255,255,255);
                int textcolorNonClick = Color.argb(255,0,0,0);

                expens.setBackgroundColor(colorClick);
                income.setBackgroundColor(colorNonClick);
                expens.setTextColor(textcolorClick);
                income.setTextColor(textcolorNonClick);
                linearAmount.setBackgroundColor(colorClick);

                statusTypeNow = "Expense";

                resetDefult();


            }
        });




        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int colorClick = Color.argb(255, 61, 228, 153);
                int colorNonClick = Color.argb(255,255,255,255);
                int textcolorClick = Color.argb(255,255,255,255);
                int textcolorNonClick = Color.argb(255,0,0,0);
                income.setBackgroundColor(colorClick);
                expens.setBackgroundColor(colorNonClick);
                income.setTextColor(textcolorClick);
                expens.setTextColor(textcolorNonClick);
                linearAmount.setBackgroundColor(colorClick);

                statusTypeNow = "Income";

                resetDefult();

            }
        });



        Button doneButton = (Button) findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddActivity.this, statusTypeNow, Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout catalogButton = (LinearLayout) findViewById(R.id.linearLayout5);
        catalogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(statusTypeNow == "Expense") {
                    Intent intent = new Intent(getApplicationContext(), ExpenseCatalogueActivity.class);
                    startActivityForResult(intent, 0);
                }
                else if(statusTypeNow == "Income"){
                    Intent intent = new Intent(getApplicationContext(), IncomeCatalogueActivity.class);
                    startActivityForResult(intent, 1);
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {
            String catalogue = data.getStringExtra("catalogue");
            int idOnAdd = data.getIntExtra("idOnAdd", 0);
            int tmpIdIcon = data.getIntExtra("idIcon", 0);
            idIcon = tmpIdIcon;

            TextView selectedCatalogue = (TextView) findViewById(R.id.selected_catalogue_textView);
            selectedCatalogue.setText(catalogue);

            ImageView onSelectedImageView = (ImageView) findViewById(R.id.catalogue_imageView);
            onSelectedImageView.setImageResource(idOnAdd);
        }
        else {
            String catalogue = data.getStringExtra("catalogue");
            int idOnAdd = data.getIntExtra("idOnAdd", 0);
            int tmpIdIcon = data.getIntExtra("idIcon", 0);
            idIcon = tmpIdIcon;

            TextView selectedCatalogue = (TextView) findViewById(R.id.selected_catalogue_textView);
            selectedCatalogue.setText(catalogue);

            ImageView onSelectedImageView = (ImageView) findViewById(R.id.catalogue_imageView);
            onSelectedImageView.setImageResource(idOnAdd);
        }

    }

    private void resetDefult() {
        TextView selectedCatalogue = (TextView) findViewById(R.id.selected_catalogue_textView);
        selectedCatalogue.setText("Select catalogue");

        ImageView onSelectedImageView = (ImageView) findViewById(R.id.catalogue_imageView);
        onSelectedImageView.setImageResource(R.drawable.ic_catalog);
    }
}
