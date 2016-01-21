package com.example.funkymonkey1981.spottocampandroid;

/**
 * Created by funkymonkey1981 on 20/01/16.
 */

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class SpottoCampImageAdaptor extends AsyncTask<Object, Void, Bitmap> {

    private NetworkImageView imv;
    private String path;
    private String url;
    ImageLoader mImageLoader;

    public SpottoCampImageAdaptor(NetworkImageView imv, String thumbnailURL) {
        this.imv = imv;
        this.path = imv.getTag().toString();
        this.url = thumbnailURL;
    }

    @Override
    protected Bitmap doInBackground(Object... params) {
        mImageLoader = com.example.funkymonkey1981.spottocampandroid.SCImageLoader.getInstance().getImageLoader();
        Bitmap bitmap = null;

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {

        if (!imv.getTag().toString().equals(path)) {
            /*
             * The path is not same. This means that this image view is handled
             * by some other async task. We don't do anything and return.
             */
            return;
        }

        if (result != null && imv != null) {
            Log.i("test","success");
            imv.setImageUrl(url, mImageLoader);
            imv.setVisibility(View.VISIBLE);
            imv.setImageBitmap(result);
        } else {
            Log.i("test","result=" + String.valueOf(result == null)); //result is null here
            Log.i("test","imv=" + String.valueOf(imv == null));
            Log.i("test","fail");
            imv.setVisibility(View.GONE);
        }
    }
}