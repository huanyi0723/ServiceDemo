package org.crazyit.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartServiceTest extends Activity {
	Button start, stop;
	 Intent intent = new Intent();

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
    	intent.setAction("org.crazyit.service.FIRST_SERVICE");
    }

    public void initView() {
    	start = (Button) findViewById(R.id.start);
		stop = (Button) findViewById(R.id.stop);
		
		start.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// 启动 
				startService(intent);
			}
		});
		stop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// 停止 
				stopService(intent);
			}
		});
    }
}