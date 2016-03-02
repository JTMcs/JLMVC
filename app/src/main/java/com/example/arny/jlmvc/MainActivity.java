package com.example.arny.jlmvc;


import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int nRan;
    String sAns;
    EditText etAns;
    Button btnNew, btnLstn, btnCnfm;
    MediaPlayer mNoise;
    Toast tCor, tBad;
    String[] arsAnml = {"cat", "chicken", "cow", "dog", "elephant", "goat", "goose", "hawk",
            "horse", "lion", "pig", "rooster", "sheep", "tiger"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Animal Fun");

        mNoise = MediaPlayer.create(getApplicationContext(), R.raw.cat);

        btnNew = (Button) findViewById(R.id.btn1);
        btnNew.setOnClickListener(GiveUp);

        btnLstn = (Button) findViewById(R.id.btn2);
        btnLstn.setOnClickListener(Listen);

        btnCnfm = (Button) findViewById(R.id.btn3);
        btnCnfm.setOnClickListener(Confirm);

        etAns = (EditText) findViewById(R.id.etAns);

        tCor = Toast.makeText(getApplicationContext(), "Correct!", Toast.LENGTH_SHORT);
        tBad = Toast.makeText(getApplicationContext(), "Wrong!", Toast.LENGTH_SHORT);
    }

    View.OnClickListener GiveUp = new View.OnClickListener() {
        public void onClick(View v) {
            etAns.setText("");
            nRan = (int) Math.floor(Math.random() * 14);
            String sAnml = arsAnml[nRan];
            int resID = getResources().getIdentifier(sAnml, "raw", getPackageName());
            mNoise = MediaPlayer.create(getApplicationContext(), resID);
            mNoise.start();

        }
    };

    View.OnClickListener Listen = new View.OnClickListener() {
        public void onClick(View v) {
            mNoise.start();
        }
    };

    View.OnClickListener Confirm = new View.OnClickListener() {
        public void onClick(View v) {
            sAns = etAns.getText().toString();
            if (sAns.equals(arsAnml[nRan])) {
                tCor.show();
                etAns.setText("");
                nRan = (int) Math.floor(Math.random() * 14);
                String sAnml = arsAnml[nRan];
                int resID = getResources().getIdentifier(sAnml, "raw", getPackageName());
                mNoise = MediaPlayer.create(getApplicationContext(), resID);
                mNoise.start();
            } else {
                tBad.show();
            }
        }
    };
}


