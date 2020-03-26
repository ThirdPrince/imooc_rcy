package com.example.imooc_rcy.viewholder;


import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imooc_rcy.DataModel;

public abstract  class TypeAbstractViewHolder extends RecyclerView.ViewHolder {

    public TypeAbstractViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public abstract void bindHolder(DataModel dataModel);
}
