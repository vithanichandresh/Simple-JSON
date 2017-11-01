package com.example.akshar.imagejson;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView recyclerView;
    ArrayList<Bean> arrayList;
    JSONArray array;
    Bean bean;

    //String url_data="http://www.androidbegin.com/tutorial/jsonparsetutorial.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (ListView) findViewById(R.id.recycleview);
        arrayList = new ArrayList<>();
        bean = new Bean();

/*

            try {
                for (int i = 0; i < array.length(); i++) {
                JSONObject object=array.getJSONObject(i);
                JSONObject object1=object.getJSONObject("Driver");
                bean.setNationaliti(object1.getString("nationality"));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

*/

        loadjson();

        recyclerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), Detail.class);
                i.putExtra("pos", position);
                i.putExtra("ravi", arrayList);
                startActivity(i);
            }
        });
    }

    private void loadjson() {
        AsyncLoader helper = new AsyncLoader(MainActivity.this, "https://www.itis.gov/ITISWebService/jsonservice/getFullRecordFromTSN?tsn=202384", new Onacysnkloader() {
            @Override
            public void Onresult(String result) {

                try {
                    Toast.makeText(MainActivity.this, "" + result, Toast.LENGTH_SHORT).show();


                    JSONObject jsonObject = new JSONObject(result);
                    JSONObject jsonObject1 = jsonObject.getJSONObject("acceptedNameList");
                    JSONArray jsonArray=jsonObject1.getJSONArray("acceptedNames");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject2=jsonArray.getJSONObject(i);
                        bean.setAname(jsonObject2.getString("acceptedName"));

                    }

                    JSONObject jsonObject3 = jsonObject.getJSONObject("expertList");
                    JSONArray jsonArray1=jsonObject3.getJSONArray("experts");
                    for (int i = 0; i <jsonArray1.length() ; i++) {
                        JSONObject  jsonObject4=jsonArray1.getJSONObject(i);
                        JSONArray jsonArray2=jsonObject4.getJSONArray("referenceFor");
                        for (int j = 0; j <jsonArray2.length() ; j++) {
                            JSONObject jsonObject5=jsonArray2.getJSONObject(j);
                            bean.setName(jsonObject5.getString("name"));
                                arrayList.add(bean);

                            MyAdpt adpt=new MyAdpt(getApplicationContext(),arrayList);
                            recyclerView.setAdapter(adpt);

                        }


                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        helper.execute();
    }
}



/*
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);


                        Bean bean=new Bean();
                        bean.setCountry(jsonObject1.getString("country"));
                        bean.setRank(jsonObject1.getString("rank"));
                        bean.setPopulation(jsonObject1.getString("population"));
                        bean.setImageUrl(jsonObject1.getString("flag"));

                    Log.e("bEAN", "Onresult: "+bean.toString() );
                        arrayList.add(bean);
                    Log.e("arraylist", "Onresult: "+arrayList );

                }
*/