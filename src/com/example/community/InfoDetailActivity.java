package com.example.community;

import java.util.ArrayList;
import java.util.HashMap;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class InfoDetailActivity extends Activity {

	   @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_info_detail);
	        
	        Button editInfoButton = (Button) findViewById(R.id.editInfoButton); 
	        Button exitAccountButton = (Button) findViewById(R.id.exitAccountButton);
	        ImageView myCollectImg = (ImageView) findViewById(R.id.myCollectImageView);
	        ImageView myNewsImg = (ImageView) findViewById(R.id.myNewsImageView);
	        ImageView myFocusImg = (ImageView) findViewById(R.id.myFocusImageView);
	        
	        TextView  myFocusTV = (TextView) findViewById(R.id.myFocusTextView);
	        TextView  myCollectTV = (TextView) findViewById(R.id.myCollectTextView);
	        TextView  myNewsTV= (TextView) findViewById(R.id.myNewsTextView);
	        
	        editInfoButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
				    Intent intent = new Intent(InfoDetailActivity.this,ModifyInfoActivity.class);
					startActivity(intent);
				}
			});
	        
	        myFocusImg.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
				    Intent intent = new Intent(InfoDetailActivity.this,FocusActivity.class);
					startActivity(intent);
				}
			});
	        
	        myFocusTV.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
				    Intent intent = new Intent(InfoDetailActivity.this,FocusActivity.class);
					startActivity(intent);
				}
			});
	        myCollectImg.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
				    Intent intent = new Intent(InfoDetailActivity.this,FocusActivity.class);
					startActivity(intent);
				}
			});
	        myCollectTV.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
				    Intent intent = new Intent(InfoDetailActivity.this,FocusActivity.class);
					startActivity(intent);
				}
			});
	        myNewsImg.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
				    Intent intent = new Intent(InfoDetailActivity.this,NewsCountAct.class);
					startActivity(intent);
				}
			});
	        myNewsTV.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
				    Intent intent = new Intent(InfoDetailActivity.this,NewsCountAct.class);
					startActivity(intent);
				}
			});
	        

	        ListView dingDanManage = (ListView) findViewById(R.id.dingDanManage);  
	        ListView qiuGouManage = (ListView) findViewById(R.id.qiuGouManage);
	          

	        
	    
	        ArrayList<HashMap<String, Object>> dingDanList = new ArrayList<HashMap<String, Object>>(); 
	       
	        HashMap<String, Object> map1 = new HashMap<String, Object>();  
	        map1.put("ItemImage", R.drawable.add);
	        map1.put("ItemTitle", "锟斤拷锟节筹拷锟斤拷");

	        dingDanList.add(map1); 
	        
	        HashMap<String, Object> map2 = new HashMap<String, Object>();
	        map2.put("ItemImage", R.drawable.add); 
	        map2.put("ItemTitle", "锟斤拷锟斤拷沙锟斤拷锟�");

	        dingDanList.add(map2);
	         
	        HashMap<String, Object> map3 = new HashMap<String, Object>();
	        map3.put("ItemImage", R.drawable.add);  
	        map3.put("ItemTitle", "锟斤拷锟斤拷锟�");

	         
	        HashMap<String, Object> map4 = new HashMap<String, Object>();
	        map4.put("ItemImage", R.drawable.add);  
	        map4.put("ItemTitle", "锟斤拷锟铰硷拷");
	        dingDanList.add(map4);                  //锟斤拷锟斤拷锟斤拷锟斤拷ListView锟斤拷锟斤拷

	         
	         ArrayList<HashMap<String, Object>> qiuGouList = new ArrayList<HashMap<String, Object>>(); 
	         
	         HashMap<String, Object> map5 = new HashMap<String, Object>();
	         map5.put("ItemImage", R.drawable.add);  
	         map5.put("ItemTitle", "锟斤拷锟斤拷锟斤拷");

	         qiuGouList.add(map5); 
	         
	         HashMap<String, Object> map6 = new HashMap<String, Object>();
	         map6.put("ItemImage", R.drawable.add);  
	         map6.put("ItemTitle", "锟斤拷锟斤拷械锟斤拷锟�");
	         qiuGouList.add(map6);                 //锟襟购癸拷锟斤拷ListView锟斤拷锟斤拷
	 
	         
	        //锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟�==锟斤拷ListItem  
	        SimpleAdapter dingDanSchedule = new SimpleAdapter(this, //没什么锟斤拷锟斤拷  
	        		                                    dingDanList,//锟斤拷锟斤拷锟皆�  
	                                                    R.layout.ding_dan_manage,//ListItem锟斤拷XML实锟斤拷  
	                                                      
	                                                    //锟斤拷态锟斤拷锟斤拷锟斤拷ListItem锟斤拷应锟斤拷锟斤拷锟斤拷          
	                                                    new String[] {"ItemImage", "ItemTitle"},   
	                                                      
	                                                    //ListItem锟斤拷XML锟侥硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟絋extView ID  
	                                                    new int[] {R.id.ItemImage,R.id.ItemTitle});  
	        //锟斤拷硬锟斤拷锟斤拷锟绞� 
	        SimpleAdapter qiuGouSchedule = new SimpleAdapter(this, //没什么锟斤拷锟斤拷  
	                qiuGouList,//锟斤拷锟斤拷锟皆�  
	                R.layout.ding_dan_manage,//ListItem锟斤拷XML实锟斤拷  
	                  
	                //锟斤拷态锟斤拷锟斤拷锟斤拷ListItem锟斤拷应锟斤拷锟斤拷锟斤拷          
	                new String[] {"ItemImage", "ItemTitle"},   
	                  
	                //ListItem锟斤拷XML锟侥硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟絋extView ID  
	                new int[] {R.id.ItemImage,R.id.ItemTitle});  
	//锟斤拷硬锟斤拷锟斤拷锟绞� 

	        dingDanManage.setAdapter(dingDanSchedule); 
	        qiuGouManage.setAdapter(qiuGouSchedule); 
	    }
	    

	  

}
