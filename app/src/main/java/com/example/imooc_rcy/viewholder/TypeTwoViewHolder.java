package com.example.imooc_rcy.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imooc_rcy.DataModel;
import com.example.imooc_rcy.R;


public class TypeTwoViewHolder extends TypeAbstractViewHolder {

    private ImageView avatar ;
    private TextView name ;

    private TextView content ;

    public TypeTwoViewHolder(@NonNull View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);
        content = itemView.findViewById(R.id.content);

    }

    @Override
    public void bindHolder(DataModel dataModel)
    {
        avatar.setBackgroundResource(dataModel.avatarColor);
        name.setText(dataModel.name);
        content.setText(dataModel.content);
    }
}
