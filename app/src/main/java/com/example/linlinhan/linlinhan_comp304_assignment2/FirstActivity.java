package com.example.linlinhan.linlinhan_comp304_assignment2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    public void GoTo_Second(View v) {
        if(v.getId()==R.id.btnShop)
        {
            //open SecondActivity
            startActivity(new Intent(this,SecondActivity.class));
        }

    }


}
