package com.tile.messager;


import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListMessageBoxAdapter extends ArrayAdapter<Cursor> {

	

	Context context;
	Cursor cursor;
	TextView tvNumber,tvBody;
	ViewHolder vh;

	public ListMessageBoxAdapter(Context context, int resource, Cursor cursor) {
		super(context, resource);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.cursor = cursor;
		//String smsBody = cursor.getString(cursor.getColumnIndex("body")) ;
		//Log.d("cursor", smsBody);
	}
	
	static class ViewHolder {
		protected TextView tvPhoneNumber, tvBody;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		View view = null;
		if(convertView == null){
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		view = inflater.inflate(R.layout.row, null);
		vh = new ViewHolder();
		
		
		
		vh.tvBody = (TextView)view.findViewById(R.id.lblMsg);
		vh.tvPhoneNumber = (TextView)view.findViewById(R.id.lblNumber);
		
		//init(convertView);
//		tvNumber.setText(smsPhoneNumber);
//		tvBody.setText(smsBody);
		
		view.setTag(vh);
		
		//tvNumber.setText("Mr.Tile");
		
//		Log.d("smsPhoneNumber", smsPhoneNumber);
//		Log.d("smsBody", smsBody);
		
		}
		else{
			return convertView;
		}
		
		/* Di chuyển con trỏ cursor đến vị trí người tiếp theo. */
		cursor.moveToPosition(position);
		
		String smsPhoneNumber = cursor.getString(cursor.getColumnIndex("address")) ;
		//String smsName = ;
		String smsBody = cursor.getString(cursor.getColumnIndex("body")) ;
		
		vh.tvBody.setText(smsBody);
		vh.tvPhoneNumber.setText(smsPhoneNumber);
		
		return view;
	}
	
//	private void init(View view){
//		tvNumber = (TextView)view.findViewById(R.id.lblNumber);
//		tvBody = (TextView)view.findViewById(R.id.lblMsg);
//	}
	

}
