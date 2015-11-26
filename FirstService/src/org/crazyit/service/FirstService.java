/**
 *
 */
package org.crazyit.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FirstService extends Service {
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.i("TAG", "onCreate" + "创建");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.i("TAG", "onStartCommand" + "启动");
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.i("TAG", "onDestroy" + "关闭");
	}
}
