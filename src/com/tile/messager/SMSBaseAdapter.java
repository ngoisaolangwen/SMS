package com.tile.messager;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SMSBaseAdapter extends BaseAdapter {
	
	private Context mContext;
    Cursor cursor;
    public SMSBaseAdapter(Context context,Cursor cur) 
    {
            super();
            this.mContext=context;
            this.cursor=cur;
           
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return cursor.getCount();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		 // inflate the layout for each item of listView
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        arg1 = inflater.inflate(R.layout.row, null);

        // move the cursor to required position 
        cursor.moveToPosition(arg0);
        
        // fetch the sender number and sms body from cursor
        String senderNumber=cursor.getString(cursor.getColumnIndex("address"));
        String smsBody=cursor.getString(cursor.getColumnIndex("body"));
       
        // get the reference of textViews
        TextView textViewConatctNumber=(TextView)arg1.findViewById(R.id.lblNumber);
        TextView textViewSMSBody=(TextView)arg1.findViewById(R.id.lblMsg);
        
        // Set the Sender number and smsBody to respective TextViews 
        textViewConatctNumber.setText(senderNumber);
        textViewSMSBody.setText(smsBody);
        

        return arg1;
	}

}
