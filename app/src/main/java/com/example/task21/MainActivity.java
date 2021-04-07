package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {


     TextView display1, display2, display3, unit1, unit2, unit3;
     ImageButton metre, temp, kg;
     EditText userinput;
     Spinner spinner;

     private final String[] userOptions = {"Metre", "Celsius", "Kilogram"};

    private void initSpinner() {
        spinner = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, userOptions);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userinput = findViewById(R.id.editTextNumber);
        display1 = findViewById(R.id.textView2);
        display2 = findViewById(R.id.textView5);
        display3 = findViewById(R.id.textView6);
        unit1 = findViewById(R.id.textView3);
        unit2 = findViewById(R.id.textView4);
        unit3 = findViewById(R.id.textView7);
        metre = findViewById(R.id.imageButton2);
        temp = findViewById(R.id.imageButton4);
        kg = findViewById(R.id.imageButton6);
        metre.setOnClickListener((View.OnClickListener) this);
        temp.setOnClickListener((View.OnClickListener) this);
        kg.setOnClickListener((View.OnClickListener) this);
        initSpinner();


    }

    public void onClick(View v) {
        String select = spinner.getSelectedItem().toString();
        double input = Integer.parseInt(String.valueOf(userinput.getText()));

        switch (v.getId()) {
            case R.id.imageButton2: metre(input, select);
                break;
            case R.id.imageButton4: temp(input, select);
                break;
            case R.id.imageButton6: kg(input, select);
                break;
        }
    }

    public void metre(double num1, String selection) {
        if (!selection.equals("Metre")){
            Toast.makeText(this, "Please choose the correct option!", Toast.LENGTH_SHORT).show();
        }

        else {

            display1.setText(String.format("%.2f", num1*100));
            display2.setText(String.format("%.2f", num1*3.28));
            display3.setText(String.format("%.2f", num1*39.37));

        }
    }

    public void temp(double num2, String selection) {
        if (!selection.equals("Celsius")){
            Toast.makeText(this, "Please choose the correct option!", Toast.LENGTH_SHORT).show();
        }
        else {

            display1.setText(String.format("%.2f", num2 * 9 / 5 + 32));
            display2.setText(String.format("%.2f", num2+273.15));
            display3.setText("");

        }
    }

    public void kg(double num3, String selection) {
        if (!selection.equals("Kilogram")){
            Toast.makeText(this, "Please choose the correct option!", Toast.LENGTH_SHORT).show();
        }
        else {

            display1.setText(String.format("%.2f", num3/100));
            display2.setText(String.format("%.2f", num3*35.27));
            display3.setText(String.format("%.2f", num3*2.2));


        }
    }






}