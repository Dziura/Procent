package com.example.procencik;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.content.Context;
import android.location.LocationManager;

import com.google.android.maps.GeoPoint;

public class NearPlace {
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
	private Place nearest;
	private double latitude;
	private double longitude;

	public NearPlace(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Place findNear() {
		double min = 10000;
		double tmp;

		XmParser parser = new XmParser();
		String xml = parser.getXmlFromUrl(URL); // getting XML
		Document doc = parser.getDomElement(xml); // getting DOM element
		NodeList nl = doc.getElementsByTagName(KEY_ITEM);
		nearest = new Place("test", "test", 34.2323, 17.040905, 7.00, 20.00, 9.00,
				20.00);

		for (int i = 0; i < nl.getLength(); i++) {
			Element e = (Element) nl.item(i);
			String name = parser.getValue(e, KEY_NAME);
			String street = parser.getValue(e, KEY_STREET);
			double lan = Double.parseDouble(parser.getValue(e, KEY_LAT));
			double lon = Double.parseDouble(parser.getValue(e, KEY_LON));
			double cf = Double.parseDouble(parser.getValue(e, KEY_CF));
			double ct = Double.parseDouble(parser.getValue(e, KEY_CT));
			double wf = Double.parseDouble(parser.getValue(e, KEY_WF));
			double wt = Double.parseDouble(parser.getValue(e, KEY_WT));

			// / tmp = distance(51.100818, 17.040905, lan, lon);
			tmp = distance(latitude, longitude, lan, lon);
			if (tmp < min) {
				min = tmp;
				nearest = new Place(name, street, lan, lon, cf, ct, wf, wt);
			}

			System.out.println(min);
		}

		return nearest;

	}

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
}
