package com.a29moon.apples2lemons;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Create variables to hold the prices and quantities
    double item1Price;
    double item1Quantity;
    double item1Result;

    String spinnerSelectionUnit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.units_drop_down_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.units_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }


    public void calculateUnitCosts(View view) {

        // Connect the Views to the Java code:
        EditText edtxt_item1_price = findViewById(R.id.edtxt_item1_price);;
        EditText edtxt_item1_quantity = findViewById(R.id.edtxt_item1_quantity);


        item1Price = Double.parseDouble(edtxt_item1_price.getText().toString());
        item1Quantity = Double.parseDouble(edtxt_item1_quantity.getText().toString());
        item1Result = item1Price / item1Quantity;

        updateResults();


    }

    public void updateResults() {
        TextView txtview_item1_result = findViewById(R.id.txtview_item1_result);
        txtview_item1_result.setText(formatResult(item1Result));

    }

    public String formatResult(double numToFormat) {
        String formattedResult = "$" + String.format("%.2f", numToFormat);

        // This is where the text string will determine which unit to display

        return formattedResult;
    }







}
