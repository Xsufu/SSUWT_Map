package com.ssuwt.ssuwtmap;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Laborathory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Laborathory extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Laborathory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Laborathory.
     */
    // TODO: Rename and change types and number of parameters
    public static Laborathory newInstance(String param1, String param2) {
        Laborathory fragment = new Laborathory();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_laborathory, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        //Находим объект, в который загружаются картинки
        ImageView imageView = view.findViewById(R.id.floor_image);

        //Находим кнопку нулевого этажа
        Button ZeroFloor = view.findViewById(R.id.button);

        //Загружаем картинку нулевого этажа в объект
        ZeroFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.zero_floor_lab);
            }
        });

        //Находим кнопку первого этажа
        Button FirstFloor = view.findViewById(R.id.button1);

        //Загружаем картинку первого этажа в объект
        FirstFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.first_floor_lab);
            }
        });

        //Находим кнопку второго этажа
        Button SecondFloor = view.findViewById(R.id.button2);

        //Загружаем картинку второго этажа в объект
        SecondFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.second_floor_lab);
            }
        });

        //Находим кнопку третьего этажа
        Button ThirdFloor = view.findViewById(R.id.button3);

        //Загружаем картинку второго этажа в объект
        ThirdFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageResource(R.drawable.third_floor_lab);
            }
        });
    }
}