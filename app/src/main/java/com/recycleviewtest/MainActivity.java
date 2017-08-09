package com.recycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv_main;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv_main = (RecyclerView) findViewById(R.id.rv_main);
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            User user = new User();
            user.setGender("猪");
            user.setNickname("黄雅倩"+i);
            user.setImageUrl(R.mipmap.ic_launcher);
            list.add(user);
        }
        adapter= new MyAdapter(list);
        rv_main.setLayoutManager(new LinearLayoutManager(this));
        rv_main.setItemAnimator(new DefaultItemAnimator());
        rv_main.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add:
                User user = new User();
                user.setImageUrl(R.mipmap.ic_launcher_round);
                user.setNickname("猪头");
                user.setGender("女");
                adapter.add(user);
                rv_main.scrollToPosition(adapter.getItemCount()-1);
                break;
            case R.id.delete:
                adapter.delete();
//                rv_main.scrollToPosition(adapter.getItemCount()-1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
