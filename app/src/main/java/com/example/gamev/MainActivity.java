package com.example.gamev;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnWr, btnR, btnNxt, btnRes;
    private TextView txtQ;
    private int questInd = 0;
    private int count = 0;

    private RightWrong[] questions = new RightWrong[] {
       new RightWrong(R.string.q1, false),
       new RightWrong(R.string.q2, true),
       new RightWrong(R.string.q3, false),
       new RightWrong(R.string.q4, false),
       new RightWrong(R.string.q5, true),
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWr = (Button)findViewById(R.id.wrong_button);
        btnR = (Button)findViewById(R.id.right_button);
        btnNxt = (Button)findViewById(R.id.next_quest);
        txtQ = (TextView)findViewById(R.id.questionText);
        btnRes = (Button)findViewById(R.id.restart_btn);

        int question = questions[questInd].getQuestion();
        txtQ.setText(question);

        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        btnWr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        btnNxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(questInd < questions.length-1) {
                    questInd++;
                    int question = questions[questInd].getQuestion();
                    txtQ.setText(question);
                    btnWr.setVisibility(View.VISIBLE);
                    btnR.setVisibility(View.VISIBLE);
                    btnNxt.setVisibility(View.INVISIBLE);
                } else {
                    txtQ.setText("Квіз скончаны. Ваш вынік: " + count + "/" + questions.length);
                    txtQ.setTextColor(Color.GREEN);
                    btnNxt.setText(R.string.result);
                    btnNxt.setVisibility(View.INVISIBLE);
                    btnRes.setVisibility(View.VISIBLE);
                }

            }
        });

        btnRes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questInd = 0;
                count = 0;
                int question = questions[questInd].getQuestion();
                txtQ.setText(question);
                btnWr.setVisibility(View.VISIBLE);
                txtQ.setTextColor(Color.BLACK);
                btnR.setVisibility(View.VISIBLE);
                btnNxt.setVisibility(View.INVISIBLE);
                btnRes.setVisibility(View.INVISIBLE);

            }
        });


    }

    private void checkAnswer(boolean userAnswer) {
        boolean answer = questions[questInd].isTrueQuest();
        if (userAnswer == answer) {
            Toast.makeText(MainActivity.this,
                    R.string.right_name, Toast.LENGTH_LONG).show();
            count++;
        }else
            Toast.makeText(MainActivity.this, R.string.wrong_name,
                    Toast.LENGTH_LONG).show();

        btnWr.setVisibility(View.INVISIBLE);
        btnR.setVisibility(View.INVISIBLE);
        btnNxt.setVisibility(View.VISIBLE);

    }
}
