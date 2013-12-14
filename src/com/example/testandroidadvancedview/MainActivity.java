package com.example.testandroidadvancedview;

import java.util.HashMap;
import java.util.Map;

import com.example.testgridlayout.GridLayoutActivity;
import com.example.testtabhostfragment.TabHostMainActivity;
import com.example.testtablelayout.TableLayoutActivity1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity
{
	private ListView mListView = null;

	private static final Map<String, Class> adapterSource = new HashMap<String, Class>();
	static
	{
		adapterSource.put("TabHostViewPager", TabHostMainActivity.class);
		adapterSource.put("GridLayout", GridLayoutActivity.class);
		adapterSource.put("TableLayout1", TableLayoutActivity1.class);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.listView1);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, adapterSource.keySet()
						.toArray(new String[]{}));
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id)
			{
				// TODO Auto-generated method stub
				String key = (String) mListView.getItemAtPosition(position);
				Intent intent = new Intent(MainActivity.this, adapterSource.get(key));
				MainActivity.this.startActivity(intent);
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
