package com.example.procencik;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
 
import java.util.ArrayList;
 
public class MyItemizedOverlay extends ItemizedOverlay<OverlayItem> {
    private ArrayList< OverlayItem > mOverlays = new ArrayList< OverlayItem >();
    Context mContext;
 
    public MyItemizedOverlay(Drawable marker) {
        super(boundCenterBottom(marker));
    }
 
    public MyItemizedOverlay(Drawable marker, Context context) {
        super(boundCenterBottom(marker));
        mContext = context;
    }
 
    public void addOverlay(OverlayItem overlay) {
        mOverlays.add(overlay);
        populate();
    }
 
    @Override
    protected OverlayItem createItem(int i) {
        return mOverlays.get(i);
    }
 
   public void clear() {
	   mOverlays.clear();
	   populate();
   }
    
    @Override
    public int size() {
        return mOverlays.size();
    }
 
    @Override
    protected boolean onTap(int i) {
        OverlayItem item = mOverlays.get(i);
        AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
        dialog.setTitle(item.getTitle());
        dialog.setMessage(item.getSnippet());
        dialog.show();
        return true;
    }
}