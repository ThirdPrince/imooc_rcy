package com.example.imooc_rcy;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 瀑布流
 */
public class StaggeredActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;

    private StaggeredAdapter simpleAdapter ;
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
        simpleAdapter = new StaggeredAdapter(this,mDatas);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(simpleAdapter);
        simpleAdapter.setOnAdapterClickListener(new OnAdapterClickListener() {
            @Override
            public void onClick(View view, int pos) {
                Toast.makeText(StaggeredActivity.this,"this is "+pos,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
