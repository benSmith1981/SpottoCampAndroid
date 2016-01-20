package com.example.funkymonkey1981.spottocampandroid;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

public class SpottoCampMainScreen extends Activity {

    private SpottoCampJSON campsites;
    private ListView campingListView;
    private SpottoCampListView campingListAdapter;
    private String url = "http://spottodev.spottocamp.com/api/spots?lng=4.8833426&lat=52.389523&tents=1&nudists=1&distance=-1&page=2";

    private static String TAG = SpottoCampMainScreen.class.getSimpleName();

    private static SpottoCampMainScreen mInstance;
    private static Context mAppContext;

    // Progress dialog
    private ProgressDialog pDialog;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camping_list);

        mInstance = this;
        this.setAppContext(getApplicationContext());

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        campingListView = (ListView) findViewById(R.id.list);

        campingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent detailView = new Intent(SpottoCampMainScreen.this, SpottoCampDetail.class);
                //How you send objects through?!
                final SpottoCampJSON.Spots.Data data = campingListAdapter.getItem(position);
                detailView.putExtra(Constants.detailExtraString,data.getName());
                startActivity(detailView);
            }
        });

        getData();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public static SpottoCampMainScreen getInstance(){
        return mInstance;
    }
    public static Context getAppContext() {
        return mAppContext;
    }
    public void setAppContext(Context mAppContext) {
        this.mAppContext = mAppContext;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_camping_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SpottoCampMainScreen Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.funkymonkey1981.spottocampandroid/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "SpottoCampMainScreen Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.funkymonkey1981.spottocampandroid/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    private void getData() {
        showDialog();
        SpottoCampServiceHandler.getInstance().getCampsiteList(url, new ServerCallBack() {
                    @Override
                    public void onSuccess(SpottoCampJSON campsites) {
                        if (campsites != null && campsites.spots != null && campsites.spots.getData() != null) {
                            campingListAdapter = new SpottoCampListView(SpottoCampMainScreen.this,
                                                                R.layout.content_camping_list,
                                                                new ArrayList<SpottoCampJSON.Spots.Data>(campsites.spots.getData()));
                            campingListView.setAdapter(campingListAdapter);
                        }
                        dismissDialog();
                    }

                    @Override
                    public void onError(VolleyError error) {
                        dismissDialog();
                    }

                }
        );

    }

    private void dismissDialog() {
        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    private void showDialog() {
        pDialog = new ProgressDialog(SpottoCampMainScreen.this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
    }
}
