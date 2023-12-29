package com.example.kiemtraandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QuanLySanPham", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(MaSP INTEGER PRIMARY KEY AUTOINCREMENT, " + "TenSP TEXT, GiaTien REAL, Image TEXT)";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES(1, 'Vegetable', '1000', 'https://wallpaperaccess.com/full/2237015.jpg')," +
                "(2, 'A', '1000', 'https://wallpaperaccess.com/full/2237015.jpg')," +
                "(3, 'Cheese', '1000', 'https://wallpaperaccess.com/full/2237015.jpg')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
}
