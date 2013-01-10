package com.thenewboston.travis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class HotOrNot {

	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "persons_name";
	public static final String KEY_HOTNESS = "persons_hotness";

	private static final String DATABASE_NAME = "hotOrNotdb";
	private static final String DATABASE_TABLE = "peopleTable";
	private static final int DATABASE_VERSION = 1;

	private dbHelper ourDbHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDataBase;

	private static class dbHelper extends SQLiteOpenHelper {

		public dbHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(" CREATE TABLE " + DATABASE_TABLE + " ( " + KEY_ROWID
					+ "  INTEGER PRIMARY_KEY AUTOINCREMENT ," + KEY_NAME
					+ " TEXT NOT NULL, " + KEY_HOTNESS + "  TEXT NOT NULL);"
			);

		}

		@Override
		public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
			// TODO Auto-generated method stub

		}

	}

	public HotOrNot(Context context) {
		ourContext = context;
	}
}
