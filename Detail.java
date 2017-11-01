package com.example.akshar.imagejson;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {
    private static final String TAG = "Detail ";
    ArrayList<Bean> arrayList;
    Button next,prev;
    Bean bean;
    int pos;
    TextView textView,txtget;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView=(ImageView) findViewById(R.id.image12223);
        textView=(TextView)findViewById(R.id.layout_name);
        txtget=(TextView)findViewById(R.id.txt5get);


       arrayList=(ArrayList<Bean>) getIntent().getSerializableExtra("ravi") ;

        pos=getIntent().getIntExtra("pos",0);


        textView.setText("Name : "+arrayList.get(pos).getAname());
        //Picasso.with(Detail.this).load(arrayList.get(pos).getImageUrl()).into(imageView );

        // biji webservice call karvi hoy to
        /*AsyncLoader helper=new AsyncLoader(Detail.this,"https://api.androidhive.info/contacts/"*//*+arrayList.get(pos).getName()*//*, new Onacysnkloader() {
            @Override
            public void Onresult(String result) {
                try {
                    Bean bean=new Bean();
                    JSONObject jsonObject=new JSONObject(result);
                    JSONArray  jsonArray=jsonObject.getJSONArray("contacts");
                    bean.setContact(jsonArray);
                    Log.e(TAG, "Onresult: "+bean.toString() );
                    for (int i = 0; i <jsonArray.length() ; i++) {
                    JSONObject jsonObject1=jsonArray.getJSONObject(i);

                        arrayList=new ArrayList<>();

                        bean.setName(jsonObject1.getString("name"));
                        bean.setEmail(jsonObject1.getString("email"));
                        JSONObject jsonObject2=jsonObject1.getJSONObject("phone");
                        bean.setPhone(jsonObject2.getString("mobile"));

                        arrayList.add(bean);
                        txtget.setText("Name :"+bean.getName()+"\n  Email :"+bean.getEmail()+"\n Mobile :"+bean.getPhone());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        });
        helper.execute();
*/
    }
}
