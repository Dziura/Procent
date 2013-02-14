package com.example.procencik;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class OwnActivity extends ListActivity {

	final Context context = this;
	private Button button;

	ArrayList<HashMap<String, String>> menuItems;
	private ListAdapter adapter;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_own);
		menuItems = new ArrayList<HashMap<String, String>>();
		adapter = new SimpleAdapter(this, menuItems, R.layout.element_sklep,
				new String[] { "name", "street", "common", "week" }, new int[] {
						R.id.textView1, R.id.textView2, R.id.textView3,
						R.id.textView4 });

		button = (Button) findViewById(R.id.add);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				LayoutInflater li = LayoutInflater.from(context);
				View promptsView = li.inflate(R.layout.mydialog, null);

				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);

				alertDialogBuilder.setView(promptsView);

				final EditText name = (EditText) promptsView
						.findViewById(R.id.name);
				final EditText street = (EditText) promptsView
						.findViewById(R.id.street);
				final EditText h1 = (EditText) promptsView
						.findViewById(R.id.h1);
				final EditText h2 = (EditText) promptsView
						.findViewById(R.id.h2);
				final EditText h3 = (EditText) promptsView
						.findViewById(R.id.h3);
				final EditText h4 = (EditText) promptsView
						.findViewById(R.id.h4);

				// set dialog message
				alertDialogBuilder
						.setCancelable(false)
						.setPositiveButton("OK",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// get user input and set it to result
										// edit text

										HashMap<String, String> map = new HashMap<String, String>();
										map.put("name", name.getText()
												.toString());
										map.put("street", "ul. "
												+ street.getText().toString());
										map.put("common", "pn-pt: "
												+ h1.getText().toString() + "-"
												+ h2.getText().toString());
										map.put("week", "sb-nd: "
												+ h3.getText().toString() + "-"
												+ h4.getText().toString());
										menuItems.add(map);
										setListAdapter(adapter);
									}
								})
						.setNegativeButton("Anuluj",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										dialog.cancel();
									}
								});

				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();

			}
		});

		ListView lv = getListView();
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					final int position, long id) {
				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);
				alertDialogBuilder
						.setCancelable(false)
						.setPositiveButton("Usun",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										menuItems.remove(position);
										setListAdapter(adapter);

									}
								})
						.setNegativeButton("Anuluj",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										dialog.cancel();
									}
								});

				AlertDialog alertDialog = alertDialogBuilder.create();
				alertDialog.show();

			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_own, menu);
		menu.add("Pokaz na mapie");
		return true;
	}
}