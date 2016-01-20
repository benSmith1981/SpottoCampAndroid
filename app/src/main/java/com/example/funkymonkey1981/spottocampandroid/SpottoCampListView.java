package com.example.funkymonkey1981.spottocampandroid;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

/**
 * Created by funkymonkey1981 on 18/01/16.
 */

public class SpottoCampListView extends ArrayAdapter<SpottoCampJSON.Spots.Data> {

    private LayoutInflater inflater;

    public SpottoCampListView(Context context, @LayoutRes int layoutId, ArrayList<SpottoCampJSON.Spots.Data> campsites) {
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
        ImageLoader mImageLoader = SpottoCampImageLoader.getInstance().getImageLoader();
        NetworkImageView nv = (NetworkImageView)  rowView.findViewById(R.id.img);
        nv.setDefaultImageResId(R.drawable.spottocamplogo); // image for loading...
        // Set the URL of the image that should be loaded into this view, and
        // specify the ImageLoader that will be used to make the request.
        nv.setImageUrl(data.getThumbnail(), mImageLoader);

        return rowView;
    }

}
