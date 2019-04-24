package com.example.filterssss;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String[] strings;
    CustomArrayAdapter customArrayAdapter;
    ArrayList<String> arrayList;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strings = new String[]{"Rohit", "Bhanu", "Amol"};

        arrayList = new ArrayList<>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");

        list = Arrays.asList(strings);

        //final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,R.layout.custom_layout,R.id.textView,arrayList);
        customArrayAdapter = new CustomArrayAdapter(this, R.layout.custom_layout, R.id.textView, strings);

        ((ListView) findViewById(R.id.listView)).setAdapter(customArrayAdapter);

        ((EditText) findViewById(R.id.editText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //customArrayAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                customArrayAdapter.getFilter().filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //customArrayAdapter.getFilter().filter(s.toString());
            }
        });


    }

    class CustomArrayAdapter extends ArrayAdapter<String>
    {
        String string="";

        private CustomArrayAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
            super(context, resource, textViewResourceId, objects);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {

            if (convertView == null)
                convertView = getLayoutInflater().inflate(R.layout.custom_layout,parent,false);

            string = customArrayAdapter.getItem(position);
            ((TextView) convertView.findViewById(R.id.tV)).setText(arrayList.get(list.indexOf(string)));


            //return convertView;
            return super.getView(position, convertView, parent);
        }
    }
}
