package com.contenthandle.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.List;

public class ContentHandleActivity extends Activity {

	public static String webUri = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		loadShareImage(getIntent());
		finish();
		PackageManager packageManager = this.getPackageManager();
		Intent intent = packageManager.getLaunchIntentForPackage(this.getPackageName());
		startActivity(intent);
	}

	public void loadShareImage(Intent intent) {
		String action = intent.getAction();
		String type = intent.getType();
		if (Intent.ACTION_SEND.equals(action) && type != null) {
			if (type.startsWith("text/")) {
				handleSendImage(intent);
			}
		}
	}

	void handleSendImage(Intent intent) {
		String uri = intent.getStringExtra(Intent.EXTRA_TEXT);
		if (uri != null) {
			ContentHandleActivity.webUri = uri;
		}
	}
}
