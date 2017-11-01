package com.example.akshar.imagejson;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdpt extends BaseAdapter {

  Context context;
  ArrayList<Bean> arrayList;

  public MyAdpt(Context context, ArrayList<Bean> arrayList) {
    this.context = context;
    this.arrayList = arrayList;
  }

  @Override
  public int getCount() {
    return arrayList.size();
  }

  @Override
  public Object getItem(int position) {
    return null;
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    convertView = layoutInflater.inflate(R.layout.my_layout, null);
    TextView txtrank,txtcountry,txtpoulatin;
    CircleImageView imageView;

    txtrank=(TextView) convertView.findViewById(R.id.idxxe);
    txtcountry=(TextView) convertView.findViewById(R.id.country);
    txtpoulatin=(TextView) convertView.findViewById(R.id.population);

    imageView=(CircleImageView)convertView.findViewById(R.id.image121);


    Log.i("Position", "getView: "+position+ "data "+arrayList.get(position));



    Bean bean = arrayList.get(position);
      txtpoulatin.setText("Anme"+bean.getAname());
      txtcountry.setText("name"+bean.getName());


      /*
    txtrank.setText("Series:"+bean.getSeries());
    txtcountry.setText("Country:"+bean.getNationaliti());
    txtpoulatin.setText("Loacality : "+bean.getLocality());*/
    //Picasso.with(context).load(bean.getImageUrl()).into(imageView);

    return convertView;
  }
}