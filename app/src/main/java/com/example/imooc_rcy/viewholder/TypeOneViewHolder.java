package com.example.imooc_rcy.viewholder;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imooc_rcy.DataModel;
import com.example.imooc_rcy.R;


public class TypeOneViewHolder extends TypeAbstractViewHolder {

    private ImageView avatar ;
    private TextView name ;

    public TypeOneViewHolder(@NonNull View itemView) {
        super(itemView);
        avatar = itemView.findViewById(R.id.avatar);
        name = itemView.findViewById(R.id.name);

    }

    @Override
    public void bindHolder(DataModel dataModel)
    {
        avatar.setBackgroundResource(dataModel.avatarColor);
        name.setText(dataModel.name);
    }
}
