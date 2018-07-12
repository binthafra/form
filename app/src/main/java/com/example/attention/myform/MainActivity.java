package com.example.attention.myform;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextPhone;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private RadioGroup radioGroup;
    private CheckBox checkBoxBike;
    private CheckBox checkBoxCar;
    private TextView textViewResult;
    private Spinner spinnerCity;
    String[] cities = {"Chittagong","Dhaka","Noakhali","Barishal"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextFirstName = findViewById(R.id.editText_firstName);
        editTextLastName = findViewById(R.id.editText_lastName);
        editTextEmail = findViewById(R.id.editText_email);
        editTextPhone = findViewById(R.id.editText_phone);
        editTextPassword = findViewById(R.id.editText_password);
        radioGroup = findViewById(R.id.myRadioGroup);
        checkBoxCar = findViewById(R.id.checkbox_car);
        checkBoxBike = findViewById(R.id.checkbox_bike);
        textViewResult = findViewById(R.id.textView_result);
        spinnerCity=findViewById(R.id.spinner_city);

        ArrayAdapter<String> adapter =new ArrayAdapter ( this,android.R.layout.simple_list_item_1,cities );
        spinnerCity.setAdapter(adapter);
    }

String gender = "";
    public void radioButton1(View view) {
        boolean click = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.radioButton1:
                if(click){
                   gender = "Male";
                }
            case R.id.radioButton2:
                if(click){
                    gender="Female";
                }
        }
    }
    String vehicle = "";
    String city = "";
    public void submit(View view) {
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();
        String password = editTextPassword.getText().toString();
        vehicle ="";

        if (checkBoxBike.isChecked()) {
            vehicle += "Bike";
        }

        if (checkBoxCar.isChecked()) {
            vehicle += "\tCar";
        }


         city = " ";
        int position =spinnerCity.getSelectedItemPosition();

        city += cities[position];

        textViewResult.setText("Name : "+ firstName  + lastName + "\n" + "Email address : " + email + "\n" + "Phone no: " + phone + "\n"
                + "Password : " + password + "\n" + "Gender : " + gender + "\n"
                + "Vehicle : " + vehicle + "\n"+"city :" + city);

    }

    public void goToSecondActivity(View view) {


        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();
        String password = editTextPassword.getText().toString();


        Intent intent = new Intent(this, Main2Activity.class);

        intent.putExtra("name", firstName +lastName);
        intent.putExtra("email", email);
        intent.putExtra("phone", phone);
        intent.putExtra("password", password);
        intent.putExtra("gender", gender);
        intent.putExtra("vehicle",vehicle);
        intent.putExtra("City",city);

        startActivity(intent);
        }

    public void SendtoGmail(View view) {
        String firstName = editTextFirstName.getText().toString();
        String lastName = editTextLastName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();
        String password = editTextPassword.getText().toString();
        String vehicle ="";
        String city="";

        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("https://mail.google.com/mail"));
        intent.putExtra(Intent.EXTRA_EMAIL,"xxxxx@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT,"My info");
        intent.putExtra(Intent.EXTRA_TEXT,"Name : " +firstName  +lastName+ "\nEmail address: "+email+ "\nCell no. : "+phone+
                "\nPassword : "+password+ "\n" + "Gender : " + gender + "\n"
                + "Vehicle : " + vehicle + "\n"+"City :" + city);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
