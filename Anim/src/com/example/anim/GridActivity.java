package com.example.anim;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;



public class GridActivity extends Activity {

	private List<Integer> darw=null;
	private MyAdapter myadpter=null;
	private GridView grid=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gridviewdemo);
		darw=new ArrayList<Integer>();
		darw.add(R.drawable.p1);
		darw.add(R.drawable.p2);
		darw.add(R.drawable.p3);
		darw.add(R.drawable.p4);
		darw.add(R.drawable.p5);
		darw.add(R.drawable.p6);
		
		darw.add(R.drawable.p7);
		myadpter=new MyAdapter();
		grid=(GridView) findViewById(R.id.gridView1);
		grid.setAdapter(myadpter);
	}
	class MyAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return darw.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return darw.get(position) ;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		/*
		 * 每个条目显示的view，有多少个就显示多少view
		 * (non-Javadoc)
		 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
		 */
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageView = null;
			if(convertView == null){
				imageView = new ImageView(GridActivity.this);
				//显示方式
				imageView.setLayoutParams(new GridView.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
				imageView.setScaleType(ScaleType.CENTER);
				imageView.setPadding(5, 5, 5, 5);// android:paddingLeft 
			}else{
				imageView = (ImageView)convertView;
			}
			imageView.setImageResource(darw.get(position));
			return imageView;
		}
		
		}
		
	
}
