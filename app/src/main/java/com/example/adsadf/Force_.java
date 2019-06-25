package com.example.adsadf;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Force_ extends Fragment {

    private ListView listView;
    private List<Forces> forces;
    private String[] forcename;

    public Force_() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_force_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = getView().findViewById(R.id.listView);

        final Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BaseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        Call<List<Forces>> call = api.getForces();
        call.enqueue(new Callback<List<Forces>>() {
            @Override
            public void onResponse(Call<List<Forces>> call, Response<List<Forces>> response) {
                forces = response.body();
                forcename = new String[forces.size()];
                for (int i = 0; i < forces.size(); i++) {
                    forcename[i] = forces.get(i).getName();
                    Log.d(":::", forces.get(i).getName());
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, forcename);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<Forces>> call, Throwable t) {

            }
        });
    }
}
