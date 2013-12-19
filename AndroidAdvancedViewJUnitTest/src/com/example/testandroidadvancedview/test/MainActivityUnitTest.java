package com.example.testandroidadvancedview.test;

import com.example.testandroidadvancedview.MainActivity;
import com.example.testandroidadvancedview.R;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.ListView;

public class MainActivityUnitTest extends ActivityUnitTestCase<MainActivity>
{
	private Intent mLaunchIntent = null;
	private ListView mListView = null;
	
	public MainActivityUnitTest()
	{
		super(MainActivity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		mLaunchIntent = new Intent(getInstrumentation().getTargetContext(),
				MainActivity.class);
		
	}

	@MediumTest
	public void testNextActivityWasLaunchedWithIntent()
	{
		startActivity(mLaunchIntent, null, null);
		mListView = (ListView) getActivity().findViewById(R.id.listView1);
	}
}
