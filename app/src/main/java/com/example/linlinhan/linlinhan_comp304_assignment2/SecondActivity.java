package com.example.linlinhan.linlinhan_comp304_assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.category,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent(this,ThirdActivity.class);

        //pass value to ThirdActivity according to the selected option on SecondActivity
        switch (item.getItemId()){
            case R.id.cellPhones:
                intent.putExtra("category","Cell Phones");
                break;
            case R.id.pcs:
                intent.putExtra("category","Laptops or Notebooks");
                break;
            case R.id.tvs:
                intent.putExtra("category","Televisions or Smart TVs");
                break;
            case R.id.printers:
                intent.putExtra("category","Printers");
                break;
            case R.id.accessories:
                intent.putExtra("category","Accessories");
                break;

        }
        startActivity(intent);
        return true;
    }

    public void GoTo_Previous(View view) {
        startActivity(new Intent(this,FirstActivity.class));
    }
}
