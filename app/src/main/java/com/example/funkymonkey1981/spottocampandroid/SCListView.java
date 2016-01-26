package com.example.funkymonkey1981.spottocampandroid;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.LayoutRes;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.example.funkymonkey1981.spottocampandroid.JsonObjects.Data;
import com.example.funkymonkey1981.spottocampandroid.data.DataProvider;
import com.example.funkymonkey1981.spottocampandroid.data.DatabaseHelper;
import com.example.funkymonkey1981.spottocampandroid.data.DatabaseProvider;
import com.example.funkymonkey1981.spottocampandroid.data.PricesProvider;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by funkymonkey1981 on 18/01/16.
 */

public class SCListView extends ArrayAdapter<Data> {

    private LayoutInflater inflater;
    private ImageLoader mImageLoader;
    Context context;
    DataProvider dataDBHandler;
    PricesProvider pricesDBHandler;

    public SCListView(Context context, @LayoutRes int layoutId, ArrayList<Data> campsites) {
        super(context, layoutId, campsites);
        inflater = LayoutInflater.from(context);
        mImageLoader = com.example.funkymonkey1981.spottocampandroid.SCImageLoader.getInstance().getImageLoader();
        this.context = context;
        dataDBHandler = new DataProvider(context);
        pricesDBHandler = new PricesProvider(context);
    }
    public ImageLoader getmImageLoader() {
        return mImageLoader;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView;
        if (view == null) {
            rowView = inflater.inflate(R.layout.list_item, null, true);
        } else {
            rowView = view;
        }
        final Data data = getItem(position);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(data.getName());

        ImageView imageView = (ImageView)rowView.findViewById(R.id.img);
        Picasso.with(rowView.getContext()).load(data.getThumbnail()).into(imageView);

        dataDBHandler.save(data);
        Log.d("database", dataDBHandler.getTableAsString("data"));
        pricesDBHandler.save(data.getPrices());
        Log.d("database", pricesDBHandler.getTableAsString("prices"));


        return rowView;
    }



}
