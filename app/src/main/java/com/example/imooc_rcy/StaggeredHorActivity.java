package com.example.imooc_rcy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * 横向GridView
 */
public class StaggeredHorActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;

    private SimpleHorListAdapter simpleAdapter ;
    private List<String> mDatas ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staggered);
        initData();
    }

    private void initData()
    {
        mDatas = new ArrayList<>();
        for(int i = 'A';i<='z';i++)
        {
            mDatas.add((char)i+"");
        }

        recyclerView = findViewById(R.id.rcy_view);
        simpleAdapter = new SimpleHorListAdapter(this,mDatas);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(simpleAdapter);
    }
}
