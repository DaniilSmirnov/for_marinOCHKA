package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Integer answer_count = 1;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView sv = new ScrollView(this);
        final LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);


        final Button b = new Button(this);
        final ArrayList<HashMap<Boolean, String>> questions = new ArrayList();
        HashMap<Boolean, String> answer = new HashMap();
        answer.put(true, "Являются");
        answer.put(false, "Не являются");
        answer.put(false, "Являются только обочины");
        questions.add(answer);
        answer.clear();
        answer.put(true, "Вы не должны начинать, возобновлять или продолжать движение, осуществлять какой-либо маневр, если это может вынудить других участников движения, имеющих по отношению к Вам преимущество, изменить направление движения или скорость");
        answer.put(false, "Вы должны остановиться только при наличии дорожного знака «Уступите дорогу»");
        answer.put(false, "Вы должны обязательно остановиться, чтобы пропустить других участников движения");
        questions.add(answer);
        answer.clear();


        b.setText("Начать тест");
        ll.addView(b);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setText("Далее");

                for (HashMap.Entry<Boolean, String> entry : questions.get(answer_count).entrySet()) {
                    CheckBox cb = new CheckBox(getApplicationContext());
                    cb.setText(entry.getValue());
                    ll.addView(cb);
                }

                answer_count += 1;

            }
        });



        this.setContentView(sv);

    }
}
