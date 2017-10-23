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

/**
 * 类描述：
 * 姓名 ：刘希鑫
 */

public class RecommendAttentionAdapter extends RecyclerView.Adapter{
    Context context;
    int a=0;
    public RecommendAttentionAdapter(Context context){

        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.recommend_attention_adapter,parent,false);
        return new ViewHodle(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHodle viewHodle= (ViewHodle) holder;
        getdianji(viewHodle);
    }
    //加号点击事件
    public void getdianji(final ViewHodle viewhodler) {
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
                    ObjectAnimator moveIn2 = ObjectAnimator.ofFloat(viewhodler.jubap, "translationX", 0f, -300f);
                    ObjectAnimator rotate2 = ObjectAnimator.ofFloat(viewhodler.jubap, "rotation", 0f, 360f);
                    ObjectAnimator fadeInOut2 = ObjectAnimator.ofFloat(viewhodler.jubap, "alpha", 0f, 1f, 1f);
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
                    ObjectAnimator moveIn2 = ObjectAnimator.ofFloat(viewhodler.jubap, "translationX", -300f, 0f);
                    ObjectAnimator rotate2 = ObjectAnimator.ofFloat(viewhodler.jubap, "rotation", 360f, 0f);
                    ObjectAnimator fadeInOut2 = ObjectAnimator.ofFloat(viewhodler.jubap, "alpha", 1f, 0f, 0f);
                    AnimatorSet animSet2 = new AnimatorSet();
                    animSet2.play(rotate2).with(fadeInOut2).with(moveIn2);
                    animSet2.setDuration(1000);
                    animSet2.start();

                }

            }
        });
    }
    @Override
    public int getItemCount() {
        return 6;
    }


    public class ViewHodle extends RecyclerView.ViewHolder{

        private final ImageView jubap; 
        private final ImageView lianjie;
        private final ImageView jiahao;
        private final ImageView pingbi;

        public ViewHodle(View itemView) {
            super(itemView);
            jubap = itemView.findViewById(R.id.recommend_attent_jubao);
            lianjie = itemView.findViewById(R.id.recommend_attent_lianjie);
            jiahao = itemView.findViewById(R.id.recommend_attent_jiahao);
            pingbi = itemView.findViewById(R.id.recommend_attent_pingbi);

        }
    }
}
