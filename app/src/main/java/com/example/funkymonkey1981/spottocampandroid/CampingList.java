package com.example.funkymonkey1981.spottocampandroid;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by funkymonkey1981 on 18/01/16.
 */

public class CampingList extends ArrayAdapter<SpottoCampJSON.Spots.Data> {

    private LayoutInflater inflater;

    public CampingList(Context context, @LayoutRes int layoutId, ArrayList<SpottoCampJSON.Spots.Data> campsites) {
        super(context, layoutId, campsites);
        inflater = LayoutInflater.from(context);

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView;
        if (view == null) {
            rowView = inflater.inflate(R.layout.list_item, null, true);
        } else {
            rowView = view;
        }
        final SpottoCampJSON.Spots.Data data = getItem(position);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
        txtTitle.setText(data.getName());

        // Get the ImageLoader through your singleton class.
        ImageLoader mImageLoader = VolleySingleton.getInstance().getImageLoader();
        NetworkImageView nv = (NetworkImageView)  rowView.findViewById(R.id.img);
        nv.setDefaultImageResId(R.drawable.spottocamplogo); // image for loading...
        // Set the URL of the image that should be loaded into this view, and
        // specify the ImageLoader that will be used to make the request.
        nv.setImageUrl(data.getThumbnail(), mImageLoader);

        return rowView;
    }

}
