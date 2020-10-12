package com.jitendera.covidninteenbyjmietiarya;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MycustomAdapter extends ArrayAdapter<countryModel> {
    private Context contexts;
    private List<countryModel> countryModelsList;

    public MycustomAdapter(Context context, List<countryModel> countryModelsList) {
        super(context, R.layout.list_custom_item,countryModelsList);
        this.contexts =context;
        this.countryModelsList = countryModelsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item,null,true);
        ImageView imageView = view.findViewById(R.id.imageFlag);
        TextView tvCountryName = view.findViewById(R.id.tvCountryName);

        tvCountryName.setText(countryModelsList.get(position).getCountry());
        Glide.with(contexts).load(countryModelsList.get(position).getFlag()).into(imageView);


        return view;
    }
}
