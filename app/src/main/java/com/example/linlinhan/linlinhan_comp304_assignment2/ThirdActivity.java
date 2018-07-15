package com.example.linlinhan.linlinhan_comp304_assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        RadioGroup rgp = (RadioGroup) findViewById(R.id.rdbGp1);
        String[] cellphones=getResources().getStringArray(R.array.cellPhones);
        String[] pcs=getResources().getStringArray(R.array.pcs);
        String[] tvs=getResources().getStringArray(R.array.tvs);
        String[] printers=getResources().getStringArray(R.array.printers);
        String[] accessories=getResources().getStringArray(R.array.accessories);

        String[] selectedArray=new String[]{};
        Intent intent=getIntent();
        // get category from SecondActivity
        category=intent.getStringExtra("category");
        // generate brand array according to the category
        switch (category){
            case "Cell Phones":
                selectedArray=cellphones;
                break;
            case "Laptops or Notebooks":
                selectedArray=pcs;
                break;
            case "Televisions or Smart TVs":
                selectedArray=tvs;
                break;
            case "Printers":
                selectedArray=printers;
                break;
            case "Accessories":
                selectedArray=accessories;
                break;
        }

        for(int i=0;i<selectedArray.length;i++)
        {
            RadioButton rbnCell = new RadioButton(this);
            rbnCell.setId(1000+i);
            rbnCell.setText(selectedArray[i]);
            rbnCell.setTextSize(15);
            rgp.addView(rbnCell);
        }

    }

    public void GoTo_Fourth(View v){
            RadioGroup rgp = (RadioGroup) findViewById(R.id.rdbGp1);
            int rbnCheckedId = rgp.getCheckedRadioButtonId();
            if (rbnCheckedId==-1)
            {
                Toast.makeText(this,"Please select the brand!", Toast.LENGTH_LONG).show();
            }
            else{
                RadioButton rbnChecked = (RadioButton) findViewById(rbnCheckedId);

                String rbnCheckedTxt=rbnChecked.getText().toString();

                    Intent intent=new Intent(ThirdActivity.this,FourthActivity.class);
                    // pass selected brand to FourthActivity
                    intent.putExtra("brand",rbnCheckedTxt);
                    // pass category(which is got from SecondActivity) to FourthActivity
                    intent.putExtra("category",category);
                    startActivity(intent);
            }
    }

    public void GoTo_Previous(View view) {
        startActivity(new Intent(this,SecondActivity.class));
    }


}
