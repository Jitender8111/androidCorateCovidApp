package com.jitendera.covidninteenbyjmietiarya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class GlobalInformationCovid extends AppCompatActivity {
    TextView tvGlobalc,tvRecoveredC,tvActive,tvDeaths;
    ListView listviewForGlobalCases;
    SimpleArcLoader simpleArcLoaderss;
    LinearLayout lnforGlobal;
    RelativeLayout relForGlobal;

    public static List<countryModel> countryModelsList = new ArrayList<>();
    countryModel countryModel;
    MycustomAdapter mycustomAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global_information_covid);

        getSupportActionBar().setTitle("World Details of Covid-19 ");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        tvGlobalc = findViewById(R.id.tvglobalTotalCasesInNumber);
        tvRecoveredC = findViewById(R.id.tvGlobalRecovredInNumber);
        tvActive = findViewById(R.id.tvglobalActiveInNumber);
        tvDeaths = findViewById(R.id.tvglobalDeathsInNumber);
        listviewForGlobalCases = findViewById(R.id.listviewForGlobalCases);
        simpleArcLoaderss = findViewById(R.id.loaderss);
        lnforGlobal = findViewById(R.id.lnforvisibleGLobal);
        relForGlobal = findViewById(R.id.relForGlobal);


        fetchInformationDaata();
        fetchData();

        listviewForGlobalCases.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                 startActivity(new Intent(getApplicationContext(),DetailsOFCountryCovid.class).putExtra("position",position));
            }
        });

    }


    private void fetchInformationDaata() {

        String url = "https://corona.lmao.ninja/v2/all/";
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response.toString());

                    tvGlobalc.setText(jsonObject.getString("cases")); // here is cases is key Get by Postman App
                    tvRecoveredC.setText(jsonObject.getString("recovered")); //here is recovered is key Get by Postman App
                    tvActive.setText(jsonObject.getString("active"));
                    tvDeaths.setText(jsonObject.getString("deaths"));




                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GlobalInformationCovid.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    private void fetchData() {


        String url  = "https://corona.lmao.ninja/v2/countries/";
        StringRequest requests = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i=0; i<jsonArray.length(); i++) {

                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        String countryName = jsonObject.getString("country");
                        String cases = jsonObject.getString("cases");
                        String todayCases = jsonObject.getString("todayCases");
                        String deaths = jsonObject.getString("deaths");
                        String TodayDeaths = jsonObject.getString("todayDeaths");
                        String recovered = jsonObject.getString("recovered");
                        String active = jsonObject.getString("active");
                        String critical = jsonObject.getString("critical");

                        JSONObject object = jsonObject.getJSONObject("countryInfo");
                        String flagUrl=object.getString("flag");

                        countryModel = new countryModel(flagUrl,countryName,cases,todayCases,deaths,TodayDeaths,recovered,active,critical);
                        countryModelsList.add(countryModel);


                    }
                    mycustomAdapter = new MycustomAdapter(GlobalInformationCovid.this,countryModelsList);
                    listviewForGlobalCases.setAdapter(mycustomAdapter);
                    simpleArcLoaderss.setVisibility(View.GONE);
                    relForGlobal.setVisibility(View.GONE);
                    lnforGlobal.setVisibility(View.VISIBLE);
                } catch (JSONException e) {
                    simpleArcLoaderss.setVisibility(View.GONE);
                    relForGlobal.setVisibility(View.GONE);
                    lnforGlobal.setVisibility(View.VISIBLE);
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GlobalInformationCovid.this, ""+error.getMessage(), Toast.LENGTH_SHORT).show();
                simpleArcLoaderss.setVisibility(View.GONE);
                relForGlobal.setVisibility(View.GONE);
                lnforGlobal.setVisibility(View.VISIBLE);
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(requests);
    }
    //--------------------------------------------------------

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}