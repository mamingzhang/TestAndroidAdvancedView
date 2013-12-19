package com.example.testandroidadvancedview.test;

import com.example.testandroidadvancedview.MainActivity;
import com.example.testandroidadvancedview.R;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.MediumTest;
import android.view.View;
import android.widget.ListView;

public class MainActivityTest extends
		ActivityInstrumentationTestCase2<MainActivity>
{

	private MainActivity mMainActivity = null;
	private ListView mListView = null;

	public MainActivityTest()
	{
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		// TODO Auto-generated method stub
		super.setUp();
		setActivityInitialTouchMode(true);
		mMainActivity = getActivity();
		mListView = (ListView) mMainActivity.findViewById(R.id.listView1);
	}

	@Override
	protected void tearDown() throws Exception
	{
		// TODO Auto-generated method stub
		super.tearDown();
	}

	public void testPreconditions()
	{
		assertNotNull("mMainActivity is null", mMainActivity);
		assertNotNull("mListView is null", mListView);
	}

	@MediumTest
	public void testListViewVisibleState()
	{
		final View decorView = mMainActivity.getWindow().getDecorView();
		ViewAsserts.assertOnScreen(decorView, mListView);
		assertTrue(View.GONE == mListView.getVisibility());
	}

	@MediumTest
	public void testListViewClick()
	{
		TouchUtils.clickView(this, mListView);
	}
}
