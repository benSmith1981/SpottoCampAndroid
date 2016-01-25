package com.example.funkymonkey1981.spottocampandroid;

import android.content.Intent;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.VolleyError;
import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Data;
import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Query;

import java.util.ArrayList;

/**
 * Created by funkymonkey1981 on 21/01/16.
 */
public class SCCampingListFragment extends Fragment {
    private Query campsites;
    private ListView campingListView;
    private SCListView campingListAdapter;
    private static String TAG = SCMainActivity.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.camping_list_fragment, container, false);

        campingListView = (ListView) view.findViewById(R.id.list);

        campingListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent detailIntent = new Intent(SCMainActivity.getInstance(), SCDetail.class);
                //How you send objects through?!
                System.out.println(campingListView.getItemAtPosition(position));
                Data data = (Data)campingListView.getItemAtPosition(position);

                Bundle mBundle = new Bundle();
                mBundle.putSerializable(Constants.SER_KEY, data);
                detailIntent.putExtras(mBundle);
                startActivity(detailIntent);
            }
        });

        return view;

    }

    protected void getData(String url) {
//        SCMainActivity.getInstance().showDialog();
        ScServiceHandler.getInstance().getCampsiteList(url, new SCServerCallBack() {
                    @Override
                    public void onSuccess(Query campsites) {
                        if (campsites != null && campsites.spots != null && campsites.spots.getData() != null) {
                            campingListAdapter = new SCListView(SCMainActivity.getInstance(),
                                    R.layout.camping_list_fragment,
                                    new ArrayList<Data>(campsites.spots.getData()));
                            campingListView.setAdapter(campingListAdapter);
                        }
//                        SCMainActivity.getInstance().dismissDialog();
                    }

                    @Override
                    public void onError(VolleyError error) {
//                        SCMainActivity.getInstance().dismissDialog();
                    }

                }
        );

    }
}

