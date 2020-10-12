package com.jitendera.covidninteenbyjmietiarya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.ArcConfiguration;
import com.leo.simplearcloader.SimpleArcDialog;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class IndiaCovidTracking extends AppCompatActivity {
    Button btnStateInfo,btnGlobalInfo,btnAdminPanel;
    TextView tvtotalCaseInNumber,tvActiveInNumber,tvRecoveredInNumber,tvdeathsInNumber;
    ImageView imageViewTotalCases,imageViewRecovered,imageViewActive,imageViewDeath;
    AnimationDrawable animationDrawable,animdrawabletwo,animdrawablethree,animdrawableFour;
     LinearLayout lnVisibility;
     SimpleArcLoader simpleArcLoader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_india_covid_tracking);



        init();
        imageViewRecovered.setBackgroundResource(R.drawable.iconcolorchanger);
        animationDrawable= (AnimationDrawable) imageViewRecovered.getBackground();

        imageViewTotalCases.setBackgroundResource(R.drawable.iconcolorchangertwo);
        animdrawabletwo= (AnimationDrawable) imageViewTotalCases.getBackground();

        imageViewActive.setBackgroundResource(R.drawable.iconcolorchangerthree);
        animdrawablethree= (AnimationDrawable) imageViewActive.getBackground();

        imageViewDeath.setBackgroundResource(R.drawable.iconcolorchangefour);
        animdrawableFour= (AnimationDrawable) imageViewDeath.getBackground();


                fetchDataa();

        btnStateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sti = new Intent(IndiaCovidTracking.this,StateInformationCovid.class);
                startActivity(sti);


            }
        });

        btnGlobalInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gi = new Intent(IndiaCovidTracking.this,GlobalInformationCovid.class);
                startActivity(gi);

            }
        });

        btnAdminPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ap = new Intent(IndiaCovidTracking.this,AdminalPanelInformation.class);
                startActivity(ap);

            }
        });

    }

    public  void init(){
        btnStateInfo = findViewById(R.id.imgBtnstatewiseInfo);
        btnGlobalInfo = findViewById(R.id.imgbtnglobalInfo);
        btnAdminPanel = findViewById(R.id.imgbtnQuestionAnswer);

        tvtotalCaseInNumber = findViewById(R.id.tvTotalCasesInNumber);
        tvActiveInNumber = findViewById(R.id.tvActiveCasesInNumber);
        tvRecoveredInNumber = findViewById(R.id.tvRecoveredInNumber);
        tvdeathsInNumber = findViewById(R.id.tvDeatInNumber);

        imageViewTotalCases = findViewById(R.id.imageViewTotalCases);
        imageViewRecovered = findViewById(R.id.imageViewRecovered);
        imageViewActive = findViewById(R.id.imageViewActive);
        imageViewDeath = findViewById(R.id.imageViewDeath);

        lnVisibility = findViewById(R.id.lnforvisible);
        simpleArcLoader = findViewById(R.id.loader);
      


    }


    private void fetchDataa() {


        String url  = "https://corona.lmao.ninja/v2/countries/";
        StringRequest requests = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i=0; i<jsonArray.length(); i++) {

                                 if (i==93){
                                     JSONObject jsonObject = jsonArray.getJSONObject(i);
                                     TextView tvTotal = findViewById(R.id.tvTotalCaseOfIndia);
                                     tvtotalCaseInNumber.setText(jsonObject.getString("cases")); // here is cases is key Get by Postman App
                                     tvRecoveredInNumber.setText(jsonObject.getString("recovered")); //here is recovered is key Get by Postman App
                                     tvActiveInNumber.setText(jsonObject.getString("active"));
                                     tvdeathsInNumber.setText(jsonObject.getString("deaths"));
                                     String tot = jsonObject.getString("country");
                                     tvTotal.setText("Total Cases "+tot);
                                 }

                            }
                                simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);
                            lnVisibility.setVisibility(View.VISIBLE);
                        } catch (JSONException e) {

                            e.printStackTrace();
                            simpleArcLoader.stop();
                            simpleArcLoader.setVisibility(View.GONE);

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(IndiaCovidTracking.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(requests);



    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        animationDrawable.start();
        animdrawabletwo.start();
        animdrawablethree.start();
        animdrawableFour.start();
    }
}