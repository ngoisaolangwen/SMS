package com.tile.messager;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;


/**
 * 
 * @author TILE
 * @version 1.0
 * @category Class main, using get list message.
 */
public class Messager extends Activity {

	ListView lv; // Inbox list message.
	// Cursor Adapter. 
	//ListMessageBoxAdapter adapter;
	SMSBaseAdapter baseAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_messager);

		/* Map id */
		init();
		
		getMessage();

	}
	
	/**
	 * init() method using get id from xml file.
	 */
	private void init(){
		lv = (ListView)findViewById(R.id.main_listview);
	}
	
	/**
	 * Method using get all message in your phone.
	 */
	private void getMessage(){
		
		//Create Inboc URI
		Uri inboxURI = Uri.parse("content://sms/inbox");
		
		// List required columns
		String[] reqCols = new String[]{"_id","address","body"};
		
		// Get Contennt Resolver object, which will deal with Content Provider
		ContentResolver cr = getContentResolver();
		
		// Fetch Inbox SMS Message from Built-in Content Provider
		Cursor c = cr.query(inboxURI,reqCols,null, null, null);
		Log.d("SMS", c.toString());
		baseAdapter = new SMSBaseAdapter(this, c);
		lv.setAdapter(baseAdapter);
		Log.d("A", "getMessage");
	}
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_actionbar, menu);
		// getMenuInflater().inflate(R.menu.messager, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/**
	 * On select action bar.
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.new_messager:
			// Add new messager
			newMessager();
			return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/**
	 * Get new messager by Intent.
	 */
	private void newMessager() {
		Intent intent = new Intent(Messager.this, New_Messager.class);
		startActivity(intent);
	}

}
