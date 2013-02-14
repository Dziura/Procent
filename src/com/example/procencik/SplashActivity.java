package com.example.procencik;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

	//private ProgressDialog pd = null;
	private final int SPLASH_DISPLAY_LENGTH = 3000; 

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle icicle) {
	    super.onCreate(icicle);
	    setContentView(R.layout.activity_splash);
	    //this.pd = ProgressDialog.show(this, "Initializing..", "Initializing Infraline...", true, false);

	    /* New Handler to start the InfralineTabWidget-Activity
	     * and close this Splash-Screen after some seconds.*/

	    new Handler().postDelayed(new Runnable(){
	        @Override
	        public void run() {
	        /* Create an Intent that will start the InfralineTabWidget-Activity. */
	            Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
	            SplashActivity.this.startActivity(mainIntent);
	            SplashActivity.this.finish();
	        }
	    }, SPLASH_DISPLAY_LENGTH);

	}

	}