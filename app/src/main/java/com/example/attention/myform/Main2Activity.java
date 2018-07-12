package com.example.attention.myform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textViewResult = findViewById(R.id.textView_result);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String phone = getIntent().getStringExtra("phone");
        String password = getIntent().getStringExtra("password");
        String gender =getIntent().getStringExtra("gender");
        String vehicle=getIntent().getStringExtra("vehicle");;
        String city =getIntent().getStringExtra("City");;

        textViewResult.setText("Name : "+name+ "\nEmail : "+email+ "\nPhone : "+phone+ "\nPassword : "+password+
                "\n" + "Gender  : " + gender + "\n"
                        + "Vehicle : " + vehicle + "\n"+"city :" + city);
    }
}
