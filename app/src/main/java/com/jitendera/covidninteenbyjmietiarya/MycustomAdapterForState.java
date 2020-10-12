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

public class MycustomAdapterForState extends ArrayAdapter<StateModel> {

    private Context contextss;
    private List<StateModel> stateModelsList;

    public MycustomAdapterForState(Context context, List<StateModel> stateModelsList) {
        super(context, R.layout.list_custom_item_for_state,stateModelsList);
        this.contextss =context;
        this.stateModelsList = stateModelsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_custom_item_for_state,null,true);
       // ImageView imageView = view.findViewById(R.id.imageFlagForState);
        TextView tvstateName = view.findViewById(R.id.tvStateName);
        TextView tvSatateCases = view.findViewById(R.id.tvStateCases);

        tvstateName.setText(stateModelsList.get(position).getState());
        tvSatateCases.setText(stateModelsList.get(position).getCases());
      //  Glide.with(contextss).load(stateModelsList.get(position).getFlag()).into(imageView);
        return view;
    }
}
