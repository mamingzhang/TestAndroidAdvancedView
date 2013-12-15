package com.example.testactionbar;

import com.example.testandroidadvancedview.MainActivity;
import com.example.testandroidadvancedview.R;
import com.example.testtabhostfragment.FirstFragment;
import com.example.testtabhostfragment.FourFragment;
import com.example.testtabhostfragment.SecondFragment;
import com.example.testtabhostfragment.ThirdFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

public class ActionBarMainActivity extends ActionBarActivity implements
		TabListener
{
	private ViewPager mViewPager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testactionbar_activity_main);


		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setAdapter(mAdapter);
		mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
		{

			@Override
			public void onPageSelected(int arg0)
			{
				// TODO Auto-generated method stub
				final ActionBar actionBar = getSupportActionBar();
				switch (arg0)
				{
				case 0:
					actionBar.selectTab(actionBar.getTabAt(0));
					break;
				case 1:
					actionBar.selectTab(actionBar.getTabAt(1));
					break;
				case 2:
					actionBar.selectTab(actionBar.getTabAt(2));
					break;
				case 3:
					actionBar.selectTab(actionBar.getTabAt(3));
					break;
				default:
					break;
				}
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
		
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowTitleEnabled(false);

		final Tab tab1 = actionBar.newTab().setText("Tab1")
				.setTabListener(this).setTag("Tab1");
		actionBar.addTab(tab1);

		final Tab tab2 = actionBar.newTab().setText("Tab2")
				.setTabListener(this).setTag("Tab2");
		actionBar.addTab(tab2);

		final Tab tab3 = actionBar.newTab().setText("Tab3")
				.setTabListener(this).setTag("Tab3");
		actionBar.addTab(tab3);

		final Tab tab4 = actionBar.newTab().setText("Tab4")
				.setTabListener(this).setTag("Tab4");
		actionBar.addTab(tab4);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.actionbar_menu, menu);

		MenuItem searchItem = menu.findItem(R.id.action_search);
		MenuItemCompat.setOnActionExpandListener(searchItem,
				new OnActionExpandListener()
				{
					@Override
					public boolean onMenuItemActionCollapse(MenuItem item)
					{
						// Do something when collapsed
						return true; // Return true to collapse action view
					}

					@Override
					public boolean onMenuItemActionExpand(MenuItem item)
					{
						// Do something when expanded
						return true; // Return true to expand action view
					}
				});

		MenuItem shareItem = menu.findItem(R.id.action_share);
		ShareActionProvider mShareActionProvider = (ShareActionProvider) MenuItemCompat
				.getActionProvider(shareItem);
		mShareActionProvider.setShareIntent(getDefaultIntent());
		return super.onCreateOptionsMenu(menu);
	}

	private Intent getDefaultIntent()
	{
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/*");
		return intent;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// TODO Auto-generated method stub
		switch (item.getItemId())
		{
		default:
			return super.onOptionsItemSelected(item);
		}

	}

	@Override
	public Intent getSupportParentActivityIntent()
	{
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, MainActivity.class);
		return intent;
	}

	@Override
	public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder builder)
	{
		// TODO Auto-generated method stub
		super.onCreateSupportNavigateUpTaskStack(builder);
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1)
	{
		// TODO Auto-generated method stub
		if (arg0.getTag().equals("Tab1"))
		{
			mViewPager.setCurrentItem(0);
		}
		else if (arg0.getTag().equals("Tab2"))
		{
			mViewPager.setCurrentItem(1);
		}
		else if (arg0.getTag().equals("Tab3"))
		{
			mViewPager.setCurrentItem(2);
		}
		else if (arg0.getTag().equals("Tab4"))
		{
			mViewPager.setCurrentItem(3);
		}
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1)
	{
		// TODO Auto-generated method stub

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

}
