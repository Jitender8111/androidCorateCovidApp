package com.jitendera.covidninteenbyjmietiarya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailsOfStateCovidCases extends AppCompatActivity {

    private  int positionState;
    TextView tvDetailsState,tvDetailsStateTotalCases,tvDetailsCinfrimCases,tvDetailsStateDeaths,tvDetailsStateForeign,tvDetialsStateDischarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_state_covid_cases);

        Intent intent = getIntent();
        positionState = intent.getIntExtra("position",0);
        String ctry = StateInformationCovid.stateModelsList.get(positionState).getState();

        getSupportActionBar().setTitle("Details of "+ctry);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvDetailsState = findViewById(R.id.tvDetailsState);
        tvDetailsStateTotalCases = findViewById(R.id.tvDetailsStateTotalCases);
        tvDetailsCinfrimCases = findViewById(R.id.tvDetailsStateConfirmCases);
        tvDetailsStateDeaths = findViewById(R.id.tvDetailsStateDeaths);
        tvDetailsStateForeign = findViewById(R.id.tvDetailsStateForeign);
        tvDetialsStateDischarge = findViewById(R.id.tvDetailsStateDischarge);


        tvDetailsState.setText(StateInformationCovid.stateModelsList.get(positionState).getState());
        tvDetailsStateTotalCases.setText(StateInformationCovid.stateModelsList.get(positionState).getActive());
        tvDetailsCinfrimCases.setText(StateInformationCovid.stateModelsList.get(positionState).getCases());
        tvDetailsStateDeaths.setText(StateInformationCovid.stateModelsList.get(positionState).getDeaths());
        tvDetailsStateForeign.setText(StateInformationCovid.stateModelsList.get(positionState).getActiveForeign());
        tvDetialsStateDischarge.setText(StateInformationCovid.stateModelsList.get(positionState).getRecovered());

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}