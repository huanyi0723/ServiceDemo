package org.crazyit.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {
	public MyIntentService() {
		super("MyIntentService");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		long endTime = System.currentTimeMillis() + 20 * 1000;
		System.out.println("onStart");
		while (System.currentTimeMillis() < endTime) {
			synchronized (this) {
				try {
					wait(endTime - System.currentTimeMillis());
				} catch (Exception e) {
				}
			}
		}
		Log.i("TAG", "onHandleIntent");
	}
}
