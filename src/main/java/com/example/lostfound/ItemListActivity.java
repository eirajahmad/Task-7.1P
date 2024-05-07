package com.example.lostfound;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ItemListAdapter adapter;
    private List<Item> itemList;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        db = new DatabaseHelper(this);
        itemList = db.getAllItems();
        adapter = new ItemListAdapter(this, itemList);
        recyclerView.setAdapter(adapter);
    }

}