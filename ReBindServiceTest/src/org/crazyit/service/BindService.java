
package org.crazyit.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class BindService extends Service {
	private int count;
	private boolean quit;
	private MyBinder binder = new MyBinder();

	public class MyBinder extends Binder 
	{
		public int getCount() {
			return count;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("Service is Binded");
		return binder;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		System.out.println("Service is Created");
		new Thread() {
			@Override
			public void run() {
				while (!quit) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					count++;
				}
			}
		}.start();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		System.out.println("Service is Started");
		return START_STICKY;
	}

	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("Service is Unbinded");
		return true;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		this.quit = true;
		System.out.println("Service is Destroyed");
	}

	@Override
	public void onRebind(Intent intent) {
		super.onRebind(intent);
		this.quit = true;
		System.out.println("---Service is ReBinded---");
	}
}