package com.jitendera.covidninteenbyjmietiarya;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.leo.simplearcloader.SimpleArcLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StateInformationCovid extends AppCompatActivity {

   //TextView txt1,txt2;
    ListView listviewForState;
    RequestQueue mqueue;

    public static List<StateModel> stateModelsList = new ArrayList<>();
    StateModel stateModel;
    MycustomAdapterForState mycustomAdapterForState;
    private SimpleArcLoader simpleArcLoaders;
    LinearLayout lnforState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_information_covid);

        getSupportActionBar().setTitle("Affected State Of India");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listviewForState = findViewById(R.id.listviewForIndianState);
        simpleArcLoaders = findViewById(R.id.loaders);
        lnforState = findViewById(R.id.lnForVisibleState);
      /*  txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);*/

       data();

        listviewForState.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                startActivity(new Intent(getApplicationContext(),DetailsOfStateCovidCases.class).putExtra("position",position));
            }
        });


    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }




    private void data() {
        mqueue = Volley.newRequestQueue(this);
        String urls = "https://api.rootnet.in/covid19-in/stats/latest";
        StringRequest requests = new StringRequest(Request.Method.GET, urls, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("regional");

                    for (int i=0; i<jsonArray.length(); i++){
                        JSONObject data = jsonArray.getJSONObject(i);
                        String stateName = data.getString("loc");
                        String cfCases= data.getString("confirmedCasesIndian");
                        String confirmedCasesForeign= data.getString("confirmedCasesForeign");
                        String discharged= data.getString("discharged");
                        String deaths= data.getString("deaths");
                        String totalConfirmed= data.getString("totalConfirmed");

                        stateModelsList.add(new StateModel(stateName,cfCases,confirmedCasesForeign,discharged,deaths,totalConfirmed));
                    }
                    mycustomAdapterForState = new MycustomAdapterForState(StateInformationCovid.this,stateModelsList);
                    listviewForState.setAdapter(mycustomAdapterForState);
                    simpleArcLoaders.setVisibility(View.GONE);
                    lnforState.setVisibility(View.VISIBLE);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(StateInformationCovid.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(requests);

    }
    //--------------------------------------------------------

}