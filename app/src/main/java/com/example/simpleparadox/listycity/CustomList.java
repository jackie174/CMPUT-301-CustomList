package com.example.simpleparadox.listycity;

import android.content.Context;
import android.text.style.IconMarginSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities){
        super(context,0, cities);
        this.cities = cities;
        this.context = context;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }
    public int getCount(){
        return cities.size();
    }
    public void addCity(City city){
        cities.add(city);
    }
    public int hasCity(City city) {
/*
        if (city.getCityName()=="Edmonton" && city.getProvinceName()=="Alberta"){
            return true;

        }else{
            return false;
        }*/
        /*
        if (cities.contains(city)) {
            return cities.size();
        }else{
            return cities.size();
        }*/
        if (cities.size() > 0) {
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).getCityName() == city.getCityName() && cities.get(i).getProvinceName() == city.getProvinceName()) {
                    return 1;

                } else {
                    return 0;
                }
            }
        }
        return 0;
    }

    public int deleteCity(City city){
        cities.remove(city);
        if (cities.size() > 0) {
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i).getCityName() == city.getCityName() && cities.get(i).getProvinceName() == city.getProvinceName()) {
                    return cities.size()-1;

                } else {
                    return cities.size();
                }
            }
        }
        return cities.size();

    }
    public int countCity(){
        return cities.size();
        //return -1;

    }


}
