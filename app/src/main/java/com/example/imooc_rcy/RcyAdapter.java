package com.example.imooc_rcy;

import android.content.Context;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class RcyAdapter extends RecyclerView.Adapter<RcyAdapter.MyViewHolder> {


    private static final String TAG = "RcyAdapter";
    private List<String> datas ;

    private static  Context context ;

    private OnOutItemClickListener onOutItemClickListener ;

    /**
     * 保存嵌套 Rcy 的 position
     */
    private SparseIntArray listPosition = new SparseIntArray();

    public RcyAdapter(Context context, List<String> mDatas)
    {
        this.context = context ;
        this.datas = mDatas ;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        MyViewHolder myViewHolder = null ;
        View view = null;
        if(viewType == 0) {
             view = LayoutInflater.from(context).inflate(R.layout.item_simple_tv, parent, false);

        }else
        {
            view = LayoutInflater.from(context).inflate(R.layout.item_rcy_tv, parent, false);
        }

        myViewHolder = new MyViewHolder(view);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(getItemViewType(position)==0) {
            holder.textView.setText(datas.get(position));
        }else
        {
            int lastSeenFirstPosition = listPosition.get(position, 0);
            if (lastSeenFirstPosition >= 0 &&   holder.linearLayoutManager != null ) {
                holder.linearLayoutManager.scrollToPositionWithOffset(lastSeenFirstPosition, 0);

            }
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public void onViewRecycled(@NonNull MyViewHolder holder) {

        final int position = holder.getAdapterPosition();

        if(getItemViewType(position)==1)
        {
            int firstVisiblePosition = holder.linearLayoutManager.findFirstVisibleItemPosition();
            int lastVisiblePosition = holder.linearLayoutManager.findLastVisibleItemPosition();
            Log.e(TAG," firstVisiblePosition::"+firstVisiblePosition+":lastVisiblePosition"+lastVisiblePosition);
            listPosition.put(position, firstVisiblePosition);
        }


        super.onViewRecycled(holder);
    }

     class  MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textView ;

        private RecyclerView nestRcy ;
        private ScrollAdapter scrollAdapter ;
        private LinearLayoutManager linearLayoutManager ;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
            nestRcy = itemView.findViewById(R.id.nest_rcy);
            Log.e(TAG,"nestRcy::"+nestRcy);
            if(nestRcy != null) {
                linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                scrollAdapter = new ScrollAdapter(context, null);
                nestRcy.setLayoutManager(linearLayoutManager);
                nestRcy.setAdapter(scrollAdapter);
                //optional
                StartSnapHelper snapHelper = new StartSnapHelper();
                snapHelper.attachToRecyclerView(nestRcy);
                scrollAdapter.setOnNestItemClickListener(new ScrollAdapter.OnNestItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(context,"nest pso ="+position,Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onItemLongClick(View view, int position) {

                    }
                });

            }
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            if(onOutItemClickListener != null)
            {
                onOutItemClickListener.onItemClick(view,getLayoutPosition());
            }
        }
    }

    public interface OnOutItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }



    // for both short and long click


    public void setOnOutItemClickListener(OnOutItemClickListener onOutItemClickListener) {
        this.onOutItemClickListener = onOutItemClickListener;
    }
}
