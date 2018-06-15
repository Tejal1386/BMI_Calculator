package com.example.tejalpatel.bmi_calculator_app;

import android.annotation.SuppressLint;
import android.graphics.Color;
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

import static com.example.tejalpatel.bmi_calculator_app.R.color.colorAccent;

public class CalculatorActivity extends AppCompatActivity {

    RadioGroup rbMeasure;
    Button btnCalc;
    EditText etxtAge, etxtHeight,etxtHeightft,etxtHeightin, etxtWeight ;
    TextView txtCat, txtResult, txtWunit, txtVSunderweight, txtSunderweight, txtUnderweight, txtNormal, txtOverweight, txtObese1 , txtObese2, txtObese3;
    int age;
    String measurement = "Standard";
    int inch, feet;
    double height, weight, result;
    TableRow trStandard, trMetric ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        btnCalc = (Button) findViewById(R.id.btnCalculate);
        etxtAge = (EditText) findViewById(R.id.etxt_age);
        etxtHeight = (EditText) findViewById(R.id.etxt_height);
        etxtHeightft = (EditText) findViewById(R.id.etxt_heightft);
        etxtHeightin = (EditText) findViewById(R.id.etxt_heightin);
        etxtWeight = (EditText) findViewById(R.id.etxt_weight);
        txtCat = (TextView) findViewById(R.id.txt_category);
        txtResult = (TextView) findViewById(R.id.txt_result);
        rbMeasure = (RadioGroup) findViewById(R.id.Rbmeasure);
        txtWunit= (TextView) findViewById(R.id.txtunit);
        trMetric = (TableRow) findViewById(R.id.trmetric);
        trStandard = (TableRow) findViewById(R.id.trstandard);

        txtVSunderweight = (TextView) findViewById(R.id.VSUnderweight);
        txtSunderweight = (TextView) findViewById(R.id.SUnderweight);
        txtUnderweight = (TextView) findViewById(R.id.Underweight);
        txtNormal = (TextView) findViewById(R.id.Normal);
        txtOverweight = (TextView) findViewById(R.id.Overweight);
        txtObese1 = (TextView) findViewById(R.id.Obese1);
        txtObese2 = (TextView) findViewById(R.id.Obese2);
        txtObese3 = (TextView) findViewById(R.id.Obese3);

        rbMeasure.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.rbstandard) {
                    measurement = "Standard";
                    txtWunit.setText("Lbs");
                    trStandard.setVisibility(View.VISIBLE);
                    trMetric.setVisibility(View.GONE);

                } else if(checkedId == R.id.rbmetric) {
                    measurement = "Metric";
                    etxtWeight.setText("");
                    txtWunit.setText("Kg");
                    trStandard.setVisibility(View.GONE);
                    trMetric.setVisibility(View.VISIBLE);
                }
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                txtVSunderweight.setTextColor(Color.BLACK);
                txtSunderweight.setTextColor(Color.BLACK);
                txtUnderweight.setTextColor(Color.BLACK);
                txtNormal.setTextColor(Color.BLACK);
                txtOverweight.setTextColor(Color.BLACK);
                txtObese1.setTextColor(Color.BLACK);
                txtObese2.setTextColor(Color.BLACK);
                txtObese3.setTextColor(Color.BLACK);


                if(measurement.equals("Standard")){
                    weight = Double.parseDouble(etxtWeight.getText().toString());
                    feet = Integer.parseInt(etxtHeightft.getText().toString()) * 12;
                    inch = Integer.parseInt(etxtHeightin.getText().toString());
                    height = feet + inch;
                    result = ( (weight * 703) / (height * height)  ) ;
                }

                else if(measurement.equals("Metric")){
                    weight = Double.parseDouble(etxtWeight.getText().toString());
                    height = Double.parseDouble(etxtHeight.getText().toString());

                    result  = weight / ((height / 100) * (height / 100));

                }

                txtResult.setText(String.valueOf(Math.round(result * 10.00) / 10.00));
                txtCat.setText("");
                if(result < 16){
                    txtCat.setText("Very Seviour Underweight");
                    txtVSunderweight.setTextColor(Color.BLUE);
                }
                else if(result >= 16  && result <= 16.9){
                    txtCat.setText("Seviour Underweight");
                    txtSunderweight.setTextColor(Color.BLUE);
                }
                else if(result >= 17  && result <= 18.4){
                    txtCat.setText("Underweight");
                    txtUnderweight.setTextColor(Color.BLUE);
                }
                else if(result >= 18.5  && result <= 24.9){
                    txtCat.setText("Normal");
                    txtNormal.setTextColor(colorAccent);
                }
                else if(result >= 25  && result <= 29.9){
                    txtCat.setText("Over Weight");
                    txtOverweight.setTextColor(Color.RED);
                }
                else if(result >= 30  && result <= 34.9){
                    txtCat.setText("Obese 1");
                    txtObese1.setTextColor(Color.RED);
                }
                else if(result >= 35  && result <= 39.9){
                    txtCat.setText("Obese 2");
                    txtObese2.setTextColor(Color.RED);
                }
                else if(result >= 40 ){
                    txtCat.setText("Obese 3");
                    txtObese3.setTextColor(Color.RED);
                }

            }
        });
    }
}
