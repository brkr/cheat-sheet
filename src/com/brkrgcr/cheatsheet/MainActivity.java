package com.brkrgcr.cheatsheet;


import com.brkrgcr.cheatsheet.views.CheatSheetDetailsFragment;
import com.brkrgcr.cheatsheet.views.CheatSheetFragment;
import com.brkrgcr.cheatsheet.R;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.transition.Visibility;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements
		NavigationDrawerFragment.NavigationDrawerCallbacks {

	private static final String TAG = "MainActivity";

	public static final String ARG_SECTION_NUMBER = "section_number";

	/**
	 * Fragment managing the behaviors, interactions and presentation of the
	 * navigation drawer.
	 */
	private NavigationDrawerFragment mNavigationDrawerFragment;

	/**
	 * Used to store the last screen title. For use in
	 * {@link #restoreActionBar()}.
	 */
	private CharSequence mTitle;

	
	private Fragment container;
	private Fragment frag;

	private int currMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		mNavigationDrawerFragment = (NavigationDrawerFragment) getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
		mTitle = getTitle();
		// Set up the drawer.
		mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
	}

	@Override
	public void onNavigationDrawerItemSelected(int position) 
	{
		// update the main content by replacing fragments
		Log.d("berker", "onNavigationDrawerItemSelected :Number : " + position);
		FragmentManager fragmentManager = getSupportFragmentManager();

		
		
		
		
		
		Bundle args=new Bundle();
		
		switch (position) {

		
		
		case 2:
			args.putInt(ARG_SECTION_NUMBER, 0);
			frag =new CheatSheetFragment();
			frag.setArguments(args);
			fragmentManager.beginTransaction().replace(R.id.container, frag).commit();
		break;
		
		

		default:
			args.putInt(ARG_SECTION_NUMBER, 0);
			frag =new CheatSheetFragment();
			frag.setArguments(args);
			fragmentManager.beginTransaction().replace(R.id.container, frag).commit();
			break;
		}

	}

	public void showCodeEditor(int codeId, String title) {
		Log.d(TAG, "showCodeEditor: " + " Code editor show" + codeId);
		FragmentManager fragmentManager = getSupportFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.container, CheatSheetDetailsFragment.newInstance(codeId,title)).addToBackStack(null).commit();

	}

	public void changeMenu(int menuId, String title) {
		mTitle = title;
		currMenu = menuId;
		invalidateOptionsMenu();
	}

	public void onSectionAttached(int number) {

		switch (number) {
		case 1:
			mTitle = getString(R.string.title_section1);
			break;
		case 2:
			mTitle = getString(R.string.title_section2);
			break;
		case 3:
			mTitle = getString(R.string.title_section3);
			break;
		}
	}

	public void restoreActionBar() {
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowTitleEnabled(true);
		actionBar.setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		if (!mNavigationDrawerFragment.isDrawerOpen()) {
			// Only show items in the action bar relevant to this screen
			// if the drawer is not showing. Otherwise, let the drawer
			// decide what to show in the action bar.
			
			if (currMenu != 0 ) {
				getMenuInflater().inflate(currMenu, menu);
				
			}else{
				getMenuInflater().inflate(R.menu.main, menu);
			}
			
			
			
			
			
			restoreActionBar();
			currMenu = 0;
			return true;
		}
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		Log.d(TAG, "onOptionsItemSelected: " + " Test : "+ item.toString());
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	


}
