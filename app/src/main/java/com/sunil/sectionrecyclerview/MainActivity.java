package com.sunil.sectionrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_section)
    Button listSection;
    @BindView(R.id.grid_section)
    Button gridSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.list_section)
    public void listClick(){
        startActivity(new Intent(this, ListActivity.class));
    }

    @OnClick(R.id.grid_section)
    public void gridClick(){
        startActivity(new Intent(this, GridViewActivity.class));
    }
}
