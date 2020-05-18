package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import interfaces.API_interface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ThirdFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    int mRace = 1;
    int mClass = 1;

    int ATT = 1;
    int DEF = 1;
    int AGI = 1;
    int MAG = 1;

    int SwordOn = 0;
    int StickOn = 0;
    int DaggerOn = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        MainActivity mActivity = new MainActivity();

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_armor);

        MakeAPICall();

        return rootView;

    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mClass = this.getArguments().getInt("class1");
        mRace = this.getArguments().getInt("race1");

        view.findViewById(R.id.button_second3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });

        // Set the parameters of the character
        //Declaration of the component as TextView
        TextView TxtATT = (TextView) getView().findViewById(R.id.att_value);
        TextView TxtDEF = (TextView) getView().findViewById(R.id.def_value);
        TextView TxtAGI = (TextView) getView().findViewById(R.id.agi_value);
        TextView TxtMAG = (TextView) getView().findViewById(R.id.mag_value);
        ImageView BackGroundImageView = (ImageView) getView().findViewById(R.id.Imageview_personnage);

        //Change parameter in function of the race and class
        if (mRace == 1) { //Race Human
            if (mClass == 1) { //Class Human_warrior
                ATT = ATT + 1 + 1;
                DEF = DEF + 1 + 1;
                AGI = AGI + 1;
                MAG = MAG + 1;
                BackGroundImageView.setBackgroundResource(R.drawable.human_warrior);
            }
            if (mClass == 2) { //Class Human_magician
                ATT = ATT + 1;
                DEF = DEF + 1 - 1;
                AGI = AGI + 1;
                MAG = MAG + 1 + 3;
                BackGroundImageView.setBackgroundResource(R.drawable.human_magician);
            }
            if (mClass == 3) { //Class Human_assassin
                ATT = ATT + 1;
                DEF = DEF + 1;
                AGI = AGI + 1 + 2;
                MAG = MAG + 1;
                BackGroundImageView.setBackgroundResource(R.drawable.human_assassin);
            }
        }
        if (mRace == 2) { //Race Orc
            if (mClass == 1) { //Class Orc_warrior
                ATT = ATT + 2 + 1;
                DEF = DEF + 2 + 1;
                AGI = AGI;
                MAG = MAG;
                BackGroundImageView.setBackgroundResource(R.drawable.orc_warrior);
            }
            if (mClass == 2) { //Class Orc_magician
                ATT = ATT + 2;
                DEF = DEF + 2 - 1;
                AGI = AGI;
                MAG = MAG + 3;
                BackGroundImageView.setBackgroundResource(R.drawable.orc_magician);
            }
            if (mClass == 3) { //Class Orc_assassin
                ATT = ATT + 2;
                DEF = DEF + 2;
                AGI = AGI + 2;
                MAG = MAG;
                BackGroundImageView.setBackgroundResource(R.drawable.orc_assassin);
            }
        }
        if (mRace == 3) { //Race Elv
            if (mClass == 1) { //Class Elv_warrior
                ATT = ATT + 1;
                DEF = DEF + 1;
                AGI = AGI + 2;
                MAG = MAG + 2;
                BackGroundImageView.setBackgroundResource(R.drawable.elv_warrior);
            }
            if (mClass == 2) { //Class Elv_magician
                ATT = ATT;
                DEF = DEF - 1;
                AGI = AGI + 2;
                MAG = MAG + 2 + 3;
                BackGroundImageView.setBackgroundResource(R.drawable.elv_magician);
            }
            if (mClass == 3) { //Class Elv_assassin
                ATT = ATT;
                DEF = DEF;
                AGI = AGI + 2 + 2;
                MAG = MAG + 2;
                BackGroundImageView.setBackgroundResource(R.drawable.elv_assassin);
            }
        }
        String att = String.valueOf(ATT);
        String def = String.valueOf(DEF);
        String agi = String.valueOf(AGI);
        String mag = String.valueOf(MAG);
        TxtATT.setText(att);
        TxtDEF.setText(def);
        TxtAGI.setText(agi);
        TxtMAG.setText(mag);

        view.findViewById(R.id.ButtonSword).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (StickOn == 0 && DaggerOn == 0 && SwordOn == 0) {
                    SwordOn = 1;
                    ATT = ATT + 5;
                    DEF = DEF + 5;
                } else if (StickOn == 0 && DaggerOn == 0 && SwordOn == 1) {
                    SwordOn = 0;
                    ATT = ATT - 5;
                    DEF = DEF - 5;
                } else {
                    Toast.makeText(getActivity(), "You already have a weapon", Toast.LENGTH_SHORT).show();
                }
                TextView TxtATT = (TextView) getView().findViewById(R.id.att_value);
                TextView TxtDEF = (TextView) getView().findViewById(R.id.def_value);
                String att = String.valueOf(ATT);
                String def = String.valueOf(DEF);
                TxtATT.setText(att);
                TxtDEF.setText(def);
            }
        });

        view.findViewById(R.id.buttonStick).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SwordOn == 0 && DaggerOn == 0 && StickOn == 0) {
                    StickOn = 1;
                    ATT = ATT + 5;
                    AGI = AGI + 5;
                } else if (SwordOn == 0 && DaggerOn == 0 && StickOn == 1) {
                    StickOn = 0;
                    ATT = ATT - 5;
                    AGI = AGI - 5;
                } else {
                    Toast.makeText(getActivity(), "You already have a weapon", Toast.LENGTH_SHORT).show();
                }
                TextView TxtATT = (TextView) getView().findViewById(R.id.att_value);
                TextView TxtAGI = (TextView) getView().findViewById(R.id.agi_value);
                String att = String.valueOf(ATT);
                String agi = String.valueOf(AGI);
                TxtATT.setText(att);
                TxtAGI.setText(agi);
            }
        });

        view.findViewById(R.id.buttonDagger).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SwordOn == 0 && StickOn == 0 && DaggerOn == 0) {
                    DaggerOn = 1;
                    ATT = ATT + 5;
                    MAG = MAG + 5;
                } else if (SwordOn == 0 && StickOn == 0 && DaggerOn == 1) {
                    DaggerOn = 0;
                    ATT = ATT - 5;
                    MAG = MAG - 5;
                } else {
                    Toast.makeText(getActivity(), "You already have a weapon", Toast.LENGTH_SHORT).show();
                }
                TextView TxtATT = (TextView) getView().findViewById(R.id.att_value);
                TextView TxtMAG = (TextView) getView().findViewById(R.id.mag_value);
                String att = String.valueOf(ATT);
                String mag = String.valueOf(MAG);
                TxtATT.setText(att);
                TxtMAG.setText(mag);
            }
        });


    }


    private static final String BASE_URL = "https://raw.githubusercontent.com/";

    private void MakeAPICall() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        API_interface interfaceAPI = retrofit.create(API_interface.class);

        Call<RestArmorResponse> call = interfaceAPI.getArmorResponse();
        call.enqueue(new Callback<RestArmorResponse>() {
            @Override
            public void onResponse(Call<RestArmorResponse> call, Response<RestArmorResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    TextView TxtATT = (TextView) getView().findViewById(R.id.att_value);
                    TextView TxtDEF = (TextView) getView().findViewById(R.id.def_value);
                    TextView TxtAGI = (TextView) getView().findViewById(R.id.agi_value);
                    TextView TxtMAG = (TextView) getView().findViewById(R.id.mag_value);
                    List<com.example.test1.Armor> ListArmor = response.body().getArmor();
                    Toast.makeText(getActivity(), "API success", Toast.LENGTH_SHORT).show();
                    recyclerView.setHasFixedSize(true);
                    // use a linear layout manager
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

                    // define an adapter
                    mAdapter = new MyAdapter(ListArmor, TxtATT, TxtDEF, TxtAGI, TxtMAG);
                    recyclerView.setAdapter(mAdapter);
                } else {
                    showError();
                }
            }

            @Override
            public void onFailure(Call<RestArmorResponse> call, Throwable t) {
                showError();
            }
        });
    }

    private void showError() {
        Toast.makeText(getActivity(), "API error", Toast.LENGTH_SHORT).show();
    }

}