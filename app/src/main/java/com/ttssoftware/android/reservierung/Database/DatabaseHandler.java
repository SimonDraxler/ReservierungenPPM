package com.ttssoftware.android.reservierung.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.ttssoftware.android.reservierung.User;

/**
 * Created by Simon on 20.01.2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "productDB.db";
    private static final String TABLE_USERS = "user";
    private static final String TABLE_RESERVIERUNGEN = "reservierungen";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_SPORT = "sport";
    public static final String COLUMN_COURT = "court";
    public static final String COLUMN_ZEIT = "zeit";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database","Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_USERS+" ("+COLUMN_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_USERNAME+ " TEXT,"+COLUMN_PASSWORD+" TEXT,"+COLUMN_NAME+" TEXT)");

        db.execSQL("CREATE TABLE " + TABLE_RESERVIERUNGEN + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SPORT + " TEXT, " + COLUMN_COURT + " Integer, " + COLUMN_ZEIT + " Text)");

        Log.d("Database", "Tabels created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESERVIERUNGEN);
        onCreate(db);
    }

    public int neuerUser(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME,user.getUsername());
        values.put(COLUMN_PASSWORD,user.getPassword());
        values.put(COLUMN_NAME, user.getName());

        long user_id = db.insert(TABLE_USERS,null,values);
        db.close();
        user.setId((int) user_id);
        return (int)user_id;
    }
    public int neueReservierung(User user){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME,user.getUsername());
        values.put(COLUMN_PASSWORD,user.getPassword());
        values.put(COLUMN_NAME,user.getName());

        long user_id = db.insert(TABLE_USERS,null,values);
        db.close();
        user.setId((int) user_id);
        return (int)user_id;
    }
    public boolean neueReservierung(String sport, int court, String zeit){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("insert into "
                + TABLE_RESERVIERUNGEN
                + "("+COLUMN_ID+","+COLUMN_SPORT+","+COLUMN_COURT+","+COLUMN_ZEIT+") "
                + "values( ? ," + sport + ", " + court + ", " + zeit);

        return true;
    }
    public User isUser(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String selectQuery = "SELECT *"+" FROM "+TABLE_USERS+" WHERE "+COLUMN_USERNAME+"="+username+" AND "+COLUMN_PASSWORD+"="+password;
        Cursor c = db.rawQuery(selectQuery,null);
        User user = null;
        if (c.moveToFirst()) {
            user = new User(c.getInt(c.getColumnIndex(COLUMN_ID)),c.getString(c.getColumnIndex(COLUMN_USERNAME)),
                    c.getString(c.getColumnIndex(COLUMN_PASSWORD)), c.getString(c.getColumnIndex(COLUMN_NAME)));
        }
        return user;
    }
}
