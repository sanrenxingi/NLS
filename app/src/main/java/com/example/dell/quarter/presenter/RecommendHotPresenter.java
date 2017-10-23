package com.example.dell.quarter.presenter;

import com.example.dell.quarter.modle.bean.RecommendHotBean;
import com.example.dell.quarter.modle.http.RecommendHotModle;
import com.example.dell.quarter.view.interfaces.RecommendHot_m;
import com.example.dell.quarter.view.interfaces.RecommendHot_p;

/**
 * 类描述：推荐下的热门界面的p层
 * 姓名 ：刘希鑫
 */

public class RecommendHotPresenter implements RecommendHot_m<RecommendHotBean> {
    RecommendHot_p re;
    private RecommendHotModle modle;

    public void getrecomm(RecommendHot_p recommendHot_p){
        this.re=recommendHot_p;
        modle = new RecommendHotModle();
    }
    //执行操作
    public void gethttp(String url,Class clazz){
       modle.getrecomm(this);
        modle.getHttp(url,clazz);
         }



    //返回成功
    @Override
    public void onSuccess(RecommendHotBean recommendHotBean) {
          re.onSuccess(recommendHotBean);
      }

    @Override
    public void Failure(int code, String str) {

    }
}
