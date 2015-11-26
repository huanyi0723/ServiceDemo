package org.crazyit.service;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BindServiceTest extends Activity implements View.OnClickListener {
	
	Intent intent = new Intent();
	Button bind, unbind, getServiceStatus;
	BindService.MyBinder binder;
	
	private ServiceConnection conn = new ServiceConnection() {
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			binder = (BindService.MyBinder) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.i("TAG", "onServiceDisconnected" + "断开连接");
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		initTitle();
		initData();
		initView();

	}

	public void initTitle() {

	}

	public void initData() {
		intent.setAction("org.crazyit.service.BIND_SERVICE");
	}

	public void initView() {
		bind = (Button) findViewById(R.id.bind);
		unbind = (Button) findViewById(R.id.unbind);
		getServiceStatus = (Button) findViewById(R.id.getServiceStatus);

		bind.setOnClickListener(this);
		unbind.setOnClickListener(this);
		getServiceStatus.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bind:// 绑定
			bindService(intent, conn, Service.BIND_AUTO_CREATE);

			break;
		case R.id.unbind:// 解绑
			unbindService(conn);
			break;
		case R.id.getServiceStatus:// 获取状态
			Toast.makeText(BindServiceTest.this, "Serivce的count值为：" + binder.getCount(), Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
}