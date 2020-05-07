package com.example.sql_data_base1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MySQL_data_Base extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "Student.DB";
    private static final String TABLE_NAME = "Student_Details";
    private static final int DATA_BASE_VERSION_NUMB = 2;
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String AGE = "Age";
    private static final String GENDER = "Gender";
    private static final String CREATE_TABLE = " CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "
                                                                   +AGE+" INTEGER,"+GENDER+" VARCHAR(20));";

    private static final String DROP_TABLE  = " DROP TABLE IF EXISTS " + TABLE_NAME;
    private static  final String EXCESS_ALL_DATA = " SELECT * FROM " + TABLE_NAME;


    private Context context;
    public MySQL_data_Base(Context context) {

        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION_NUMB);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         try {
             db.execSQL(CREATE_TABLE);
             Toast.makeText(context,"OnCreate is called and Table is created",Toast.LENGTH_LONG).show();
         }
         catch (Exception e){
             Toast.makeText(context,"Exception: "+e,Toast.LENGTH_LONG).show();
         }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
            Toast.makeText(context,"OnUpgrade is called and Table is upgraded",Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(context,"Exception: "+e,Toast.LENGTH_LONG).show();
        }


    }
    public long insert_data(String name,String age, String gender){

        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);
        long rowid = database.insert(TABLE_NAME,null,contentValues);

        return rowid;
    }

    public Cursor Display_Data(){
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor =  database.rawQuery(EXCESS_ALL_DATA,null);
        return cursor;
    }

    public boolean update_data(String Id, String name, String age, String gender){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, Id);
        contentValues.put(NAME,name);
        contentValues.put(AGE,age);
        contentValues.put(GENDER,gender);

        database.update(TABLE_NAME,contentValues,ID + " = ? ", new String[]{Id});
        return true;
    }

    public int Delete_Data(String id){
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete(TABLE_NAME, ID + " = ? ",new String[]{id});


    }


}
