package com.example.testviewtransition;

import com.example.testandroidadvancedview.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

/*
 * http://blog.csdn.net/tianjf0514/article/details/7556487
 */
public class TextSwitcherActivity extends Activity implements ViewFactory,
		OnTouchListener
{
	private TextSwitcher textSwicher;

	// 图片数组
	private String[] arrayTexts = { "文本01", "文本02", "文本03", "文本04" };
	// 要显示的图片在图片数组中的Index
	private int textIndex;
	// 左右滑动时手指按下的X坐标
	private float touchDownX;
	// 左右滑动时手指松开的X坐标
	private float touchUpX;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.textswitcher_activity_main);
		textSwicher = (TextSwitcher) findViewById(R.id.textSwicher);

		// 为TextSwitcher设置Factory，用来为TextSwitcher制造TextView
		textSwicher.setFactory(this);
		// 设置TextSwitcher左右滑动事件
		textSwicher.setOnTouchListener(this);
	}

	@Override
	public View makeView()
	{
		// TODO Auto-generated method stub
		TextView textView = new TextView(this);
		textView.setTextSize(100);
		textView.setLayoutParams(new TextSwitcher.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		textView.setGravity(Gravity.CENTER);
		textView.setText(arrayTexts[textIndex]);
		return textView;
	}

	@Override
	public boolean onTouch(View v, MotionEvent event)
	{
		// TODO Auto-generated method stub
		if (event.getAction() == MotionEvent.ACTION_DOWN)
		{
			// 取得左右滑动时手指按下的X坐标
			touchDownX = event.getX();
			return true;
		}
		else if (event.getAction() == MotionEvent.ACTION_UP)
		{
			// 取得左右滑动时手指松开的X坐标
			touchUpX = event.getX();
			// 从左往右，看前一文本
			if (touchUpX - touchDownX > 100)
			{
				// 取得当前要看的文本的index
				textIndex = textIndex == 0 ? arrayTexts.length - 1
						: textIndex - 1;
				// 设置文本切换的动画
				textSwicher.setInAnimation(AnimationUtils.loadAnimation(this,
						android.R.anim.slide_in_left));
				textSwicher.setOutAnimation(AnimationUtils.loadAnimation(this,
						android.R.anim.slide_out_right));
				// 设置当前要看的文本
				textSwicher.setText(arrayTexts[textIndex]);
				// 从右往左，看下一张
			}
			else if (touchDownX - touchUpX > 100)
			{
				// 取得当前要看的文本的index
				textIndex = textIndex == arrayTexts.length - 1 ? 0
						: textIndex + 1;
				// 设置文本切换的动画
				// 由于Android没有提供slide_out_left和slide_in_right，所以仿照slide_in_left和slide_out_right编写了slide_out_left和slide_in_right
				textSwicher.setInAnimation(AnimationUtils.loadAnimation(this,
						R.anim.slide_out_left));
				textSwicher.setOutAnimation(AnimationUtils.loadAnimation(this,
						R.anim.slide_in_right));
				// 设置当前要看的文本
				textSwicher.setText(arrayTexts[textIndex]);
			}
			return true;
		}
		return false;
	}
}
