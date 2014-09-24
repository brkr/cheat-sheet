package com.brkrgcr.cheatsheet.views;

import java.util.ArrayList;
import java.util.List;

import com.brkrgcr.cheatsheet.MainActivity;
import com.brkrgcr.cheatsheet.R;
import com.brkrgcr.cheatsheet.R.array;
import com.brkrgcr.cheatsheet.R.id;
import com.brkrgcr.cheatsheet.R.layout;

import android.app.Activity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class CheatSheetFragment extends Fragment {

	private static final String TAG = "CodeFragment";
	
	private MainActivity mMainActivity;

	public static final int INDEX = 2;

	public static int ID;
	
	private static int ROOT;
	/**
	 * CheatSheets
	 */
	private List<String> cheatSheetList;
	
	/**
	 * Filtered CheatSheets
	 */
	private List<String> filteredList;

	private ListView cheatSheets;
	
	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static CheatSheetFragment newInstance(int sectionNumber) {
		CheatSheetFragment fragment = new CheatSheetFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		Log.d(TAG, "onCreateView: " + " generate view ");
		mMainActivity.changeMenu(0, "Cheat Sheet");
		View view = inflater.inflate(R.layout.cheatsheet_dashboard, container, false);
		
		filteredList = new ArrayList<String>();
		cheatSheetList=new ArrayList<String>();
		cheatSheets = (ListView) view.findViewById(R.id.cheat_sheet_list);
		ROOT=getArguments().getInt(ARG_SECTION_NUMBER);
		/*
		 * Root ID web service gönderilecek buradan liste geliyorsa fragmenttaki liste doldurulacak
		 * CheatShhet geliyorsa cheatsheet sayfasýna yönlendirilecek
		 */
		switch(ROOT)
		{
		
		case 0:
			cheatSheetList.clear();
			cheatSheetList.add("Flask");
			cheatSheetList.add("Spring");
			cheatSheetList.add("Laravel");
			cheatSheets.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cheatSheetList));
			Log.e("Cheatsheet", "Enter The Switch"+ROOT);
			break;
		case 1:
			cheatSheetList.clear();
			cheatSheetList.add("Java");
			cheatSheetList.add("Python");
			cheatSheetList.add("Ruby");
			cheatSheets.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cheatSheetList));
			Log.e("Cheatsheet", "Enter The Switch"+ROOT);
			break;
		case 2:
			cheatSheetList.clear();
			cheatSheetList.add("Flask");
			cheatSheetList.add("Spring");
			cheatSheetList.add("Laravel");
			cheatSheets.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cheatSheetList));
			Log.e("Cheatsheet", "Enter The Switch"+ROOT);
			break;
			
		default:
			cheatSheetList.clear();
			cheatSheetList.add("Flask");
			cheatSheetList.add("Spring");
			cheatSheetList.add("Laravel");
			cheatSheets.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, cheatSheetList));
			Log.e("Cheatsheet", "Enter The Switch"+ROOT);
			break;
		}
		
		
		

		
		
		final SearchView mSearchView = (SearchView) view.findViewById(R.id.search);
		
		mSearchView.setOnQueryTextListener(searchListiner);
		
		cheatSheets.setOnItemClickListener(new OnItemClickListener() {
			 
             @Override
             public void onItemClick(AdapterView<?> parent, View view,
                int position, long id) {
               /*
                * Bu pozisyonda ki elemetin id alýnarak web service egönderilecek
                * web service den gelen habere göre yeniden liste oluþturulacak veya cheatsheet gösterilecek 
                */
            	 
            	 
            	 
            	 
            	 
              // ListView Clicked item index
              int itemPosition = position;
              
              // ListView Clicked item value
//              String  itemValue = (String) cheatSheets.getItemAtPosition(position);
              
//              Log.d(TAG, "onItemClick: " + " Selected item Value " + itemValue);
              
//              int id_ = getResources().getIdentifier(itemValue, "string", getActivity().getPackageName());
//              Log.d(TAG, "onItemClick: " + " id : "+ id_);
//              mMainActivity.showCodeEditor(id_, itemValue.toString());
             }

        }); 
		
		return view;
	}
	
	
	
	private OnQueryTextListener searchListiner = new OnQueryTextListener() {
		
		@Override
		public boolean onQueryTextSubmit(String query) {
			// TODO Auto-generated method stub
			Log.d(TAG, "onQueryTextSubmit: " + " TExt : "+ query);
			return false;
		}
		
		@Override
		public boolean onQueryTextChange(String newText) {		
			
			Log.d(TAG, "onQueryTextChange: " + " Text : "+ newText);
			
			filteredList.clear();
			
			for (int i = 0; i < cheatSheetList.size(); i++) {
				String curr = cheatSheetList.get(i);
				if(curr.toLowerCase().contains(newText.toLowerCase())){
					/**
					 * Add filtered and reflesh listview
					 */
					filteredList.add(curr);
					
				}				
			}
			
			
			cheatSheets.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, filteredList.toArray(new String[filteredList.size()])));
			return false;
		}
	};
	
	

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mMainActivity = (MainActivity) activity;
		((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
	}

}
