package com.example.anim;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

	private LinearLayout llv;
	private TextView touch;
	private ImageView image;
	private int iv_x;
	private int image_width;
	private int image_height;
	private int iv_y;
	private int screen_width;
	private int screen_height;
	private Bitmap bitmap;
	private SurfaceHolder surfacehode=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		this.screen_height=super.getWindowManager().getDefaultDisplay().getHeight();
		this.screen_width=super.getWindowManager().getDefaultDisplay().getWidth();
		
		
		
		
		
		setContentView(R.layout.activity_main);
		AutoCheckUpdate autocheck=new AutoCheckUpdate(this);
		autocheck.check();
		llv=(LinearLayout) findViewById(R.id.lvout);
		touch=(TextView) findViewById(R.id.touch);
		LayoutInflater inflator=LayoutInflater.from(this);
		View view=inflator.inflate(R.layout.afda, null);

llv.addView(view);
		this.image=new ImageView(this);
		this.bitmap=BitmapFactory.decodeResource(super.getResources(), R.drawable.ic_launcher);
this.image_width=this.bitmap.getWidth();
this.image_height=this.bitmap.getHeight();
this.iv_x=(this.screen_height-this.image_height)/2;
this.iv_y=(this.screen_width-this.image_width)/2;
this.image.setImageBitmap(bitmap);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		
		// TODO Auto-generated method stub
System.out.println(event.getPointerCount());
if(event.getPointerCount()==2){
	System.out.println("weizhi1"+event.getX(0)+"y"+event.getY(0));
	System.out.println("weizhi2"+event.getY(1)+"y"+event.getY(1));
	
}
		return true;
	}
	/**
	 * @deprecated Use {@link #diaoysffs()} instead
	 */


private class mySurface extends SurfaceView implements SurfaceHolder.Callback{

		public mySurface(Context context) {
			super(context);
			MainActivity.this.surfacehode=super.getHolder();
			MainActivity.this.surfacehode.addCallback(this);
			// TODO Auto-generated constructor stub
			super.setFocusable(true);//获得焦点进行操作
		}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			
		}
	
}
	
private void setImage(float scale,int width,int height){
	Canvas canvas =MainActivity.this.surfacehode.lockCanvas();
	Paint paint =new Paint();
	Matrix martix=new Matrix();
	martix.postScale(scale, scale);
	canvas.drawBitmap(bitmap, martix, paint);
	this.surfacehode.unlockCanvasAndPost(canvas);//解锁，并提交对象
}

}
