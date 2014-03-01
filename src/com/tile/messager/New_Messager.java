package com.tile.messager;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

/**
 * Class using show new messager.
 * @author TILE
 * @version 1.0
 */
@SuppressLint("NewApi") // Because app using API 8, Android 2.2
public class New_Messager extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_messager);
		
		// Get action bar.
		ActionBar actionBar = getActionBar();
		
		// Enabling Up / Back navigation.
		actionBar.setDisplayShowHomeEnabled(true);
		
		
	}
	
	

}
