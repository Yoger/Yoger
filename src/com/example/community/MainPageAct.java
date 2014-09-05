package com.example.community;



//import com.phicomm.hu.FxService;
//import com.phicomm.hu.MainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.app.LocalActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

@SuppressWarnings("deprecation")
public class MainPageAct extends ActivityGroup {
	

	private LinearLayout messagesBox = null;
	private ImageView breImageView =null;
	private ImageView lunchImageView =null;
	private ImageView dinnerImageView =null;
	private ImageView sweetImageView =null;
	private ImageView addImageView=null;


	private LocalActivityManager localActivityManager = null;
	


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main_page);		
		localActivityManager = getLocalActivityManager();
	    addImageView=(ImageView)findViewById(R.id.mainpage_image_add);
	    addImageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent intent = new Intent(MainPageAct.this, FxService.class);
				startService(intent);

			}
		});
		messagesBox = (LinearLayout)findViewById(R.id.messages);
		messagesBox.removeAllViews();
		messagesBox.addView(localActivityManager.startActivity("Module1",
				new Intent(MainPageAct.this, HomePageAct.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)).getDecorView());
		
		


		
		breImageView = (ImageView) findViewById(R.id.bre);
		breImageView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				messagesBox.removeAllViews();
				messagesBox.addView(localActivityManager.startActivity("Module1",
						new Intent(MainPageAct.this, HomePageAct.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)).getDecorView());
			}
		});
		lunchImageView = (ImageView) findViewById(R.id.lunch);
		lunchImageView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				messagesBox.removeAllViews();
				messagesBox.addView(localActivityManager.startActivity("Module2",
						new Intent(MainPageAct.this, MakeMoneyAct.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)).getDecorView());
			}
		});
		dinnerImageView = (ImageView) findViewById(R.id.dinner);
		dinnerImageView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				messagesBox.removeAllViews();
				messagesBox.addView(localActivityManager.startActivity("Module3",
						new Intent(MainPageAct.this, ClassifyAct.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)).getDecorView());
			}
		});
		sweetImageView = (ImageView) findViewById(R.id.sweet);
		sweetImageView.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				messagesBox.removeAllViews();
				messagesBox.addView(localActivityManager.startActivity("Module4",
						new Intent(MainPageAct.this,InfoDetailActivity.class).addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT)).getDecorView());
			}
		});

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
			askForOut();

			return true;
		}

		return super.onKeyDown(keyCode, event);
	}

	private void askForOut() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("确定退出").setMessage("确定退出？").setPositiveButton("确定",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, 
							int which) {
						finish();
					}
				}).setNegativeButton("取消",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, 
							int which) {
						dialog.cancel();
					}
				}).setCancelable(false).show();

	

	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}


}

