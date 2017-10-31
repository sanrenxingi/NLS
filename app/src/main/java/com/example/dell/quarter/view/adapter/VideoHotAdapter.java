package com.example.dell.quarter.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.bean.VideoHotBean;
import com.example.dell.quarter.view.activity.VideoPlayActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by dell on 2017/10/19.
 * 视频热门的适配器
 * 聂雁宾
 */

public class VideoHotAdapter extends RecyclerView.Adapter{
    Context context;
    List<VideoHotBean.DataBean> list;
//有参构造
    public VideoHotAdapter(Context context, List<VideoHotBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
//初始化数据
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HotViewHolder hotViewHolder=new HotViewHolder(LayoutInflater.from(context).inflate(R.layout.videohot_item,parent,false));
        return hotViewHolder;
    }
//将数据加载
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
      if(holder instanceof HotViewHolder){
//         final String mediaSrc = lists.get(position).getMediaSrc();
          //加载图片
          ImageLoader.getInstance().displayImage(list.get(position).getUserImg(),((HotViewHolder) holder).img);
          ((HotViewHolder) holder).img.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
//                  Toast.makeText(context,"点击"+position,Toast.LENGTH_SHORT).show();
                  Intent intent=new Intent(context, VideoPlayActivity.class);
                  intent.putExtra("isLive",false);
                  intent.putExtra("url","http://172.17.29.27/oppo.mp4");
                  context.startActivity(intent);
              }
          });

      }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    //优化
    class HotViewHolder extends RecyclerView.ViewHolder {

        public ImageView img;

        public HotViewHolder(View itemView) {
            super(itemView);
            //找ID
            img = itemView.findViewById(R.id.video_hot_img);
        }
    }
}
