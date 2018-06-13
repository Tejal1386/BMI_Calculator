package com.example.tejalpatel.bmi_calculator_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    RadioButton rgMale, rgFemale,rgstandard, rgmetrix;
    RadioGroup Rbmeasure;
    Button btnCalc;
    EditText etxt_age, etxt_height, etxt_weight ;
    TextView txtcat, txtWunit;
    int age;
    double height, weight, result;
    TableRow trStandard, trMetric ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btnCalc = (Button) findViewById(R.id.btnCalculate);
        etxt_age = (EditText) findViewById(R.id.etxt_age);
        etxt_height = (EditText) findViewById(R.id.etxt_height);
        etxt_weight = (EditText) findViewById(R.id.etxt_weight);
        txtcat = (TextView) findViewById(R.id.txt_category);
        Rbmeasure = (RadioGroup) findViewById(R.id.Rbmeasure);
        txtWunit= (TextView) findViewById(R.id.txtunit);
        trMetric = (TableRow) findViewById(R.id.trmetric);
        trStandard = (TableRow) findViewById(R.id.trstandard);

        Rbmeasure.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.rbstandard) {

                    txtWunit.setText("Lbs");
                    trStandard.setVisibility(View.VISIBLE);
                    trMetric.setVisibility(View.GONE);



                } else if(checkedId == R.id.rbmetric) {
                    txtWunit.setText("Kg");
                    trStandard.setVisibility(View.GONE);
                    trMetric.setVisibility(View.VISIBLE);
                }
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age =  Integer.parseInt(etxt_age.getText().toString());
                weight = Float.parseFloat(etxt_weight.getText().toString());
                height = Float.parseFloat(etxt_height.getText().toString());

                //setting error for if  fields are empty
                if (TextUtils.isEmpty(etxt_weight.getText().toString())) {
                    etxt_weight.setError("Please enter your weight");
                    etxt_weight.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(etxt_height.getText().toString())) {
                    etxt_height.setError("Please enter your height");
                    etxt_height.requestFocus();
                    return;
                }

                   weight = weight * 0.45 ;
                   height = height / 100.00 ;




                result = (float) (weight / height * height);
                txtcat.setText(String.valueOf( result));

            }
        });
    }
}
