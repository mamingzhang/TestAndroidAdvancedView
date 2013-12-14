package com.example.testviewtransition;

import com.example.testandroidadvancedview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.ViewSwitcher;

public class ViewSwitcherActivity extends Activity implements OnGestureListener
{
	private ViewSwitcher mViewSwitcher;
	private GestureDetector mGestureDector;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewswitcher_activity_main);
		mViewSwitcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);
		mViewSwitcher.setInAnimation(this, android.R.anim.fade_in);
		mViewSwitcher.setOutAnimation(this, android.R.anim.fade_out);
		mGestureDector = new GestureDetector(this, this);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		mGestureDector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY)
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY)
	{
		// TODO Auto-generated method stub
		if (e1.getRawY() > e2.getRawY())
		{
			mViewSwitcher.showNext();
		}
		else
		{
			mViewSwitcher.showPrevious();
		}
		return false;
	}
}
