package com.example.testtabhostfragment;

import com.example.testandroidadvancedview.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SecondFragment extends Fragment
{

	public SecondFragment()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment2_layout, container, false);
		return view;
	}
}
