package com.example.testscreenrotation;

import com.example.testandroidadvancedview.R;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class TestScreenRotationActivity extends Activity
{
	private static final String TAG = "TestScreenRotationActivity";
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.screen_rotation_activity_main);
		
		Log.v(TAG, "onCreate");
	}
	
	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onRestoreInstanceState(savedInstanceState);
		
		Log.v(TAG, "onRestoreInstanceState");
	}

	@Override
	protected void onStart()
	{
		// TODO Auto-generated method stub
		super.onStart();
		Log.v(TAG, "onStart");
	}

	@Override
	protected void onRestart()
	{
		// TODO Auto-generated method stub
		super.onRestart();
		Log.v(TAG, "onRestart");
	}

	@Override
	protected void onResume()
	{
		// TODO Auto-generated method stub
		super.onResume();
		Log.v(TAG, "onResume");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState)
	{
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.v(TAG, "onSaveInstanceState");
	}

	@Override
	protected void onPause()
	{
		// TODO Auto-generated method stub
		super.onPause();
		Log.v(TAG, "onPause");
	}

	@Override
	public Object onRetainNonConfigurationInstance()
	{
		// TODO Auto-generated method stub
		Log.v(TAG, "onRetainNonConfigurationInstance");

		return super.onRetainNonConfigurationInstance();
	}

	@Override
	protected void onStop()
	{
		// TODO Auto-generated method stub
		super.onStop();
		Log.v(TAG, "onStop");
	}

	@Override
	protected void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v(TAG, "onConfigurationChanged");
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		Log.v(TAG, "onConfigurationChanged");
	}
}
