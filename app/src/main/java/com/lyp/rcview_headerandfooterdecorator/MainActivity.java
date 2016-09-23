package com.lyp.rcview_headerandfooterdecorator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.lyp.rcview_headerandfooterdecorator.adapter.HeaderAndFooterDecorator;
import com.lyp.rcview_headerandfooterdecorator.adapter.MessageAdapter;
import com.lyp.rcview_headerandfooterdecorator.bean.Message;
import com.lyp.rcview_headerandfooterdecorator.utils.ModelUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcView;

    private MessageAdapter mAdapter;
    private HeaderAndFooterDecorator decorator;

    private List<Message> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcView = (RecyclerView) findViewById(R.id.rcView);
        rcView.setLayoutManager(new LinearLayoutManager(this));

        mData = ModelUtil.getMessageData();
        mAdapter = new MessageAdapter(this, mData);
        mAdapter.setOnItemClickListener(new MessageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "Click "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                Toast.makeText(MainActivity.this, "LongClick "+position, Toast.LENGTH_SHORT).show();
            }
        });


        decorator = new HeaderAndFooterDecorator(mAdapter);

        TextView t1 = new TextView(this);
        t1.setText("Header 1");
        TextView t2 = new TextView(this);
        t2.setText("Header 2");
        TextView t3 = new TextView(this);
        t3.setText("Footer 1");
        decorator.addHeaderView(t1);
        decorator.addHeaderView(t2);
        decorator.addFooterView(t3);

        rcView.setAdapter(decorator);
    }
}
