package Tarakanoff.corp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "users";
    public static final String TABLE_TEACHERS = "TEACHERS";
    public static final String TABLE_STUDENTS = "STUDENTS";
    public static final String TABLE_AUTHENTICATION = "AUTHENTICATION";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "NAME";
    public static final String KEY_FNAME = "FNAME";
    public static final String KEY_MNAME = "MNAME";
    public static final String KEY_KAFEDRA = "KAFEDRA";
    public static final String KEY_EMAIL = "EMAIL";
    public static final String KEY_PHONE = "PHONE";

    public static final String KEY_NUMBER_STD = "_number_std";
    public static final String KEY_NAME_STD = "NAME_STD";
    public static final String KEY_FNAME_STD = "FNAME_STD";
    public static final String KEY_MNAME_STD = "MNAME_STD";
    public static final String KEY_GROUP_STD = "GROUP_STD";
    public static final String KEY_EMAIL_STD = "EMAIL_STD";
    public static final String KEY_PHONE_STD = "PHONE_STD";

    public static final String KEY_ID_AUTH = "_id_auth";
    public static final String KEY_LOGIN = "LOGIN";
    public static final String KEY_PASSWORD = "PASSWORD";


    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_TEACHERS + "(" + KEY_ID + " integer primary key," + KEY_NAME + " varchar(30)," +
                KEY_FNAME + " varchar(30)," + KEY_MNAME + " varchar(30)," + KEY_KAFEDRA + " varchar(30)," +
                KEY_EMAIL + " varchar(30)," + KEY_PHONE + " ing(11)" + ")");
        db.execSQL("create table " + TABLE_STUDENTS + "(" + KEY_NUMBER_STD + " integer primary key," +
                KEY_NAME_STD + " varchar(30)," + KEY_FNAME_STD + " varchar(30)," +
                KEY_MNAME_STD + " varchar(30)," + KEY_GROUP_STD + " varchar(30)," +
                KEY_EMAIL_STD + " varchar(30)," + KEY_PHONE_STD + " ing(11)" + ")");
        db.execSQL("create table " + TABLE_AUTHENTICATION + "(" + KEY_ID_AUTH + " integer primary key," +
                KEY_LOGIN + " varchar(30)," + KEY_PASSWORD + " varchar(30)" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + TABLE_TEACHERS + TABLE_STUDENTS + TABLE_AUTHENTICATION);

        onCreate(db);
    }
}
