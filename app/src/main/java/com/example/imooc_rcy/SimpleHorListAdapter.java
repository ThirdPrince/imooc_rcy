package com.example.imooc_rcy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class SimpleHorListAdapter extends RecyclerView.Adapter<SimpleHorListAdapter.MyViewHolder> {



    private List<String> datas ;

    private Context context ;

    public SimpleHorListAdapter(Context context, List<String> mDatas)
    {
        this.context = context ;
        this.datas = mDatas ;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_simple_tv_hor,parent,false);
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
    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView textView ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }
}
