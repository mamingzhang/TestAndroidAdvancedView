package com.example.testviewtransition;

import com.example.testandroidadvancedview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewAnimator;

public class ViewAnimatorActivity extends Activity
{	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewanimator_activity_main);
		
		final ViewAnimator viewAnimator = (ViewAnimator)findViewById(R.id.viewAnimator);
		findViewById(R.id.showNext).setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				viewAnimator.showNext();
			}
		});
		findViewById(R.id.showPrevious).setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
				viewAnimator.showPrevious();
			}
		});
	}
}
