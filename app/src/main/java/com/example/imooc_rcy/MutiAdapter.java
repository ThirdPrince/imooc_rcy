package com.example.imooc_rcy;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imooc_rcy.viewholder.TypeAbstractViewHolder;
import com.example.imooc_rcy.viewholder.TypeOneViewHolder;
import com.example.imooc_rcy.viewholder.TypeThreeViewHolder;
import com.example.imooc_rcy.viewholder.TypeTwoViewHolder;

import java.util.List;

/**
 * 多 type adpter
 */
class MutiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static final String TAG = "MutiAdapter";

    private List<DataModel> datas ;

    private Context context ;

    private OnAdapterClickListener onAdapterClickListener ;

    private LayoutInflater layoutInflater ;

    public void setOnAdapterClickListener(OnAdapterClickListener onAdapterClickListener) {
        this.onAdapterClickListener = onAdapterClickListener;
    }

    public MutiAdapter(Context context, List<DataModel> mDatas)
    {
        this.context = context ;
        this.datas = mDatas ;
        layoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType)
        {
            case DataModel.TYPE_ONE:
                return  new TypeOneViewHolder(layoutInflater.inflate(R.layout.item_one,parent,false));

            case DataModel.TYPE_TWO:
                return  new TypeTwoViewHolder(layoutInflater.inflate(R.layout.item_two,parent,false));
            case DataModel.TYPE_THREE:
                return  new TypeThreeViewHolder(layoutInflater.inflate(R.layout.item_three,parent,false));
        }

        return  null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       // holder.textView.setText(datas.get(position).name);
        TypeAbstractViewHolder typeAbstractViewHolder = (TypeAbstractViewHolder)holder;
        typeAbstractViewHolder.bindHolder(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        int type = datas.get(position).type;
        Log.e(TAG,"type="+type);
        return type ;
                //super.getItemViewType(position);
    }




}
