package com.example.procencik;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageButton red;
	private Context context;
	private Button more;
	private Button my;
	LocationManager locationManager;
	private ConnectivityManager connManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = getApplicationContext();

		red = (ImageButton) findViewById(R.id.redButton);
		more = (Button) findViewById(R.id.Szukaj);

		my = (Button) findViewById(R.id.my);
		my.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Intent intent = new Intent(context, OwnActivity.class);
				startActivity(intent);
			}
		});

		more.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				Intent intent = new Intent(context, MorePlaces.class);
				startActivity(intent);
			}
		});

		red.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				String networkService = Context.CONNECTIVITY_SERVICE;
				locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
				connManager = (ConnectivityManager) getSystemService(networkService);
				if (!locationManager
						.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
					Toast.makeText(context, "Wlacz GPS!", Toast.LENGTH_SHORT)
							.show();
				} else if (connManager.getNetworkInfo(
						ConnectivityManager.TYPE_MOBILE).isConnected()
						|| connManager.getNetworkInfo(
								ConnectivityManager.TYPE_WIFI).isConnected()) {
					boolean change = true;
					Intent intent = new Intent(context, MapsActivity.class);
					intent.putExtra("change", change);
					Toast.makeText(context, "Szukam...", Toast.LENGTH_SHORT)
							.show();
					startActivity(intent);

				} else {
					Toast.makeText(context, "Wlacz Interneta!",
							Toast.LENGTH_SHORT).show();

				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		menu.add("INFO");
		return true;
	}

}
