package com.example.jasmn.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
ListView listView;
    databaseHelper databaseHelper;

    ArrayList<String> titles=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.listnote);
        listView=findViewById(R.id.listview);

        databaseHelper =new databaseHelper(this);

         titles = databaseHelper.selectall();
        ArrayAdapter arrayAdapter=new ArrayAdapter(Main2Activity.this,android.R.layout.simple_list_item_1,titles);
              listView.setAdapter(arrayAdapter);
//        Backendless.Data.of(note.class).find(new AsyncCallback<List<note>>() {
//            @Override
//            public void handleResponse(List<note> response) {
//
//                titles = new ArrayList<>();
//                for (note note:response){
//                    titles.add(note.getName());
//                }
//                ArrayAdapter arrayAdapter=new ArrayAdapter(Main2Activity.this,android.R.layout.simple_list_item_1,titles);
//                listView.setAdapter(arrayAdapter);
//            }
//
//            @Override
//            public void handleFault(BackendlessFault fault) {
//
//            }
//        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                DataQueryBuilder queryBuilder=DataQueryBuilder.create();
//                queryBuilder.setWhereClause("name ='"+titles.get(i)+"'");
//                Backendless.Data.of(note.class).find(queryBuilder, new AsyncCallback<List<note>>() {
//                    @Override
//                    public void handleResponse(List<note> response) {
//                        Intent  intent = new Intent(Main2Activity.this,MainActivity.class);
//                        intent.putExtra("title",response.get(0).getName());
//                        intent.putExtra("detail",response.get(0).getDetail());
//                        startActivity(intent);
//                    }
//
//                    @Override
//                    public void handleFault(BackendlessFault fault) {
//
//                    }
//                });
           }
       });
    }

}
