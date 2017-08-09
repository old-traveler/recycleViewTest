package com.recycleviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hyc on 2017/8/9 16:24
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<User> list;

    public MyAdapter(List<User> list){
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main,parent,false));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.load(list.get(position),position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView iv_head;
        private TextView tv_nickname;
        private TextView tv_gender;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv_head = (ImageView) itemView.findViewById(R.id.iv_item_head);
            tv_nickname = (TextView) itemView.findViewById(R.id.tv_item_nickname);
            tv_gender = (TextView) itemView.findViewById(R.id.tv_item_gender);

        }

        public void load(User user, final int position){
            iv_head.setImageResource(user.getImageUrl());
            tv_nickname.setText(user.getNickname());
            tv_gender.setText(user.getGender());
            tv_nickname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    list.remove(position);
                    notifyDataSetChanged();
                }
            });
        }
    }

    public void add(User user){
        list.add(user);
        notifyItemInserted(list.size()-1);
    }

    public void delete(){
        list.remove(list.size()-1);
        notifyItemRemoved(list.size());
    }

}
