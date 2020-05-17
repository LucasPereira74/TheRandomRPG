package com.example.test1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import interfaces.PassDataInterface;


public class SecondFragment extends Fragment {

    private int Race = 1;
    private int Class = 1;

    public int getRace() {
        return Race;
    }

    public int getClass1() {
        return Class;
    }

    PassDataInterface passDataInterface;

    public void InitData(PassDataInterface passDataInterface){
        this.passDataInterface = passDataInterface;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = new MainActivity();
                mainActivity.setClass(Class);
                mainActivity.setRace(Race);
                NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });


        view.findViewById(R.id.button_human).setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Race = 1;
                    ImageView BackGroundImageView = (ImageView) getView().findViewById(R.id.carac_backgroung);
                    if(Class == 1) {
                        BackGroundImageView.setBackgroundResource(R.drawable.human_warrior);
                    }
                    if(Class == 2) {
                        BackGroundImageView.setBackgroundResource(R.drawable.human_magician);
                    }
                    if(Class == 3) {
                        BackGroundImageView.setBackgroundResource(R.drawable.human_assassin);
                    }
                }
        });

        view.findViewById(R.id.button_orc).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Race = 2;
                ImageView BackGroundImageView = (ImageView) getView().findViewById(R.id.carac_backgroung);
                if(Class == 1) {
                    BackGroundImageView.setBackgroundResource(R.drawable.orc_warrior);
                }
                if(Class == 2) {
                    BackGroundImageView.setBackgroundResource(R.drawable.orc_magician);
                }
                if(Class == 3) {
                    BackGroundImageView.setBackgroundResource(R.drawable.orc_assassin);
                }
            }
        });

        view.findViewById(R.id.button_elv).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Race = 3;
                ImageView BackGroundImageView = (ImageView) getView().findViewById(R.id.carac_backgroung);
                if(Class == 1) {
                    BackGroundImageView.setBackgroundResource(R.drawable.elv_warrior);
                }
                if(Class == 2) {
                    BackGroundImageView.setBackgroundResource(R.drawable.elv_magician);
                }
                if(Class == 3) {
                    BackGroundImageView.setBackgroundResource(R.drawable.elv_assassin);
                }
            }
        });

        view.findViewById(R.id.button_warrior).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = 1;
                ImageView BackGroundImageView = (ImageView) getView().findViewById(R.id.carac_backgroung);
                if(Race == 1) {
                    BackGroundImageView.setBackgroundResource(R.drawable.human_warrior);
                }
                if(Race == 2) {
                    BackGroundImageView.setBackgroundResource(R.drawable.orc_warrior);
                }
                if(Race == 3) {
                    BackGroundImageView.setBackgroundResource(R.drawable.elv_warrior);
                }
            }
        });

        view.findViewById(R.id.button_magician).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = 2;
                ImageView BackGroundImageView = (ImageView) getView().findViewById(R.id.carac_backgroung);
                if(Race == 1) {
                    BackGroundImageView.setBackgroundResource(R.drawable.human_magician);
                }
                if(Race == 2) {
                    BackGroundImageView.setBackgroundResource(R.drawable.orc_magician);
                }
                if(Race == 3) {
                    BackGroundImageView.setBackgroundResource(R.drawable.elv_magician);
                }
            }
        });

        view.findViewById(R.id.button_assassin).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Class = 3;
                ImageView BackGroundImageView = (ImageView) getView().findViewById(R.id.carac_backgroung);
                if(Race == 1) {
                    BackGroundImageView.setBackgroundResource(R.drawable.human_assassin);
                }
                if(Race == 2) {
                    BackGroundImageView.setBackgroundResource(R.drawable.orc_assassin);
                }
                if(Race == 3) {
                    BackGroundImageView.setBackgroundResource(R.drawable.elv_assassin);
                }
            }
        });

    }




}
