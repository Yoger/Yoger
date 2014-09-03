package com.example.community;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SearchPageAct extends Activity {
	
    private Spinner searchType = null; 
    private Spinner selectType = null; 

    ArrayAdapter<String> searchTypeAdapter = null; 
    ArrayAdapter<String> selectTypeAdapter = null; 
    
    private String[] searchTypeArray = new String[] {"��Ʒ","����","�û�"};
    private String[] selectTypeArray = new String[] {"�ۺ�����","�۸�����","ʱ������"};
  
 
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
				// TODO Auto-generated method stub   arg2Ϊ��ǰѡ�� 0-2
			
			}
         });
    }
    
    private void set_selectType()
    {        
    	selectType = (Spinner)findViewById(R.id.select_type);
    	selectTypeAdapter = new ArrayAdapter<String>(SearchPageAct.this,
                android.R.layout.simple_spinner_item, selectTypeArray);
    	selectType.setAdapter(selectTypeAdapter);
    	selectType.setSelection(0,true);  //����Ĭ��ѡ����˴�ΪĬ��ѡ�е�4��ֵ
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search_page);
		set_searchType();
		set_selectType();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search_page, menu);
		return true;
	}

}
 