package com.example.linlinhan.linlinhan_comp304_assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {
    int arrayLength;
    String brand;
    String category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Intent intent=getIntent();
        String[] productItems=new String[]{};

        // get brand from ThirdActivity
        brand=intent.getStringExtra("brand");
        // get category from ThirdActivity
        category=intent.getStringExtra("category");
        // generate product array according to the selected brand
        switch (brand){
            case "iPhone":
                productItems=getResources().getStringArray(R.array.iphones);
                break;
            case"Samsung":
                productItems=getResources().getStringArray(R.array.sumsungs);
                break;
            case"Black Berry":
                productItems=getResources().getStringArray(R.array.blackBerry);
                break;
            case"Google":
                productItems=getResources().getStringArray(R.array.google);
                break;
            case"LG":
                productItems=getResources().getStringArray(R.array.lg);
                break;
            case"Acer":
                productItems=getResources().getStringArray(R.array.acers);
                break;
            case"Apple":
                productItems=getResources().getStringArray(R.array.apple);
                break;
            case"Dell":
                productItems=getResources().getStringArray(R.array.dell);
                break;
            case"Sony":
                productItems=getResources().getStringArray(R.array.sony);
                break;
            case"Panasonic":
                productItems=getResources().getStringArray(R.array.panasonic);
                break;
            case"TOSHIBA":
                productItems=getResources().getStringArray(R.array.toshiba);
                break;
            case"Canon":
                productItems=getResources().getStringArray(R.array.canon);
                break;
            case"Epson":
                productItems=getResources().getStringArray(R.array.epson);
                break;
            case"Lexmark":
                productItems=getResources().getStringArray(R.array.lexmark);
                break;
            case"Nikon":
                productItems=getResources().getStringArray(R.array.nikon);
                break;
            case"Fujifilm":
                productItems=getResources().getStringArray(R.array.fujifilm);
                break;
            case"Leica":
                productItems=getResources().getStringArray(R.array.leica);
                break;
        }

        arrayLength=productItems.length;

        LinearLayout ll = (LinearLayout)findViewById(R.id.ll);
        for(int i = 0; i < arrayLength; i++) {
            CheckBox cb = new CheckBox(this);
            cb.setText(productItems[i]);
            cb.setId(100+i);
            cb.setTextSize(15);
            ll.addView(cb);
        }
    }

    public void GoTo_Fifth(View v){

        Intent intent=new Intent(FourthActivity.this,FifthActivity.class);
        // pass brand to FifthActivity
        intent.putExtra("brand",brand);
        String txtCheckBox=null;
        int countChecked=0;
        for(int i = 0; i < arrayLength; i++){
           CheckBox checkBox = (CheckBox) findViewById(100+i);
           if (checkBox.isChecked())
            {
                // pass every selected product to FifthActivity
                txtCheckBox= checkBox.getText().toString();
                intent.putExtra("product"+i,txtCheckBox);
                countChecked++;
            }
        }

        if (countChecked==0)
        {
            Toast.makeText(this,"Please select at least one product!", Toast.LENGTH_LONG).show();
        }

        else
        {
            // pass number of selected options to FifthActivity
            intent.putExtra("countChecked",String.valueOf(countChecked));
            // pass category to FifthActivity
            intent.putExtra("category",category);
            startActivity(intent);
        }
    }

    public void GoTo_Previous(View view) {

        Intent intent=new Intent(this,ThirdActivity.class);
        // pass category to ThirdActivity
        intent.putExtra("category",category);
        startActivity(intent);
    }

}


