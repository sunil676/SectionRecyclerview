package com.sunil.sectionrecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sunil on 11/26/16.
 */

public class ListActivity extends AppCompatActivity{

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
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        //This is the code to provide a sectioned list
        List<SectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<SectionedRecyclerViewAdapter.Section>();

        //Sections
        sections.add(new SectionedRecyclerViewAdapter.Section(0,"Weekends"));
        sections.add(new SectionedRecyclerViewAdapter.Section(2,"Favorites"));
        sections.add(new SectionedRecyclerViewAdapter.Section(4,"Offers"));

        //Add your adapter to the sectionAdapter
        SectionedRecyclerViewAdapter.Section[] dummy = new SectionedRecyclerViewAdapter.Section[sections.size()];
        SectionedRecyclerViewAdapter mSectionedAdapter = new
                SectionedRecyclerViewAdapter(this,R.layout.item_section, R.id.sectionName, adapter);
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
