package com.brkrgcr.cheatsheet.views;

import com.brkrgcr.cheatsheet.MainActivity;
import com.brkrgcr.cheatsheet.ShaderEditor;
import com.brkrgcr.cheatsheet.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class CheatSheetDetailsFragment extends Fragment {

	private static final String TAG = "CheatSheetDetailsFragment";
	
	private static final String CODE_ID = "String_Code_ID";
	
	private static final String TITLE = "PAGE_TITLE";

	private static final String ARG_SECTION_NUMBER = null;
	
	private MainActivity mMainActivity;
	
	public static final int INDEX = 0x100;
	
	public static CheatSheetDetailsFragment newInstance(int codeId, String title) {
		CheatSheetDetailsFragment fragment = new CheatSheetDetailsFragment();
		Bundle args = new Bundle();
		
		args.putInt(CODE_ID, codeId);
		args.putString(TITLE, title);
		
		fragment.setArguments(args);
		return fragment;
	}

	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		
		View root = inflater.inflate(R.layout.code, container, false);
		int codeId = getArguments().getInt(CODE_ID);
		String code = getResources().getString(codeId);
		String title = getArguments().getString(TITLE);
		
		
		
		/**
		 * Change action bar menu
		 */
		mMainActivity.changeMenu(R.menu.editor, title);
		
		ShaderEditor editor = (ShaderEditor) root.findViewById(R.id.codeEditor);
		
		editor.setText(code);
		
		return root;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		Log.d(TAG, "onOptionsItemSelected: " + " Test "+ item.toString());
		return super.onOptionsItemSelected(item);
	}
	
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mMainActivity = (MainActivity) activity;
		//((MainActivity) activity).onSectionAttached(getArguments().getInt(ARG_SECTION_NUMBER));
	}
}
