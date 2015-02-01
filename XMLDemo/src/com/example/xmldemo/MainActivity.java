package com.example.xmldemo;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.xmldemo.model.Book;
import com.example.xmldemo.parser.PullBookParser;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	private static final String TAG = "MainActivity";
	private Button readBtn;
	private Button writeBtn;
	private PullBookParser parser;
	private List<Book> books;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		readBtn = (Button) findViewById(R.id.readxml);
		writeBtn = (Button) findViewById(R.id.writexml);
		readBtn.setOnClickListener(this);
		writeBtn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.readxml:
			try {
				InputStream is = getAssets().open("books.xml");
				parser = new PullBookParser();
				books = parser.parse(is);
				for (Book book : books) {
					Log.i(TAG, "ID:" + book.getId() + " Name:" + book.getName());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			break;
		case R.id.writexml:

			String xml;
			try {
				xml = parser.serialize(books);
				FileOutputStream fos = openFileOutput("books.xml",
						Context.MODE_PRIVATE);
				fos.write(xml.getBytes("UTF-8"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

}
