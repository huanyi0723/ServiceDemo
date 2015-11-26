package org.crazyit.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		long endTime = System.currentTimeMillis() + 20 * 1000;
		while (System.currentTimeMillis() < endTime) {
			synchronized (this) {
				try {
					wait(endTime - System.currentTimeMillis());
				} catch (Exception e) {
				}
			}
		}
		return START_STICKY;
	}
}
