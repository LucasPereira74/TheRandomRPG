package com.example.test1;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Armor> values;
    private TextView AttText;
    private TextView DefText;
    private TextView AgiText;
    private TextView MagText;

    private int ATT_Charac;
    private int DEF_Charac;
    private int AGI_Charac;
    private int MAG_Charac;

    private int ATT_Armor;
    private int DEF_Armor;
    private int AGI_Armor;
    private int MAG_Armor;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        TextView txtHeader;
        TextView txtFooter;
        View layout;

        ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, Armor item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Armor> myDataset, TextView textview, TextView textview2, TextView textview3, TextView textview4) {
        values = myDataset;
        AttText = textview;
        DefText = textview3;
        AgiText = textview3;
        MagText = textview4;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final Armor currentArmor = values.get(position);
        holder.txtHeader.setText(currentArmor.getName());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ATT_Charac = Integer.valueOf(AttText.getText().toString());
                DEF_Charac = Integer.valueOf(DefText.getText().toString());
                AGI_Charac = Integer.valueOf(AgiText.getText().toString());
                MAG_Charac = Integer.valueOf(MagText.getText().toString());

                ATT_Armor = currentArmor.getATT();
                DEF_Armor = currentArmor.getDEF();
                AGI_Armor = currentArmor.getAGI();
                MAG_Armor = currentArmor.getMAG();

                ATT_Charac = ATT_Charac + ATT_Armor;
                DEF_Charac = DEF_Charac + DEF_Armor;
                AGI_Charac = AGI_Charac + AGI_Armor;
                MAG_Charac = MAG_Charac + MAG_Armor;

                String att = String.valueOf(ATT_Charac);
                String def = String.valueOf(DEF_Charac);
                String agi = String.valueOf(AGI_Charac);
                String mag = String.valueOf(MAG_Charac);
                AttText.setText(att);
                DefText.setText(def);
                AgiText.setText(agi);
                MagText.setText(mag);
            }
        });

        holder.txtFooter.setText(currentArmor.getLvl());
    }



    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}
