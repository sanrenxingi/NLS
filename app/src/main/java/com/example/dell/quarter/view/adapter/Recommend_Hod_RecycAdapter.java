package com.example.dell.quarter.view.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.quarter.R;
import com.example.dell.quarter.view.view.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.List;

/**
 * 类描述：热门界面适配器
 * 姓名 ：刘希鑫
 */

public class Recommend_Hod_RecycAdapter extends RecyclerView.Adapter{
    Context context;
    List<String> arr;
    List<String> list;
    public Recommend_Hod_RecycAdapter(Context context,List<String> arr,List<String> list){
        this.context=context;
        this.arr = arr;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
           return 0;
        }else{
        return position;
    }}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHodler hodler=null;
        if (viewType==0){
            View view= LayoutInflater.from(context).inflate(R.layout.adapter_banner,null);
           hodler= new ViewHodler(view);
        }else if(viewType>0){
            View view= LayoutInflater.from(context).inflate(R.layout.recommend_recyc_adapter,null);
           hodler= new ViewHodler(view);
        }
        return hodler;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         if (getItemViewType(position)==0){
             ViewHodler viewHolder= (ViewHodler) holder;
             //设置banner样式
             viewHolder.banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//设置图片加载器
             viewHolder.banner.setImageLoader(new GlideImageLoader());
//设置图片集合

//设置banner动画效果
             viewHolder.banner.setBannerAnimation(Transformer.DepthPage);
//设置标题集合（当banner样式有显示title时）

//设置自动轮播，默认为true
             viewHolder.banner.isAutoPlay(true);
//设置轮播时间
             viewHolder.banner.setDelayTime(1500);
//设置指示器位置（当banner模式中有指示器时）
             viewHolder.banner.setIndicatorGravity(BannerConfig.CENTER);
             viewHolder.banner.setImages(arr);
             viewHolder.banner.setBannerTitles(list);
             viewHolder.banner.start();
         }


    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHodler extends RecyclerView.ViewHolder{


        private final Banner banner;

        public ViewHodler(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }
}
