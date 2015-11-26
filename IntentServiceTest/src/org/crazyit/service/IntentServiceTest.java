package org.crazyit.service;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class IntentServiceTest extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	public void startService(View source) {
		Intent intent = new Intent(this, MyService.class);
		startService(intent);
	}

	public void startIntentService(View source) {
		Intent intent = new Intent(this, MyIntentService.class);
		startService(intent);
	}
}
