package com.fullpagedeveloper.searchvoice;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

	private static final String TAG = "MainActivity";
	TextView tvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button = (Button) findViewById(R.id.btn_Voice);
		tvResult = (TextView) findViewById(R.id.tvResult);

	}

	public void onSearchClick(View v) {
		try {
			Intent intent = new Intent(RecognizerIntent.ACTION_WEB_SEARCH);
			//String term = tvResult.getText().toString();
			intent.putExtra(RecognizerIntent.ACTION_WEB_SEARCH, RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
			intent.putExtra(RecognizerIntent.ACTION_WEB_SEARCH, Locale.getDefault());
			if (intent.resolveActivity(getPackageManager()) != null) {
				startActivityForResult(intent, 10);
			} else {
				Toast.makeText(getApplicationContext(), "Your device don't support speech input!", Toast.LENGTH_LONG).show();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
