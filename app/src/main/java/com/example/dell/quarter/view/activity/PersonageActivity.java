package com.example.dell.quarter.view.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.quarter.R;

import static com.umeng.socialize.utils.DeviceConfig.context;

public class PersonageActivity extends BaseActivity {

    private ImageView recommend_recyc_pingbi;
    private ImageView recommend_recyc_jubao;
    private ImageView recommend_recyc_lianjie;
    private CheckBox recommend_recyc_jiahao;
    private Button btn_yiguanzhu;
    private Button btn_guanzhu;
    private TextView tv_guanzhu;

    @Override
    int setViewId() {
        return R.layout.activity_personage;
    }

    @Override
    void initData() {

    }

    @Override
    void initView() {
        tv_guanzhu = findViewById(R.id.tv_guanzhu);
        //已关注
        btn_yiguanzhu = findViewById(R.id.btn_yiguanzhu);
        //关注
        btn_guanzhu = findViewById(R.id.btn_guanzhu);
        //关注点击事件
        btn_guanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_guanzhu.setVisibility(View.GONE);
                btn_yiguanzhu.setVisibility(View.VISIBLE);
                tv_guanzhu.setText("100000关注");
            }
        });
        //已关注点击事件
        btn_yiguanzhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn_guanzhu.setVisibility(View.VISIBLE);
                btn_yiguanzhu.setVisibility(View.GONE);
                tv_guanzhu.setText("99999关注");
            }
        });
        //屏蔽
        recommend_recyc_pingbi = findViewById(R.id.recommend_recyc_pingbi);
        //举报
        recommend_recyc_jubao = findViewById(R.id.recommend_recyc_jubao);
        //链接
        recommend_recyc_lianjie = findViewById(R.id.recommend_recyc_lianjie);

        recommend_recyc_jiahao = findViewById(R.id.recommend_recyc_jiahao);
        //加号的点击事件，弹出三个图片，举报，屏蔽，链接
        getdianji();
    }

    private void getdianji() {
        recommend_recyc_jiahao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b){

                    //动画加号切换为减号并旋转
                    Animator animator = AnimatorInflater.loadAnimator(PersonageActivity.this, R.animator.come_one);
                    animator.setTarget(recommend_recyc_jiahao);
                    animator.start();

                    //动画举报
                    Animator animator1 = AnimatorInflater.loadAnimator(PersonageActivity.this, R.animator.come_two);
                    animator1.setTarget(recommend_recyc_jubao);
                    animator1.start();
                    //动画链接
                    Animator animator2 = AnimatorInflater.loadAnimator(PersonageActivity.this, R.animator.come_thread);
                    animator2.setTarget(recommend_recyc_lianjie);
                    animator2.start();
                    //动画屏蔽
                    Animator animator3 = AnimatorInflater.loadAnimator(PersonageActivity.this, R.animator.come_for);
                    animator3.setTarget(recommend_recyc_pingbi);
                    animator3.start();
                    //关闭动画
                    animator.clone();
                    animator1.clone();
                    animator2.clone();
                    animator3.clone();
//
                }else if (b==false){

                    //动画加号切换为减号并旋转
                    Animator animator = AnimatorInflater.loadAnimator(PersonageActivity.this, R.animator.take_one);
                    animator.setTarget(recommend_recyc_jiahao);
                    animator.start();


                    //动画链接
                    Animator animator2 = AnimatorInflater.loadAnimator(PersonageActivity.this, R.animator.take_thread);
                    animator2.setTarget(recommend_recyc_lianjie);
                    animator2.start();
                    //动画屏蔽
                    Animator animator3 = AnimatorInflater.loadAnimator(PersonageActivity.this, R.animator.take_for);
                    animator3.setTarget(recommend_recyc_pingbi);
                    animator3.start();
                    //动画举报
                    Animator animator1 = AnimatorInflater.loadAnimator(PersonageActivity.this, R.animator.take_two);
                    animator1.setTarget(recommend_recyc_jubao);
                    animator1.start();
                    animator.clone();
                    animator1.clone();
                    animator2.clone();
                    animator3.clone();
                }

            }
        });
    }

    @Override
    void initLogic() {

    }
}
