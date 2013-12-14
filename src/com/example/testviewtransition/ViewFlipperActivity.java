package com.example.testviewtransition;

import com.example.testandroidadvancedview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

/*
 * http://www.truiton.com/2013/07/android-viewflipper-with-swipe-by-motionevent-class/
 */
public class ViewFlipperActivity extends Activity
{
	private ViewFlipper mViewFlipper;
	private float initialX;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewflipper_activity_main);
		mViewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
		mViewFlipper.setInAnimation(this, android.R.anim.fade_in);
		mViewFlipper.setOutAnimation(this, android.R.anim.fade_out);
	}

	@Override
	public boolean onTouchEvent(MotionEvent touchevent)
	{
		switch (touchevent.getAction())
		{
		case MotionEvent.ACTION_DOWN:
			initialX = touchevent.getX();
			break;
		case MotionEvent.ACTION_UP:
			float finalX = touchevent.getX();
			if (initialX > finalX)
			{
				if (mViewFlipper.getDisplayedChild() == 1)
					break;

				mViewFlipper.setOutAnimation(this, R.anim.out_left);
				mViewFlipper.setInAnimation(this, R.anim.in_right);
				mViewFlipper.showNext();
				
			}
			else
			{
				if (mViewFlipper.getDisplayedChild() == 0)
					break;

				mViewFlipper.setOutAnimation(this, R.anim.out_right);
				mViewFlipper.setInAnimation(this, R.anim.in_left);
				mViewFlipper.showPrevious();
			}
			break;
		}
		return false;
	}
}
