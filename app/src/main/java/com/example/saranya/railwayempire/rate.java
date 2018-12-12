package com.example.saranya.railwayempire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class rate extends Fragment {

    Button btn2;
    RatingBar ratingBar;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rate, container, false);
        btn2 = (Button)view.findViewById(R.id.ratebtn);
        ratingBar=(RatingBar)view.findViewById(R.id.ratingBar);
        btn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                rate();
            }
        });
        return view;

    }
    public void rate() {
        float ratingvalue = ratingBar.getRating();
        Toast.makeText(getActivity(), "Rating is" + ratingvalue, Toast.LENGTH_SHORT).show();
    }



    public void onViewCreated(View view,Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        getActivity().setTitle("Rateus");
    }



}
