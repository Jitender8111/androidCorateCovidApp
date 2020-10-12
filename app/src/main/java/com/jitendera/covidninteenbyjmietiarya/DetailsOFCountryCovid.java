package com.jitendera.covidninteenbyjmietiarya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

public class DetailsOFCountryCovid extends AppCompatActivity {
    private  int positionCountry;
    TextView tvDetailscountry,tvDetailsTotalCases,tvDetailsToadyCases,tvDetailsToadyDeaths,tvDetailsDeaths,tvDetialsRecovered,tvDetailsActive,tvDetailsCritical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_o_f_country_covid);

        Intent intent = getIntent();
        positionCountry = intent.getIntExtra("position",0);
        String ctry = GlobalInformationCovid.countryModelsList.get(positionCountry).getCountry();

        getSupportActionBar().setTitle("Details of "+ctry);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



        tvDetailscountry = findViewById(R.id.tvDetailsCountry);
        tvDetailsTotalCases = findViewById(R.id.tvDetailsTotalCases);
        tvDetailsToadyCases = findViewById(R.id.tvDetailsTodayCases);
        tvDetailsToadyDeaths = findViewById(R.id.tvDetailsTodayDeaths);
        tvDetailsDeaths = findViewById(R.id.tvDetailsDeaths);
        tvDetialsRecovered = findViewById(R.id.tvDetailsRecovered);
        tvDetailsActive = findViewById(R.id.tvDetailsActive);
        tvDetailsCritical = findViewById(R.id.tvDetailsCritical);

        tvDetailscountry.setText(GlobalInformationCovid.countryModelsList.get(positionCountry).getCountry());
        tvDetailsTotalCases.setText(GlobalInformationCovid.countryModelsList.get(positionCountry).getCases());
        tvDetailsToadyDeaths.setText(GlobalInformationCovid.countryModelsList.get(positionCountry).getTodayCases());
        tvDetailsDeaths.setText(GlobalInformationCovid.countryModelsList.get(positionCountry).getTodayDeaths());
        tvDetailsDeaths.setText(GlobalInformationCovid.countryModelsList.get(positionCountry).getDeaths());
        tvDetialsRecovered.setText(GlobalInformationCovid.countryModelsList.get(positionCountry).getRecovered());
        tvDetailsActive.setText(GlobalInformationCovid.countryModelsList.get(positionCountry).getActive());
        tvDetailsCritical.setText(GlobalInformationCovid.countryModelsList.get(positionCountry).getCritical());




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}