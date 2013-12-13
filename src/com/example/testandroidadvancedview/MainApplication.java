package com.example.testandroidadvancedview;


import android.app.Application;

public class MainApplication extends Application
{
	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		super.onCreate();
		CrashHandler crashHandler = CrashHandler.getInstance();  
        // ע��crashHandler  
        crashHandler.init(getApplicationContext());
	}
}
