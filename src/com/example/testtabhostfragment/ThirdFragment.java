package com.example.testtabhostfragment;

import com.example.testandroidadvancedview.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ThirdFragment extends Fragment
{

	public ThirdFragment()
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.fragment3_layout, container, false);
		return view;
	}
}
