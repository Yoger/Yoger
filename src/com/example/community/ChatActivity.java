package com.example.community;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ChatActivity extends Activity implements OnClickListener {
	private Button mBtnSend;
	private Button mBtnBack;
	private EditText mEditTextContent;
	private ChatMsgViewAdapter mAdapter;
	private ListView mListView;
	private List<ChatMsgEntity> mDataArrays = new ArrayList<ChatMsgEntity>();
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.chat);
		initView();
		initData();
	}
	
	private void initView() {
		mListView = (ListView) findViewById(R.id.listview);
		mBtnBack = (Button) findViewById(R.id.btn_back);
		mBtnBack.setOnClickListener(this);
		mBtnSend = (Button) findViewById(R.id.btn_send);
		mBtnSend.setOnClickListener(this);
		mEditTextContent = (EditText) findViewById(R.id.et_sendmessage);
	}
	
	
	private String[] msgArray = new String[]{" 我去这也行", 
			"对", 
			"我", 
			"就是", 
			"一句", 
			"测试",
			"而已", 
			"天"};

	private String[]dataArray = new String[]{"2012-09-01 18:00", "2012-09-01 18:10", 
			"2012-09-01 18:11", "2012-09-01 18:20", 
			"2012-09-01 18:30", "2012-09-01 18:35", 
			"2012-09-01 18:40", "2012-09-01 18:50"};
	private final static int COUNT = 8;
	//这个函数用于初始化测试数据
	private void initData() {
		
		for(int i = 0; i < COUNT; i++) {
			ChatMsgEntity entity = new ChatMsgEntity();
    		entity.setDate(dataArray[i]);
    		if (i % 2 == 0)
    		{
    			entity.setName("测试员");
    			entity.setMsgType(true);
    		}else{
    			entity.setName("Shamoo");
    			entity.setMsgType(false);
    		}
    		
    		entity.setText(msgArray[i]);
    		mDataArrays.add(entity);
		}
		mAdapter = new ChatMsgViewAdapter(this, mDataArrays);
		mListView.setAdapter(mAdapter);
	}
	
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch(view.getId()) {
		case R.id.btn_back:
			back();
			break;
		case R.id.btn_send:
			send();
			break;
		}
	}

	private void send()
	{
		String contString = mEditTextContent.getText().toString();
		if (contString.length() > 0)
		{
			ChatMsgEntity entity = new ChatMsgEntity();
			entity.setDate(getDate());
			entity.setName("");
			entity.setMsgType(false);
			entity.setText(contString);
			mDataArrays.add(entity);
			mAdapter.notifyDataSetChanged();
			mEditTextContent.setText("");
			mListView.setSelection(mListView.getCount() - 1);
		}
	}
	
	
	private String getDate() {
        Calendar c = Calendar.getInstance();
        String year = String.valueOf(c.get(Calendar.YEAR));
        String month = String.valueOf(c.get(Calendar.MONTH));
        String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH) + 1);
        String hour = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        String mins = String.valueOf(c.get(Calendar.MINUTE));
        StringBuffer sbBuffer = new StringBuffer();
        sbBuffer.append(year + "-" + month + "-" + day + " " + hour + ":" + mins); 
        return sbBuffer.toString();
    }
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		back();
		return true;
	}
	
	private void back() {
		finish();
	}
}
