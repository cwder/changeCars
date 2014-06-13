package a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SeekBar;

public class Db extends SQLiteOpenHelper{

	
	public Db(Context context, String name, CursorFactory factory, int version) {
		super(context, "cwd.db", factory, VERSION);
		SeekBar aBar;
	}

	public static final int VERSION = 1;
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table cwd (personId integer primary key autoincrement ,name varchar(20),age integer)");
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exist cwd");
		onCreate(db);
	}

}
