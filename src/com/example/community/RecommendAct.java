package com.example.community;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

public class RecommendAct extends Activity {
private List<Map<String, Object>> mData;
	
	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);
		map = new HashMap<String, Object>();
		map.put("title1", "G1");
		map.put("img1", R.drawable.no_pic);
		map.put("title2", "G2");
		map.put("img2", R.drawable.no_pic);
		list.add(map);

		
		return list;
	}
			
	
	public final class ViewHolder{
		public ImageView img1;
		public TextView title1;
		public ImageView img2;
		public TextView title2;
	}
	
	
	public class MyAdapter extends BaseAdapter{

		private LayoutInflater mInflater;
		
		
		public MyAdapter(Context context){
			this.mInflater = LayoutInflater.from(context);
		}
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return mData.size();
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			ViewHolder holder = null;
			if (convertView == null) {
				
				holder=new ViewHolder();  
				
				convertView = mInflater.inflate(R.layout.recommend_list, null);
				holder.img1 = (ImageView)convertView.findViewById(R.id.imageView1);
				holder.title1 = (TextView)convertView.findViewById(R.id.textView1);
				holder.img2 = (ImageView)convertView.findViewById(R.id.imageView2);
				holder.title2 = (TextView)convertView.findViewById(R.id.textView2);
				convertView.setTag(holder);
				
			}else {
				
				holder = (ViewHolder)convertView.getTag();
			}
			
			holder.img1.setBackgroundResource((Integer)mData.get(position).get("img1"));
			holder.title1.setText((String)mData.get(position).get("title1"));
			holder.img2.setBackgroundResource((Integer)mData.get(position).get("img2"));
			holder.title2.setText((String)mData.get(position).get("title2"));


			
			
			
			return convertView;
		}
		
	}
///scroll Ç¶Ì× listview	
	public void setListViewHeightBasedOnChildren(ListView listView) {
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null)
			return;
		if (listAdapter.getCount() <= 1)
			return;

		int totalHeight = 0;
		View view = null;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			view = listAdapter.getView(i, null, listView);
			view.measure(0,0);
			totalHeight += view.getMeasuredHeight();
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		listView.setLayoutParams(params);
		listView.requestLayout();
	}



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_recommend);
		mData = getData();
		MyAdapter adapter = new MyAdapter(this);
		ListView listview=(ListView)findViewById(R.id.recommend_listview);
		listview.setAdapter(adapter);
		setListViewHeightBasedOnChildren(listview);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.recommend, menu);
		return true;
	}

}
