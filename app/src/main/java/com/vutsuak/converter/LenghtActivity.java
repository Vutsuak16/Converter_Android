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

public class LenghtActivity extends Activity implements OnItemSelectedListener {
    String f;
    String t;
    Spinner spinner;
    String main;
    TextView set;
    Spinner s1, s2;
    EditText mEdit;
    double val1=0.0;
    double Value=0.0;
    Button button ;
    double factor1 = 0.0;
    double factor2 = 0.0;
    private String[] state = {"angstrom", "astronomical", "centimeter",
            "decimeter", "foot",
            "inch", "kilometer", "light year", "meter", "mile", "millimeter", "micrometer", "micron", "nanometer", "nautical mile", "yard"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lenght);
        set = (TextView) findViewById(R.id.textView3);
        set.setText("");
        button= (Button) findViewById(R.id.convert);
        mEdit = (EditText) findViewById(R.id.from);
        mEdit.setText("1");
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
        HashMap unitTometer;
        unitTometer = new HashMap();
        HashMap meterTounit;
        meterTounit = new HashMap();



        unitTometer.put("angstrom", Math.pow(10, -10)*1.0);
        unitTometer.put("astronomical", 149597870691.0);
        unitTometer.put("centimeter", Math.pow(10, -2)*1.0);
        unitTometer.put("chain", Math.pow(10, -10)*1.0);
        unitTometer.put("decimeter", Math.pow(10, -1)*1.0);
        unitTometer.put("fathom", 1.8288);
        unitTometer.put("foot", 0.3048);
        unitTometer.put("furlong", 201.168);
        unitTometer.put("inch", 0.0254);
        unitTometer.put("kilometer", 1000.0);
        unitTometer.put("league", 4828.032);
        unitTometer.put("light year", 9460730472581000.0);
        unitTometer.put("meter", 1.0);
        unitTometer.put("mile", 1609.344);
        unitTometer.put("millimeter", Math.pow(10, -3)*1.0);
        unitTometer.put("micrometer", Math.pow(10, -6)*1.0);
        unitTometer.put("nanometer", Math.pow(10, -9)*1.0);
        unitTometer.put("nautical mile", 1852.0);
        unitTometer.put("parsec", 30856775813060000.0);
        unitTometer.put("rod", 5.0292);
        unitTometer.put("yard", .9144);
        meterTounit.put("angstrom",Math.pow(10,10)*1.0);
        meterTounit.put("astronomical", 6.6846587 * Math.pow(10, -12));
        meterTounit.put("centimeter", 100.0);
        meterTounit.put("chain", 0.04970969537899);
        meterTounit.put("decimeter", 10.0);
        meterTounit.put("fathom", 0.5468066491689);
        meterTounit.put("foot", 3.280839895013);
        meterTounit.put("furlong", 0.004970969537899);
        meterTounit.put("inch", 39.37007874016);
        meterTounit.put("kilometer", 0.0001);
        meterTounit.put("league", 0.0002071237307458);
        meterTounit.put("light year", 1.057000834025 * Math.pow(10, -16));
        meterTounit.put("meter", 1.0);
        meterTounit.put("mile", 0.0006213711922373);
        meterTounit.put("millimeter", 1000.0);
        meterTounit.put("micrometer", 1000000.0);
        meterTounit.put("nanometer", 1000000000.0);
        meterTounit.put("nautical mile", 0.0005399568034557);
        meterTounit.put("parsec", 3.240779289639 * Math.pow(10, -17));
        meterTounit.put("rod", 0.198838781516);
        meterTounit.put("yard", 1.093613298338);


        String key1 = null;
        String key2 = null;
        Iterator iterator1 = unitTometer.keySet().iterator();
        Iterator iterator2 = meterTounit.keySet().iterator();
        while (iterator1.hasNext()) {
            key1 = (String) iterator1.next();
            if (key1.equals(f)) {
                factor1 = (double) unitTometer.get(key1);
                break;
            }
        }
        while (iterator2.hasNext()) {
            key2 = (String) iterator2.next();
            if (key2.equals(t)) {
                factor2 = (double) meterTounit.get(key2);
                break;
            }
        }
        System.out.println(factor1);
        System.out.println(factor2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                main = mEdit.getText().toString();
                val1 = Double.parseDouble(main);
                Value = val1 * factor1 * factor2;

                if(f.equals(t))
                    set.setText("1");
                else
                    set.setText(Double.toString(Value));
            }


        });



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }
}

