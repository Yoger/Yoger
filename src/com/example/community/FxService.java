package com.example.community;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class FxService extends Service 
{

	//���帡�����ڲ���
    LinearLayout mFloatLayout;
    WindowManager.LayoutParams wmParams;
    //���������������ò��ֲ����Ķ���
	WindowManager mWindowManager;
	Button mFloatClose;
	Button mFloatRelease;
	Button mFloatSeek;
	private static final String TAG = "FxService";
	
	@Override
	public void onCreate() 
	{
		// TODO Auto-generated method stub
		System.out.println("float-create!");
		super.onCreate();
		Log.i(TAG, "oncreat");
		createFloatView();
        //Toast.makeText(FxService.this, "create FxService", Toast.LENGTH_LONG);		
	}

	@Override
	public IBinder onBind(Intent intent)
	{
		// TODO Auto-generated method stub
		return null;
	}

	private void createFloatView()
	{
		wmParams = new WindowManager.LayoutParams();
		//��ȡWindowManagerImpl.CompatModeWrapper
		mWindowManager = (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);
		//����window type
		wmParams.type = LayoutParams.TYPE_PHONE; 
	    wmParams.format = PixelFormat.RGBA_8888;;
		//����ͼƬ��ʽ��Ч��Ϊ����͸��
//        wmParams.format = PixelFormat.RGBA_8888; 
//        wmParams.format = PixelFormat.RGB_565; 
        //���ø������ڲ��ɾ۽���ʵ�ֲ���������������������ɼ����ڵĲ�����
//        wmParams.flags =
//          LayoutParams.FLAG_NOT_FOCUSABLE
//          ;
        
        //������������ʾ��ͣ��λ��Ϊ����ö�
        wmParams.gravity = Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL; 
        
        // ����Ļ���Ͻ�Ϊԭ�㣬����x��y��ʼֵ
        //wmParams.x = 0;
        //wmParams.y = 0;

        /*// �����������ڳ�������
        wmParams.width = 200;
        wmParams.height = 80;*/
        
        //�����������ڳ�������  
        wmParams.width = WindowManager.LayoutParams.FILL_PARENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        
        LayoutInflater inflater = LayoutInflater.from(getApplication());
        //��ȡ����������ͼ���ڲ���
        mFloatLayout = (LinearLayout) inflater.inflate(R.layout.float_layout, null);
        //���mFloatLayout
        mWindowManager.addView(mFloatLayout, wmParams);
        Log.i(TAG, "mFloatLayout-->left" + mFloatLayout.getLeft());
        Log.i(TAG, "mFloatLayout-->right" + mFloatLayout.getRight());
        Log.i(TAG, "mFloatLayout-->top" + mFloatLayout.getTop());
        Log.i(TAG, "mFloatLayout-->bottom" + mFloatLayout.getBottom());      
        
        //�������ڰ�ť
        mFloatRelease = (Button)mFloatLayout.findViewById(R.id.Float_sell);
        mFloatSeek=(Button)mFloatLayout.findViewById(R.id.Float_seek);
        mFloatRelease.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
			    Intent intent = new Intent(FxService.this,ReleaseGoodsAct.class);
			    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				stopSelf();
			}
		});
        mFloatSeek.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
			    Intent intent = new Intent(FxService.this,ReleaseSeekAct.class);
			    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(intent);
				stopSelf();
			}
		});
        
        mFloatClose=(Button)mFloatLayout.findViewById(R.id.Float_close);
        mFloatClose.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				stopSelf();
			}
		});
        mFloatLayout.measure(View.MeasureSpec.makeMeasureSpec(0,
				View.MeasureSpec.UNSPECIFIED), View.MeasureSpec
				.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//        Log.i(TAG, "Width/2--->" + mFloatView.getMeasuredWidth()/2);
//        Log.i(TAG, "Height/2--->" + mFloatView.getMeasuredHeight()/2);
        //���ü����������ڵĴ����ƶ�
//        mFloatView.setOnTouchListener(new OnTouchListener() 
//        {
//			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) 
//			{
//				// TODO Auto-generated method stub
//				//getRawX�Ǵ���λ���������Ļ�����꣬getX������ڰ�ť������
//				wmParams.x = (int) event.getRawX() - mFloatView.getMeasuredWidth()/2;
//				//Log.i(TAG, "Width/2--->" + mFloatView.getMeasuredWidth()/2);
//				Log.i(TAG, "RawX" + event.getRawX());
//				Log.i(TAG, "X" + event.getX());
//				//25Ϊ״̬���ĸ߶�
//	            wmParams.y = (int) event.getRawY() - mFloatView.getMeasuredHeight()/2 - 25;
//	           // Log.i(TAG, "Width/2--->" + mFloatView.getMeasuredHeight()/2);
//	            Log.i(TAG, "RawY" + event.getRawY());
//	            Log.i(TAG, "Y" + event.getY());
//	             //ˢ��
//	            mWindowManager.updateViewLayout(mFloatLayout, wmParams);
//				return false;
//			}
//		});	
//        
//        mFloatView.setOnClickListener(new OnClickListener() 
//        {
//			
//			@Override
//			public void onClick(View v) 
//			{
//				// TODO Auto-generated method stub
//				Toast.makeText(FxService.this, "onClick", Toast.LENGTH_SHORT).show();
//			}
//		});
	}
	
	@Override
	public void onDestroy() 
	{
		// TODO Auto-generated method stub
		super.onDestroy();
		if(mFloatLayout != null)
		{
			mWindowManager.removeView(mFloatLayout);
		}
	}
	
}
