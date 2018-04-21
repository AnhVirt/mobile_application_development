package com.example.anhviet.moneychange;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity {
    private Spinner spinner1;
    private Spinner spinner2;
    private EditText editText1;
    private TextView textView;
    private double rate = 0;
    private ExchangeRate hashMap = new ExchangeRate();
    private DecimalFormat df = new DecimalFormat("###,###.###");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = this.findViewById(R.id.editText);
        spinner1 = this.findViewById(R.id.spinner1);
        spinner2 = this.findViewById(R.id.spinner2);
        textView = this.findViewById(R.id.textView);

        List<String> list = new ArrayList<>();
        list.add("USD");
        list.add("AUD");
        list.add("VND");
        list.add("EUR");
        hashMap.onCreate();
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_activated_1);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                editText1.setHint(spinner1.getSelectedItem().toString());
                if(editText1.getText().length() > 0){
                    rate =  ExchangeRate(spinner1,spinner2);
                    textView.setText(ChangeRate(editText1.getText().toString(),rate));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setHint(spinner2.getSelectedItem().toString());
                if(editText1.getText().length() > 0){
                    rate =  ExchangeRate(spinner1,spinner2);
                    textView.setText(ChangeRate(editText1.getText().toString(),rate));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                double rate = 1;
                if(editText1.getText().hashCode()== s.hashCode()){
                    if(editText1.getText().length() > 0){
                        rate =  ExchangeRate(spinner1,spinner2);
                        textView.setText(ChangeRate(editText1.getText().toString(),rate));
                    }
                    else
                        textView.setText("");

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    protected double ExchangeRate(Spinner spinner1,Spinner spinner2){
        String x = spinner1.getSelectedItem().toString();
        String y = spinner2.getSelectedItem().toString();
        rate = hashMap.get(x) / hashMap.get(y);
        return rate;
    }
    protected  String ChangeRate(String s,Double d){
        return String.valueOf( df.format(Double.parseDouble(s)* d));
    }

}

