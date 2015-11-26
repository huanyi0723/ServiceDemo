package org.crazyit.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class BindService extends Service {

	private int count;
	private boolean quit;
	private MyBinder binder = new MyBinder();

	public class MyBinder extends Binder {
		public int getCount() {
			return count;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.i("TAG", "onBind" );
		// 返回IBinder对象
		return binder;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("TAG", "onCreate" + "创建");
		
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
	public boolean onUnbind(Intent intent) {
		Log.i("TAG", "onUnbind");
		return true;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		this.quit = true;
		Log.i("TAG", "onDestroy");
	}
}