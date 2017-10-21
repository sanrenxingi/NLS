package com.example.dell.quarter.view.adapter;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

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
    int a=0;
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
         }else if (getItemViewType(position)>0){
                   final ViewHodler viewhodler= (ViewHodler) holder;
              //加号的点击事件，弹出三个图片，举报，屏蔽，链接
           getdianji(viewhodler);

         }
    }

    @Override
    public int getItemCount() {
        return 15;
    }
//加号点击事件
    public void getdianji(final ViewHodler viewhodler) {
        viewhodler.jiahao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a==0){
                    a=1;
                    //动画加号切换为减号并旋转
                    ObjectAnimator jia=ObjectAnimator.ofFloat(viewhodler.jiahao, "rotation", 0f, 360f);
                    jia.setDuration(1000);
                    jia.start();
                    viewhodler.jiahao.setImageResource(R.drawable.jianhao);
                    //动画链接
                    ObjectAnimator moveIn = ObjectAnimator.ofFloat(viewhodler.pingbi, "translationX", 0f, -100f);
                    ObjectAnimator rotate = ObjectAnimator.ofFloat(viewhodler.pingbi, "rotation", 0f, 360f);
                    ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(viewhodler.pingbi, "alpha", 0f, 1f, 1f);
                    AnimatorSet animSet = new AnimatorSet();
                    animSet.play(rotate).with(fadeInOut).with(moveIn);
                    animSet.setDuration(1000);
                    animSet.start();
                    //动画屏蔽
                    ObjectAnimator moveIn1 = ObjectAnimator.ofFloat(viewhodler.lianjie, "translationX", 0f, -200f);
                    ObjectAnimator rotate1 = ObjectAnimator.ofFloat(viewhodler.lianjie, "rotation", 0f, 360f);
                    ObjectAnimator fadeInOut1 = ObjectAnimator.ofFloat(viewhodler.lianjie, "alpha", 0f, 1f, 1f);
                    AnimatorSet animSet1 = new AnimatorSet();
                    animSet1.play(rotate1).with(fadeInOut1).with(moveIn1);
                    animSet1.setDuration(1000);
                    animSet1.start();
                    //动画举报
                    ObjectAnimator moveIn2 = ObjectAnimator.ofFloat(viewhodler.jubao, "translationX", 0f, -300f);
                    ObjectAnimator rotate2 = ObjectAnimator.ofFloat(viewhodler.jubao, "rotation", 0f, 360f);
                    ObjectAnimator fadeInOut2 = ObjectAnimator.ofFloat(viewhodler.jubao, "alpha", 0f, 1f, 1f);
                    AnimatorSet animSet2 = new AnimatorSet();
                    animSet2.play(rotate2).with(fadeInOut2).with(moveIn2);
                    animSet2.setDuration(1000);
                    animSet2.start();
                }else if (a==1){
                    a=0;
                    //动画加号切换为减号并旋转
                    ObjectAnimator jia=ObjectAnimator.ofFloat(viewhodler.jiahao, "rotation", 360f, 00f);
                    jia.setDuration(1000);
                    jia.start();
                    viewhodler.jiahao.setImageResource(R.drawable.jiahao);
                    //动画链接
                    ObjectAnimator moveIn = ObjectAnimator.ofFloat(viewhodler.pingbi, "translationX", -100f, 0f);
                    ObjectAnimator rotate = ObjectAnimator.ofFloat(viewhodler.pingbi, "rotation", 360f, 0f);
                    ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(viewhodler.pingbi, "alpha", 1f, 0f, 0f);
                    AnimatorSet animSet = new AnimatorSet();
                    animSet.play(rotate).with(fadeInOut).with(moveIn);
                    animSet.setDuration(1000);
                    animSet.start();
                    //动画屏蔽
                    ObjectAnimator moveIn1 = ObjectAnimator.ofFloat(viewhodler.lianjie, "translationX", -200f, 0f);
                    ObjectAnimator rotate1 = ObjectAnimator.ofFloat(viewhodler.lianjie, "rotation", 360f, 0f);
                    ObjectAnimator fadeInOut1 = ObjectAnimator.ofFloat(viewhodler.lianjie, "alpha", 1f, 0f, 0f);
                    AnimatorSet animSet1 = new AnimatorSet();
                    animSet1.play(rotate1).with(fadeInOut1).with(moveIn1);
                    animSet1.setDuration(1000);
                    animSet1.start();
                    //动画举报
                    ObjectAnimator moveIn2 = ObjectAnimator.ofFloat(viewhodler.jubao, "translationX", -300f, 0f);
                    ObjectAnimator rotate2 = ObjectAnimator.ofFloat(viewhodler.jubao, "rotation", 360f, 0f);
                    ObjectAnimator fadeInOut2 = ObjectAnimator.ofFloat(viewhodler.jubao, "alpha", 1f, 0f, 0f);
                    AnimatorSet animSet2 = new AnimatorSet();
                    animSet2.play(rotate2).with(fadeInOut2).with(moveIn2);
                    animSet2.setDuration(1000);
                    animSet2.start();

                }

            }
        });
    }

    public class ViewHodler extends RecyclerView.ViewHolder{


        private final Banner banner;
        private final ImageView jubao;
        private final ImageView pingbi;
        private final ImageView lianjie;
        private final ImageView jiahao;

        public ViewHodler(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
            jubao = itemView.findViewById(R.id.recommend_recyc_jubao);
            pingbi = itemView.findViewById(R.id.recommend_recyc_pingbi);
            lianjie = itemView.findViewById(R.id.recommend_recyc_lianjie);
            jiahao = itemView.findViewById(R.id.recommend_recyc_jiahao);
        }
    }
}
