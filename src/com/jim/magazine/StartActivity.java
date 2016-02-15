package com.jim.magazine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * 启动页
 * 
 * author:jim
 * 
 * 
 * */

public class StartActivity extends Activity{
	private AppManager manager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_startpage);
		manager = AppManager.getInstance();
		manager.addActivity(StartActivity.this);
		new MyThread().start();
	}
	
	class MyThread extends Thread {
		@Override
		public void run() {
			try {
				Thread.sleep(3000);
				
				//引导到登录界面
				Intent intent=new Intent(StartActivity.this,LoginActivity.class);
				startActivity(intent);
				
				manager.killActivity(StartActivity.this);
			} catch (Exception e) {
				e.printStackTrace();
			}
			super.run();
		}
	}
	
}
