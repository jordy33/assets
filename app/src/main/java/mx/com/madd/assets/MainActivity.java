package mx.com.madd.assets;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.List;
/*
 create table books (id integer primary key,title varchar(16),edition varchar(16));
 insert into books values (1,'Moby Dick','First');
 insert into books values (2,'Dracula','Second');
 insert into books values (3,'Gone with the wind','Second');

 CREATE TABLE `dbVersion` (
	`version_id`	int NOT NULL,
	PRIMARY KEY(version_id)
);
 insert into dvVersion values (1);
 */
public class MainActivity extends AppCompatActivity {
    private final static String TAG = "INFO";
    private SQLiteDatabase db;
    DataBaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DataBaseHelper(this, getFilesDir().getAbsolutePath());
        try {
            dbHelper.prepareDatabase();
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        List<Books> list = dbHelper.getBooks();
        for (int i =0; i< list.size(); i++) {
            Books book = list.get(i);
            Log.d("INFO",book.getTitle());
            Log.d("INFO",book.getEdition());
        }
    }
}
