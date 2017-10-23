package com.example.dell.quarter.view.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.quarter.R;
import com.example.dell.quarter.modle.bean.CrossTalkBean;

import java.util.List;

/**
 * 类用途：
 * 作者：史曌宇
 */

public class CrossTalkAdapter extends RecyclerView.Adapter<CrossTalkAdapter.MyViewHolder>{


    private  List<CrossTalkBean.CharacterBean> list;
    private  FragmentActivity activity;

    public CrossTalkAdapter(FragmentActivity activity, List<CrossTalkBean.CharacterBean> list) {
        this.activity=activity;
        this.list=list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(activity, R.layout.crosstalk_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.item_name.setText(list.get(position).getUser().getUserName());
        holder.item_date.setText(list.get(position).getCharacter_uptime());
        holder.item_cross_talk.setText(list.get(position).getCharacter_content());
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{


        private final TextView item_name;
        private final TextView item_date;
        private final TextView item_cross_talk;
        public MyViewHolder(View itemView) {
            super(itemView);
             item_name = itemView.findViewById(R.id.recylerview_item_name);
             item_date = itemView.findViewById(R.id.recylerview_item_date);
             item_cross_talk = itemView.findViewById(R.id.recylerview_item_cross_talk);
        }
    }

}
