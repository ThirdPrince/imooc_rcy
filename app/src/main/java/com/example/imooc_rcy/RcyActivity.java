package com.example.imooc_rcy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * Vertical rcy 嵌套 hor rcy
 */
public class RcyActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;

    private List<String> mDatas ;

    private RcyAdapter rcyAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcy);
        initView();
        initDatas();

    }

    private void initDatas()
    {
        mDatas = new ArrayList<>();
        for(int i = 'A';i<='z';i++)
        {
            mDatas.add(i+"");
        }
        rcyAdapter = new RcyAdapter(this,mDatas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(rcyAdapter);
        rcyAdapter.setOnOutItemClickListener(new RcyAdapter.OnOutItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RcyActivity.this,"out pso ="+position,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }

    private void initView()
    {
        recyclerView = findViewById(R.id.rcy_view);
    }
}
