package com.example.sosik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView objTV_CountingShake;
    private static boolean activityTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        objTV_CountingShake = (TextView) findViewById(R.id.txtCountingShake);

        Intent serviceIntent = new Intent(getApplicationContext(), MyService.class);
        startService(serviceIntent);
    }

    @Override
    public void onStart() {
        super.onStart();
        activityTop = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        activityTop = true;
    }

    @Override
    protected void onPause() {
        super.onPause();
        activityTop = false;
    }

    @Override
    protected void onStop(){
        super.onStop();
        activityTop = false;
    }

    public static boolean isActivityVisible() {
        return activityTop;
    }
}
