package com.example.imooc_rcy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Imocc Rcy
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView ;

    private List<String>  mDatas ;

    private SimpleAdapter simpleAdapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initView();
        simpleAdapter = new SimpleAdapter(this,mDatas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
       // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(simpleAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        simpleAdapter.setOnAdapterClickListener(new OnAdapterClickListener() {
            @Override
            public void onClick(View view, int pos) {
                Toast.makeText(MainActivity.this,"this is "+pos,Toast.LENGTH_SHORT).show();
            }
        });

        //startActivity(new Intent(this,RcyActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id)
        {
            case R.id.add:
                simpleAdapter.insertData(1);
                break;
            case R.id.remove:
                simpleAdapter.removeData(1);
                break;
            case R.id.action_list_view:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                //recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
               // recyclerView.setAdapter(simpleAdapter);
                break;
            case R.id.action_grid_view:
                recyclerView.setLayoutManager(new GridLayoutManager(this,3));
               // recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
               // recyclerView.setAdapter(simpleAdapter);

                break;

            case R.id.action_hor_grid_view:

                startActivity(new Intent(MainActivity.this, StaggeredHorActivity.class));
               // recyclerView.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                //GridLayoutManager gridLayoutManager = new GridLayoutManager(this,5);
                //recyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
               // gridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL)
                //recyclerView.setLayoutManager(gridLayoutManager);
               // recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
               // recyclerView.setAdapter(simpleAdapter);

                break;
            case R.id.action_stagger_view:
                startActivity(new Intent(MainActivity.this, StaggeredActivity.class));
               // recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
               // recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
                break;

            case R.id.nest_rcy_view:
                startActivity(new Intent(MainActivity.this,RcyActivity.class));
                break;
        }
       // recyclerView.setAdapter(simpleAdapter);
        return super.onOptionsItemSelected(item);
    }

    private void initDatas()
    {
        mDatas = new ArrayList<>();
        for(int i = 'A';i<='z';i++)
        {
            mDatas.add((char)i+"");
        }

    }

    private void initView()
    {
        recyclerView = findViewById(R.id.rcy_view);
    }
}
