package com.yiriba.listviewsimple;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<Country> {

    private ArrayList<Country> countryList;
    Context context;

    public CustomAdapter(Context context, ArrayList<Country> countryList) {
        super(context, R.layout.my_list_item, countryList);
        this.countryList = countryList;
        this.context = context;
    }

    //View lookup cache
    private static class ViewHolder {

        TextView tv_country;
        TextView tv_cupWins;
        ImageView flagImg;



    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // Get the data item for this position
        Country model = getItem(position);

        // Check if an existing view is being reused, otherwise inflate (display) the view.
        ViewHolder viewHolder;
        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.my_list_item, parent, false);
            viewHolder.tv_country = (TextView) convertView.findViewById(R.id.tv_country);
            viewHolder.tv_cupWins = (TextView) convertView.findViewById(R.id.tv_cup_win_desc);
            viewHolder.flagImg = (ImageView) convertView.findViewById(R.id.iv);
            result = convertView;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        // Get the data from the model class
        viewHolder.tv_country.setText(model.getCountry_name());
        viewHolder.tv_cupWins.setText(model.getCup_win_count());
        viewHolder.flagImg.setImageResource(model.getFlag_img());

        return convertView;
    }



}
