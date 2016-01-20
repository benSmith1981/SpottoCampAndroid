package com.example.funkymonkey1981.spottocampandroid;

import android.app.ProgressDialog;
import android.text.TextUtils;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;


/**
 * Created by funkymonkey1981 on 18/01/16.
 */
public class SpottoCampJSONRequest<T> extends Request<T> {

    private RequestQueue mRequestQueue;
    protected final Response.Listener<T> listener;
    private static SpottoCampJSONRequest mInstance;
    protected SpottoCampJSON campsites;
    // Progress dialog
    private ProgressDialog pDialog;
    protected String url;

    public SpottoCampJSONRequest(Response.Listener<T> listener,
                                 Response.ErrorListener errorListener,
                                 String url){
        super(Method.GET, url, errorListener);
        this.listener = listener;
        this.url = url;
    }

    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        return null;
    }

    @Override
    protected void deliverResponse(T response) {
        if (listener != null) {
            listener.onResponse(response);
        }
    }

    public static class Builder<T> {
        Response.Listener<T> listener;
        String url;
        Response.ErrorListener errorListener;

        public Builder() {
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public Builder listener(Response.Listener<T> listener) {
            this.listener = listener;
            return this;
        }


        public Builder errorListener(Response.ErrorListener listener) {
            this.errorListener = listener;
            return this;
        }



        public SpottoCampJSONRequest<T> build() {
            if (listener == null || errorListener == null || TextUtils.isEmpty(url)) {
                throw new IllegalArgumentException("Jackson requests require at least the listener, errorListener and url to be defined");
            }
            return new SpottoCampJSONRequest<T>(
                    listener,
                    errorListener,
                    url
            );
        }
    }

}