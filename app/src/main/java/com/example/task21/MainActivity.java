package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;




public class MainActivity extends AppCompatActivity {


     TextView display1, display2, display3, unit1, unit2, unit3;
     ImageButton metre, temp, kg;
     EditText user_input;
     Spinner spinner;

     private final String[] userOptions = {"Metre", "Celsius", "Kilogram"};


    private void initSpinner() {
        spinner = findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, userOptions);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectionUnit = parent.getItemAtPosition(position).toString();

                if(selectionUnit.equals("Metre")){
                    unit1.setText("Centimetre");
                    unit2.setText("Foot");
                    unit3.setText("Inch");
                }
                else if (selectionUnit.equals("Celsius")){
                    unit1.setText("Fahrenheit");
                    unit2.setText("Kelvin");
                    unit3.setText("");
                    display3.setText("");
                }
                else if (selectionUnit.equals("Kilogram")){
                    unit1.setText("Gram");
                    unit2.setText("Ounce(Oz)");
                    unit3.setText("Pound(lb)");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user_input = findViewById(R.id.editTextNumber);
        display1 = findViewById(R.id.textView2);
        display2 = findViewById(R.id.textView5);
        display3 = findViewById(R.id.textView6);
        unit1 = findViewById(R.id.textView3);
        unit2 = findViewById(R.id.textView4);
        unit3 = findViewById(R.id.textView7);
        metre = findViewById(R.id.imageButton2);
        temp = findViewById(R.id.imageButton4);
        kg = findViewById(R.id.imageButton6);
        metre = findViewById(R.id.imageButton2);
        temp = findViewById(R.id.imageButton4);
        kg = findViewById(R.id.imageButton6);
        initSpinner();



        metre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = spinner.getSelectedItem().toString();
                double input = Integer.parseInt(String.valueOf(user_input.getText()));
                try{
                    if (text.equals("Metre")) {
                        display1.setText(String.format("%.2f", input*100));
                        display2.setText(String.format("%.2f", input/0.3048));
                        display3.setText(String.format("%.2f", input/0.0254));
                    } else {
                        Toast.makeText(MainActivity.this, "Please click the correct button!", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception NumberFormatException){

                }

            }

        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = spinner.getSelectedItem().toString();
                double input = Integer.parseInt(String.valueOf(user_input.getText()));
                try{
                    if (text.equals("Celsius")) {
                        display1.setText(String.format("%.2f", input * 9 / 5 + 32));
                        display2.setText(String.format("%.2f", input+273.15));
                        display3.setText("");
                    } else {
                        Toast.makeText(MainActivity.this, "Please click the correct button!", Toast.LENGTH_SHORT).show();
                    }
                }catch(Exception NumberFormatException){

                }

            }
        });

        kg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = spinner.getSelectedItem().toString();
                double input = Integer.parseInt(String.valueOf(user_input.getText()));

                try{
                    if (text.equals("Kilogram")){
                        display1.setText(String.format("%.2f", input*1000));
                        display2.setText(String.format("%.2f", input/0.02834952));
                        display3.setText(String.format("%.2f", input/0.45359237));

                    }else{
                        Toast.makeText(MainActivity.this, "Please click the correct button!", Toast.LENGTH_SHORT).show();
                    }

                }catch (Exception NumberFormatException){

                }

            }
        });



    }








}