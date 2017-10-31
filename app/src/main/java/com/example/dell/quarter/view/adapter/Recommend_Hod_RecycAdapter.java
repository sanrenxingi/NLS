package com.example.dell.quarter.view.adapter;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.quarter.R;
import com.example.dell.quarter.view.activity.VideoPlayActivity;
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
    private SparseBooleanArray mCheckStates = new SparseBooleanArray();
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
            //无限轮播
            ViewHodler viewHolder= (ViewHodler) holder;
            bannerlunbo(viewHolder);
        }else if (getItemViewType(position)>0){
            final ViewHodler viewhodler= (ViewHodler) holder;
            //更换侧边收藏等
            setce(viewhodler);
            //加号的点击事件，弹出三个图片，举报，屏蔽，链接
            getdianji(viewhodler);

            //中间点击图片出现隐藏开始按钮
            visibleimage(viewhodler,position);
            //按钮点击跳转到另一个界面播放视频
            ijkplay();




        }
    }

    private void ijkplay() {
        //按钮点击跳转到另一个界面播放视频
//        Intent intent=new Intent(context,)
    }

    //中间点击图片出现隐藏开始按钮
    private void visibleimage(final ViewHodler viewhodler, int position) {
        viewhodler.yuyihu.setTag(position);
        viewhodler.yuyihu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int pos = (int) buttonView.getTag();
                if (isChecked) {
                    mCheckStates.put(pos, true);
                    //do something
                    //展示开始按钮，隐藏边上四个评论
                    viewhodler.anniu.setVisibility(View.VISIBLE);
                    viewhodler.xihuan.setVisibility(View.GONE);
                    viewhodler.shoucang.setVisibility(View.GONE);
                    viewhodler.zhuanzai.setVisibility(View.GONE);
                    viewhodler.pinglun.setVisibility(View.GONE);
                    //视频播放
                    viewhodler.anniu.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent=new Intent(context, VideoPlayActivity.class);
                            intent.putExtra("isLive",false);
                            intent.putExtra("url","http://172.17.29.27/oppo.mp4");
                            context.startActivity(intent);
                        }
                    });

                } else {
                    mCheckStates.delete(pos);
                    //do something else
                    //隐藏开始按钮，展示边上四个评论
                    viewhodler.anniu.setVisibility(View.GONE);
                    viewhodler.xihuan.setVisibility(View.VISIBLE);
                    viewhodler.shoucang.setVisibility(View.VISIBLE);
                    viewhodler.zhuanzai.setVisibility(View.VISIBLE);
                    viewhodler.pinglun.setVisibility(View.VISIBLE);
                }
            }
        });
        viewhodler.yuyihu.setChecked(mCheckStates.get(position, false));
    }

    //无限轮播
    private void bannerlunbo(ViewHodler viewHolder) {

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

    //更换侧边收藏等
    private void setce(final ViewHodler viewhodler) {
        //喜欢图片
//        SpannableString ss = new SpannableString("1122\n1056");
//        Drawable red_heart = context.getResources().getDrawable(R.drawable.my_live);
//        //图片大小 d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
//        red_heart.setBounds(0, 0,30, 30);
//        //创建ImageSpan
//        ImageSpan span = new ImageSpan(red_heart, ImageSpan.ALIGN_BASELINE);
//        //用ImageSpan替换文本
//        ss.setSpan(span, 0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        viewhodler.xihuan.setText(ss);
        /**
         * 收藏
         */
//        SpannableString ss1 = new SpannableString("1122\n803");
//        Drawable d1 = context.getResources().getDrawable(R.drawable.my_shoucang);
//        //图片大小 d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
//        d1.setBounds(0, 0,30, 30);
//        //创建ImageSpan
//        ImageSpan span1 = new ImageSpan(d1, ImageSpan.ALIGN_BASELINE);
//        //用ImageSpan替换文本
//        ss1.setSpan(span1, 0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
//        viewhodler.shoucang.setText(ss1);

        /**
         * 转载
         */
        SpannableString ss2 = new SpannableString("1122\n506");
        Drawable d2 = context.getResources().getDrawable(R.drawable.raw_1499995160);
        //图片大小 d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        d2.setBounds(0, 0,30, 30);
        //创建ImageSpan
        ImageSpan span2 = new ImageSpan(d2, ImageSpan.ALIGN_BASELINE);
        //用ImageSpan替换文本
        ss2.setSpan(span2, 0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        viewhodler.zhuanzai.setText(ss2);

        /**
         * 评论
         */
        SpannableString ss3 = new SpannableString("1122\n1.1万");
        Drawable d3 = context.getResources().getDrawable(R.drawable.raw_1499933789);
        //图片大小 d.setBounds(0, 0, d.getIntrinsicWidth(), d.getIntrinsicHeight());
        d3.setBounds(0, 0,30, 30);
        //创建ImageSpan
        ImageSpan span3 = new ImageSpan(d3, ImageSpan.ALIGN_BASELINE);
        //用ImageSpan替换文本
        ss3.setSpan(span3, 0,5, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
        viewhodler.pinglun.setText(ss3);
    }

    @Override
    public int getItemCount() {
        return 5;
    }
    //加号点击事件
    public void getdianji(final ViewHodler viewhodler) {
        viewhodler.jiahao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){

                    //动画加号切换为减号并旋转
                    Animator animator = AnimatorInflater.loadAnimator(context, R.animator.come_one);
                    animator.setTarget(viewhodler.jiahao);
                    animator.start();

                    //动画举报
                    Animator animator1 = AnimatorInflater.loadAnimator(context, R.animator.come_two);
                    animator1.setTarget(viewhodler.jubao);
                    animator1.start();
                    //动画链接
                    Animator animator2 = AnimatorInflater.loadAnimator(context, R.animator.come_thread);
                    animator2.setTarget(viewhodler.lianjie);
                    animator2.start();
                    //动画屏蔽
                    Animator animator3 = AnimatorInflater.loadAnimator(context, R.animator.come_for);
                    animator3.setTarget(viewhodler.pingbi);
                    animator3.start();
                    //关闭动画
                    animator.clone();
                    animator1.clone();
                    animator2.clone();
                    animator3.clone();
//
                }else if (b==false){

                    //动画加号切换为减号并旋转
                    Animator animator = AnimatorInflater.loadAnimator(context, R.animator.take_one);
                    animator.setTarget(viewhodler.jiahao);
                    animator.start();


                    //动画链接
                    Animator animator2 = AnimatorInflater.loadAnimator(context, R.animator.take_thread);
                    animator2.setTarget(viewhodler.lianjie);
                    animator2.start();
                    //动画屏蔽
                    Animator animator3 = AnimatorInflater.loadAnimator(context, R.animator.take_for);
                    animator3.setTarget(viewhodler.pingbi);
                    animator3.start();
                    //动画举报
                    Animator animator1 = AnimatorInflater.loadAnimator(context, R.animator.take_two);
                    animator1.setTarget(viewhodler.jubao);
                    animator1.start();
                    animator.clone();
                    animator1.clone();
                    animator2.clone();
                    animator3.clone();
                }

            }
        });
    }



    public class ViewHodler extends RecyclerView.ViewHolder{


        private final Banner banner;
        private final ImageView jubao;
        private final ImageView pingbi;
        private final ImageView lianjie;
        private final CheckBox jiahao;
        private final CheckBox xihuan;
        private final CheckBox shoucang;
        private final TextView zhuanzai;
        private final TextView pinglun;
        private final ImageView anniu;
        private final CheckBox yuyihu;

        public ViewHodler(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
            jubao = itemView.findViewById(R.id.recommend_recyc_jubao);
            pingbi = itemView.findViewById(R.id.recommend_recyc_pingbi);
            lianjie = itemView.findViewById(R.id.recommend_recyc_lianjie);
            jiahao = itemView.findViewById(R.id.recommend_recyc_jiahao);
            xihuan = itemView.findViewById(R.id.xihuan);
            shoucang = itemView.findViewById(R.id.shoucang);
            zhuanzai = itemView.findViewById(R.id.zhuanzai);
            pinglun = itemView.findViewById(R.id.pinglun);
            yuyihu = itemView.findViewById(R.id.recommend_recyc_yuyihu);
            anniu = itemView.findViewById(R.id.recommend_recyc_anniu);

        }
    }
}
