package com.example.funkymonkey1981.spottocampandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;

import java.util.ArrayList;

/**
 * Created by funkymonkey1981 on 21/01/16.
 */
public class SCCampingListFragment extends Fragment {
    private SCJSON campsites;
    private ListView campingListView;
    private SCListView campingListAdapter;
    private String url = "http://spottodev.spottocamp.com/api/spots?lng=4.8833426&lat=52.389523&tents=1&nudists=1&distance=-1&page=2";
    // Progress dialog
    private ProgressDialog pDialog;
    private static String TAG = SCMainActivity.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camping_list_fragment, container, false);

//        pDialog = new ProgressDialog(SCMainActivity.getInstance());
//        pDialog.setMessage("Please wait...");
//        pDialog.setCancelable(false);

        campingListView = (ListView) view.findViewById(R.id.list);

        campingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent detailView = new Intent(SCMainActivity.getInstance(), SCDetail.class);
                //How you send objects through?!
                final SCJSON.Spots.Data data = campingListAdapter.getItem(position);
                detailView.putExtra(Constants.detailExtraString, data.getName());
                startActivity(detailView);
            }
        });
        getData();

        return view;

    }

    private void getData() {
//        showDialog();
        ScServiceHandler.getInstance().getCampsiteList(url, new SCServerCallBack() {
                    @Override
                    public void onSuccess(SCJSON campsites) {
                        if (campsites != null && campsites.spots != null && campsites.spots.getData() != null) {
                            campingListAdapter = new SCListView(SCMainActivity.getInstance(),
                                    R.layout.camping_list_fragment,
                                    new ArrayList<SCJSON.Spots.Data>(campsites.spots.getData()));
                            campingListView.setAdapter(campingListAdapter);
                        }
//                        dismissDialog();
                    }

                    @Override
                    public void onError(VolleyError error) {
//                        dismissDialog();
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
        pDialog = new ProgressDialog(SCMainActivity.getInstance());
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        pDialog.show();
    }
}

