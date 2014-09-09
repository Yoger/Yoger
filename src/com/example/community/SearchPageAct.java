package com.example.community;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class SearchPageAct extends Activity {
	
    private Spinner searchType = null; 
    private Spinner selectType = null; 

    ArrayAdapter<String> searchTypeAdapter = null; 
    ArrayAdapter<String> selectTypeAdapter = null; 
    
    private String[] searchTypeArray = new String[] {"商品","服务","用户"};
    private String[] selectTypeArray = new String[] {"综合排序","价格排序","时间排序"};
    
    private ListView mylistview = null;
	private List<Map<String,Object>>  mData;
  
 
    private void set_searchType()
    {        
    	searchType = (Spinner)findViewById(R.id.search_type);
    	searchTypeAdapter = new ArrayAdapter<String>(SearchPageAct.this,
                android.R.layout.simple_spinner_item, searchTypeArray);
    	searchType.setAdapter(searchTypeAdapter);
    	searchType.setSelection(0,true);  
    	searchType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub   arg2为当前选项 0-2
			
			}
         });
    }
    
    private void set_selectType()
    {        
    	selectType = (Spinner)findViewById(R.id.select_type);
    	selectTypeAdapter = new ArrayAdapter<String>(SearchPageAct.this,
                android.R.layout.simple_spinner_item, selectTypeArray);
    	selectType.setAdapter(selectTypeAdapter);
    	selectType.setSelection(0,true);  //设置默认选中项，此处为默认选中第4个值
    	searchType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onNothingSelected(AdapterView<?> arg0)
            {

            }

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub

			}

        });
     }
    
    private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "商品名称");
		map.put("img", R.drawable.no_pic);
		map.put("price", "￥50");
		map.put("point", "点赞数：60");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("name", "商品名称");
		map.put("img", R.drawable.no_pic);
		map.put("price", "￥50");
		map.put("point", "点赞数：60");
		list.add(map);

		map = new HashMap<String, Object>();
		map.put("name", "商品名称");
		map.put("img", R.drawable.no_pic);
		map.put("price", "￥50");
		map.put("point", "点赞数：60");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "商品名称");
		map.put("img", R.drawable.no_pic);
		map.put("price", "￥50");
		map.put("point", "点赞数：60");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "商品名称");
		map.put("img", R.drawable.no_pic);
		map.put("price", "￥50");
		map.put("point", "点赞数：60");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "商品名称");
		map.put("img", R.drawable.no_pic);
		map.put("price", "￥50");
		map.put("point", "点赞数：60");
		list.add(map);
		
		map = new HashMap<String, Object>();
		map.put("name", "商品名称");
		map.put("img", R.drawable.no_pic);
		map.put("price", "￥50");
		map.put("point", "点赞数：60");
		list.add(map);
		
		return list;
	}

	public final class ViewHolder{
		public ImageView goodsimg;
		public TextView goodsname;
		public TextView goodsprice;
		public TextView goodspoint;
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
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {

			ViewHolder holder = null;
			if (convertView == null){
				holder = new ViewHolder();
				convertView = mInflater.inflate(R.layout.goods_item, null);
				holder.goodsimg = (ImageView) convertView.findViewById(R.id.goods_item_img);
				holder.goodsname = (TextView) convertView.findViewById(R.id.goods_item_name);
				holder.goodsprice = (TextView) convertView.findViewById(R.id.goods_item_price);
				holder.goodspoint= (TextView) convertView.findViewById(R.id.goods_item_point);
				convertView.setTag(holder);
					
			}else{
				holder = (ViewHolder)convertView.getTag();
			}
			
			holder.goodsimg.setBackgroundResource((Integer)mData.get(position).get("img"));
			holder.goodsname.setText((String)mData.get(position).get("name"));
			holder.goodsprice.setText((String)mData.get(position).get("price"));
			holder.goodspoint.setText((String)mData.get(position).get("point"));
			
			return convertView;
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_search_page);
		set_searchType();
		set_selectType();
		mylistview = (ListView)findViewById(R.id.search_page_listview);
		MyAdapter adapter = new MyAdapter(this);
		mData=getData();
		mylistview.setAdapter(adapter);
		Button btnBack = (Button) findViewById(R.id.TitleBackBtn);

		btnBack.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				KeyEvent newEvent = new KeyEvent
						(KeyEvent.ACTION_DOWN,
						KeyEvent.KEYCODE_BACK);
				onKeyDown(KeyEvent.KEYCODE_BACK, newEvent);
			}
		});
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) 
		{
			// 按下的如果是BACK，同时没有重复
			finish();

			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_page, menu);
		return true;
	}

}
 