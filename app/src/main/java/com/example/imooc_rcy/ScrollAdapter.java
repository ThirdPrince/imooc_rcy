package com.example.imooc_rcy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class ScrollAdapter extends RecyclerView.Adapter<ScrollAdapter.MyViewHolder> {



    private List<String> datas ;

    private Context context ;

    private OnNestItemClickListener onNestItemClickListener;

    public ScrollAdapter(Context context, List<String> mDatas)
    {
        this.context = context ;
        this.datas = mDatas ;
        datas = new ArrayList<>();
        for(int i = 0;i<20;i++)
        {
            datas.add(i+"_");
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_nest_tv,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
     class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        private TextView textView ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if(onNestItemClickListener != null)
            {
                onNestItemClickListener.onItemClick(view,getLayoutPosition());
            }
        }

        @Override
        public boolean onLongClick(View view) {
            return false;
        }
    }

    public interface OnNestItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    // for both short and long click

    public void setOnNestItemClickListener(OnNestItemClickListener onNestItemClickListener) {
        this.onNestItemClickListener = onNestItemClickListener;
    }
}
