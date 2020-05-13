package com.example.taskapp.ui.onboard;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.taskapp.MainActivity;
import com.example.taskapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BoardFragment extends Fragment {


    public BoardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_board, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textTitle = view.findViewById(R.id.textTitle);
        TextView textDesc = view.findViewById(R.id.textDesc);
        Button button = view.findViewById(R.id.buttonGetStart);
        ImageView image = view.findViewById(R.id.imageView);
        LinearLayout backgColor = view.findViewById(R.id.bg_color);

        int pos = getArguments().getInt("pos");
        switch (pos) {
            case 0:
                textTitle.setText("Дом");
                textDesc.setText("House");
                image.setImageResource(R.drawable.home);
                button.setVisibility(View.GONE);
                backgColor.setBackgroundColor(getResources().getColor(R.color.AntiqueWhite));
                break;
            case 1:
                textTitle.setText("Земля");
                textDesc.setText("Earth");
                image.setImageResource(R.drawable.earth);
                button.setVisibility(View.GONE);
                backgColor.setBackgroundColor(getResources().getColor(R.color.Coral));
                break;
            case 2:
                textTitle.setText("Часы");
                textDesc.setText("Clock");
                image.setImageResource(R.drawable.clock);
                button.setVisibility(View.VISIBLE);
                backgColor.setBackgroundColor(getResources().getColor(R.color.Yellow));
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        saveIsShown();
                        Intent intent = new Intent(getContext(), MainActivity.class);
                        startActivity(intent);
                        getActivity().finish();
                    }
                });
                break;
        }
    }

    private void saveIsShown() {
        SharedPreferences preferences = getActivity().getSharedPreferences("settings", Context.MODE_PRIVATE);
        preferences.edit().putBoolean("isShown", true).apply();
    }
}
