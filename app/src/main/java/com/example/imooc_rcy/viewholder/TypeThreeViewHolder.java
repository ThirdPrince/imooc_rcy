package com.example.imooc_rcy.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.imooc_rcy.DataModel;
import com.example.imooc_rcy.R;


public class TypeThreeViewHolder extends TypeAbstractViewHolder {

    private ImageView avatar ;
    private TextView name ;

    private TextView content ;

    public TypeThreeViewHolder(@NonNull View itemView) {
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
