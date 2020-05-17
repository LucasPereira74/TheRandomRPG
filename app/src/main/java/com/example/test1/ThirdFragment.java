package com.example.test1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        MainActivity mActivity = new MainActivity();


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_armor);

        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }
        // define an adapter
        mAdapter = new MyAdapter(input);
        recyclerView.setAdapter(mAdapter);
        return rootView;

    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        MainActivity mainActivity = new MainActivity();
        mClass = mainActivity.getMyDataClass();
        mRace = mainActivity.getMyDataRace();

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
        if(mRace == 1){ //Race Human
            if(mClass == 1){ //Class Human_warrior
                ATT = ATT + 1 + 1;
                DEF = DEF + 1 + 1;
                AGI = AGI + 1;
                MAG = MAG + 1;
                BackGroundImageView.setBackgroundResource(R.drawable.human_warrior);
            }
            if(mClass == 2){ //Class Human_magician
                ATT = ATT + 1;
                DEF = DEF + 1 - 1;
                AGI = AGI + 1;
                MAG = MAG + 1 + 3;
                BackGroundImageView.setBackgroundResource(R.drawable.human_magician);
            }
            if(mClass == 3){ //Class Human_assassin
                ATT = ATT + 1;
                DEF = DEF + 1;
                AGI = AGI + 1 + 2;
                MAG = MAG + 1;
                BackGroundImageView.setBackgroundResource(R.drawable.human_assassin);
            }
        }
        if(mRace == 2){ //Race Orc
            if(mClass == 1){ //Class Orc_warrior
                ATT = ATT + 2 + 1;
                DEF = DEF + 2 + 1;
                AGI = AGI ;
                MAG = MAG ;
                BackGroundImageView.setBackgroundResource(R.drawable.orc_warrior);
            }
            if(mClass == 2){ //Class Orc_magician
                ATT = ATT + 2;
                DEF = DEF + 2 - 1;
                AGI = AGI;
                MAG = MAG + 3;
                BackGroundImageView.setBackgroundResource(R.drawable.orc_magician);
            }
            if(mClass == 3){ //Class Orc_assassin
                ATT = ATT + 2;
                DEF = DEF + 2;
                AGI = AGI + 2;
                MAG = MAG;
                BackGroundImageView.setBackgroundResource(R.drawable.orc_assassin);
            }
        }
        if(mRace == 3){ //Race Elv
            if(mClass == 1){ //Class Elv_warrior
                ATT = ATT + 1;
                DEF = DEF + 1;
                AGI = AGI + 2;
                MAG = MAG + 2;
                BackGroundImageView.setBackgroundResource(R.drawable.elv_warrior);
            }
            if(mClass == 2){ //Class Elv_magician
                ATT = ATT;
                DEF = DEF - 1;
                AGI = AGI + 2;
                MAG = MAG + 2 + 3;
                BackGroundImageView.setBackgroundResource(R.drawable.elv_magician);
            }
            if(mClass == 3){ //Class Elv_assassin
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
    }




    /*Class Armor for API Armor*/
    public class Armor {
        private String AddedOn;
        private String ArmorName;
        private int ATT;
        private int DEF;
        private int AGI;
        private int MAG;

        public Armor() {}

        /*Constructor*/
        public Armor(String cAddedOn, String cArmorName, int cATT, int cDEF, int cAGI, int cMAG){
            AddedOn = cAddedOn;
            ArmorName = cArmorName;
            ATT = cATT;
            DEF = cDEF;
            AGI = cAGI;
            MAG = cMAG;
        }

        /*Functions get*/
        public String getAddedOn(){
            return AddedOn;
        }
        public String getArmorName(){
            return ArmorName;
        }
        public int getATT(){
            return ATT;
        }
        public int getDEF(){
            return DEF;
        }
        public int getAGI(){
            return AGI;
        }
        public int getMAG(){
            return MAG;
        }

        /*Functions set*/
        public void setAddedOn(String AddedOn) {
            this.AddedOn = AddedOn;
        }
        public void setArmorName(String ArmorName) {
            this.ArmorName = ArmorName;
        }
        public void setATT(int ATT){
            this.ATT = ATT;
        }
        public void setDEF(int DEF){
            this.DEF = DEF;
        }
        public void setAGI(int AGI){
            this.AGI = AGI;
        }
        public void setMAG(int MAG){
            this.MAG = MAG;
        }

    }


}
