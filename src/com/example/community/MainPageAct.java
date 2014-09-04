package com.example.community;



//import com.phicomm.hu.FxService;
//import com.phicomm.hu.MainActivity;

import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityGroup;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
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
				//System.out.println("1");				
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

	}
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
		return true;
	}


}

