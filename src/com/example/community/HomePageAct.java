package com.example.community;


import android.os.Bundle;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;

@SuppressWarnings("deprecation")
public class HomePageAct extends ActivityGroup  {
	private LocalActivityManager localActivityManager1 = null;
	private ScrollView messagesScrollView = null;
	 private Spinner home_searchType = null; 
     private AutoCompleteTextView autoTv= null;
     private ImageView search_iv=null;

	    ArrayAdapter<String> home_searchTypeAdapter = null; 
	    private String[] home_searchTypeArray = new String[] {"商品","服务","用户"};

	 
	    private void set_searchType()
	    {        
	    	home_searchType = (Spinner)findViewById(R.id.Home_search_type);
	    	home_searchTypeAdapter = new ArrayAdapter<String>(HomePageAct.this,
	                android.R.layout.simple_spinner_item, home_searchTypeArray);
	    	home_searchType.setAdapter(home_searchTypeAdapter);
	    	home_searchType.setSelection(0,true);  
	    	home_searchType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
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
    
    	/**
		 * 初始化AutoCompleteTextView，最多显示5项提示，使
		 * AutoCompleteTextView在一开始获得焦点时自动提示
		 * @param field 保存在sharedPreference中的字段名
		 * @param auto 要操作的AutoCompleteTextView
		 */
		private void initAutoComplete(String field,AutoCompleteTextView auto) {
			SharedPreferences sp = getSharedPreferences("network_url", 0);
			String longhistory = sp.getString("history", "nothing");
			String[]  hisArrays = longhistory.split(",");
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_dropdown_item_1line, hisArrays);
			//只保留最近的50条的记录
			if(hisArrays.length > 50){
				String[] newArrays = new String[50];
				System.arraycopy(hisArrays, 0, newArrays, 0, 50);
				adapter = new ArrayAdapter<String>(this,
						android.R.layout.simple_dropdown_item_1line, newArrays);
			}
			auto.setAdapter(adapter);
			auto.setDropDownHeight(350);
			auto.setThreshold(1);
			auto.setCompletionHint("最近的5条记录");
			auto.setOnFocusChangeListener(new OnFocusChangeListener() {
				@Override
				public void onFocusChange(View v, boolean hasFocus) {
					AutoCompleteTextView view = (AutoCompleteTextView) v;
					if (hasFocus) {
							view.showDropDown();
					}
				}
			});
		}



		/**
		 * 把指定AutoCompleteTextView中内容保存到sharedPreference中指定的字符段
		 * @param field  保存在sharedPreference中的字段名
		 * @param auto  要操作的AutoCompleteTextView
		 */
		private void saveHistory(String field,AutoCompleteTextView auto) {
			String text = auto.getText().toString();
			SharedPreferences sp = getSharedPreferences("network_url", 0);
			String longhistory = sp.getString(field, "nothing");
			if (!longhistory.contains(text + ",")) {
				StringBuilder sb = new StringBuilder(longhistory);
				sb.insert(0, text + ",");
				sp.edit().putString("history", sb.toString()).commit();
			}
		}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home_page);
		localActivityManager1 = getLocalActivityManager();
		messagesScrollView = (ScrollView)findViewById(R.id.homemessage);
		messagesScrollView.removeAllViews();
		messagesScrollView.addView(localActivityManager1.startActivity("Module1",
				new Intent(HomePageAct.this, RecommendAct.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)).getDecorView());
		
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				messagesScrollView.removeAllViews();
				messagesScrollView.addView(localActivityManager1.startActivity("Module1",
						new Intent(HomePageAct.this, RecommendAct.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)).getDecorView());
			}
		});
		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				messagesScrollView.removeAllViews();
				messagesScrollView.addView(localActivityManager1.startActivity("Module2",
						new Intent(HomePageAct.this, MovementAct.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)).getDecorView());
			}
		});
		set_searchType();
		autoTv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		initAutoComplete("history",autoTv);
		search_iv = (ImageView) findViewById(R.id.homepage_search_button);
		search_iv.setOnClickListener(new OnClickListener(){
			public void onClick(View arg0) {
				saveHistory("history",autoTv);
				Intent intent=new Intent(HomePageAct.this,SearchPageAct.class);
				startActivity(intent);
				
			}
			
		});
	
	}
	



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home_page, menu);
		return true;
	}

}
