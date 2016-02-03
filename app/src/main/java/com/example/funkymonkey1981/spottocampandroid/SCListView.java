package com.example.funkymonkey1981.spottocampandroid;

import android.app.Activity;
import android.content.Context;
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

    public SCListView(Context context, @LayoutRes int layoutId, ArrayList<Data> campsites) {
        super(context, layoutId, campsites);
        inflater = LayoutInflater.from(context);
        mImageLoader = com.example.funkymonkey1981.spottocampandroid.SCImageLoader.getInstance().getImageLoader();
        this.context = context;

    }
    public ImageLoader getmImageLoader() {
        return mImageLoader;
    }

    static class ViewHolder {
        TextView txtTitle;
        ImageView imageView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //This holds the view
        ViewHolder rowView;

        // inflate the layout
        if (convertView == null) {
            //set view passed in, to the view of the list
            convertView = inflater.inflate(R.layout.list_item, null, true);

            //Initialise view holder
            rowView = new ViewHolder();

            //get views
            rowView.txtTitle = (TextView) convertView.findViewById(R.id.txt);
            rowView.imageView = (ImageView) convertView.findViewById(R.id.img);

            // store the holder with the view.
            convertView.setTag(rowView);

        } else { //view holder already set so retrieve it
            rowView = (ViewHolder) convertView.getTag();
        }

        // data item based on the position
        final Data data = getItem(position);

        // assign values if the object is not null
        if(data != null) {
            // get the TextView from the ViewHolder and then set the text (item name) and tag (item ID) values
            rowView.txtTitle.setText(data.getName());

            Picasso.with(convertView.getContext())
                    .load(data.getThumbnail())
                    .resize(500, 500)
                    .centerCrop()
                    .into(rowView.imageView);
        }

        return convertView;

    }


}
