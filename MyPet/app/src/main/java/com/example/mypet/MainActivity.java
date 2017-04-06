package com.example.mypet;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private ListView listView;

    private List<String> petCategories = PetFactory.getPetCategories();

    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list_view);
        gridView = (GridView) findViewById(R.id.grid_view);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this ,ListActivity.class);
                String category = (String) adapter.getItem(position);
                intent.putExtra(ListActivity.EXTRA_KEY, category);
                startActivity(intent);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this ,ListActivity.class);
                String category = (String) adapter.getItem(position);
                intent.putExtra(ListActivity.EXTRA_KEY, category);
                startActivity(intent);
            }
        });

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, petCategories);
        showListView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_btn_list_view:
                showListView();
                return true;
            case R.id.menu_btn_grid_view:
                showGridView();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showListView() {
        gridView.setAdapter(null);
        gridView.setVisibility(View.GONE);

        listView.setAdapter(adapter);
        listView.setVisibility(View.VISIBLE);
    }

    private void showGridView() {
        listView.setAdapter(null);
        listView.setVisibility(View.GONE);

        gridView.setAdapter(adapter);
        gridView.setVisibility(View.VISIBLE);
    }
}
