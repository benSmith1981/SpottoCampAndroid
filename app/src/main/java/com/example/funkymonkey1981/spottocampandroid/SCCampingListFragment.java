package com.example.funkymonkey1981.spottocampandroid;

import android.app.Activity;
import android.content.Intent;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Data;
import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Query;
import com.example.funkymonkey1981.spottocampandroid.data.DataProvider;
import com.example.funkymonkey1981.spottocampandroid.data.PricesProvider;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by funkymonkey1981 on 21/01/16.
 */
public class SCCampingListFragment extends Fragment {
    private ListView campingListView;
    private SCListView campingListAdapter;
    private static String TAG = SCMainActivity.class.getSimpleName();
    DataProvider dataDBHandler;
    PricesProvider pricesDBHandler;
    Query campsiteData = null;

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

        setDataDBHandler(new DataProvider(campingListView.getContext()));
        setPricesDBHandler(new PricesProvider(campingListView.getContext()));

        return view;

    }

    public DataProvider getDataDBHandler() {
        return dataDBHandler;
    }

    public void setDataDBHandler(DataProvider dataDBHandler) {
        this.dataDBHandler = dataDBHandler;
    }

    public PricesProvider getPricesDBHandler() {
        return pricesDBHandler;
    }

    public void setPricesDBHandler(PricesProvider pricesDBHandler) {
        this.pricesDBHandler = pricesDBHandler;
    }

    public Query getCampsiteData() {
        return campsiteData;
    }

    public void setCampsiteData(Query campsiteData) {
        this.campsiteData = campsiteData;
    }

    protected void getData(String url) {
//        SCMainActivity.getInstance().showDialog();
        ScServiceHandler.getInstance().getCampsiteList(url, new SCServerCallBack() {
                    @Override
                    public void onSuccess(Query campsites) {
                        setCampsiteData(campsites);
                        AddCampingDataTask addCampingDataTask = new AddCampingDataTask(getActivity());
                        addCampingDataTask.execute((Void) null);

//                        SCMainActivity.getInstance().dismissDialog();
                    }

                    @Override
                    public void onError(VolleyError error) {
//                        SCMainActivity.getInstance().dismissDialog();
                    }

                }
        );

    }

    public class AddCampingDataTask extends AsyncTask<Void, Void, Long> {

        private final WeakReference<Activity> activityWeakRef;

        public AddCampingDataTask(Activity context) {
            this.activityWeakRef = new WeakReference<Activity>(context);
        }

        @Override
        protected Long doInBackground(Void... arg0) {
            List<Data> campsiteData =  getCampsiteData().spots.getData();
            long result = 0;
            if (campsiteData != null && getCampsiteData() != null) {
                for (Data campsite : campsiteData) {
                    result = getDataDBHandler().save(campsite);
                    if (campsite.getPrices() != null && result != -1){
                        result = getPricesDBHandler().save(campsite.getPrices());
                    }
                }
            }
            return result;
        }

        @Override
        protected void onPostExecute(Long result) {
            if (activityWeakRef.get() != null
                    && !activityWeakRef.get().isFinishing()) {
                if (result != -1) {
                    Toast.makeText(activityWeakRef.get(), "CAMPSITE DATA Saved",
                            Toast.LENGTH_LONG).show();
                }
            }
            GetCampingDataTask getCampingDataTask = new GetCampingDataTask(getActivity());
            getCampingDataTask.execute((Void) null);

        }
    }

    public class GetCampingDataTask extends AsyncTask<Void, Void, Long> {

        private final WeakReference<Activity> activityWeakRef;
        private List<Data> campingData;
        public GetCampingDataTask(Activity context) {
            this.activityWeakRef = new WeakReference<Activity>(context);
        }

        @Override
        protected Long doInBackground(Void... arg0) {
            long result = 0;
            //retrieve all data
            campingData = dataDBHandler.getAllData();
            return result;
        }

        @Override
        protected void onPostExecute(Long result) {
            if (campingData != null) {
                campingListAdapter = new SCListView(SCMainActivity.getInstance(),
                        R.layout.camping_list_fragment,
                        new ArrayList<Data>(campingData));
                campingListView.setAdapter(campingListAdapter);
            }

            if (activityWeakRef.get() != null
                    && !activityWeakRef.get().isFinishing()) {
                if (result != -1) {
                    Toast.makeText(activityWeakRef.get(), "CAMPSITE DATA LOADED",
                            Toast.LENGTH_LONG).show();
                }
            }
        }
    }

}

