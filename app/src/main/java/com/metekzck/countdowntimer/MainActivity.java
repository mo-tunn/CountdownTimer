package com.metekzck.countdowntimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            textView = findViewById(R.id.textView);
            return insets;
        });
    }
    public void startTimer(View view){
        new CountDownTimer(10000,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                textView.setText("Left :"+millisUntilFinished/1000+" second");
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"Timer finished!",Toast.LENGTH_LONG).show();
            }
        }.start();

    }
}