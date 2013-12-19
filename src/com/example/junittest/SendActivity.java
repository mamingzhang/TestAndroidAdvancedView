package com.example.junittest;

import com.example.testandroidadvancedview.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SendActivity extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_activity_layout_main);
		findViewById(R.id.button1).setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				Intent intent = new Intent(SendActivity.this, ReceiveActivity.class);
				startActivity(intent);
			}
		});
	}
}
