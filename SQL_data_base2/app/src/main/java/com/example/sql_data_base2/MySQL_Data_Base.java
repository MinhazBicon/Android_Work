package com.example.sql_data_base2;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MySQL_Data_Base extends SQLiteOpenHelper {
    private static final String DATA_BASE_NAME = "user_details.db";
    private static final String TABLE_NAME = "user_details";
    private static final String ID = "Id";
    private static final String NAME = "Name";
    private static final String USER_NAME = "user_name";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final int VERSION = 2;
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + NAME + " VARCHAR(255) NOT NULL,"
                                                    + EMAIL + " TEXT NOT NULL," + USER_NAME + " TEXT NOT NULL," + PASSWORD + " TEXT NOT NULL)";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    private Context context;

    public MySQL_Data_Base(@Nullable Context context) {
        super(context, DATA_BASE_NAME, null, VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context, "Data_Base is created", Toast.LENGTH_LONG).show();

        } catch (Exception e) {

            Toast.makeText(context, "Exception: " + e, Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
            Toast.makeText(context, "Data Base upgraded", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(context, "Exception: " + e, Toast.LENGTH_LONG).show();
        }
    }

    public long Insert_Data(UserDetails userDetails) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME,userDetails.getName());
        contentValues.put(EMAIL,userDetails.getEmail());
        contentValues.put(USER_NAME,userDetails.getUserName());
        contentValues.put(PASSWORD,userDetails.getPassword());

        long rowId = database.insert(TABLE_NAME,null,contentValues);
        return rowId;
    }

    public Boolean Match_Identity(String user_name, String password) {

        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery(" SELECT * FROM " + TABLE_NAME, null);
        boolean result = false;

        if (cursor.getCount() == 0) {
            Toast.makeText(context, "Please SignUp First....", Toast.LENGTH_LONG).show();
        }
        else {
            while (cursor.moveToNext()) {

                String User_name = cursor.getString(3);
                String Password = cursor.getString(4);
                if (User_name.equals(user_name) && Password.equals(password)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}