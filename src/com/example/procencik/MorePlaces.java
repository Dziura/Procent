package com.example.procencik;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MorePlaces extends ListActivity {

	// All static variables
	static final String URL = "http://dl.dropbox.com/u/20236503/Places.xml";
	// XML node keys
	static final String KEY_ITEM = "Place"; // parent node
	static final String KEY_NAME = "Name";
	static final String KEY_STREET = "Street";
	static final String KEY_LAT = "Latitude";
	static final String KEY_LON = "Longitude";
	static final String KEY_CF = "commonFrom";
	static final String KEY_CT = "commonTo";
	static final String KEY_WF = "weekFrom";
	static final String KEY_WT = "weekTo";
	Place near;
	LocationManager locationManager;
	double latitude;
	double longitude;
	ArrayList<HashMap<String, String>> menuItems;
	double min;

	private double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	private double distance(double lat1, double lon1, double lat2, double lon2) {

		int R = 6371000;
		double dLat = deg2rad(lat2 - lat1);
		double dLon = deg2rad(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
				+ Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2))
				* Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double d = R * c;
		return d;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more_places);

		min = 1000;
		double tmp;
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		latitude = locationManager.getLastKnownLocation(
				LocationManager.GPS_PROVIDER).getLatitude();
		longitude = locationManager.getLastKnownLocation(
				LocationManager.GPS_PROVIDER).getLongitude();
		

		XmParser parser = new XmParser();
		String xml = parser.getXmlFromUrl(URL); // getting XML
		Document doc = parser.getDomElement(xml); // getting DOM element
		NodeList nl = doc.getElementsByTagName(KEY_ITEM);
		near = new Place("test", "test", 34.2323, 17.040905, 7.00, 20.00, 9.00,
				20.00);
		while (true) {
			menuItems = new ArrayList<HashMap<String, String>>();
			int places = 0;
			// looping through all item nodes <item>
			for (int i = 0; i < nl.getLength(); i++) {
				HashMap<String, String> map = new HashMap<String, String>();
				Element e = (Element) nl.item(i);
				String name = parser.getValue(e, KEY_NAME);
				String street = parser.getValue(e, KEY_STREET);
				double lan = Double.parseDouble(parser.getValue(e, KEY_LAT));
				double lon = Double.parseDouble(parser.getValue(e, KEY_LON));
				double cf = Double.parseDouble(parser.getValue(e, KEY_CF));
				double ct = Double.parseDouble(parser.getValue(e, KEY_CT));
				double wf = Double.parseDouble(parser.getValue(e, KEY_WF));
				double wt = Double.parseDouble(parser.getValue(e, KEY_WT));

				tmp = distance(latitude, longitude, lan, lon);
				if (tmp < min) {
					places += 1;
					map.put(KEY_NAME, name);
					map.put(KEY_STREET, "ul." + street);
					map.put("time",
							"pn-pt: " + parser.getValue(e, KEY_CF) + "-"
									+ parser.getValue(e, KEY_CT) + "  sb-nd: "
									+ parser.getValue(e, KEY_WF) + "-"
									+ parser.getValue(e, KEY_WT));
					map.put("distance", (int) tmp + " m");
					System.out.println(name + " " + tmp);
					menuItems.add(map);
					map.put(KEY_LAT, parser.getValue(e, KEY_LAT));
					map.put(KEY_LON, parser.getValue(e, KEY_LON));
				}

			}
			if (places < 3) {
				min += 500;
				continue;
			} else
				break;
		}
		// Adding menuItems to ListView
		ListAdapter adapter = new SimpleAdapter(this, menuItems,
				R.layout.element, new String[] { KEY_NAME, KEY_STREET, "time",
						"distance", KEY_LAT, KEY_LON }, new int[] {
						R.id.textView1, R.id.textView2, R.id.textView3,
						R.id.textView4, R.id.lat, R.id.lon });

		setListAdapter(adapter);

		// selecting single ListView item
		ListView lv = getListView();
		// listening to single listitem click
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				boolean change = false;
				// getting values from selected ListItem
				String lat = ((TextView) view.findViewById(R.id.lat)).getText()
						.toString();
				String lon = ((TextView) view.findViewById(R.id.lon)).getText()
						.toString();
				String name = ((TextView) view.findViewById(R.id.textView1)).getText()
						.toString();
				String street = ((TextView) view.findViewById(R.id.textView2)).getText()
						.toString();
				String time = ((TextView) view.findViewById(R.id.textView3)).getText()
						.toString();
				// Starting new intent
				Intent intent = new Intent(getApplicationContext(),
						MapsActivity.class);
				intent.putExtra(KEY_LAT, lat);
				intent.putExtra(KEY_LON, lon);
				intent.putExtra("Time", time);
				intent.putExtra("Name", name);
				intent.putExtra("Street", street);
				intent.putExtra(KEY_LAT, lat);
				intent.putExtra("change", change);

				startActivity(intent);

			}
		});

	}
}
