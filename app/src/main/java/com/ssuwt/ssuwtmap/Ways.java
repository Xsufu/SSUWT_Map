package com.ssuwt.ssuwtmap;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Ways#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ways extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Ways() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ways.
     */
    // TODO: Rename and change types and number of parameters
    public static Ways newInstance(String param1, String param2) {
        Ways fragment = new Ways();
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

    String itemFrom, itemTo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ways, container, false);

        //Массив строк для спиннера
        String[] buildings = { "...", "Главный", "Лабораторный", "К2" };

        //Находим спиннер "откуда" по ID
        Spinner spinnerFrom = (Spinner) view.findViewById(R.id.spinnerFrom);

        //Находим спиннер "куда" по ID
        Spinner spinnerTo = view.findViewById(R.id.spinnerTo);

        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, buildings);

        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Применяем адаптер к спиннеру "Откуда"
        spinnerFrom.setAdapter(adapter);

        // Применяем адаптер к спиннеру "Куда"
        spinnerTo.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }

    float convertDpToPixels(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button accept = view.findViewById(R.id.accept);

        TextView textFirst = view.findViewById(R.id.textFirst);
        TextView textSecond = view.findViewById(R.id.textSecond);

        ImageView imgWide = view.findViewById(R.id.imgWide);
        ImageView imgWide2 = view.findViewById(R.id.imgWide2);

        //Находим спиннер "откуда" по ID
        Spinner spinnerFrom = (Spinner) view.findViewById(R.id.spinnerFrom);

        //Находим спиннер "куда" по ID
        Spinner spinnerTo = view.findViewById(R.id.spinnerTo);

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Получаем выбранный объект
                itemFrom = (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Получаем выбранный объект
                itemTo = (String)parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean flag = false;

                if (itemFrom == itemTo){

                    if (itemFrom == "..." && itemTo == "...") {
                        Toast toast = Toast.makeText(getActivity(),
                                "Заполните все поля!", Toast.LENGTH_LONG);
                        toast.show();
                        toast.setGravity(Gravity.CENTER, 0, 0);

                        flag = true;
                    }

                    else {
                        Toast toast = Toast.makeText(getActivity(),
                                "Пункты отправления и прибытия не должны совпадать!", Toast.LENGTH_LONG);
                        toast.show();
                        toast.setGravity(Gravity.CENTER, 0, 0);
                    }

                }

                if (itemFrom == "..." && !flag){
                    Toast toast = Toast.makeText(getActivity(),
                            "Выберите пункт отправления!", Toast.LENGTH_LONG);
                    toast.show();
                    toast.setGravity(Gravity.CENTER, 0, 0);
                }

                if (itemTo == "..." && !flag){
                    Toast toast = Toast.makeText(getActivity(),
                            "Выберите пункт назначения!", Toast.LENGTH_LONG);
                    toast.show();
                    toast.setGravity(Gravity.CENTER, 0, 0);
                }

                if (itemFrom == "Главный" && itemTo == "Лабораторный") {
                    textFirst.setText("Пешком до станции метро \"Площадь Ленина (Вход 3)\"");
                    imgWide.setImageResource(R.drawable.main_metro);
                    textSecond.setText("На метро до станции \"Гагаринская\"");
                    imgWide2.setImageResource(R.drawable.lab_metro);
                }

                if (itemFrom == "Лабораторный" && itemTo == "Главный") {
                    textFirst.setText("Пешком до станции метро \"Гагаринская\"");
                    imgWide.setImageResource(R.drawable.lab_metro);
                    textSecond.setText("На метро до станции \"Площадь Ленина (выход 3)\"");
                    imgWide2.setImageResource(R.drawable.main_metro);
                }

                if (itemFrom == "Главный" && itemTo == "К2") {
                    textFirst.setText("Пешком до станции метро \"Площадь Ленина (Вход 3)\"");
                    imgWide.setImageResource(R.drawable.main_metro);
                    textSecond.setText("На метро до станции \"Гагаринская\"");
                    imgWide2.setImageResource(R.drawable.k2_metro);
                }

                if (itemFrom == "К2" && itemTo == "Главный") {
                    textFirst.setText("Пешком до станции метро \"Гагаринская\"");
                    imgWide.setImageResource(R.drawable.k2_metro);
                    textSecond.setText("На метро до станции \"Площадь Ленина (Выход 3)\"");
                    imgWide2.setImageResource(R.drawable.main_metro);
                }

                if ((itemFrom == "Лабораторный" && itemTo == "К2") || (itemTo == "Лабораторный" && itemFrom == "К2")) {
                    //Выводим текст
                    textFirst.setText("Пеший маршрут");
                    //Выводим картинку
                    imgWide.setImageResource(R.drawable.lab_k2);
                    //Чистим от текста второй объект
                    textSecond.setText("");
                    //Удаляем вторую картинку
                    imgWide2.setImageDrawable(null);
                }
            }
        });
    }
}