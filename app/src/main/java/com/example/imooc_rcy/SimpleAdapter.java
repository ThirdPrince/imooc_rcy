package com.example.imooc_rcy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class SimpleAdapter  extends RecyclerView.Adapter<SimpleAdapter.MyViewHolder> {



    private List<String> datas ;

    private Context context ;

    private OnAdapterClickListener onAdapterClickListener ;

    public void setOnAdapterClickListener(OnAdapterClickListener onAdapterClickListener) {
        this.onAdapterClickListener = onAdapterClickListener;
    }

    public SimpleAdapter(Context context, List<String> mDatas)
    {
        this.context = context ;
        this.datas = mDatas ;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_simple_tv,parent,false);
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
     class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(onAdapterClickListener != null )
            {
                onAdapterClickListener.onClick(v,getLayoutPosition());
            }
        }
    }

    public void insertData(int pos)
    {
        datas.add(pos,"insert pos");
        notifyItemInserted(pos);
    }

    public void removeData(int pos)
    {
        datas.remove(pos);
        notifyItemRemoved(pos);
    }
}
