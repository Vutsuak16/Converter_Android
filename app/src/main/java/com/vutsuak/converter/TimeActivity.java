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

public class TimeActivity extends Activity implements OnItemSelectedListener {
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
    double factor1 = 0.0;
    double factor2 = 0.0;
    private String[] state = {"millenneium", "century", "decade",
            "Julian year", "Gregorian year",
            "year", "month", "forthnight", "week", "day", "hour", "minute", "second", "millisecond", "microsecond","nanosecond"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        mEdit = (EditText) findViewById(R.id.from);
        set = (TextView) findViewById(R.id.textView2);
        set.setText("Time Converter");
        button= (Button) findViewById(R.id.convert);
        mEdit.setText("1");
        mediumText=(TextView)findViewById(R.id.textView3);
        mediumText.setText("1");
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
        HashMap unitToseconds;
        unitToseconds = new HashMap();
        HashMap secondTounit;
        secondTounit = new HashMap();



        unitToseconds.put("millenneium",31536000000.0);
        unitToseconds.put("century", 3153600000.0);
        unitToseconds.put("decade",315360000.0);
        unitToseconds.put("Julian Year",31557600.0);
        unitToseconds.put("Gregorian Year",31556952 );
        unitToseconds.put("year",31536000.0);
        unitToseconds.put("month",2629822.96584 );
        unitToseconds.put("forthnight",1209600.0);
        unitToseconds.put("week", 604800.0 );
        unitToseconds.put("day",86400.0);
        unitToseconds.put("hour",3600.0 );
        unitToseconds.put("minute",60.0);
        unitToseconds.put("second", 1.0);
        unitToseconds.put("millisecond",Math.pow(10, -3)*1.0);
        unitToseconds.put("microsecond",Math.pow(10,-6)*1.0);
        unitToseconds.put("nanosecond",Math.pow(10,-9)*1.0);

        secondTounit.put("millenneium",3.171*Math.pow(10,-11));
        secondTounit.put("century", 3.171*Math.pow(10,-10));
        secondTounit.put("decade",3.171*Math.pow(10,-9));
        secondTounit.put("Julian year", 3.169*Math.pow(10,-8));
        secondTounit.put("Gregorian year",3.169*Math.pow(10,-8));
        secondTounit.put("year", 3.171*Math.pow(10,-9));
        secondTounit.put("month",3.802*Math.pow(10,-7) );
        secondTounit.put("forthnight",8.27*Math.pow(10,-7));
        secondTounit.put("week",0.0000016);
        secondTounit.put("day",0.0000116);
        secondTounit.put("hour",0.000278);
        secondTounit.put("minute",0.0167);
        secondTounit.put("second",1.0);
        secondTounit.put("millisecond",1000.0);
        secondTounit.put("microsecond",1000000.0);
        secondTounit.put("nanosecond",Math.pow(10,9)*1.0);



        String key1 = null;
        String key2 = null;
        Iterator iterator1 = unitToseconds.keySet().iterator();
        Iterator iterator2 = secondTounit.keySet().iterator();
        while (iterator1.hasNext()) {
            key1 = (String) iterator1.next();
            if (key1.equals(f)) {
                factor1 = (double) unitToseconds.get(key1);
                break;
            }
        }
        while (iterator2.hasNext()) {
            key2 = (String) iterator2.next();
            if (key2.equals(t)) {
                factor2 = (double) secondTounit.get(key2);
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




