package com.gimbal.android.sample;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import com.gimbal.android.BeaconEventListener;
import com.gimbal.android.BeaconManager;
import com.gimbal.android.Gimbal;
import com.gimbal.android.PlaceEventListener;
import com.gimbal.android.PlaceManager;
import com.gimbal.android.Visit;

public class Beacon extends CordovaPlugin {

	public static final String ACTION_INITIALIZE_BEACON = "initializeBeacon";
	private PlaceEventListener placeEventListener;
	
	private BeaconEventListener beaconSightingListener;
    private BeaconManager beaconManager;

	
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
	
		if (action.equals(ACTION_INITIALIZE_BEACON)) {
			String Gimbal_Api_Key = "d5297ecf-d442-47c8-add3-e4037cda9b03";
			Gimbal.setApiKey(cordova.getActivity().getApplication(), Gimbal_Api_Key);
			cordova.getActivity().runOnUiThread(new Runnable() {
				
				@Override
				public void run() {
					placeEventListener = new PlaceEventListener() {
						
						@Override
						public void onVisitStart(Visit visit) {
							// TODO Auto-generated method stub
							super.onVisitStart(visit);
							 String placeName = visit.getPlace().getName();
						        
						        	
	        if (placeName.equalsIgnoreCase("Reception")) {
	       	 Toast.makeText(cordova.getActivity(), placeName, Toast.LENGTH_LONG).show();	
		        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						cordova.getActivity());
		 
					// set title
					alertDialogBuilder.setTitle(placeName);
		 
					// set dialog message
					alertDialogBuilder
						.setMessage("Welcome to the Photon World 2015 Conference !!!")
						.setCancelable(false)
						.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, close
								// current activity
								Toast.makeText(cordova.getActivity(), "Yes", Toast.LENGTH_LONG).show();
							}
						  })
						.setNegativeButton("No",new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,int id) {
								// if this button is clicked, just close
								// the dialog box and do nothing
								dialog.cancel();
							}
						});
		 
						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();
		 
						// show it
						alertDialog.show();			
			          }		
						       int flag = 0;
						        if (placeName.equalsIgnoreCase("Check-in") && flag == 0) {
							       	 Toast.makeText(cordova.getActivity(), placeName, Toast.LENGTH_LONG).show();	
								        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
												cordova.getActivity());
								 
											// set title
											alertDialogBuilder.setTitle(placeName);
								 
											// set dialog message
											alertDialogBuilder
												.setMessage("Would you like to Check-In using QR ?")
												.setCancelable(false)
												.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
													public void onClick(DialogInterface dialog,int id) {
														// if this button is clicked, close
														// current activity
														Toast.makeText(cordova.getActivity(), "Yes", Toast.LENGTH_LONG).show();
													}
												  })
												.setNegativeButton("No",new DialogInterface.OnClickListener() {
													public void onClick(DialogInterface dialog,int id) {
														// if this button is clicked, just close
														// the dialog box and do nothing
														dialog.cancel();
													}
												});
								 
												// create alert dialog
												AlertDialog alertDialog = alertDialogBuilder.create();
								 
												// show it
												alertDialog.show();	
												flag ++;
									          }						        
						        flag ++;
						
						}
						@Override
						public void onVisitEnd(Visit visit) {
							// TODO Auto-generated method stub
							 String placeName = visit.getPlace().getName();	
							 Toast.makeText(cordova.getActivity(), placeName, Toast.LENGTH_LONG).show();
							 
							 AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
										cordova.getActivity());
						 
									// set title
									alertDialogBuilder.setTitle(placeName);
						 
									// set dialog message
									alertDialogBuilder
										.setMessage("Thank you for support")
										.setCancelable(false)
										.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
											public void onClick(DialogInterface dialog,int id) {
												// if this button is clicked, close
												// current activity
												Toast.makeText(cordova.getActivity(), "Yes", Toast.LENGTH_LONG).show();
											}
										  })
										.setNegativeButton("No",new DialogInterface.OnClickListener() {
											public void onClick(DialogInterface dialog,int id) {
												// if this button is clicked, just close
												// the dialog box and do nothing
												dialog.cancel();
											}
										});
						 
										// create alert dialog
										AlertDialog alertDialog = alertDialogBuilder.create();
						 
										// show it
										alertDialog.show();			
						}
					};
					 PlaceManager.getInstance().addListener(placeEventListener);
	            	 PlaceManager.getInstance().startMonitoring();    
    	        }
			});
			/*beaconSightingListener = new BeaconEventListener() {
	            @Override
	            public void onBeaconSighting(BeaconSighting sighting) {
	                Log.i("INFO", sighting.toString());
	                sighting.getRSSI();
	            }
	        };
	        beaconManager = new BeaconManager();
	        beaconManager.addListener(beaconSightingListener);
	        beaconManager.startListening();*/
				
				}
		return false;
	}

	
}
