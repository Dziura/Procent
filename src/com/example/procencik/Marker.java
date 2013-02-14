package com.example.procencik;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

class Marker extends Overlay {

	private GeoPoint p;

	Marker(double latitude, double longitude) {

		p = new GeoPoint((int) (latitude * 1E6), (int) (longitude * 1E6));
	}

	@Override
	public boolean draw(Canvas canvas, MapView mapView, boolean shadow,
			long when) {
		super.draw(canvas, mapView, shadow);

		// ---translate the GeoPoint to screen pixels---
		Point screenPts = new Point();
		mapView.getProjection().toPixels(p, screenPts);

		// ---add the marker---
		Bitmap marker = BitmapFactory.decodeResource(mapView.getContext()
				.getResources(), R.drawable.bar);
		canvas.drawBitmap(marker, screenPts.x, screenPts.y, null);

		return true;

	}



}