package com.example.testtabhostfragment;

import com.example.testandroidadvancedview.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FirstFragment extends Fragment
{

	public FirstFragment()
	{
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment1_layout, container, false);
		return view;
	}
}
