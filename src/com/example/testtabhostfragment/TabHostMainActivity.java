package com.example.testtabhostfragment;

import com.example.testandroidadvancedview.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabContentFactory;
import android.widget.TabHost.TabSpec;

public class TabHostMainActivity extends FragmentActivity implements TabContentFactory
{
	@SuppressWarnings("unused")
	private static final String TAG = "TestTabHost";
	
	private ViewPager mViewPager = null;
	private TabHost mTabHost = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabhost_activity_main);
		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setAdapter(mAdapter);
 		mTabHost = (TabHost) findViewById(R.id.tabhost);
 		mTabHost.setup();
 		createTabs();
 		mTabHost.setOnTabChangedListener(new OnTabChangeListener()
		{
			
			@Override
			public void onTabChanged(String tabId)
			{
				// TODO Auto-generated method stub
				String tabIndex = tabId.substring(9);
				int curIndex = Integer.valueOf(tabIndex) - 1;
				mViewPager.setCurrentItem(curIndex, true);
			}
		});
 		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
		{
			
			@Override
			public void onPageSelected(int arg0)
			{
				// TODO Auto-generated method stub
				mTabHost.setCurrentTab(arg0);
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0)
			{
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void createTabs()
	{
		if (mTabHost.getTabWidget().getTabCount() > 0)
		{
			// Crash on Gingerbread if tab isn't set to zero since adding a
			// new tab removes selection state on the old tab which will be
			// null unless the current tab index is the same as the first
			// tab index being added
			mTabHost.setCurrentTab(0);
			mTabHost.clearAllTabs();
		}

		int count = mAdapter.getCount();
		for (int index = 0; index < count; index++)
		{
			TabSpec spec = mTabHost.newTabSpec("Fragment_"+(index+1));
			spec.setContent(this);
			spec.setIndicator("Tab"+(index+1));
			mTabHost.addTab(spec);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(
			getSupportFragmentManager())
	{

		@Override
		public int getCount()
		{
			// TODO Auto-generated method stub
			return 4;
		}

		@Override
		public Fragment getItem(int arg0)
		{
			// TODO Auto-generated method stub
			Fragment fragment = null;

			switch (arg0)
			{
			case 0:
				fragment = new FirstFragment();
				break;

			case 1:
				fragment = new SecondFragment();
				break;

			case 2:
				fragment = new ThirdFragment();
				break;

			case 3:
				fragment = new FourFragment();
				break;
			default:
				break;
			}

			return fragment;
		}
	};

	@Override
	public View createTabContent(String tag)
	{
		// TODO Auto-generated method stub
		View view = new View(this);
		view.setVisibility(View.GONE);
		return view;
	}
}
