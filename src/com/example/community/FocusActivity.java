package com.example.community;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class FocusActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);
   
      //绑定XML中的ListView，作为Item的容器  
        ListView focusListView = (ListView) findViewById(R.id.focusListView); 
       
          
        //生成动态数组，并且转载数据  
        ArrayList<HashMap<String, Object>> focusList = new ArrayList<HashMap<String, Object>>();  
         
        HashMap<String, Object> map1 = new HashMap<String, Object>();  
        map1.put("ItemImage", R.drawable.no_pic);  
        map1.put("ItemTitle", "张三");  
        focusList.add(map1);  
        
        HashMap<String, Object> map2 = new HashMap<String, Object>();  
        map2.put("ItemImage", R.drawable.no_pic);  
        map2.put("ItemTitle", "李四");  
        focusList.add(map2);
        
        //生成适配器，数组===》ListItem  
        SimpleAdapter focusListSchedule = new SimpleAdapter(this, //没什么解释  
        		                                    focusList,//数据来源   
                                                    R.layout.ding_dan_manage,//ListItem的XML实现  
                                                      
                                                    //动态数组与ListItem对应的子项          
                                                    new String[] {"ItemImage", "ItemTitle"},   
                                                      
                                                    //ListItem的XML文件里面的两个TextView ID  
                                                    new int[] {R.id.ItemImage,R.id.ItemTitle});  
        //添加并且显示  
        focusListView.setAdapter(focusListSchedule); 
    }


}
