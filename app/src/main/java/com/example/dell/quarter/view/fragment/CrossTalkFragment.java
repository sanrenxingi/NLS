package com.example.dell.quarter.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.bean.CrossTalkBean;
import com.example.dell.quarter.presenter.CrossTalkPresenter;
import com.example.dell.quarter.view.adapter.CrossTalkAdapter;
import com.example.dell.quarter.view.interfaces.RegisterInterfaceP_V;

import java.util.List;



/**
 * Created by dell on 2017/10/17.
 * 段子
 */

public class CrossTalkFragment extends FatherFragment implements RegisterInterfaceP_V<CrossTalkBean>{

    private CrossTalkPresenter crossTalkPresenter;
    private RecyclerView recyclerView;

    @Override
    protected void initView(View view) {
        crossTalkPresenter = new CrossTalkPresenter();
        recyclerView = (RecyclerView) view.findViewById(R.id.recylerview);

    }

    @Override
    void inDate() {
        crossTalkPresenter.attachView(this);
        setRecylerViewLayoutMannger();

    }

    private void setRecylerViewLayoutMannger() {
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(manager);
    }
    @Override
    int inLayout() {
        return R.layout.fragment_crosstalk;
    }

    @Override
    public void onSuccess(CrossTalkBean crossTalkBean) {
        List<CrossTalkBean.CharacterBean> list = crossTalkBean.getCharacter();
        setRecylerViewAdapter(list);
    }


private void setRecylerViewAdapter(List<CrossTalkBean.CharacterBean> list) {
    CrossTalkAdapter adapter = new CrossTalkAdapter(getActivity(),list);
    recyclerView.setAdapter(adapter);
    }
    @Override
    public void onError(CrossTalkBean crossTalkBean) {

    }
}
