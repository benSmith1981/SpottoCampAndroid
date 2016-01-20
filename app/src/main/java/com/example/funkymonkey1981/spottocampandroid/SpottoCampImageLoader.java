package com.example.funkymonkey1981.spottocampandroid;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class SpottoCampImageLoader {
    private static SpottoCampImageLoader mInstance = null;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    // Progress dialog
    private ProgressDialog pDialog;

    private SpottoCampImageLoader(){
        mRequestQueue = Volley.newRequestQueue(SpottoCampMainScreen.getAppContext());
        mImageLoader = new ImageLoader(this.mRequestQueue, new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap> mCache = new LruCache<String, Bitmap>(10);
            public void putBitmap(String url, Bitmap bitmap) {
                mCache.put(url, bitmap);
            }
            public Bitmap getBitmap(String url) {
                return mCache.get(url);
            }
        });
    }

    public static SpottoCampImageLoader getInstance(){
        if(mInstance == null){
            mInstance = new SpottoCampImageLoader();
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        return this.mRequestQueue;
    }
    
    public ImageLoader getImageLoader(){
        return this.mImageLoader;
    }

}
