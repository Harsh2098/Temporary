package com.example.adsadf;

import android.os.Bundle;
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

import static com.example.adsadf.Api.BASE_URL;

public class ForceFragment extends Fragment {

    private ListView listView;
    private List<Forces> forces;
    private String[] forceName;

    public ForceFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_force_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView = getView().findViewById(R.id.listView);

        final Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);
        Call<List<Forces>> call = api.getForces();
        call.enqueue(new Callback<List<Forces>>() {
            @Override
            public void onResponse(@NonNull Call<List<Forces>> call, @NonNull Response<List<Forces>> response) {
                forces = response.body();
                forceName = new String[forces.size()];
                for (int i = 0; i < forces.size(); i++) {
                    forceName[i] = forces.get(i).getName();
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, forceName);
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(@NonNull Call<List<Forces>> call, @NonNull Throwable t) {

            }
        });
    }
}
