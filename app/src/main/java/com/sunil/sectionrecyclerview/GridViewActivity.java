package com.sunil.sectionrecyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 11/26/16.
 */

public class GridViewActivity extends Activity{


    String imageUrl[] = Constant.image;
    String names[] = Constant.name;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acivity_listview);
        ButterKnife.bind(this);

        List<ItemModel> list = getList();
        RecyclerAdapter adapter = new RecyclerAdapter(this, list);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        //This is the code to provide a sectioned list
        List<SectionedGridRecyclerViewAdapter.Section> sections =
                new ArrayList<SectionedGridRecyclerViewAdapter.Section>();

        //Sections
        sections.add(new SectionedGridRecyclerViewAdapter.Section(0,"Weekends"));
        sections.add(new SectionedGridRecyclerViewAdapter.Section(3,"Favorites"));

        //Add your adapter to the sectionAdapter
        SectionedGridRecyclerViewAdapter.Section[] dummy = new SectionedGridRecyclerViewAdapter.Section[sections.size()];
        SectionedGridRecyclerViewAdapter mSectionedAdapter = new
                SectionedGridRecyclerViewAdapter(this ,R.layout.item_section, R.id.sectionName, recyclerView, adapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        //Apply this adapter to the RecyclerView
        recyclerView.setAdapter(mSectionedAdapter);

    }

    private List<ItemModel> getList() {
        List<ItemModel> list = new ArrayList<>();
        for (int i = 0; i < imageUrl.length; i++) {
            ItemModel model = new ItemModel();
            model.setName(names[i]);
            model.setImagePath(imageUrl[i]);
            list.add(model);
        }
        return list;
    }
}
