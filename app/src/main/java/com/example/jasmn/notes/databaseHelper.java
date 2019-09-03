package com.example.jasmn.notes;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class databaseHelper  {
     SQLiteDatabase db;
     Engine engine;

    public databaseHelper(Context context) {
      engine=new Engine(context);
        db=engine.getWritableDatabase();


    }
    public String selectdetail(String note){
        String query="select detail from note where note=?";
        String[] where={note};

        Cursor cursor = db.rawQuery(query, where);
        if (cursor.getCount() > 0) {
            cursor.moveToNext();

            String detail=cursor.getString(0);

            return detail;
        }

        return "";
    }


    public ArrayList<String> selectall(){
        String query="select note from note";

        Cursor cursor = db.rawQuery(query, null);
        ArrayList<String> notes=new ArrayList<>();
        notes.add("please select");
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                notes.add(cursor.getString(0));
            }

            return notes;

        }

        return null;

    }


}
