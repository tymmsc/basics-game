package com.teamBasics.framework.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Environment;
import android.preference.PreferenceManager;

import com.teamBasics.framework.FileIO;

public class AndroidFileIO implements FileIO {
	Context context;
	AssetManager assets;
	String externalStoragePath;

	public AndroidFileIO(Context context) {
		this.context = context;
		this.assets = context.getAssets();
		this.externalStoragePath = Environment.getExternalStorageDirectory()
				.getAbsolutePath() + File.separator;
		System.out.println(externalStoragePath);
		this.externalStoragePath="/";

	}

	@Override
	public InputStream readAsset(String file) throws IOException {
		return assets.open(file);
	}

	@Override
	public InputStream readFile(String file) throws IOException {
		return context.openFileInput(file);
	}

	@Override
	public OutputStream writeFile(String file) throws IOException {
		return context.openFileOutput(file, Context.MODE_PRIVATE);
	}

	public SharedPreferences getSharedPref() {
		return PreferenceManager.getDefaultSharedPreferences(context);
	}
}