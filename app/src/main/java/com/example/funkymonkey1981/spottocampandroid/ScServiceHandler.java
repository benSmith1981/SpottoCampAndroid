package com.example.funkymonkey1981.spottocampandroid;
import android.app.Application;
import android.app.ProgressDialog;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.funkymonkey1981.spottocampandroid.data.Query;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;

import java.io.IOException;


/**
 * Created by funkymonkey1981 on 18/01/16.
 */
public class ScServiceHandler extends Application{

    public static final String TAG = ScServiceHandler.class.getSimpleName();

    // Progress dialog
    private ProgressDialog pDialog;

    private static ScServiceHandler mInstance = null;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static ScServiceHandler getInstance() {
        return mInstance;
    }


    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public ImageLoader getImageLoader(){

        return this.mImageLoader;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        getRequestQueue().add(req);
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }


    public void getCampsiteList(String urlJsonObj, final SCServerCallBack callback){
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                urlJsonObj, null, new Response.Listener<JSONObject>() {
            protected Query campsites;
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, response.toString());
                try {
                    //create ObjectMapper instance
                    ObjectMapper objectMapper = new ObjectMapper();
                    String responseJSONString = String.valueOf(response);
                    callback.onSuccess(objectMapper.readValue(responseJSONString,Query.class)); // call call back function here

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(SCMainActivity.getAppContext(),
                            "Error: " + e.getMessage(),
                            Toast.LENGTH_LONG).show();
                }


            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(SCMainActivity.getAppContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                callback.onError(error);

            }
        });

        // Adding request to request queue
        ScServiceHandler.getInstance().addToRequestQueue(jsonObjReq);
    }

}