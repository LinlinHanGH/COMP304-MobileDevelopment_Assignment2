package com.example.linlinhan.linlinhan_comp304_assignment2;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class FifthActivity extends AppCompatActivity {
    String brand;
    String product="";
    String category;

    Button displayDate;
    TextView textview1;
    private int selectedDate,selectedMonth,selectedYear;

    String selectedDMY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        Intent intent=getIntent();
        // get brand and category from FourthActivity
        brand=intent.getStringExtra("brand");
        category=intent.getStringExtra("category");
        int count=Integer.valueOf(intent.getStringExtra("countChecked")) ;

        for(int i=0;i<count;i++){
            product+=intent.getStringExtra("product"+i)+System.getProperty ("line.separator");
        }


        textview1=(TextView)findViewById(R.id.textView1);
        displayDate=(Button)findViewById(R.id.btnDate);

        displayDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // custom dialog
                final Dialog dialog = new Dialog(FifthActivity.this);
                dialog.setContentView(R.layout.datepickerview);
                dialog.setTitle("");

                DatePicker datePicker = (DatePicker) dialog.findViewById(R.id.date);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                selectedDate=calendar.get(Calendar.DAY_OF_MONTH);
                selectedMonth=calendar.get(Calendar.MONTH);
                selectedYear=calendar.get(Calendar.YEAR);
                datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {

                    @Override
                    public void onDateChanged(DatePicker datePicker, int year, int month, int dayOfMonth) {

                        selectedDMY=year + "-" + (month + 1) + "-" + dayOfMonth;
                        if(selectedDate ==dayOfMonth && selectedMonth==month && selectedYear==year) {
                            textview1.setText( selectedDMY);
                            dialog.dismiss();
                        }else {
                            if(selectedDate !=dayOfMonth){
                                textview1.setText(selectedDMY);
                                dialog.dismiss();
                            }else {
                                if(selectedMonth !=month){
                                    textview1.setText(selectedDMY);
                                    dialog.dismiss();
                                }
                            }
                        }
                        selectedDate=dayOfMonth;
                        selectedMonth=(month);
                        selectedYear=year;
                    }
                });

                dialog.show();
            }

        });
    }

    public void GoTo_Sixth(View view) {
        EditText edtName = (EditText)findViewById(R.id.edtName);
        EditText edtAddress = (EditText)findViewById(R.id.edtAddress);
        EditText edtCreNum = (EditText)findViewById(R.id.edtCreNum);
        EditText edtCreDate = (EditText)findViewById(R.id.edtCreDate);
        EditText edtPhNum = (EditText)findViewById(R.id.edtPhNum);

        if (edtName.getText().toString().trim().equals(""))
        {
            edtName.setError( "Name is required!" );
        }
        else if (edtAddress.getText().toString().trim().equals(""))
        {
            edtAddress.setError( "Address is required!" );
        }
        else if (edtCreNum.getText().toString().trim().equals("")){
            edtCreNum.setError( "Credit Card Number is required!" );
        }
        else if (edtCreDate.getText().toString().trim().equals("")){
            edtCreNum.setError( "Credit Card Expiration Date is required!" );
        }
        else{
            Intent intent=new Intent(this,SixthActivity.class);

            //pass all the values to SixthActivity
            intent.putExtra("name",edtName.getText().toString());
            intent.putExtra("address",edtAddress.getText().toString());
            intent.putExtra("creNum",edtCreNum.getText().toString());
            intent.putExtra("creDate",edtCreDate.getText().toString());
            intent.putExtra("phNum",edtPhNum.getText().toString());
            intent.putExtra("date",selectedDMY);
            intent.putExtra("category",category);
            intent.putExtra("brand",brand);
            intent.putExtra("product",product);
            startActivity(intent);
        }
    }

    public void GoTo_Previous(View view) {
        Intent intent=new Intent(this,FourthActivity.class);

        //pass brand and category to FourthActivity
        intent.putExtra("brand",brand);
        intent.putExtra("category",category);
        startActivity(intent);
    }
}
