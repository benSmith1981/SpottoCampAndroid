package com.example.funkymonkey1981.spottocampandroid;

import com.android.volley.VolleyError;

/**
 * Created by funkymonkey1981 on 20/01/16.
 */

public interface SCServerCallBack {

    void onSuccess(SCJSON campsites);

    void onError(VolleyError error);
}
