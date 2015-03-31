package nl.xservices.plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.widget.Toast;

public class Beacon extends CordovaPlugin {

	public static final String ACTION_INITIALIZE_BEACON = "initializeBeacon";

	
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
	
		if (action.equals(ACTION_INITIALIZE_BEACON)) {
			initializeBeacon(callbackContext);
		}

		return false;
	}

	private void initializeBeacon(final CallbackContext callbackContext)  {
	//String Gimbal_Api_Key = "";
	//Gimbal.setApiKey(cordova.getActivity().getApplication(), Gimbal_Api_Key);
		cordova.getActivity().runOnUiThread(new Runnable() {
         public void run() {
             try {
                Toast.makeText(cordova.getActivity(), "Welcome", Toast.LENGTH_LONG).show();
                 callbackContext.success();
             } catch (Exception e) {
                 callbackContext.error("JSONException");
             }
         }
     });

	}
}
