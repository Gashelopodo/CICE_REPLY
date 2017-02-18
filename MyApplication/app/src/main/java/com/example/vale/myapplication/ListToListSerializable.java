package com.example.vale.myapplication;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;

import java.util.Arrays;

public class ListToListSerializable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_to_list_serializable);

        if (savedInstanceState == null) {
            ListView lv = (ListView)findViewById(R.id.lista);
            lv.setAdapter(new MyListAdapter(this));
        }else{
            boolean[] arrayB = savedInstanceState.getBooleanArray("clicks");
            MyListAdapter mla = new MyListAdapter(this, arrayB);

            ListView lv = (ListView)findViewById(R.id.lista);
            lv.setAdapter(mla);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE, 1, 1, "Filtrar");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case 1:
                MyListAdapter mla1 = new MyListAdapter(this, MyListAdapter.getClicks(), true);
                ListView lv = (ListView)findViewById(R.id.lista);
                lv.setAdapter(mla1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBooleanArray("clicks", MyListAdapter.getClicks());
        super.onSaveInstanceState(outState);
    }
}
