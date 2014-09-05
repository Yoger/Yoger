package com.example.community;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class DisplayInfoActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_display_info);
   
      //��XML�е�ListView����ΪItem������  
        ListView soldAndQiuGou = (ListView) findViewById(R.id.soldAndQiuGou); 
        Button talkToHeButton = (Button) findViewById(R.id.talkToHeButton);
        Button focusHeORButton = (Button) findViewById(R.id.focusHeORButton);
        
        talkToHeButton.setOnClickListener(new talkToHeButtonListener());
        focusHeORButton.setOnClickListener(new focusHeORButtonListener());
          
        //���ɶ�̬���飬����ת������  
        ArrayList<HashMap<String, Object>> soldAndQiuGouList = new ArrayList<HashMap<String, Object>>();  
         
        HashMap<String, Object> map1 = new HashMap<String, Object>();  
        map1.put("ItemImage", R.drawable.no_pic);  
        map1.put("ItemTitle", "���ڳ���");  
        soldAndQiuGouList.add(map1);  
        
        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("ItemImage", R.drawable.no_pic);  
        map2.put("ItemTitle", "������");  
        soldAndQiuGouList.add(map2);
        
        //����������������===��ListItem  
        SimpleAdapter soldAndQiuGouSchedule = new SimpleAdapter(this, //ûʲô����  
        		                                    soldAndQiuGouList,//������Դ   
                                                    R.layout.ding_dan_manage,//ListItem��XMLʵ��  
                                                      
                                                    //��̬������ListItem��Ӧ������          
                                                    new String[] {"ItemImage", "ItemTitle"},   
                                                      
                                                    //ListItem��XML�ļ����������TextView ID  
                                                    new int[] {R.id.ItemImage,R.id.ItemTitle});  
        //��Ӳ�����ʾ  
        soldAndQiuGou.setAdapter(soldAndQiuGouSchedule); 


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
			// ���µ������BACK��ͬʱû���ظ�
			finish();

			return true;
		}

		return super.onKeyDown(keyCode, event);
	}
    
    public class talkToHeButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
    public class focusHeORButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
    	
    }



}
