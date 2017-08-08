package com.langxiaodemo.iosdialogtext;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by admin on 2016/9/8.
 */
public class RecyDmeoActivity extends Activity {

    private RecyclerView rv;
    private String[] data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy);
        rv = (RecyclerView) findViewById(R.id.rv);
        //设置布局管理器
        rv.setLayoutManager(new LinearLayoutManager(this));//线性布局,默认竖直布局
//        rv.setLayoutManager(new LinearLayoutManager(RecyDmeoActivity.this,LinearLayoutManager.HORIZONTAL,false));//线性布局,水平布局
//        rv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));//流式布局,水平布局
        //设置Item增加、移除动画
        rv.setItemAnimator(new DefaultItemAnimator());
        data = new String[]{"1","2","12","22","13","23","14","24","15","25","16","26","17","27","18","28","19","29"};
        rv.setAdapter(new MyRecycleViewAdapter());

    }

    private class MyRecycleViewAdapter extends RecyclerView.Adapter<MyRecycleViewAdapter.MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    RecyDmeoActivity.this).inflate(R.layout.item_recyclerview,parent,false));

            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv1.setText(data[position]);
        }

        @Override
        public int getItemCount() {
            return data.length;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{

            private final TextView tv1;

            public MyViewHolder(View view) {
                super(view);
                tv1 = (TextView) view.findViewById(R.id.tv1);

            }
        }
    }


}
