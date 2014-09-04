package com.example.community;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ModifyInfoActivity extends Activity {

	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_modify_info);
	        
	        Button changeImageButton = (Button) findViewById(R.id.changeImageButton);
	        Button changePSWButton = (Button) findViewById(R.id.changePSWButton);
	        Button saveChangeButton = (Button) findViewById(R.id.saveChangeButton);
	        EditText userName = (EditText) findViewById(R.id.userName);
	        EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
	        EditText emailAddress = (EditText) findViewById(R.id.emailAddress);
	      //绑定XML中的ListView，作为Item的容器  
	          
	        changeImageButton.setOnClickListener(new changeImageButtonListener());
	        changePSWButton.setOnClickListener(new changePSWButtonListener());
	        saveChangeButton.setOnClickListener(new saveChangeButtonListener());
	        
	    }
	    
	    public class changeImageButtonListener implements OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
	    	
	    }
	    
	    public class saveChangeButtonListener implements OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				
			}
	    	
	    }
	    
	    public class changePSWButtonListener implements OnClickListener{

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(ModifyInfoActivity.this,ChangePswAct.class);
				startActivity(intent);
				
			}
	    	
	    }
}
