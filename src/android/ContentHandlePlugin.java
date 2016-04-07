package com.contenthandle.plugin;

import android.util.Log;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ContentHandlePlugin extends CordovaPlugin {

	public static final String LOG_TAG = "ContentHandlePlugin";
    private static CallbackContext contentHandleContext;
	
	@Override
	public boolean execute(final String action, final JSONArray data,
			final CallbackContext callbackContext) {
 		    if ("getShareWebUrl".equals(action)) {
		   	cordova.getThreadPool().execute(new Runnable() {
				public void run() {
					contentHandleContext = callbackContext;
					Log.v(LOG_TAG, "execute: data=" + data.toString());
        			JSONObject json = null;
					try {
						if (ContentHandleActivity.webUri != null) {
							json = new JSONObject().put("webUrl",ContentHandleActivity.webUri);
							ContentHandlePlugin.sendEvent(json);
						}
						else
						{
						  ContentHandlePlugin.sendEvent(null);
						}
						ContentHandleActivity.webUri = null;
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			return true;

		}else if ("isShareIntent".equals(action)) {
			cordova.getThreadPool().execute(new Runnable() {
				public void run() {
						if (ContentHandleActivity.webUri != null) {
							callbackContext.success();
					      }
					   else	{
						   callbackContext.error("not Active");
						}
				}
			});
				return true;
		} else {
			Log.e(LOG_TAG, "Invalid action : " + action);
			callbackContext.sendPluginResult(new PluginResult(
					PluginResult.Status.INVALID_ACTION));
			return false;
		}

	}

	public static void sendEvent(JSONObject _json) {
		PluginResult pluginResult = null;
		if(_json == null){
			pluginResult = new PluginResult(PluginResult.Status.OK, "");
		}
		else {
			 pluginResult = new PluginResult(PluginResult.Status.OK, _json);
		}
		pluginResult.setKeepCallback(true);
		if (contentHandleContext != null) {
			contentHandleContext.sendPluginResult(pluginResult);
		}
	}

	public static void sendError(String message) {
		PluginResult pluginResult = new PluginResult(PluginResult.Status.ERROR,message);
		pluginResult.setKeepCallback(true);
		if (contentHandleContext != null) {
			contentHandleContext.sendPluginResult(pluginResult);
		}
	}

	@Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
	}

	@Override
	public void onPause(boolean multitasking) {
		super.onPause(multitasking);
	}

	@Override
	public void onResume(boolean multitasking) {
		super.onResume(multitasking);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

}