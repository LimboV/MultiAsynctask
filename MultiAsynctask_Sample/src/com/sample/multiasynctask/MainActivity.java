package com.sample.multiasynctask;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btn_start).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		int what = 0;
		int value = 0;
		for (int i = 0; i < 7; i++) {
			what += 1;
			value += 1;
			LongAsynctask asynctask = new LongAsynctask();
			asynctask.execute(new Paramer(what, value));
		}
	}
}
