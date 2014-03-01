package com.tile.messager;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class GetListSMS extends Activity implements OnClickListener {
	
	
	// GUI widget
	Button btnSend, btnInbox, btnDraft;
	TextView lblMsg, lblNumber;
	ListView lvMsg;
	
	// Cursor Adapter.
	SimpleCursorAdapter adapter;
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_list_sms);
		
		// GUI map.
		init();
		
		
		
		
		
	}
	
	
	// Init GUI Widget.
	private void init(){
		btnDraft = (Button)findViewById(R.id.btn_draft);
		btnDraft.setOnClickListener(GetListSMS.this);
		btnInbox = (Button)findViewById(R.id.btn_inbox);
		btnInbox.setOnClickListener(this);
		btnSend = (Button)findViewById(R.id.btn_sendbox);
		btnSend.setOnClickListener(this);
		lvMsg = (ListView)findViewById(R.id.lst_sms);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.get_list_sm, menu);
		return true;
	}


	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		if(arg0 == btnInbox){
			
			//Create Inboc URI
			Uri inboxURI = Uri.parse("content://sms/inbox");
			
			// List required columns
			String[] reqCols = new String[]{"_id","address","body"};
			
			// Get Contennt Resolver object, which will deal with Content Provider
			ContentResolver cr = getContentResolver();
			
			// Fetch Inbox SMS Message from Built-in Content Provider
			Cursor c = cr.query(inboxURI,reqCols,null, null, null);
			Log.d("SMS", c.toString());
			//Attached Cursor with adappter and display in listview
//			adapter = new SimpleCursorAdapter(this, R.layout.activity_get_list_sms, c, new String[] {"body", "address"}
//			,new int[] {R.id.lblMsg,R.id.lblNumber});
//			lvMsg.setAdapter(adapter);
			
			
			
		}
		else if(arg0 == btnSend){
			//Create Inboc URI
			Uri inboxURI = Uri.parse("content://sms/sent");
			
			// List required columns
			String[] reqCols = new String[]{"_id","address","body"};
			
			// Get Contennt Resolver object, which will deal with Content Provider
			ContentResolver cr = getContentResolver();
			
			// Fetch Inbox SMS Message from Built-in Content Provider
			Cursor c = cr.query(inboxURI,reqCols,null, null, null);
			
			//Attached Cursor with adappter and display in listview
			adapter = new SimpleCursorAdapter(this, R.layout.activity_get_list_sms, c, new String[] {"body", "address"}
			,new int[] {R.id.lblMsg,R.id.lblNumber});
			lvMsg.setAdapter(adapter);

		}
		else{
			//Create Inboc URI
			Uri inboxURI = Uri.parse("content://sms/draft");
			
			// List required columns
			String[] reqCols = new String[]{"_id","address","body"};
			
			// Get Contennt Resolver object, which will deal with Content Provider
			ContentResolver cr = getContentResolver();
			
			// Fetch Inbox SMS Message from Built-in Content Provider
			Cursor c = cr.query(inboxURI,reqCols,null, null, null);
			Log.d("SMS_Draft", c.getColumnIndex("_id") +"");
			//Attached Cursor with adappter and display in listview
//			adapter = new SimpleCursorAdapter(this, R.layout.activity_get_list_sms, c, new String[] {"body", "address"}
//			,new int[] {R.id.lblMsg,R.id.lblNumber});
//			lvMsg.setAdapter(adapter);

		}
		
		
		
		
	}

}
