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

	//定义浮动窗口布局
    LinearLayout mFloatLayout;
    WindowManager.LayoutParams wmParams;
    //创建浮动窗口设置布局参数的对象
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
		//获取WindowManagerImpl.CompatModeWrapper
		mWindowManager = (WindowManager)getApplication().getSystemService(getApplication().WINDOW_SERVICE);
		//设置window type
		wmParams.type = LayoutParams.TYPE_PHONE; 
	    wmParams.format = PixelFormat.RGBA_8888;;
		//设置图片格式，效果为背景透明
//        wmParams.format = PixelFormat.RGBA_8888; 
//        wmParams.format = PixelFormat.RGB_565; 
        //设置浮动窗口不可聚焦（实现操作除浮动窗口外的其他可见窗口的操作）
//        wmParams.flags =
//          LayoutParams.FLAG_NOT_FOCUSABLE
//          ;
        
        //调整悬浮窗显示的停靠位置为左侧置顶
        wmParams.gravity = Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL; 
        
        // 以屏幕左上角为原点，设置x、y初始值
        //wmParams.x = 0;
        //wmParams.y = 0;

        /*// 设置悬浮窗口长宽数据
        wmParams.width = 200;
        wmParams.height = 80;*/
        
        //设置悬浮窗口长宽数据  
        wmParams.width = WindowManager.LayoutParams.FILL_PARENT;
        wmParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        
        LayoutInflater inflater = LayoutInflater.from(getApplication());
        //获取浮动窗口视图所在布局
        mFloatLayout = (LinearLayout) inflater.inflate(R.layout.float_layout, null);
        //添加mFloatLayout
        mWindowManager.addView(mFloatLayout, wmParams);
        Log.i(TAG, "mFloatLayout-->left" + mFloatLayout.getLeft());
        Log.i(TAG, "mFloatLayout-->right" + mFloatLayout.getRight());
        Log.i(TAG, "mFloatLayout-->top" + mFloatLayout.getTop());
        Log.i(TAG, "mFloatLayout-->bottom" + mFloatLayout.getBottom());      
        
        //浮动窗口按钮
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
        //设置监听浮动窗口的触摸移动
//        mFloatView.setOnTouchListener(new OnTouchListener() 
//        {
//			
//			@Override
//			public boolean onTouch(View v, MotionEvent event) 
//			{
//				// TODO Auto-generated method stub
//				//getRawX是触摸位置相对于屏幕的坐标，getX是相对于按钮的坐标
//				wmParams.x = (int) event.getRawX() - mFloatView.getMeasuredWidth()/2;
//				//Log.i(TAG, "Width/2--->" + mFloatView.getMeasuredWidth()/2);
//				Log.i(TAG, "RawX" + event.getRawX());
//				Log.i(TAG, "X" + event.getX());
//				//25为状态栏的高度
//	            wmParams.y = (int) event.getRawY() - mFloatView.getMeasuredHeight()/2 - 25;
//	           // Log.i(TAG, "Width/2--->" + mFloatView.getMeasuredHeight()/2);
//	            Log.i(TAG, "RawY" + event.getRawY());
//	            Log.i(TAG, "Y" + event.getY());
//	             //刷新
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
