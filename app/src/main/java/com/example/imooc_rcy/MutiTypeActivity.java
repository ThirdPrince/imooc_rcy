package com.example.imooc_rcy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 多type Rcy
 */
public class MutiTypeActivity extends AppCompatActivity {

    private RecyclerView rcy_view;

    private MutiAdapter mutiAdapter ;

    int colors[] = {android.R.color.holo_red_dark,android.R.color.holo_blue_dark,android.R.color.holo_orange_dark};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muti_type);
        initView();
        initData();
    }
    private void initView()
    {
        rcy_view = findViewById(R.id.rcy_view);


    }

    private void initData()
    {
        List<DataModel> list = new ArrayList<>();
        for(int i = 0;i<20;i++)
        {
            int type = (int)(Math.random()*3) +1;
            //new Random().nextInt(3);
            DataModel dataModel = new DataModel();
            dataModel.avatarColor = colors[type -1];
            dataModel.type = type ;
            dataModel.name = "name:"+i;
            dataModel.content = "content:"+i;
            dataModel.contentColor = colors[(type+1)%3];
            list.add(dataModel);

        }
        mutiAdapter = new MutiAdapter(this,list);
        rcy_view.setLayoutManager(new LinearLayoutManager(this));
        rcy_view.setAdapter(mutiAdapter);
    }
}
