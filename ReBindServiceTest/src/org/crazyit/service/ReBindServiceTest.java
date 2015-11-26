package org.crazyit.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ReBindServiceTest extends Activity {
	BindService.MyBinder binder;
	Intent intent;
	private ServiceConnection conn = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("--Service Connected--");
			binder = (BindService.MyBinder) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			System.out.println("--Service Disconnected--");
		}
	};

	public void start(View source) {
		startService(intent);
	}

	public void bind(View source) {
		bindService(intent, conn, Service.BIND_AUTO_CREATE);
	}

	public void unBind(View source) {
		unbindService(conn);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		intent = new Intent();
		intent.setAction("org.crazyit.service.BIND_SERVICE");
	}
}