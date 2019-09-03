package com.example.jasmn.notes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText title1, detail;
    note notedata = new note();
    String nme;
    String det;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Backendless.initApp(this, "593EAAB4-E026-70F8-FF53-311A766D3700", "7A8D63B6-D6E0-1F94-FF75-062B7A72A600");
        title1 = findViewById(R.id.editText3title);
        detail = findViewById(R.id.editText2detail);
        Intent intent = getIntent();

        nme = intent.getStringExtra("title");

        det = intent.getStringExtra("detail");
        title1.setText(nme);
       detail.setText(det);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.titles, menu);
        return true;
    }

    public void save(View view) {
        if (title1.getText().toString().equals(nme)){
            Map<String, Object> changes = new HashMap<>();
            changes.put( "detail", detail.getText().toString() );
            Backendless.Data.of(note.class).update("name='" + nme + "'", changes, new AsyncCallback<Integer>() {
                @Override
                public void handleResponse(Integer response) {
                    Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void handleFault(BackendlessFault fault) {

                }
            });
        }
        else {
            notedata.setName(title1.getText().toString());
            notedata.setDetail(detail.getText().toString());
            Backendless.Persistence.save(notedata, new AsyncCallback<note>() {
                @Override
                public void handleResponse(note response) {
                    Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
                    title1.setText("");
                    detail.setText("");
                }

                @Override
                public void handleFault(BackendlessFault fault) {

                }
            });

        }
    }

    public void all(MenuItem item) {

        Intent in = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(in);

    }
}