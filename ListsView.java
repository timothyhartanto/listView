package com.example.proto.listview;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListsView extends ListActivity {

    String className[] = {"main", "menu", "etc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, className));
        //setContentView(R.layout.activity_list_view);
    }

    @Override
    protected void onListItemClick(ListView lv, View v, int position, long id){
        super.onListItemClick(lv, v, position, id);
        String openClass = className[position];
        try{
            Class selected = Class.forName("com.example.proto.listview." + openClass);
            Intent selectedIntent = new Intent(this, selected);
            startActivity(selectedIntent);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        finish();
    }
}
