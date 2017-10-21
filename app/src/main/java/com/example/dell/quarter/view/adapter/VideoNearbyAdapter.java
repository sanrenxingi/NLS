package com.example.dell.quarter.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.bean.VideoHotBean;
import com.example.dell.quarter.modle.bean.VideoNearbyBean;
import com.example.dell.quarter.view.activity.VideoPlayActivity;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by dell on 2017/10/21.
 * 视频中的附近适配器
 * 聂雁宾
 */

public class VideoNearbyAdapter extends RecyclerView.Adapter{
    Context context;
    List<VideoNearbyBean.DataBean> list;

    public VideoNearbyAdapter(Context context, List<VideoNearbyBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        VideoNearbyAdapter.NearbyViewHolder nearbyViewHolder=new VideoNearbyAdapter.NearbyViewHolder(LayoutInflater.from(context).inflate(R.layout.videohot_item,parent,false));
        return nearbyViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VideoNearbyAdapter.NearbyViewHolder) {
//         final String mediaSrc = list.get(position).getMediaSrc();
            //加载图片
            ImageLoader.getInstance().displayImage(list.get(position).getUserImg(), ((VideoNearbyAdapter.NearbyViewHolder) holder).img);
            ((VideoNearbyAdapter.NearbyViewHolder) holder).img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
//                  Toast.makeText(context,"点击"+position,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, VideoPlayActivity.class);
//                 intent.putExtra("url",mediaSrc);
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
    class NearbyViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;

        public NearbyViewHolder(View itemView) {
            super(itemView);
            //找ID
            img = itemView.findViewById(R.id.video_hot_img);
        }
    }
}
