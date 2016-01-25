package com.example.funkymonkey1981.spottocampandroid;

import com.android.volley.VolleyError;
import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Query;

/**
 * Created by funkymonkey1981 on 20/01/16.
 */

public interface SCServerCallBack {

    void onSuccess(Query campsites);

    void onError(VolleyError error);
}
