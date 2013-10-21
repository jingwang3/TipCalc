package com.example.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText tipTotal, peopleTotal, tipRate, billTotal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		billTotal = (EditText) findViewById(R.id.editText1);
		peopleTotal = (EditText) findViewById(R.id.editText2);
		tipRate = (EditText) findViewById(R.id.editText3);
		tipTotal = (EditText) findViewById(R.id.editText4);
		tipTotal.setKeyListener(null);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/** Called when the user touches the button */
	public void calculateTotal(View view) {
		// Do something in response to button click
		if(billTotal.getText().length() <= 0){
			billTotal.setText("0");
		}
		if(peopleTotal.getText().length() <= 0){
			peopleTotal.setText("1");
		}
		if(tipRate.getText().length() <= 0){
			tipRate.setText("15");
		}
		
		
		try {
			tipTotal.setText("$ "
					+ Float.parseFloat(billTotal.getText().toString())
					* (1 + Float.parseFloat(tipRate.getText().toString()) / 100)
					/ Float.parseFloat(peopleTotal.getText().toString()));
		} catch (Exception e) {

		}
	}

}
