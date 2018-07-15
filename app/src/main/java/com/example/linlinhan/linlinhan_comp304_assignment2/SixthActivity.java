package com.example.linlinhan.linlinhan_comp304_assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SixthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        Intent intent=getIntent();
        // get values from FifthActivity
        TextView txtName=(TextView)findViewById(R.id.txtName);
        txtName.setText(intent.getStringExtra("name"));

        TextView txtAddress=(TextView)findViewById(R.id.txtAddress);
        txtAddress.setText(intent.getStringExtra("address"));

        TextView txtCreNum=(TextView)findViewById(R.id.txtCreNum);
        txtCreNum.setText(intent.getStringExtra("creNum"));

        TextView txtCreDate=(TextView)findViewById(R.id.txtCreDate);
        txtCreDate.setText(intent.getStringExtra("creDate"));

        TextView txtPhNum=(TextView)findViewById(R.id.txtPhNum);
        txtPhNum.setText(intent.getStringExtra("phNum"));

        TextView txtDate=(TextView)findViewById(R.id.txtDate);
        txtDate.setText(intent.getStringExtra("date"));

        TextView txtCategory=(TextView)findViewById(R.id.txtCategory);
        txtCategory.setText(intent.getStringExtra("category"));

        TextView txtBrand=(TextView)findViewById(R.id.txtBrand);
        txtBrand.setText(intent.getStringExtra("brand"));

        String product=intent.getStringExtra("product");
        TextView txtProduct=(TextView)findViewById(R.id.txtProduct);
        txtProduct.setText(product);


    }
}
