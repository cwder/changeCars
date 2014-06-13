package com.example.cwd;

import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CommonDBAdapter {
	private Context mContext = null;
	private static CommonDBAdapter instance;
	private CommonDBHelper commonDBHelper;
	private SQLiteDatabase mDb;
	public final static String DB_NAME = "maapin.db";
	public final static int VERSION = 1;
	private static final Object DB_LOCK = new Object();

	public static final String TABLE_CITIES = "licai";
	public static final String CITIES_CREATE = "create table " + TABLE_CITIES
			+ "(id1 INTEGER , id2 INTEGER,name TEXT,expected_yield TEXT," +
			"break_even TEXT, initial_amount TEXT , manage_period TEXT,constraint pk_t2 primary key (id1,id2));";

	private CommonDBAdapter(Context ctx) {
		this.mContext = ctx;
	}

	public static CommonDBAdapter getInstance(Context con) {
		if (instance == null) {
			synchronized (CommonDBAdapter.class) {
				if (instance == null) {
					instance = new CommonDBAdapter(con.getApplicationContext());
				}
			}
		}
		return instance;
	}
	
	public void save(){
		SQLiteDatabase db = commonDBHelper.getWritableDatabase();
		db.execSQL("replace into licai (id1,id2,name,initial_amount) values (?,?,?,?)", new Object[]{1,1,"gerg","fewf"});
		db.execSQL("replace into licai (id1,id2,name,initial_amount) values (?,?,?,?)", new Object[]{1,3,"fe","ger"});
		//db.execSQL("insert into licai (id,name,initial_amount) values (?,?,?)", new Object[]{5,"vvv","vvv"});
	}


	public void initDataBase() {
		if (commonDBHelper != null) {
			mDb = commonDBHelper.getReadableDatabase();
		}
	}
	
	public CommonDBAdapter open() throws SQLException {
		synchronized (DB_LOCK) {
			if (commonDBHelper == null) {
				commonDBHelper = new CommonDBHelper(mContext);
			}
		}
		return this;
	}

	public void close() {
		synchronized (DB_LOCK) {
			if (commonDBHelper != null) {
				commonDBHelper.close();
				commonDBHelper = null;
			}
		}
	}

	public long insert(String table, ContentValues cv) {
		mDb = commonDBHelper.getWritableDatabase();
		return mDb.insert(table, null, cv);
	}

	public void bulkInsert(String table, List<ContentValues> cvs) {
		mDb = commonDBHelper.getWritableDatabase();
		mDb.beginTransaction();
		try {
			for (ContentValues cv : cvs) {
				mDb.insert(table, null, cv);
			}
			mDb.setTransactionSuccessful();
		} catch (Exception e) {
		} finally {
			mDb.endTransaction();
		}
		mDb.close();
	}

	public void delete(String table, String whereClause, String[] whereArgs) {
		mDb = commonDBHelper.getWritableDatabase();
		mDb.delete(table, whereClause, whereArgs);
	}

	public Cursor query(String table, String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy) {
		mDb = commonDBHelper.getReadableDatabase();
		return mDb.query(table, columns, selection, selectionArgs, groupBy,
				having, orderBy);
	}

	private class CommonDBHelper extends SQLiteOpenHelper {

		public CommonDBHelper(Context context) {
			super(context, DB_NAME, null, VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			/*db.beginTransaction();
			try {
				// ...
				db.execSQL(CITIES_CREATE);
				db.setTransactionSuccessful();
			} finally {
				db.endTransaction();
			}*/
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}
	}
}
