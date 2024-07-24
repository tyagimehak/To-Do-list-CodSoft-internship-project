package com.example.doit;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(this::addItem);

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
        setUpListViewListener();


    }

    private void setUpListViewListener() {
        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            Context context = getApplicationContext();
            Toast.makeText(context,"Item Removed",Toast.LENGTH_LONG).show();

            items.remove(i);
            itemsAdapter.notifyDataSetChanged();
            return true;
        });
    }

    private void addItem(View view) {
        EditText input = findViewById(R.id.editTextText2);
        String itemText = input.getText().toString();

        if(!(itemText.isEmpty())){
            itemsAdapter.add(itemText);
            input.setText("");
        }
        else{
            Toast.makeText(getApplicationContext(), "Please enter text...",Toast.LENGTH_LONG).show();
        }
    }
}
