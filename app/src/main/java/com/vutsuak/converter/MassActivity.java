package com.vutsuak.converter;

import android.app.Activity;


import java.util.HashMap;
import java.util.Iterator;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;

public class MassActivity extends Activity implements OnItemSelectedListener {
    String f;
    String t;
    Spinner spinner;
    String main;
    TextView set,mediumText;
    Spinner s1, s2;
    EditText mEdit;

    double val1=0.0;
    double Value=0.0;
    Button button ;
    double factor1 = 1.0;
    double factor2 = 1.0;
    private String[] state = {"atomic mass unit", "carat", "cental",
            "centigram", "decagram",
            "dram", "grain", "gram", "kilogram", "microgram", "milligram", "ounce", "pound", "qurater", "stone","tonne"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass);
        mEdit = (EditText) findViewById(R.id.from);
        set = (TextView) findViewById(R.id.textView2);
        set.setText("Mass Converter");
        button= (Button) findViewById(R.id.convert);
        mEdit.setText("1");
        mediumText=(TextView)findViewById(R.id.textView3);
        mediumText.setText("1.0");
        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, state);
        adapter_state
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(adapter_state);
        s2.setAdapter(adapter_state);
        s1.setOnItemSelectedListener(this);
        s2.setOnItemSelectedListener(this);



    }

    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {




        spinner = (Spinner) parent;
        if (spinner.getId() == R.id.spinner1) {
            s1.setSelection(position);
            f = (String) s1.getSelectedItem();
        } else if (spinner.getId() == R.id.spinner2) {
            s2.setSelection(position);
            t = (String) s2.getSelectedItem();
        }
        HashMap unitTokilograms;
        unitTokilograms = new HashMap();
        HashMap kilogramTounit;
        kilogramTounit = new HashMap();



        unitTokilograms.put("atomic mass unit", 1.66*Math.pow(10, -27));
        unitTokilograms.put("carat", 0.0002 );
        unitTokilograms.put("cental", 45.35 );
        unitTokilograms.put("centigram", Math.pow(10, -5)*1.0);
        unitTokilograms.put("decagram", Math.pow(10, -2)*1.0);
        unitTokilograms.put("dram", 0.00177);
        unitTokilograms.put("grain", 0.0000647);
        unitTokilograms.put("gram", 0.001 );
        unitTokilograms.put("kilogram", 1.0);
        unitTokilograms.put("microgram", Math.pow(10,-9)*1.0);
        unitTokilograms.put("milligram", Math.pow(10,-6)*1.0);
        unitTokilograms.put("ounce", 0.02834);
        unitTokilograms.put("pound", 0.4535);
        unitTokilograms.put("quarter", 12.70058);
        unitTokilograms.put("stone", 6.3502 );
        unitTokilograms.put("tonne", 1000.0);
        kilogramTounit.put("atomic mass unit",6.022*Math.pow(10,26));
        kilogramTounit.put("carat", 5000.0);
        kilogramTounit.put("cental", 0.022);
        kilogramTounit.put("centigram", 100000.0);
        kilogramTounit.put("decagram", 100.0 );
        kilogramTounit.put("dram", 564.3834);
        kilogramTounit.put("grain", 15432.3584);
        kilogramTounit.put("gram", 1000.0);
        kilogramTounit.put("kilogram", 1.0);
        kilogramTounit.put("microgram",1000000000.0);
        kilogramTounit.put("milligram",1000000.0);
        kilogramTounit.put("ounce",35.274);
        kilogramTounit.put("pound", 2.2046);
        kilogramTounit.put("quarter", 0.0787);
        kilogramTounit.put("stone",0.15747);
        kilogramTounit.put("tonne",0.001 );


        String key1 = null;
        String key2 = null;
        Iterator iterator1 = unitTokilograms.keySet().iterator();
        Iterator iterator2 = kilogramTounit.keySet().iterator();
        while (iterator1.hasNext()) {
            key1 = (String) iterator1.next();
            if (key1.equals(f)) {
                factor1 = (double) unitTokilograms.get(key1);
                break;
            }
        }
        while (iterator2.hasNext()) {
            key2 = (String) iterator2.next();
            if (key2.equals(t)) {
                factor2 = (double) kilogramTounit.get(key2);
                break;
            }
        }


        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                main = mEdit.getText().toString();
                val1 = Double.parseDouble(main);
                Value = val1 * factor1 * factor2;
                if(f.equals(t))
                    mediumText.setText("1");
                else
                    mediumText.setText(Double.toString(Value));
            }


        });



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
}




