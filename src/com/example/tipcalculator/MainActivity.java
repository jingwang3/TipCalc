package com.example.tipcalculator;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText totalPerPerson, peopleTotal, tipRate, billBeforeTax, totalTax, mealTotal;
	private InputMethodManager imm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		billBeforeTax = (EditText) findViewById(R.id.editText1);
		peopleTotal = (EditText) findViewById(R.id.editText2);
		tipRate = (EditText) findViewById(R.id.editText3);
		totalTax = (EditText) findViewById(R.id.editText6);
		mealTotal = (EditText) findViewById(R.id.editText5);
		totalPerPerson = (EditText) findViewById(R.id.editText4);
		totalPerPerson.setKeyListener(null);
		mealTotal.setKeyListener(null);
		
		imm = (InputMethodManager)getSystemService(
			      Context.INPUT_METHOD_SERVICE);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/** Called when the user touches the button */
	public void calculateTotal(View view) {
		int perPersonRate = 0;
		int finalTotalBill = 0;
		// Do something in response to button click
		if(billBeforeTax.getText().length() <= 0){
			billBeforeTax.setText("0.0");
		}
		if(totalTax.getText().length() <= 0){
			totalTax.setText("0.0");
		}
		if(peopleTotal.getText().length() <= 0){
			peopleTotal.setText("1");
		}
		if(tipRate.getText().length() <= 0){
			tipRate.setText("15");
		}
		
		try {
			perPersonRate = Math.round((Float.parseFloat(billBeforeTax.getText().toString())
					* (1 + Float.parseFloat(tipRate.getText().toString()) / 100) + Float.parseFloat(totalTax.getText().toString()))
					/ Float.parseFloat(peopleTotal.getText().toString()));
			
			finalTotalBill = Math.round(perPersonRate * Float.parseFloat(peopleTotal.getText().toString()));
			
			
			totalPerPerson.setText("$ " + perPersonRate);
			mealTotal.setText("$ " + finalTotalBill);
		} catch (Exception e) {

		}
		
		imm.hideSoftInputFromWindow(totalPerPerson.getWindowToken(), 0);
		
	}

}
