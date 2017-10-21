package com.example.dell.quarter.view.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.bean.RecommendHotBean;
import com.example.dell.quarter.presenter.RecommendHotPresenter;
import com.example.dell.quarter.view.adapter.Recommend_Hod_RecycAdapter;
import com.example.dell.quarter.view.interfaces.RecommendHot_p;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：推荐下的热门界面
 * 姓名 ：刘希鑫
 */

public class RecommendHotFragment extends FatherFragment implements RecommendHot_p<RecommendHotBean>{
  //死数据
    String url="http://www.babybuy100.com/API/getShopOverview.ashx";
    //热门查询接口
  //  String recommend = Api.RECOMMEND;

    private RecommendHotPresenter re;
    private RecyclerView recyclerView;
    private ImageView jiahao;
    private ImageView lianjie;
    private ImageView pingbi;
    private ImageView jubao;
//用来判断按钮的状态
    int a=0;


    //找到控件
    @Override
    protected void initView(View view) {

        recyclerView = view.findViewById(R.id.reco_hot_recyc);
recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //添加下划线
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity()
        ,DividerItemDecoration.HORIZONTAL));



//banner设置方法全部调用完毕时最后调用

    }
  //执行操作
    @Override
    void inDate() {
        re = new RecommendHotPresenter();
        re.getrecomm(this);
        re.gethttp(url,RecommendHotBean.class);

    }








    //找到布局
    @Override
    int inLayout() {
        return R.layout.fragment_recommend_hot;
    }

    //返回数据
    @Override
    public void onSuccess(RecommendHotBean recommendHotBean) {
        RecommendHotBean bean= recommendHotBean;
        List<RecommendHotBean.ResultBean.AdvsBean> advs = bean.getResult().getAdvs();

        List<String> arr=new ArrayList<>();
        List<String> list=new ArrayList<>();
        for (int a=0;a<advs.size();a++){
            arr.add(advs.get(a).getPic());
            list.add(advs.get(a).getDescriptions());
        }
        Recommend_Hod_RecycAdapter adapter=new Recommend_Hod_RecycAdapter(getActivity(),arr,list);
        recyclerView.setAdapter(adapter);




    }
//返回失败的数据
    @Override
    public void failure(int code, String str) {

    }
}
