package com.example.task21;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


     TextView display1, display2, display3, unit1, unit2, unit3;
     ImageButton metre, temp, kg;
     EditText input;
     Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.editTextNumber);

        display1 = findViewById(R.id.textView2);
        display2 = findViewById(R.id.textView5);
        display3 = findViewById(R.id.textView6);

        unit1 = findViewById(R.id.textView3);
        unit2 = findViewById(R.id.textView4);
        unit3 = findViewById(R.id.textView7);

        metre = findViewById(R.id.imageButton2);
        temp = findViewById(R.id.imageButton4);
        kg = findViewById(R.id.imageButton6);

        spinner = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();

                String selectedUnit = parent.getItemAtPosition(position).toString();
                if (selectedUnit.equals("Metre")) {
                    unit1.setText("Centimetre");
                    unit2.setText("Foot");
                    unit3.setText("Inch");
                }
                else if (selectedUnit.equals("Celsius")){
                    unit1.setText("Fahrenheit");
                    unit2.setText("Kelvin");
                    unit3.setText("");
                }
                else if (selectedUnit.equals("Kilograms")){
                    unit1.setText("Gram");
                    unit2.setText("Ounce(Oz)");
                    unit3.setText("Pound(lb)");
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        metre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num =  Double.parseDouble(input.getText().toString());

                double res1 = num * 100;
                double res2 = num / 0.3048;
                double res3 = num / 0.0254;
                res1 = Math.round(res1 * 100.0)/100.0;
                res2 = Math.round(res2 * 100.0)/100.0;
                res3 = Math.round(res3 * 100.0)/100.0;
                display1.setText(Double.toString(res1));
                display2.setText(Double.toString(res2));
                display3.setText(Double.toString(res3));
            }
        });

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num =  Double.parseDouble(input.getText().toString());

                double res1 = num * 1.8 + 32;
                double res2 = num + 273.15;
                res1 = Math.round(res1 * 100.0)/100.0;
                res2 = Math.round(res2 * 100.0)/100.0;
                display1.setText(Double.toString(res1));
                display2.setText(Double.toString(res2));
                display3.setText("");

            }
        });

        kg.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double num =  Double.parseDouble(input.getText().toString());
                double res1 = num * 1000;
                double res2 = num / 0.02834952;
                double res3 = num / 0.45359237;
                res1 = Math.round(res1 * 100.0)/100.0;
                res2 = Math.round(res2 * 100.0)/100.0;
                res3 = Math.round(res3 * 100.0)/100.0;
                display1.setText(Double.toString(res1));
                display2.setText(Double.toString(res2));
                display3.setText(Double.toString(res3));
            }
        }));



    }


}